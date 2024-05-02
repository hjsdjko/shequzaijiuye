
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
 * 再就业人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/renyuan")
public class RenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(RenyuanController.class);

    @Autowired
    private RenyuanService renyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        PageUtils page = renyuanService.queryPage(params);

        //字典表数据转换
        List<RenyuanView> list =(List<RenyuanView>)page.getList();
        for(RenyuanView c:list){
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
        RenyuanEntity renyuan = renyuanService.selectById(id);
        if(renyuan !=null){
            //entity转view
            RenyuanView view = new RenyuanView();
            BeanUtils.copyProperties( renyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,renyuan:{}",this.getClass().getName(),renyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<RenyuanEntity> queryWrapper = new EntityWrapper<RenyuanEntity>()
            .eq("username", renyuan.getUsername())
            .or()
            .eq("renyuan_phone", renyuan.getRenyuanPhone())
            .or()
            .eq("renyuan_id_number", renyuan.getRenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenyuanEntity renyuanEntity = renyuanService.selectOne(queryWrapper);
        if(renyuanEntity==null){
            renyuan.setCreateTime(new Date());
            renyuan.setPassword("123456");
            renyuanService.insert(renyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者再就业人员手机号或者再就业人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RenyuanEntity renyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,renyuan:{}",this.getClass().getName(),renyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<RenyuanEntity> queryWrapper = new EntityWrapper<RenyuanEntity>()
            .notIn("id",renyuan.getId())
            .andNew()
            .eq("username", renyuan.getUsername())
            .or()
            .eq("renyuan_phone", renyuan.getRenyuanPhone())
            .or()
            .eq("renyuan_id_number", renyuan.getRenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenyuanEntity renyuanEntity = renyuanService.selectOne(queryWrapper);
        if("".equals(renyuan.getRenyuanPhoto()) || "null".equals(renyuan.getRenyuanPhoto())){
                renyuan.setRenyuanPhoto(null);
        }
        if(renyuanEntity==null){
            renyuanService.updateById(renyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者再就业人员手机号或者再就业人员身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        renyuanService.deleteBatchIds(Arrays.asList(ids));
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
            List<RenyuanEntity> renyuanList = new ArrayList<>();//上传的东西
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
                            RenyuanEntity renyuanEntity = new RenyuanEntity();
//                            renyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //renyuanEntity.setPassword("123456");//密码
//                            renyuanEntity.setRenyuanName(data.get(0));                    //再就业人员姓名 要改的
//                            renyuanEntity.setRenyuanPhone(data.get(0));                    //再就业人员手机号 要改的
//                            renyuanEntity.setRenyuanIdNumber(data.get(0));                    //再就业人员身份证号 要改的
//                            renyuanEntity.setRenyuanPhoto("");//详情和图片
//                            renyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            renyuanEntity.setRenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            renyuanEntity.setCreateTime(date);//时间
                            renyuanList.add(renyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //再就业人员手机号
                                if(seachFields.containsKey("renyuanPhone")){
                                    List<String> renyuanPhone = seachFields.get("renyuanPhone");
                                    renyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> renyuanPhone = new ArrayList<>();
                                    renyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("renyuanPhone",renyuanPhone);
                                }
                                //再就业人员身份证号
                                if(seachFields.containsKey("renyuanIdNumber")){
                                    List<String> renyuanIdNumber = seachFields.get("renyuanIdNumber");
                                    renyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> renyuanIdNumber = new ArrayList<>();
                                    renyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("renyuanIdNumber",renyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<RenyuanEntity> renyuanEntities_username = renyuanService.selectList(new EntityWrapper<RenyuanEntity>().in("username", seachFields.get("username")));
                        if(renyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenyuanEntity s:renyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //再就业人员手机号
                        List<RenyuanEntity> renyuanEntities_renyuanPhone = renyuanService.selectList(new EntityWrapper<RenyuanEntity>().in("renyuan_phone", seachFields.get("renyuanPhone")));
                        if(renyuanEntities_renyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenyuanEntity s:renyuanEntities_renyuanPhone){
                                repeatFields.add(s.getRenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [再就业人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //再就业人员身份证号
                        List<RenyuanEntity> renyuanEntities_renyuanIdNumber = renyuanService.selectList(new EntityWrapper<RenyuanEntity>().in("renyuan_id_number", seachFields.get("renyuanIdNumber")));
                        if(renyuanEntities_renyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenyuanEntity s:renyuanEntities_renyuanIdNumber){
                                repeatFields.add(s.getRenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [再就业人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        renyuanService.insertBatch(renyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        RenyuanEntity renyuan = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("username", username));
        if(renyuan==null || !renyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(renyuan.getId(),username, "renyuan", "再就业人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","再就业人员");
        r.put("username",renyuan.getRenyuanName());
        r.put("tableName","renyuan");
        r.put("userId",renyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody RenyuanEntity renyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<RenyuanEntity> queryWrapper = new EntityWrapper<RenyuanEntity>()
            .eq("username", renyuan.getUsername())
            .or()
            .eq("renyuan_phone", renyuan.getRenyuanPhone())
            .or()
            .eq("renyuan_id_number", renyuan.getRenyuanIdNumber())
            ;
        RenyuanEntity renyuanEntity = renyuanService.selectOne(queryWrapper);
        if(renyuanEntity != null)
            return R.error("账户或者再就业人员手机号或者再就业人员身份证号已经被使用");
        renyuan.setCreateTime(new Date());
        renyuanService.insert(renyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        RenyuanEntity renyuan = new RenyuanEntity();
        renyuan.setPassword("123456");
        renyuan.setId(id);
        renyuanService.updateById(renyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        RenyuanEntity renyuan = renyuanService.selectOne(new EntityWrapper<RenyuanEntity>().eq("username", username));
        if(renyuan!=null){
            renyuan.setPassword("123456");
            boolean b = renyuanService.updateById(renyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrRenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        RenyuanEntity renyuan = renyuanService.selectById(id);
        if(renyuan !=null){
            //entity转view
            RenyuanView view = new RenyuanView();
            BeanUtils.copyProperties( renyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
