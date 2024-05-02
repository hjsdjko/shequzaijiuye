
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
 * 培训项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/peixunxiangmu")
public class PeixunxiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(PeixunxiangmuController.class);

    @Autowired
    private PeixunxiangmuService peixunxiangmuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        params.put("peixunxiangmuDeleteStart",1);params.put("peixunxiangmuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = peixunxiangmuService.queryPage(params);

        //字典表数据转换
        List<PeixunxiangmuView> list =(List<PeixunxiangmuView>)page.getList();
        for(PeixunxiangmuView c:list){
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
        PeixunxiangmuEntity peixunxiangmu = peixunxiangmuService.selectById(id);
        if(peixunxiangmu !=null){
            //entity转view
            PeixunxiangmuView view = new PeixunxiangmuView();
            BeanUtils.copyProperties( peixunxiangmu , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(peixunxiangmu.getLaoshiId());
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
    public R save(@RequestBody PeixunxiangmuEntity peixunxiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,peixunxiangmu:{}",this.getClass().getName(),peixunxiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            peixunxiangmu.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PeixunxiangmuEntity> queryWrapper = new EntityWrapper<PeixunxiangmuEntity>()
            .eq("laoshi_id", peixunxiangmu.getLaoshiId())
            .eq("peixunxiangmu_uuid_number", peixunxiangmu.getPeixunxiangmuUuidNumber())
            .eq("peixunxiangmu_name", peixunxiangmu.getPeixunxiangmuName())
            .eq("peixunxiangmu_gongsi", peixunxiangmu.getPeixunxiangmuGongsi())
            .eq("peixunxiangmu_gongsi_address", peixunxiangmu.getPeixunxiangmuGongsiAddress())
            .eq("peixunxiangmu_peixun_address", peixunxiangmu.getPeixunxiangmuPeixunAddress())
            .eq("peixunxiangmu_types", peixunxiangmu.getPeixunxiangmuTypes())
            .eq("peixunxiangmu_delete", peixunxiangmu.getPeixunxiangmuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeixunxiangmuEntity peixunxiangmuEntity = peixunxiangmuService.selectOne(queryWrapper);
        if(peixunxiangmuEntity==null){
            peixunxiangmu.setPeixunxiangmuDelete(1);
            peixunxiangmu.setInsertTime(new Date());
            peixunxiangmu.setCreateTime(new Date());
            peixunxiangmuService.insert(peixunxiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeixunxiangmuEntity peixunxiangmu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,peixunxiangmu:{}",this.getClass().getName(),peixunxiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            peixunxiangmu.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<PeixunxiangmuEntity> queryWrapper = new EntityWrapper<PeixunxiangmuEntity>()
            .notIn("id",peixunxiangmu.getId())
            .andNew()
            .eq("laoshi_id", peixunxiangmu.getLaoshiId())
            .eq("peixunxiangmu_uuid_number", peixunxiangmu.getPeixunxiangmuUuidNumber())
            .eq("peixunxiangmu_name", peixunxiangmu.getPeixunxiangmuName())
            .eq("peixunxiangmu_gongsi", peixunxiangmu.getPeixunxiangmuGongsi())
            .eq("peixunxiangmu_gongsi_address", peixunxiangmu.getPeixunxiangmuGongsiAddress())
            .eq("peixunxiangmu_peixun_address", peixunxiangmu.getPeixunxiangmuPeixunAddress())
            .eq("peixunxiangmu_types", peixunxiangmu.getPeixunxiangmuTypes())
            .eq("peixunxiangmu_delete", peixunxiangmu.getPeixunxiangmuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeixunxiangmuEntity peixunxiangmuEntity = peixunxiangmuService.selectOne(queryWrapper);
        if(peixunxiangmuEntity==null){
            peixunxiangmuService.updateById(peixunxiangmu);//根据id更新
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
        ArrayList<PeixunxiangmuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            PeixunxiangmuEntity peixunxiangmuEntity = new PeixunxiangmuEntity();
            peixunxiangmuEntity.setId(id);
            peixunxiangmuEntity.setPeixunxiangmuDelete(2);
            list.add(peixunxiangmuEntity);
        }
        if(list != null && list.size() >0){
            peixunxiangmuService.updateBatchById(list);
        }
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
            List<PeixunxiangmuEntity> peixunxiangmuList = new ArrayList<>();//上传的东西
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
                            PeixunxiangmuEntity peixunxiangmuEntity = new PeixunxiangmuEntity();
//                            peixunxiangmuEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuUuidNumber(data.get(0));                    //培训项目编号 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuName(data.get(0));                    //培训项目名称 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuGongsi(data.get(0));                    //所属培训公司 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuGongsiAddress(data.get(0));                    //培训公司地址 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuPeixunAddress(data.get(0));                    //培训地址 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuTypes(Integer.valueOf(data.get(0)));   //培训项目类型 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuContent("");//详情和图片
//                            peixunxiangmuEntity.setPeixunKaishiTime(sdf.parse(data.get(0)));          //培训开始时间 要改的
//                            peixunxiangmuEntity.setPeixunJieshuTime(sdf.parse(data.get(0)));          //培训结束时间 要改的
//                            peixunxiangmuEntity.setPeixunxiangmuDelete(1);//逻辑删除字段
//                            peixunxiangmuEntity.setInsertTime(date);//时间
//                            peixunxiangmuEntity.setCreateTime(date);//时间
                            peixunxiangmuList.add(peixunxiangmuEntity);


                            //把要查询是否重复的字段放入map中
                                //培训项目编号
                                if(seachFields.containsKey("peixunxiangmuUuidNumber")){
                                    List<String> peixunxiangmuUuidNumber = seachFields.get("peixunxiangmuUuidNumber");
                                    peixunxiangmuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> peixunxiangmuUuidNumber = new ArrayList<>();
                                    peixunxiangmuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("peixunxiangmuUuidNumber",peixunxiangmuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //培训项目编号
                        List<PeixunxiangmuEntity> peixunxiangmuEntities_peixunxiangmuUuidNumber = peixunxiangmuService.selectList(new EntityWrapper<PeixunxiangmuEntity>().in("peixunxiangmu_uuid_number", seachFields.get("peixunxiangmuUuidNumber")).eq("peixunxiangmu_delete", 1));
                        if(peixunxiangmuEntities_peixunxiangmuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeixunxiangmuEntity s:peixunxiangmuEntities_peixunxiangmuUuidNumber){
                                repeatFields.add(s.getPeixunxiangmuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [培训项目编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        peixunxiangmuService.insertBatch(peixunxiangmuList);
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
