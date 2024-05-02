package com.entity.vo;

import com.entity.ZhengshuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 证书
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhengshu")
public class ZhengshuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 再就业人员
     */

    @TableField(value = "renyuan_id")
    private Integer renyuanId;


    /**
     * 证书编号
     */

    @TableField(value = "zhengshu_uuid_number")
    private String zhengshuUuidNumber;


    /**
     * 证书名称
     */

    @TableField(value = "zhengshu_name")
    private String zhengshuName;


    /**
     * 证书类型
     */

    @TableField(value = "zhengshu_types")
    private Integer zhengshuTypes;


    /**
     * 证书文件
     */

    @TableField(value = "zhengshu_photo")
    private String zhengshuPhoto;


    /**
     * 备注
     */

    @TableField(value = "zhengshu_content")
    private String zhengshuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：证书编号
	 */
    public String getZhengshuUuidNumber() {
        return zhengshuUuidNumber;
    }


    /**
	 * 获取：证书编号
	 */

    public void setZhengshuUuidNumber(String zhengshuUuidNumber) {
        this.zhengshuUuidNumber = zhengshuUuidNumber;
    }
    /**
	 * 设置：证书名称
	 */
    public String getZhengshuName() {
        return zhengshuName;
    }


    /**
	 * 获取：证书名称
	 */

    public void setZhengshuName(String zhengshuName) {
        this.zhengshuName = zhengshuName;
    }
    /**
	 * 设置：证书类型
	 */
    public Integer getZhengshuTypes() {
        return zhengshuTypes;
    }


    /**
	 * 获取：证书类型
	 */

    public void setZhengshuTypes(Integer zhengshuTypes) {
        this.zhengshuTypes = zhengshuTypes;
    }
    /**
	 * 设置：证书文件
	 */
    public String getZhengshuPhoto() {
        return zhengshuPhoto;
    }


    /**
	 * 获取：证书文件
	 */

    public void setZhengshuPhoto(String zhengshuPhoto) {
        this.zhengshuPhoto = zhengshuPhoto;
    }
    /**
	 * 设置：备注
	 */
    public String getZhengshuContent() {
        return zhengshuContent;
    }


    /**
	 * 获取：备注
	 */

    public void setZhengshuContent(String zhengshuContent) {
        this.zhengshuContent = zhengshuContent;
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

}
