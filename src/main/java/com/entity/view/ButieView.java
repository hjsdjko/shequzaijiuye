package com.entity.view;

import com.entity.ButieEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 补贴
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("butie")
public class ButieView extends ButieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 补贴类型的值
		*/
		private String butieValue;



		//级联表 renyuan
			/**
			* 再就业人员姓名
			*/
			private String renyuanName;
			/**
			* 再就业人员手机号
			*/
			private String renyuanPhone;
			/**
			* 再就业人员身份证号
			*/
			private String renyuanIdNumber;
			/**
			* 再就业人员头像
			*/
			private String renyuanPhoto;
			/**
			* 电子邮箱
			*/
			private String renyuanEmail;

	public ButieView() {

	}

	public ButieView(ButieEntity butieEntity) {
		try {
			BeanUtils.copyProperties(this, butieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 补贴类型的值
			*/
			public String getButieValue() {
				return butieValue;
			}
			/**
			* 设置： 补贴类型的值
			*/
			public void setButieValue(String butieValue) {
				this.butieValue = butieValue;
			}
























				//级联表的get和set renyuan

					/**
					* 获取： 再就业人员姓名
					*/
					public String getRenyuanName() {
						return renyuanName;
					}
					/**
					* 设置： 再就业人员姓名
					*/
					public void setRenyuanName(String renyuanName) {
						this.renyuanName = renyuanName;
					}

					/**
					* 获取： 再就业人员手机号
					*/
					public String getRenyuanPhone() {
						return renyuanPhone;
					}
					/**
					* 设置： 再就业人员手机号
					*/
					public void setRenyuanPhone(String renyuanPhone) {
						this.renyuanPhone = renyuanPhone;
					}

					/**
					* 获取： 再就业人员身份证号
					*/
					public String getRenyuanIdNumber() {
						return renyuanIdNumber;
					}
					/**
					* 设置： 再就业人员身份证号
					*/
					public void setRenyuanIdNumber(String renyuanIdNumber) {
						this.renyuanIdNumber = renyuanIdNumber;
					}

					/**
					* 获取： 再就业人员头像
					*/
					public String getRenyuanPhoto() {
						return renyuanPhoto;
					}
					/**
					* 设置： 再就业人员头像
					*/
					public void setRenyuanPhoto(String renyuanPhoto) {
						this.renyuanPhoto = renyuanPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getRenyuanEmail() {
						return renyuanEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setRenyuanEmail(String renyuanEmail) {
						this.renyuanEmail = renyuanEmail;
					}




}
