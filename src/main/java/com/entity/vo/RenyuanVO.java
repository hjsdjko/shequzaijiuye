package com.entity.vo;

import com.entity.RenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 再就业人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("renyuan")
public class RenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 再就业人员姓名
     */

    @TableField(value = "renyuan_name")
    private String renyuanName;


    /**
     * 再就业人员手机号
     */

    @TableField(value = "renyuan_phone")
    private String renyuanPhone;


    /**
     * 再就业人员身份证号
     */

    @TableField(value = "renyuan_id_number")
    private String renyuanIdNumber;


    /**
     * 再就业人员头像
     */

    @TableField(value = "renyuan_photo")
    private String renyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "renyuan_email")
    private String renyuanEmail;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：再就业人员姓名
	 */
    public String getRenyuanName() {
        return renyuanName;
    }


    /**
	 * 获取：再就业人员姓名
	 */

    public void setRenyuanName(String renyuanName) {
        this.renyuanName = renyuanName;
    }
    /**
	 * 设置：再就业人员手机号
	 */
    public String getRenyuanPhone() {
        return renyuanPhone;
    }


    /**
	 * 获取：再就业人员手机号
	 */

    public void setRenyuanPhone(String renyuanPhone) {
        this.renyuanPhone = renyuanPhone;
    }
    /**
	 * 设置：再就业人员身份证号
	 */
    public String getRenyuanIdNumber() {
        return renyuanIdNumber;
    }


    /**
	 * 获取：再就业人员身份证号
	 */

    public void setRenyuanIdNumber(String renyuanIdNumber) {
        this.renyuanIdNumber = renyuanIdNumber;
    }
    /**
	 * 设置：再就业人员头像
	 */
    public String getRenyuanPhoto() {
        return renyuanPhoto;
    }


    /**
	 * 获取：再就业人员头像
	 */

    public void setRenyuanPhoto(String renyuanPhoto) {
        this.renyuanPhoto = renyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getRenyuanEmail() {
        return renyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setRenyuanEmail(String renyuanEmail) {
        this.renyuanEmail = renyuanEmail;
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
