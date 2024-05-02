package com.dao;

import com.entity.PeixunxiangmuCailiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeixunxiangmuCailiaoView;

/**
 * 培训项目材料 Dao 接口
 *
 * @author 
 */
public interface PeixunxiangmuCailiaoDao extends BaseMapper<PeixunxiangmuCailiaoEntity> {

   List<PeixunxiangmuCailiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
