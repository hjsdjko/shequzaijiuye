package com.entity.model;

import com.entity.ButieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 补贴
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ButieModel implements Serializable {
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
     * 补贴名称
     */
    private String butieName;


    /**
     * 补贴类型
     */
    private Integer butieTypes;


    /**
     * 补贴金额
     */
    private Double butieJine;


    /**
     * 补贴详情
     */
    private String butieContent;


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
	 * 获取：补贴名称
	 */
    public String getButieName() {
        return butieName;
    }


    /**
	 * 设置：补贴名称
	 */
    public void setButieName(String butieName) {
        this.butieName = butieName;
    }
    /**
	 * 获取：补贴类型
	 */
    public Integer getButieTypes() {
        return butieTypes;
    }


    /**
	 * 设置：补贴类型
	 */
    public void setButieTypes(Integer butieTypes) {
        this.butieTypes = butieTypes;
    }
    /**
	 * 获取：补贴金额
	 */
    public Double getButieJine() {
        return butieJine;
    }


    /**
	 * 设置：补贴金额
	 */
    public void setButieJine(Double butieJine) {
        this.butieJine = butieJine;
    }
    /**
	 * 获取：补贴详情
	 */
    public String getButieContent() {
        return butieContent;
    }


    /**
	 * 设置：补贴详情
	 */
    public void setButieContent(String butieContent) {
        this.butieContent = butieContent;
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
