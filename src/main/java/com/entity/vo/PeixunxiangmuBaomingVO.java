package com.entity.vo;

import com.entity.PeixunxiangmuBaomingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 培训项目报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("peixunxiangmu_baoming")
public class PeixunxiangmuBaomingVO implements Serializable {
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
     * 培训项目
     */

    @TableField(value = "peixunxiangmu_id")
    private Integer peixunxiangmuId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 审核状态
     */

    @TableField(value = "peixunxiangmu_baoming_yesno_types")
    private Integer peixunxiangmuBaomingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "peixunxiangmu_baoming_yesno_text")
    private String peixunxiangmuBaomingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


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
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getPeixunxiangmuBaomingYesnoTypes() {
        return peixunxiangmuBaomingYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setPeixunxiangmuBaomingYesnoTypes(Integer peixunxiangmuBaomingYesnoTypes) {
        this.peixunxiangmuBaomingYesnoTypes = peixunxiangmuBaomingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getPeixunxiangmuBaomingYesnoText() {
        return peixunxiangmuBaomingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setPeixunxiangmuBaomingYesnoText(String peixunxiangmuBaomingYesnoText) {
        this.peixunxiangmuBaomingYesnoText = peixunxiangmuBaomingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
