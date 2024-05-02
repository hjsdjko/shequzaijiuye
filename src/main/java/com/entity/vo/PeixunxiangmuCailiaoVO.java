package com.entity.vo;

import com.entity.PeixunxiangmuCailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 培训项目材料
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("peixunxiangmu_cailiao")
public class PeixunxiangmuCailiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
