package com.entity.model;

import com.entity.PeixunxiangmuCailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 培训项目材料
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeixunxiangmuCailiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 培训项目
     */
    private Integer peixunxiangmuId;


    /**
     * 培训项目编号
     */
    private String peixunxiangmuCailiaoUuidNumber;


    /**
     * 材料名称
     */
    private String peixunxiangmuCailiaoName;


    /**
     * 材料类型
     */
    private Integer peixunxiangmuCailiaoTypes;


    /**
     * 材料数量
     */
    private Integer peixunxiangmuCailiaoNumber;


    /**
     * 材料详情
     */
    private String peixunxiangmuCailiaoContent;


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
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
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
	 * 获取：培训项目编号
	 */
    public String getPeixunxiangmuCailiaoUuidNumber() {
        return peixunxiangmuCailiaoUuidNumber;
    }


    /**
	 * 设置：培训项目编号
	 */
    public void setPeixunxiangmuCailiaoUuidNumber(String peixunxiangmuCailiaoUuidNumber) {
        this.peixunxiangmuCailiaoUuidNumber = peixunxiangmuCailiaoUuidNumber;
    }
    /**
	 * 获取：材料名称
	 */
    public String getPeixunxiangmuCailiaoName() {
        return peixunxiangmuCailiaoName;
    }


    /**
	 * 设置：材料名称
	 */
    public void setPeixunxiangmuCailiaoName(String peixunxiangmuCailiaoName) {
        this.peixunxiangmuCailiaoName = peixunxiangmuCailiaoName;
    }
    /**
	 * 获取：材料类型
	 */
    public Integer getPeixunxiangmuCailiaoTypes() {
        return peixunxiangmuCailiaoTypes;
    }


    /**
	 * 设置：材料类型
	 */
    public void setPeixunxiangmuCailiaoTypes(Integer peixunxiangmuCailiaoTypes) {
        this.peixunxiangmuCailiaoTypes = peixunxiangmuCailiaoTypes;
    }
    /**
	 * 获取：材料数量
	 */
    public Integer getPeixunxiangmuCailiaoNumber() {
        return peixunxiangmuCailiaoNumber;
    }


    /**
	 * 设置：材料数量
	 */
    public void setPeixunxiangmuCailiaoNumber(Integer peixunxiangmuCailiaoNumber) {
        this.peixunxiangmuCailiaoNumber = peixunxiangmuCailiaoNumber;
    }
    /**
	 * 获取：材料详情
	 */
    public String getPeixunxiangmuCailiaoContent() {
        return peixunxiangmuCailiaoContent;
    }


    /**
	 * 设置：材料详情
	 */
    public void setPeixunxiangmuCailiaoContent(String peixunxiangmuCailiaoContent) {
        this.peixunxiangmuCailiaoContent = peixunxiangmuCailiaoContent;
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
