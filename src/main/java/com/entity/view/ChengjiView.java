package com.entity.view;

import com.entity.ChengjiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 考试成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 成绩类型的值
		*/
		private String chengjiValue;



		//级联表 kaoshi
			/**
			* 考试 的 老师
			*/
			private Integer kaoshiLaoshiId;
			/**
			* 考试编号
			*/
			private String kaoshiUuidNumber;
			/**
			* 考试名称
			*/
			private String kaoshiName;
			/**
			* 考试地点
			*/
			private String kaoshiAddress;
			/**
			* 考试时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date kaoshiTime;
			/**
			* 考试类型
			*/
			private Integer kaoshiTypes;
				/**
				* 考试类型的值
				*/
				private String kaoshiValue;
			/**
			* 考试详情
			*/
			private String kaoshiContent;

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

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 成绩类型的值
			*/
			public String getChengjiValue() {
				return chengjiValue;
			}
			/**
			* 设置： 成绩类型的值
			*/
			public void setChengjiValue(String chengjiValue) {
				this.chengjiValue = chengjiValue;
			}



















				//级联表的get和set kaoshi

					/**
					* 获取：考试 的 老师
					*/
					public Integer getKaoshiLaoshiId() {
						return kaoshiLaoshiId;
					}
					/**
					* 设置：考试 的 老师
					*/
					public void setKaoshiLaoshiId(Integer kaoshiLaoshiId) {
						this.kaoshiLaoshiId = kaoshiLaoshiId;
					}


					/**
					* 获取： 考试编号
					*/
					public String getKaoshiUuidNumber() {
						return kaoshiUuidNumber;
					}
					/**
					* 设置： 考试编号
					*/
					public void setKaoshiUuidNumber(String kaoshiUuidNumber) {
						this.kaoshiUuidNumber = kaoshiUuidNumber;
					}

					/**
					* 获取： 考试名称
					*/
					public String getKaoshiName() {
						return kaoshiName;
					}
					/**
					* 设置： 考试名称
					*/
					public void setKaoshiName(String kaoshiName) {
						this.kaoshiName = kaoshiName;
					}

					/**
					* 获取： 考试地点
					*/
					public String getKaoshiAddress() {
						return kaoshiAddress;
					}
					/**
					* 设置： 考试地点
					*/
					public void setKaoshiAddress(String kaoshiAddress) {
						this.kaoshiAddress = kaoshiAddress;
					}

					/**
					* 获取： 考试时间
					*/
					public Date getKaoshiTime() {
						return kaoshiTime;
					}
					/**
					* 设置： 考试时间
					*/
					public void setKaoshiTime(Date kaoshiTime) {
						this.kaoshiTime = kaoshiTime;
					}

					/**
					* 获取： 考试类型
					*/
					public Integer getKaoshiTypes() {
						return kaoshiTypes;
					}
					/**
					* 设置： 考试类型
					*/
					public void setKaoshiTypes(Integer kaoshiTypes) {
						this.kaoshiTypes = kaoshiTypes;
					}


						/**
						* 获取： 考试类型的值
						*/
						public String getKaoshiValue() {
							return kaoshiValue;
						}
						/**
						* 设置： 考试类型的值
						*/
						public void setKaoshiValue(String kaoshiValue) {
							this.kaoshiValue = kaoshiValue;
						}

					/**
					* 获取： 考试详情
					*/
					public String getKaoshiContent() {
						return kaoshiContent;
					}
					/**
					* 设置： 考试详情
					*/
					public void setKaoshiContent(String kaoshiContent) {
						this.kaoshiContent = kaoshiContent;
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
