
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
 * 证书
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhengshu")
public class ZhengshuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhengshuController.class);

    @Autowired
    private ZhengshuService zhengshuService;


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
        PageUtils page = zhengshuService.queryPage(params);

        //字典表数据转换
        List<ZhengshuView> list =(List<ZhengshuView>)page.getList();
        for(ZhengshuView c:list){
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
        ZhengshuEntity zhengshu = zhengshuService.selectById(id);
        if(zhengshu !=null){
            //entity转view
            ZhengshuView view = new ZhengshuView();
            BeanUtils.copyProperties( zhengshu , view );//把实体数据重构到view中

                //级联表
                RenyuanEntity renyuan = renyuanService.selectById(zhengshu.getRenyuanId());
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
    public R save(@RequestBody ZhengshuEntity zhengshu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhengshu:{}",this.getClass().getName(),zhengshu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("再就业人员".equals(role))
            zhengshu.setRenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhengshuEntity> queryWrapper = new EntityWrapper<ZhengshuEntity>()
            .eq("renyuan_id", zhengshu.getRenyuanId())
            .eq("zhengshu_uuid_number", zhengshu.getZhengshuUuidNumber())
            .eq("zhengshu_name", zhengshu.getZhengshuName())
            .eq("zhengshu_types", zhengshu.getZhengshuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhengshuEntity zhengshuEntity = zhengshuService.selectOne(queryWrapper);
        if(zhengshuEntity==null){
            zhengshu.setInsertTime(new Date());
            zhengshu.setCreateTime(new Date());
            zhengshuService.insert(zhengshu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhengshuEntity zhengshu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhengshu:{}",this.getClass().getName(),zhengshu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("再就业人员".equals(role))
//            zhengshu.setRenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhengshuEntity> queryWrapper = new EntityWrapper<ZhengshuEntity>()
            .notIn("id",zhengshu.getId())
            .andNew()
            .eq("renyuan_id", zhengshu.getRenyuanId())
            .eq("zhengshu_uuid_number", zhengshu.getZhengshuUuidNumber())
            .eq("zhengshu_name", zhengshu.getZhengshuName())
            .eq("zhengshu_types", zhengshu.getZhengshuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhengshuEntity zhengshuEntity = zhengshuService.selectOne(queryWrapper);
        if("".equals(zhengshu.getZhengshuPhoto()) || "null".equals(zhengshu.getZhengshuPhoto())){
                zhengshu.setZhengshuPhoto(null);
        }
        if(zhengshuEntity==null){
            zhengshuService.updateById(zhengshu);//根据id更新
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
        zhengshuService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZhengshuEntity> zhengshuList = new ArrayList<>();//上传的东西
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
                            ZhengshuEntity zhengshuEntity = new ZhengshuEntity();
//                            zhengshuEntity.setRenyuanId(Integer.valueOf(data.get(0)));   //再就业人员 要改的
//                            zhengshuEntity.setZhengshuUuidNumber(data.get(0));                    //证书编号 要改的
//                            zhengshuEntity.setZhengshuName(data.get(0));                    //证书名称 要改的
//                            zhengshuEntity.setZhengshuTypes(Integer.valueOf(data.get(0)));   //证书类型 要改的
//                            zhengshuEntity.setZhengshuPhoto("");//详情和图片
//                            zhengshuEntity.setZhengshuContent("");//详情和图片
//                            zhengshuEntity.setInsertTime(date);//时间
//                            zhengshuEntity.setCreateTime(date);//时间
                            zhengshuList.add(zhengshuEntity);


                            //把要查询是否重复的字段放入map中
                                //证书编号
                                if(seachFields.containsKey("zhengshuUuidNumber")){
                                    List<String> zhengshuUuidNumber = seachFields.get("zhengshuUuidNumber");
                                    zhengshuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhengshuUuidNumber = new ArrayList<>();
                                    zhengshuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhengshuUuidNumber",zhengshuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //证书编号
                        List<ZhengshuEntity> zhengshuEntities_zhengshuUuidNumber = zhengshuService.selectList(new EntityWrapper<ZhengshuEntity>().in("zhengshu_uuid_number", seachFields.get("zhengshuUuidNumber")));
                        if(zhengshuEntities_zhengshuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhengshuEntity s:zhengshuEntities_zhengshuUuidNumber){
                                repeatFields.add(s.getZhengshuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [证书编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhengshuService.insertBatch(zhengshuList);
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
