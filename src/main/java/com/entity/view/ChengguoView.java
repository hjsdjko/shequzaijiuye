package com.entity.view;

import com.entity.ChengguoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 成果
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chengguo")
public class ChengguoView extends ChengguoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 成果类型的值
		*/
		private String chengguoValue;



	public ChengguoView() {

	}

	public ChengguoView(ChengguoEntity chengguoEntity) {
		try {
			BeanUtils.copyProperties(this, chengguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 成果类型的值
			*/
			public String getChengguoValue() {
				return chengguoValue;
			}
			/**
			* 设置： 成果类型的值
			*/
			public void setChengguoValue(String chengguoValue) {
				this.chengguoValue = chengguoValue;
			}















}
