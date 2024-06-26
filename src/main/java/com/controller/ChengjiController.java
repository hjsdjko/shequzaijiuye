
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 考试成绩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chengji")
public class ChengjiController {
    private static final Logger logger = LoggerFactory.getLogger(ChengjiController.class);

    @Autowired
    private ChengjiService chengjiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KaoshiService kaoshiService;
    @Autowired
    private RenyuanService renyuanService;

    @Autowired
    private LaoshiService laoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("再就业人员".equals(role))
            params.put("renyuanId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chengjiService.queryPage(params);

        //字典表数据转换
        List<ChengjiView> list =(List<ChengjiView>)page.getList();
        for(ChengjiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChengjiEntity chengji = chengjiService.selectById(id);
        if(chengji !=null){
            //entity转view
            ChengjiView view = new ChengjiView();
            BeanUtils.copyProperties( chengji , view );//把实体数据重构到view中

                //级联表
                KaoshiEntity kaoshi = kaoshiService.selectById(chengji.getKaoshiId());
                if(kaoshi != null){
                    BeanUtils.copyProperties( kaoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKaoshiId(kaoshi.getId());
                }
                //级联表
                RenyuanEntity renyuan = renyuanService.selectById(chengji.getRenyuanId());
                if(renyuan != null){
                    BeanUtils.copyProperties( renyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setRenyuanId(renyuan.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChengjiEntity chengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chengji:{}",this.getClass().getName(),chengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("再就业人员".equals(role))
            chengji.setRenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChengjiEntity> queryWrapper = new EntityWrapper<ChengjiEntity>()
            .eq("kaoshi_id", chengji.getKaoshiId())
            .eq("renyuan_id", chengji.getRenyuanId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengjiEntity chengjiEntity = chengjiService.selectOne(queryWrapper);
        if(chengjiEntity==null){


            if(chengji.getChengji()>80)
                chengji.setChengjiTypes(4);
            else if(chengji.getChengji()>60)
                chengji.setChengjiTypes(3);
            else if(chengji.getChengji()>40)
                chengji.setChengjiTypes(2);
            else
                chengji.setChengjiTypes(1);


            chengji.setInsertTime(new Date());
            chengji.setCreateTime(new Date());
            chengjiService.insert(chengji);
            return R.ok();
        }else {
            return R.error(511,"该人员已有该考试的记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChengjiEntity chengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chengji:{}",this.getClass().getName(),chengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("再就业人员".equals(role))
//            chengji.setRenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ChengjiEntity> queryWrapper = new EntityWrapper<ChengjiEntity>()
            .notIn("id",chengji.getId())
            .andNew()
            .eq("kaoshi_id", chengji.getKaoshiId())
            .eq("renyuan_id", chengji.getRenyuanId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengjiEntity chengjiEntity = chengjiService.selectOne(queryWrapper);
        if(chengjiEntity==null){




            if(chengji.getChengji()>80)
                chengji.setChengjiTypes(4);
            else if(chengji.getChengji()>60)
                chengji.setChengjiTypes(3);
            else if(chengji.getChengji()>40)
                chengji.setChengjiTypes(2);
            else
                chengji.setChengjiTypes(1);


            chengjiService.updateById(chengji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该人员已有该考试的记录");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ChengjiEntity> chengjiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChengjiEntity chengjiEntity = new ChengjiEntity();
//                            chengjiEntity.setKaoshiId(Integer.valueOf(data.get(0)));   //考试 要改的
//                            chengjiEntity.setRenyuanId(Integer.valueOf(data.get(0)));   //再就业人员 要改的
//                            chengjiEntity.setChengjiTypes(Integer.valueOf(data.get(0)));   //成绩类型 要改的
//                            chengjiEntity.setChengji(data.get(0));                    //考试成绩 要改的
//                            chengjiEntity.setChengjiContent("");//详情和图片
//                            chengjiEntity.setInsertTime(date);//时间
//                            chengjiEntity.setCreateTime(date);//时间
                            chengjiList.add(chengjiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chengjiService.insertBatch(chengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
