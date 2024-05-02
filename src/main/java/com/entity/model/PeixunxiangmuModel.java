package com.entity.model;

import com.entity.PeixunxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 培训项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeixunxiangmuModel implements Serializable {
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
	 * 获取：培训项目编号
	 */
    public String getPeixunxiangmuUuidNumber() {
        return peixunxiangmuUuidNumber;
    }


    /**
	 * 设置：培训项目编号
	 */
    public void setPeixunxiangmuUuidNumber(String peixunxiangmuUuidNumber) {
        this.peixunxiangmuUuidNumber = peixunxiangmuUuidNumber;
    }
    /**
	 * 获取：培训项目名称
	 */
    public String getPeixunxiangmuName() {
        return peixunxiangmuName;
    }


    /**
	 * 设置：培训项目名称
	 */
    public void setPeixunxiangmuName(String peixunxiangmuName) {
        this.peixunxiangmuName = peixunxiangmuName;
    }
    /**
	 * 获取：所属培训公司
	 */
    public String getPeixunxiangmuGongsi() {
        return peixunxiangmuGongsi;
    }


    /**
	 * 设置：所属培训公司
	 */
    public void setPeixunxiangmuGongsi(String peixunxiangmuGongsi) {
        this.peixunxiangmuGongsi = peixunxiangmuGongsi;
    }
    /**
	 * 获取：培训公司地址
	 */
    public String getPeixunxiangmuGongsiAddress() {
        return peixunxiangmuGongsiAddress;
    }


    /**
	 * 设置：培训公司地址
	 */
    public void setPeixunxiangmuGongsiAddress(String peixunxiangmuGongsiAddress) {
        this.peixunxiangmuGongsiAddress = peixunxiangmuGongsiAddress;
    }
    /**
	 * 获取：培训地址
	 */
    public String getPeixunxiangmuPeixunAddress() {
        return peixunxiangmuPeixunAddress;
    }


    /**
	 * 设置：培训地址
	 */
    public void setPeixunxiangmuPeixunAddress(String peixunxiangmuPeixunAddress) {
        this.peixunxiangmuPeixunAddress = peixunxiangmuPeixunAddress;
    }
    /**
	 * 获取：培训项目类型
	 */
    public Integer getPeixunxiangmuTypes() {
        return peixunxiangmuTypes;
    }


    /**
	 * 设置：培训项目类型
	 */
    public void setPeixunxiangmuTypes(Integer peixunxiangmuTypes) {
        this.peixunxiangmuTypes = peixunxiangmuTypes;
    }
    /**
	 * 获取：培训项目详情
	 */
    public String getPeixunxiangmuContent() {
        return peixunxiangmuContent;
    }


    /**
	 * 设置：培训项目详情
	 */
    public void setPeixunxiangmuContent(String peixunxiangmuContent) {
        this.peixunxiangmuContent = peixunxiangmuContent;
    }
    /**
	 * 获取：培训开始时间
	 */
    public Date getPeixunKaishiTime() {
        return peixunKaishiTime;
    }


    /**
	 * 设置：培训开始时间
	 */
    public void setPeixunKaishiTime(Date peixunKaishiTime) {
        this.peixunKaishiTime = peixunKaishiTime;
    }
    /**
	 * 获取：培训结束时间
	 */
    public Date getPeixunJieshuTime() {
        return peixunJieshuTime;
    }


    /**
	 * 设置：培训结束时间
	 */
    public void setPeixunJieshuTime(Date peixunJieshuTime) {
        this.peixunJieshuTime = peixunJieshuTime;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getPeixunxiangmuDelete() {
        return peixunxiangmuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setPeixunxiangmuDelete(Integer peixunxiangmuDelete) {
        this.peixunxiangmuDelete = peixunxiangmuDelete;
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
