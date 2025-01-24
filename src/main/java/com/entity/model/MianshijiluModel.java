package com.entity.model;

import com.entity.MianshijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 面试记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MianshijiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 用工部门
     */
    private Integer gongsiId;


    /**
     * 面试记录编号
     */
    private String mianshijiluUuidNumber;


    /**
     * 面试记录标题
     */
    private String mianshijiluName;


    /**
     * 面试时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date mianshijiluTime;


    /**
     * 面试内容
     */
    private String mianshijiluContent;


    /**
     * 面试结果
     */
    private Integer mianshijiluTypes;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
