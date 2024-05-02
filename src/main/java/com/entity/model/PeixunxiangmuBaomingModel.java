package com.entity.model;

import com.entity.PeixunxiangmuBaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 培训项目报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeixunxiangmuBaomingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 再就业人员
     */
    private Integer renyuanId;


    /**
     * 培训项目
     */
    private Integer peixunxiangmuId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 审核状态
     */
    private Integer peixunxiangmuBaomingYesnoTypes;


    /**
     * 审核意见
     */
    private String peixunxiangmuBaomingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：再就业人员
	 */
    public Integer getRenyuanId() {
        return renyuanId;
    }


    /**
	 * 设置：再就业人员
	 */
    public void setRenyuanId(Integer renyuanId) {
        this.renyuanId = renyuanId;
    }
    /**
	 * 获取：培训项目
	 */
    public Integer getPeixunxiangmuId() {
        return peixunxiangmuId;
    }


    /**
	 * 设置：培训项目
	 */
    public void setPeixunxiangmuId(Integer peixunxiangmuId) {
        this.peixunxiangmuId = peixunxiangmuId;
    }
    /**
	 * 获取：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：报名时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getPeixunxiangmuBaomingYesnoTypes() {
        return peixunxiangmuBaomingYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setPeixunxiangmuBaomingYesnoTypes(Integer peixunxiangmuBaomingYesnoTypes) {
        this.peixunxiangmuBaomingYesnoTypes = peixunxiangmuBaomingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getPeixunxiangmuBaomingYesnoText() {
        return peixunxiangmuBaomingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setPeixunxiangmuBaomingYesnoText(String peixunxiangmuBaomingYesnoText) {
        this.peixunxiangmuBaomingYesnoText = peixunxiangmuBaomingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
