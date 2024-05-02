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
 * 补贴
 *
 * @author 
 * @email
 */
@TableName("butie")
public class ButieEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ButieEntity() {

	}

	public ButieEntity(T t) {
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
     * 补贴名称
     */
    @TableField(value = "butie_name")

    private String butieName;


    /**
     * 补贴类型
     */
    @TableField(value = "butie_types")

    private Integer butieTypes;


    /**
     * 补贴金额
     */
    @TableField(value = "butie_jine")

    private Double butieJine;


    /**
     * 补贴详情
     */
    @TableField(value = "butie_content")

    private String butieContent;


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
	 * 设置：补贴名称
	 */
    public String getButieName() {
        return butieName;
    }
    /**
	 * 获取：补贴名称
	 */

    public void setButieName(String butieName) {
        this.butieName = butieName;
    }
    /**
	 * 设置：补贴类型
	 */
    public Integer getButieTypes() {
        return butieTypes;
    }
    /**
	 * 获取：补贴类型
	 */

    public void setButieTypes(Integer butieTypes) {
        this.butieTypes = butieTypes;
    }
    /**
	 * 设置：补贴金额
	 */
    public Double getButieJine() {
        return butieJine;
    }
    /**
	 * 获取：补贴金额
	 */

    public void setButieJine(Double butieJine) {
        this.butieJine = butieJine;
    }
    /**
	 * 设置：补贴详情
	 */
    public String getButieContent() {
        return butieContent;
    }
    /**
	 * 获取：补贴详情
	 */

    public void setButieContent(String butieContent) {
        this.butieContent = butieContent;
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
        return "Butie{" +
            "id=" + id +
            ", renyuanId=" + renyuanId +
            ", butieName=" + butieName +
            ", butieTypes=" + butieTypes +
            ", butieJine=" + butieJine +
            ", butieContent=" + butieContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
