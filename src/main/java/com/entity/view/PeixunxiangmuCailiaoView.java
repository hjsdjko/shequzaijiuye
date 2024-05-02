package com.entity.view;

import com.entity.PeixunxiangmuCailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 培训项目材料
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("peixunxiangmu_cailiao")
public class PeixunxiangmuCailiaoView extends PeixunxiangmuCailiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 材料类型的值
		*/
		private String peixunxiangmuCailiaoValue;



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

		//级联表 laoshi
			/**
			* 老师姓名
			*/
			private String laoshiName;
			/**
			* 老师手机号
			*/
			private String laoshiPhone;
			/**
			* 老师身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 老师头像
			*/
			private String laoshiPhoto;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;

	public PeixunxiangmuCailiaoView() {

	}

	public PeixunxiangmuCailiaoView(PeixunxiangmuCailiaoEntity peixunxiangmuCailiaoEntity) {
		try {
			BeanUtils.copyProperties(this, peixunxiangmuCailiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 材料类型的值
			*/
			public String getPeixunxiangmuCailiaoValue() {
				return peixunxiangmuCailiaoValue;
			}
			/**
			* 设置： 材料类型的值
			*/
			public void setPeixunxiangmuCailiaoValue(String peixunxiangmuCailiaoValue) {
				this.peixunxiangmuCailiaoValue = peixunxiangmuCailiaoValue;
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














				//级联表的get和set laoshi

					/**
					* 获取： 老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}

					/**
					* 获取： 老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}

					/**
					* 获取： 老师身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 老师身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}

					/**
					* 获取： 老师头像
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 老师头像
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}




}
