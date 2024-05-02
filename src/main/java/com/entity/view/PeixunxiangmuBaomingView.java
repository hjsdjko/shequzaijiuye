package com.entity.view;

import com.entity.PeixunxiangmuBaomingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 培训项目报名
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("peixunxiangmu_baoming")
public class PeixunxiangmuBaomingView extends PeixunxiangmuBaomingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 审核状态的值
		*/
		private String peixunxiangmuBaomingYesnoValue;



		//级联表 peixunxiangmu
			/**
			* 培训项目 的 老师
			*/
			private Integer peixunxiangmuLaoshiId;
			/**
			* 培训项目编号
			*/
			private String peixunxiangmuUuidNumber;
			/**
			* 培训项目名称
			*/
			private String peixunxiangmuName;
			/**
			* 所属培训公司
			*/
			private String peixunxiangmuGongsi;
			/**
			* 培训公司地址
			*/
			private String peixunxiangmuGongsiAddress;
			/**
			* 培训地址
			*/
			private String peixunxiangmuPeixunAddress;
			/**
			* 培训项目类型
			*/
			private Integer peixunxiangmuTypes;
				/**
				* 培训项目类型的值
				*/
				private String peixunxiangmuValue;
			/**
			* 培训项目详情
			*/
			private String peixunxiangmuContent;
			/**
			* 培训开始时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date peixunKaishiTime;
			/**
			* 培训结束时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date peixunJieshuTime;
			/**
			* 逻辑删除
			*/
			private Integer peixunxiangmuDelete;

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

	public PeixunxiangmuBaomingView() {

	}

	public PeixunxiangmuBaomingView(PeixunxiangmuBaomingEntity peixunxiangmuBaomingEntity) {
		try {
			BeanUtils.copyProperties(this, peixunxiangmuBaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核状态的值
			*/
			public String getPeixunxiangmuBaomingYesnoValue() {
				return peixunxiangmuBaomingYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setPeixunxiangmuBaomingYesnoValue(String peixunxiangmuBaomingYesnoValue) {
				this.peixunxiangmuBaomingYesnoValue = peixunxiangmuBaomingYesnoValue;
			}























				//级联表的get和set peixunxiangmu

					/**
					* 获取：培训项目 的 老师
					*/
					public Integer getPeixunxiangmuLaoshiId() {
						return peixunxiangmuLaoshiId;
					}
					/**
					* 设置：培训项目 的 老师
					*/
					public void setPeixunxiangmuLaoshiId(Integer peixunxiangmuLaoshiId) {
						this.peixunxiangmuLaoshiId = peixunxiangmuLaoshiId;
					}


					/**
					* 获取： 培训项目编号
					*/
					public String getPeixunxiangmuUuidNumber() {
						return peixunxiangmuUuidNumber;
					}
					/**
					* 设置： 培训项目编号
					*/
					public void setPeixunxiangmuUuidNumber(String peixunxiangmuUuidNumber) {
						this.peixunxiangmuUuidNumber = peixunxiangmuUuidNumber;
					}

					/**
					* 获取： 培训项目名称
					*/
					public String getPeixunxiangmuName() {
						return peixunxiangmuName;
					}
					/**
					* 设置： 培训项目名称
					*/
					public void setPeixunxiangmuName(String peixunxiangmuName) {
						this.peixunxiangmuName = peixunxiangmuName;
					}

					/**
					* 获取： 所属培训公司
					*/
					public String getPeixunxiangmuGongsi() {
						return peixunxiangmuGongsi;
					}
					/**
					* 设置： 所属培训公司
					*/
					public void setPeixunxiangmuGongsi(String peixunxiangmuGongsi) {
						this.peixunxiangmuGongsi = peixunxiangmuGongsi;
					}

					/**
					* 获取： 培训公司地址
					*/
					public String getPeixunxiangmuGongsiAddress() {
						return peixunxiangmuGongsiAddress;
					}
					/**
					* 设置： 培训公司地址
					*/
					public void setPeixunxiangmuGongsiAddress(String peixunxiangmuGongsiAddress) {
						this.peixunxiangmuGongsiAddress = peixunxiangmuGongsiAddress;
					}

					/**
					* 获取： 培训地址
					*/
					public String getPeixunxiangmuPeixunAddress() {
						return peixunxiangmuPeixunAddress;
					}
					/**
					* 设置： 培训地址
					*/
					public void setPeixunxiangmuPeixunAddress(String peixunxiangmuPeixunAddress) {
						this.peixunxiangmuPeixunAddress = peixunxiangmuPeixunAddress;
					}

					/**
					* 获取： 培训项目类型
					*/
					public Integer getPeixunxiangmuTypes() {
						return peixunxiangmuTypes;
					}
					/**
					* 设置： 培训项目类型
					*/
					public void setPeixunxiangmuTypes(Integer peixunxiangmuTypes) {
						this.peixunxiangmuTypes = peixunxiangmuTypes;
					}


						/**
						* 获取： 培训项目类型的值
						*/
						public String getPeixunxiangmuValue() {
							return peixunxiangmuValue;
						}
						/**
						* 设置： 培训项目类型的值
						*/
						public void setPeixunxiangmuValue(String peixunxiangmuValue) {
							this.peixunxiangmuValue = peixunxiangmuValue;
						}

					/**
					* 获取： 培训项目详情
					*/
					public String getPeixunxiangmuContent() {
						return peixunxiangmuContent;
					}
					/**
					* 设置： 培训项目详情
					*/
					public void setPeixunxiangmuContent(String peixunxiangmuContent) {
						this.peixunxiangmuContent = peixunxiangmuContent;
					}

					/**
					* 获取： 培训开始时间
					*/
					public Date getPeixunKaishiTime() {
						return peixunKaishiTime;
					}
					/**
					* 设置： 培训开始时间
					*/
					public void setPeixunKaishiTime(Date peixunKaishiTime) {
						this.peixunKaishiTime = peixunKaishiTime;
					}

					/**
					* 获取： 培训结束时间
					*/
					public Date getPeixunJieshuTime() {
						return peixunJieshuTime;
					}
					/**
					* 设置： 培训结束时间
					*/
					public void setPeixunJieshuTime(Date peixunJieshuTime) {
						this.peixunJieshuTime = peixunJieshuTime;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getPeixunxiangmuDelete() {
						return peixunxiangmuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setPeixunxiangmuDelete(Integer peixunxiangmuDelete) {
						this.peixunxiangmuDelete = peixunxiangmuDelete;
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
