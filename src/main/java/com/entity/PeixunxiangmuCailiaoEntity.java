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
 * 培训项目材料
 *
 * @author 
 * @email
 */
@TableName("peixunxiangmu_cailiao")
public class PeixunxiangmuCailiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeixunxiangmuCailiaoEntity() {

	}

	public PeixunxiangmuCailiaoEntity(T t) {
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
     * 老师
     */
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 培训项目
     */
    @TableField(value = "peixunxiangmu_id")

    private Integer peixunxiangmuId;


    /**
     * 培训项目编号
     */
    @TableField(value = "peixunxiangmu_cailiao_uuid_number")

    private String peixunxiangmuCailiaoUuidNumber;


    /**
     * 材料名称
     */
    @TableField(value = "peixunxiangmu_cailiao_name")

    private String peixunxiangmuCailiaoName;


    /**
     * 材料类型
     */
    @TableField(value = "peixunxiangmu_cailiao_types")

    private Integer peixunxiangmuCailiaoTypes;


    /**
     * 材料数量
     */
    @TableField(value = "peixunxiangmu_cailiao_number")

    private Integer peixunxiangmuCailiaoNumber;


    /**
     * 材料详情
     */
    @TableField(value = "peixunxiangmu_cailiao_content")

    private String peixunxiangmuCailiaoContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }
    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
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
	 * 设置：培训项目编号
	 */
    public String getPeixunxiangmuCailiaoUuidNumber() {
        return peixunxiangmuCailiaoUuidNumber;
    }
    /**
	 * 获取：培训项目编号
	 */

    public void setPeixunxiangmuCailiaoUuidNumber(String peixunxiangmuCailiaoUuidNumber) {
        this.peixunxiangmuCailiaoUuidNumber = peixunxiangmuCailiaoUuidNumber;
    }
    /**
	 * 设置：材料名称
	 */
    public String getPeixunxiangmuCailiaoName() {
        return peixunxiangmuCailiaoName;
    }
    /**
	 * 获取：材料名称
	 */

    public void setPeixunxiangmuCailiaoName(String peixunxiangmuCailiaoName) {
        this.peixunxiangmuCailiaoName = peixunxiangmuCailiaoName;
    }
    /**
	 * 设置：材料类型
	 */
    public Integer getPeixunxiangmuCailiaoTypes() {
        return peixunxiangmuCailiaoTypes;
    }
    /**
	 * 获取：材料类型
	 */

    public void setPeixunxiangmuCailiaoTypes(Integer peixunxiangmuCailiaoTypes) {
        this.peixunxiangmuCailiaoTypes = peixunxiangmuCailiaoTypes;
    }
    /**
	 * 设置：材料数量
	 */
    public Integer getPeixunxiangmuCailiaoNumber() {
        return peixunxiangmuCailiaoNumber;
    }
    /**
	 * 获取：材料数量
	 */

    public void setPeixunxiangmuCailiaoNumber(Integer peixunxiangmuCailiaoNumber) {
        this.peixunxiangmuCailiaoNumber = peixunxiangmuCailiaoNumber;
    }
    /**
	 * 设置：材料详情
	 */
    public String getPeixunxiangmuCailiaoContent() {
        return peixunxiangmuCailiaoContent;
    }
    /**
	 * 获取：材料详情
	 */

    public void setPeixunxiangmuCailiaoContent(String peixunxiangmuCailiaoContent) {
        this.peixunxiangmuCailiaoContent = peixunxiangmuCailiaoContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "PeixunxiangmuCailiao{" +
            "id=" + id +
            ", laoshiId=" + laoshiId +
            ", peixunxiangmuId=" + peixunxiangmuId +
            ", peixunxiangmuCailiaoUuidNumber=" + peixunxiangmuCailiaoUuidNumber +
            ", peixunxiangmuCailiaoName=" + peixunxiangmuCailiaoName +
            ", peixunxiangmuCailiaoTypes=" + peixunxiangmuCailiaoTypes +
            ", peixunxiangmuCailiaoNumber=" + peixunxiangmuCailiaoNumber +
            ", peixunxiangmuCailiaoContent=" + peixunxiangmuCailiaoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
