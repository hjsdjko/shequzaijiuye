
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
 * 补贴
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/butie")
public class ButieController {
    private static final Logger logger = LoggerFactory.getLogger(ButieController.class);

    @Autowired
    private ButieService butieService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = butieService.queryPage(params);

        //字典表数据转换
        List<ButieView> list =(List<ButieView>)page.getList();
        for(ButieView c:list){
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
        ButieEntity butie = butieService.selectById(id);
        if(butie !=null){
            //entity转view
            ButieView view = new ButieView();
            BeanUtils.copyProperties( butie , view );//把实体数据重构到view中

                //级联表
                RenyuanEntity renyuan = renyuanService.selectById(butie.getRenyuanId());
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
    public R save(@RequestBody ButieEntity butie, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,butie:{}",this.getClass().getName(),butie.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("再就业人员".equals(role))
            butie.setRenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ButieEntity> queryWrapper = new EntityWrapper<ButieEntity>()
            .eq("renyuan_id", butie.getRenyuanId())
            .eq("butie_name", butie.getButieName())
            .eq("butie_types", butie.getButieTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ButieEntity butieEntity = butieService.selectOne(queryWrapper);
        if(butieEntity==null){
            butie.setInsertTime(new Date());
            butie.setCreateTime(new Date());
            butieService.insert(butie);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ButieEntity butie, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,butie:{}",this.getClass().getName(),butie.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("再就业人员".equals(role))
//            butie.setRenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ButieEntity> queryWrapper = new EntityWrapper<ButieEntity>()
            .notIn("id",butie.getId())
            .andNew()
            .eq("renyuan_id", butie.getRenyuanId())
            .eq("butie_name", butie.getButieName())
            .eq("butie_types", butie.getButieTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ButieEntity butieEntity = butieService.selectOne(queryWrapper);
        if(butieEntity==null){
            butieService.updateById(butie);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        butieService.deleteBatchIds(Arrays.asList(ids));
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
            List<ButieEntity> butieList = new ArrayList<>();//上传的东西
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
                            ButieEntity butieEntity = new ButieEntity();
//                            butieEntity.setRenyuanId(Integer.valueOf(data.get(0)));   //再就业人员 要改的
//                            butieEntity.setButieName(data.get(0));                    //补贴名称 要改的
//                            butieEntity.setButieTypes(Integer.valueOf(data.get(0)));   //补贴类型 要改的
//                            butieEntity.setButieJine(data.get(0));                    //补贴金额 要改的
//                            butieEntity.setButieContent("");//详情和图片
//                            butieEntity.setInsertTime(date);//时间
//                            butieEntity.setCreateTime(date);//时间
                            butieList.add(butieEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        butieService.insertBatch(butieList);
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
