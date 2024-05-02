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
 * 成果
 *
 * @author 
 * @email
 */
@TableName("chengguo")
public class ChengguoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengguoEntity() {

	}

	public ChengguoEntity(T t) {
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
     * 成果名称
     */
    @TableField(value = "chengguo_name")

    private String chengguoName;


    /**
     * 成果类型
     */
    @TableField(value = "chengguo_types")

    private Integer chengguoTypes;


    /**
     * 成果相关文件
     */
    @TableField(value = "chengguo_file")

    private String chengguoFile;


    /**
     * 成果详情
     */
    @TableField(value = "chengguo_content")

    private String chengguoContent;


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
	 * 设置：成果名称
	 */
    public String getChengguoName() {
        return chengguoName;
    }
    /**
	 * 获取：成果名称
	 */

    public void setChengguoName(String chengguoName) {
        this.chengguoName = chengguoName;
    }
    /**
	 * 设置：成果类型
	 */
    public Integer getChengguoTypes() {
        return chengguoTypes;
    }
    /**
	 * 获取：成果类型
	 */

    public void setChengguoTypes(Integer chengguoTypes) {
        this.chengguoTypes = chengguoTypes;
    }
    /**
	 * 设置：成果相关文件
	 */
    public String getChengguoFile() {
        return chengguoFile;
    }
    /**
	 * 获取：成果相关文件
	 */

    public void setChengguoFile(String chengguoFile) {
        this.chengguoFile = chengguoFile;
    }
    /**
	 * 设置：成果详情
	 */
    public String getChengguoContent() {
        return chengguoContent;
    }
    /**
	 * 获取：成果详情
	 */

    public void setChengguoContent(String chengguoContent) {
        this.chengguoContent = chengguoContent;
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
        return "Chengguo{" +
            "id=" + id +
            ", chengguoName=" + chengguoName +
            ", chengguoTypes=" + chengguoTypes +
            ", chengguoFile=" + chengguoFile +
            ", chengguoContent=" + chengguoContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
