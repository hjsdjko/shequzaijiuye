package com.dao;

import com.entity.RenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RenyuanView;

/**
 * 再就业人员 Dao 接口
 *
 * @author 
 */
public interface RenyuanDao extends BaseMapper<RenyuanEntity> {

   List<RenyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
