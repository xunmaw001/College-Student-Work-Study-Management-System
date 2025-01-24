package com.entity.vo;

import com.entity.MianshijiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 面试记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("mianshijilu")
public class MianshijiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 用工部门
     */

    @TableField(value = "gongsi_id")
    private Integer gongsiId;


    /**
     * 面试记录编号
     */

    @TableField(value = "mianshijilu_uuid_number")
    private String mianshijiluUuidNumber;


    /**
     * 面试记录标题
     */

    @TableField(value = "mianshijilu_name")
    private String mianshijiluName;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "mianshijilu_time")
    private Date mianshijiluTime;


    /**
     * 面试内容
     */

    @TableField(value = "mianshijilu_content")
    private String mianshijiluContent;


    /**
     * 面试结果
     */

    @TableField(value = "mianshijilu_types")
    private Integer mianshijiluTypes;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：用工部门
	 */
    public Integer getGongsiId() {
        return gongsiId;
    }


    /**
	 * 获取：用工部门
	 */

    public void setGongsiId(Integer gongsiId) {
        this.gongsiId = gongsiId;
    }
    /**
	 * 设置：面试记录编号
	 */
    public String getMianshijiluUuidNumber() {
        return mianshijiluUuidNumber;
    }


    /**
	 * 获取：面试记录编号
	 */

    public void setMianshijiluUuidNumber(String mianshijiluUuidNumber) {
        this.mianshijiluUuidNumber = mianshijiluUuidNumber;
    }
    /**
	 * 设置：面试记录标题
	 */
    public String getMianshijiluName() {
        return mianshijiluName;
    }


    /**
	 * 获取：面试记录标题
	 */

    public void setMianshijiluName(String mianshijiluName) {
        this.mianshijiluName = mianshijiluName;
    }
    /**
	 * 设置：面试时间
	 */
    public Date getMianshijiluTime() {
        return mianshijiluTime;
    }


    /**
	 * 获取：面试时间
	 */

    public void setMianshijiluTime(Date mianshijiluTime) {
        this.mianshijiluTime = mianshijiluTime;
    }
    /**
	 * 设置：面试内容
	 */
    public String getMianshijiluContent() {
        return mianshijiluContent;
    }


    /**
	 * 获取：面试内容
	 */

    public void setMianshijiluContent(String mianshijiluContent) {
        this.mianshijiluContent = mianshijiluContent;
    }
    /**
	 * 设置：面试结果
	 */
    public Integer getMianshijiluTypes() {
        return mianshijiluTypes;
    }


    /**
	 * 获取：面试结果
	 */

    public void setMianshijiluTypes(Integer mianshijiluTypes) {
        this.mianshijiluTypes = mianshijiluTypes;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
