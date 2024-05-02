package com.dao;

import com.entity.PeixunxiangmuBaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeixunxiangmuBaomingView;

/**
 * 培训项目报名 Dao 接口
 *
 * @author 
 */
public interface PeixunxiangmuBaomingDao extends BaseMapper<PeixunxiangmuBaomingEntity> {

   List<PeixunxiangmuBaomingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
