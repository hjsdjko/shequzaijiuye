package com.entity.model;

import com.entity.ZhengshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 证书
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhengshuModel implements Serializable {
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
     * 证书编号
     */
    private String zhengshuUuidNumber;


    /**
     * 证书名称
     */
    private String zhengshuName;


    /**
     * 证书类型
     */
    private Integer zhengshuTypes;


    /**
     * 证书文件
     */
    private String zhengshuPhoto;


    /**
     * 备注
     */
    private String zhengshuContent;


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
	 * 获取：证书编号
	 */
    public String getZhengshuUuidNumber() {
        return zhengshuUuidNumber;
    }


    /**
	 * 设置：证书编号
	 */
    public void setZhengshuUuidNumber(String zhengshuUuidNumber) {
        this.zhengshuUuidNumber = zhengshuUuidNumber;
    }
    /**
	 * 获取：证书名称
	 */
    public String getZhengshuName() {
        return zhengshuName;
    }


    /**
	 * 设置：证书名称
	 */
    public void setZhengshuName(String zhengshuName) {
        this.zhengshuName = zhengshuName;
    }
    /**
	 * 获取：证书类型
	 */
    public Integer getZhengshuTypes() {
        return zhengshuTypes;
    }


    /**
	 * 设置：证书类型
	 */
    public void setZhengshuTypes(Integer zhengshuTypes) {
        this.zhengshuTypes = zhengshuTypes;
    }
    /**
	 * 获取：证书文件
	 */
    public String getZhengshuPhoto() {
        return zhengshuPhoto;
    }


    /**
	 * 设置：证书文件
	 */
    public void setZhengshuPhoto(String zhengshuPhoto) {
        this.zhengshuPhoto = zhengshuPhoto;
    }
    /**
	 * 获取：备注
	 */
    public String getZhengshuContent() {
        return zhengshuContent;
    }


    /**
	 * 设置：备注
	 */
    public void setZhengshuContent(String zhengshuContent) {
        this.zhengshuContent = zhengshuContent;
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
