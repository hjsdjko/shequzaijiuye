package com.dao;

import com.entity.ChengguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengguoView;

/**
 * 成果 Dao 接口
 *
 * @author 
 */
public interface ChengguoDao extends BaseMapper<ChengguoEntity> {

   List<ChengguoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
