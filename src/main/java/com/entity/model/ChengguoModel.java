package com.entity.model;

import com.entity.ChengguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 成果
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChengguoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 成果名称
     */
    private String chengguoName;


    /**
     * 成果类型
     */
    private Integer chengguoTypes;


    /**
     * 成果相关文件
     */
    private String chengguoFile;


    /**
     * 成果详情
     */
    private String chengguoContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：成果名称
	 */
    public String getChengguoName() {
        return chengguoName;
    }


    /**
	 * 设置：成果名称
	 */
    public void setChengguoName(String chengguoName) {
        this.chengguoName = chengguoName;
    }
    /**
	 * 获取：成果类型
	 */
    public Integer getChengguoTypes() {
        return chengguoTypes;
    }


    /**
	 * 设置：成果类型
	 */
    public void setChengguoTypes(Integer chengguoTypes) {
        this.chengguoTypes = chengguoTypes;
    }
    /**
	 * 获取：成果相关文件
	 */
    public String getChengguoFile() {
        return chengguoFile;
    }


    /**
	 * 设置：成果相关文件
	 */
    public void setChengguoFile(String chengguoFile) {
        this.chengguoFile = chengguoFile;
    }
    /**
	 * 获取：成果详情
	 */
    public String getChengguoContent() {
        return chengguoContent;
    }


    /**
	 * 设置：成果详情
	 */
    public void setChengguoContent(String chengguoContent) {
        this.chengguoContent = chengguoContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
