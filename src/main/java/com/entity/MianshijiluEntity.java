package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 面试记录
 *
 * @author 
 * @email
 */
@TableName("mianshijilu")
public class MianshijiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MianshijiluEntity() {

	}

	public MianshijiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 用工部门
     */
    @ColumnInfo(comment="用工部门",type="int(11)")
    @TableField(value = "gongsi_id")

    private Integer gongsiId;


    /**
     * 面试记录编号
     */
    @ColumnInfo(comment="面试记录编号",type="varchar(200)")
    @TableField(value = "mianshijilu_uuid_number")

    private String mianshijiluUuidNumber;


    /**
     * 面试记录标题
     */
    @ColumnInfo(comment="面试记录标题",type="varchar(200)")
    @TableField(value = "mianshijilu_name")

    private String mianshijiluName;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="面试时间",type="timestamp")
    @TableField(value = "mianshijilu_time")

    private Date mianshijiluTime;


    /**
     * 面试内容
     */
    @ColumnInfo(comment="面试内容",type="longtext")
    @TableField(value = "mianshijilu_content")

    private String mianshijiluContent;


    /**
     * 面试结果
     */
    @ColumnInfo(comment="面试结果",type="int(11)")
    @TableField(value = "mianshijilu_types")

    private Integer mianshijiluTypes;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：用工部门
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }
    /**
	 * 设置：用工部门
	 */

    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
    }
    /**
	 * 获取：面试记录编号
	 */
    public String getMianshijiluUuidNumber() {
        return mianshijiluUuidNumber;
    }
    /**
	 * 设置：面试记录编号
	 */

    public void setMianshijiluUuidNumber(String mianshijiluUuidNumber) {
        this.mianshijiluUuidNumber = mianshijiluUuidNumber;
    }
    /**
	 * 获取：面试记录标题
	 */
    public String getMianshijiluName() {
        return mianshijiluName;
    }
    /**
	 * 设置：面试记录标题
	 */

    public void setMianshijiluName(String mianshijiluName) {
        this.mianshijiluName = mianshijiluName;
    }
    /**
	 * 获取：面试时间
	 */
    public Date getMianshijiluTime() {
        return mianshijiluTime;
    }
    /**
	 * 设置：面试时间
	 */

    public void setMianshijiluTime(Date mianshijiluTime) {
        this.mianshijiluTime = mianshijiluTime;
    }
    /**
	 * 获取：面试内容
	 */
    public String getMianshijiluContent() {
        return mianshijiluContent;
    }
    /**
	 * 设置：面试内容
	 */

    public void setMianshijiluContent(String mianshijiluContent) {
        this.mianshijiluContent = mianshijiluContent;
    }
    /**
	 * 获取：面试结果
	 */
    public Integer getMianshijiluTypes() {
        return mianshijiluTypes;
    }
    /**
	 * 设置：面试结果
	 */

    public void setMianshijiluTypes(Integer mianshijiluTypes) {
        this.mianshijiluTypes = mianshijiluTypes;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Mianshijilu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongsiId=" + gongsiId +
            ", mianshijiluUuidNumber=" + mianshijiluUuidNumber +
            ", mianshijiluName=" + mianshijiluName +
            ", mianshijiluTime=" + DateUtil.convertString(mianshijiluTime,"yyyy-MM-dd") +
            ", mianshijiluContent=" + mianshijiluContent +
            ", mianshijiluTypes=" + mianshijiluTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
