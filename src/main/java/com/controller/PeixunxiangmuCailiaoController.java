
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
 * 培训项目材料
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/peixunxiangmuCailiao")
public class PeixunxiangmuCailiaoController {
    private static final Logger logger = LoggerFactory.getLogger(PeixunxiangmuCailiaoController.class);

    @Autowired
    private PeixunxiangmuCailiaoService peixunxiangmuCailiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private PeixunxiangmuService peixunxiangmuService;
    @Autowired
    private LaoshiService laoshiService;

    @Autowired
    private RenyuanService renyuanService;


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
        PageUtils page = peixunxiangmuCailiaoService.queryPage(params);

        //字典表数据转换
        List<PeixunxiangmuCailiaoView> list =(List<PeixunxiangmuCailiaoView>)page.getList();
        for(PeixunxiangmuCailiaoView c:list){
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
        PeixunxiangmuCailiaoEntity peixunxiangmuCailiao = peixunxiangmuCailiaoService.selectById(id);
        if(peixunxiangmuCailiao !=null){
            //entity转view
            PeixunxiangmuCailiaoView view = new PeixunxiangmuCailiaoView();
            BeanUtils.copyProperties( peixunxiangmuCailiao , view );//把实体数据重构到view中

                //级联表
                PeixunxiangmuEntity peixunxiangmu = peixunxiangmuService.selectById(peixunxiangmuCailiao.getPeixunxiangmuId());
                if(peixunxiangmu != null){
                    BeanUtils.copyProperties( peixunxiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setPeixunxiangmuId(peixunxiangmu.getId());
                    view.setPeixunxiangmuLaoshiId(peixunxiangmu.getLaoshiId());
                }
                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(peixunxiangmuCailiao.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
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
    public R save(@RequestBody PeixunxiangmuCailiaoEntity peixunxiangmuCailiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,peixunxiangmuCailiao:{}",this.getClass().getName(),peixunxiangmuCailiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            peixunxiangmuCailiao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PeixunxiangmuCailiaoEntity> queryWrapper = new EntityWrapper<PeixunxiangmuCailiaoEntity>()
            .eq("laoshi_id", peixunxiangmuCailiao.getLaoshiId())
            .eq("peixunxiangmu_id", peixunxiangmuCailiao.getPeixunxiangmuId())
            .eq("peixunxiangmu_cailiao_uuid_number", peixunxiangmuCailiao.getPeixunxiangmuCailiaoUuidNumber())
            .eq("peixunxiangmu_cailiao_name", peixunxiangmuCailiao.getPeixunxiangmuCailiaoName())
            .eq("peixunxiangmu_cailiao_types", peixunxiangmuCailiao.getPeixunxiangmuCailiaoTypes())
            .eq("peixunxiangmu_cailiao_number", peixunxiangmuCailiao.getPeixunxiangmuCailiaoNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeixunxiangmuCailiaoEntity peixunxiangmuCailiaoEntity = peixunxiangmuCailiaoService.selectOne(queryWrapper);
        if(peixunxiangmuCailiaoEntity==null){
            peixunxiangmuCailiao.setInsertTime(new Date());
            peixunxiangmuCailiao.setCreateTime(new Date());
            peixunxiangmuCailiaoService.insert(peixunxiangmuCailiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeixunxiangmuCailiaoEntity peixunxiangmuCailiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,peixunxiangmuCailiao:{}",this.getClass().getName(),peixunxiangmuCailiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            peixunxiangmuCailiao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<PeixunxiangmuCailiaoEntity> queryWrapper = new EntityWrapper<PeixunxiangmuCailiaoEntity>()
            .notIn("id",peixunxiangmuCailiao.getId())
            .andNew()
            .eq("laoshi_id", peixunxiangmuCailiao.getLaoshiId())
            .eq("peixunxiangmu_id", peixunxiangmuCailiao.getPeixunxiangmuId())
            .eq("peixunxiangmu_cailiao_uuid_number", peixunxiangmuCailiao.getPeixunxiangmuCailiaoUuidNumber())
            .eq("peixunxiangmu_cailiao_name", peixunxiangmuCailiao.getPeixunxiangmuCailiaoName())
            .eq("peixunxiangmu_cailiao_types", peixunxiangmuCailiao.getPeixunxiangmuCailiaoTypes())
            .eq("peixunxiangmu_cailiao_number", peixunxiangmuCailiao.getPeixunxiangmuCailiaoNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeixunxiangmuCailiaoEntity peixunxiangmuCailiaoEntity = peixunxiangmuCailiaoService.selectOne(queryWrapper);
        if(peixunxiangmuCailiaoEntity==null){
            peixunxiangmuCailiaoService.updateById(peixunxiangmuCailiao);//根据id更新
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
        peixunxiangmuCailiaoService.deleteBatchIds(Arrays.asList(ids));
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
            List<PeixunxiangmuCailiaoEntity> peixunxiangmuCailiaoList = new ArrayList<>();//上传的东西
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
                            PeixunxiangmuCailiaoEntity peixunxiangmuCailiaoEntity = new PeixunxiangmuCailiaoEntity();
//                            peixunxiangmuCailiaoEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            peixunxiangmuCailiaoEntity.setPeixunxiangmuId(Integer.valueOf(data.get(0)));   //培训项目 要改的
//                            peixunxiangmuCailiaoEntity.setPeixunxiangmuCailiaoUuidNumber(data.get(0));                    //培训项目编号 要改的
//                            peixunxiangmuCailiaoEntity.setPeixunxiangmuCailiaoName(data.get(0));                    //材料名称 要改的
//                            peixunxiangmuCailiaoEntity.setPeixunxiangmuCailiaoTypes(Integer.valueOf(data.get(0)));   //材料类型 要改的
//                            peixunxiangmuCailiaoEntity.setPeixunxiangmuCailiaoNumber(Integer.valueOf(data.get(0)));   //材料数量 要改的
//                            peixunxiangmuCailiaoEntity.setPeixunxiangmuCailiaoContent("");//详情和图片
//                            peixunxiangmuCailiaoEntity.setInsertTime(date);//时间
//                            peixunxiangmuCailiaoEntity.setCreateTime(date);//时间
                            peixunxiangmuCailiaoList.add(peixunxiangmuCailiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //培训项目编号
                                if(seachFields.containsKey("peixunxiangmuCailiaoUuidNumber")){
                                    List<String> peixunxiangmuCailiaoUuidNumber = seachFields.get("peixunxiangmuCailiaoUuidNumber");
                                    peixunxiangmuCailiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> peixunxiangmuCailiaoUuidNumber = new ArrayList<>();
                                    peixunxiangmuCailiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("peixunxiangmuCailiaoUuidNumber",peixunxiangmuCailiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //培训项目编号
                        List<PeixunxiangmuCailiaoEntity> peixunxiangmuCailiaoEntities_peixunxiangmuCailiaoUuidNumber = peixunxiangmuCailiaoService.selectList(new EntityWrapper<PeixunxiangmuCailiaoEntity>().in("peixunxiangmu_cailiao_uuid_number", seachFields.get("peixunxiangmuCailiaoUuidNumber")));
                        if(peixunxiangmuCailiaoEntities_peixunxiangmuCailiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeixunxiangmuCailiaoEntity s:peixunxiangmuCailiaoEntities_peixunxiangmuCailiaoUuidNumber){
                                repeatFields.add(s.getPeixunxiangmuCailiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [培训项目编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        peixunxiangmuCailiaoService.insertBatch(peixunxiangmuCailiaoList);
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
