package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 培训项目报名
 *
 * @author 
 * @email
 */
@TableName("peixunxiangmu_baoming")
public class PeixunxiangmuBaomingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeixunxiangmuBaomingEntity() {

	}

	public PeixunxiangmuBaomingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 再就业人员
     */
    @TableField(value = "renyuan_id")

    private Integer renyuanId;


    /**
     * 培训项目
     */
    @TableField(value = "peixunxiangmu_id")

    private Integer peixunxiangmuId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 审核状态
     */
    @TableField(value = "peixunxiangmu_baoming_yesno_types")

    private Integer peixunxiangmuBaomingYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "peixunxiangmu_baoming_yesno_text")

    private String peixunxiangmuBaomingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：再就业人员
	 */
    public Integer getRenyuanId() {
        return renyuanId;
    }
    /**
	 * 获取：再就业人员
	 */

    public void setRenyuanId(Integer renyuanId) {
        this.renyuanId = renyuanId;
    }
    /**
	 * 设置：培训项目
	 */
    public Integer getPeixunxiangmuId() {
        return peixunxiangmuId;
    }
    /**
	 * 获取：培训项目
	 */

    public void setPeixunxiangmuId(Integer peixunxiangmuId) {
        this.peixunxiangmuId = peixunxiangmuId;
    }
    /**
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getPeixunxiangmuBaomingYesnoTypes() {
        return peixunxiangmuBaomingYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setPeixunxiangmuBaomingYesnoTypes(Integer peixunxiangmuBaomingYesnoTypes) {
        this.peixunxiangmuBaomingYesnoTypes = peixunxiangmuBaomingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getPeixunxiangmuBaomingYesnoText() {
        return peixunxiangmuBaomingYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setPeixunxiangmuBaomingYesnoText(String peixunxiangmuBaomingYesnoText) {
        this.peixunxiangmuBaomingYesnoText = peixunxiangmuBaomingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PeixunxiangmuBaoming{" +
            "id=" + id +
            ", renyuanId=" + renyuanId +
            ", peixunxiangmuId=" + peixunxiangmuId +
            ", insertTime=" + insertTime +
            ", peixunxiangmuBaomingYesnoTypes=" + peixunxiangmuBaomingYesnoTypes +
            ", peixunxiangmuBaomingYesnoText=" + peixunxiangmuBaomingYesnoText +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
