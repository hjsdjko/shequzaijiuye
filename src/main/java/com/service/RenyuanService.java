package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RenyuanEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 再就业人员 服务类
 */
public interface RenyuanService extends IService<RenyuanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}