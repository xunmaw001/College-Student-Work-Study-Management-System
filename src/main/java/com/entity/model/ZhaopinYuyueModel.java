package com.entity.model;

import com.entity.ZhaopinYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 兼职报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhaopinYuyueModel implements Serializable {
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
     * 招聘
     */
    private Integer zhaopinId;


    /**
     * 备注
     */
    private String zhaopinYuyueText;


    /**
     * 报名状态
     */
    private Integer zhaopinYuyueYesnoTypes;


    /**
     * 回复
     */
    private String zhaopinYuyueYesnoText;


    /**
     * 投递时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：招聘
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }


    /**
	 * 设置：招聘
	 */
    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 获取：备注
	 */
    public String getZhaopinYuyueText() {
        return zhaopinYuyueText;
    }


    /**
	 * 设置：备注
	 */
    public void setZhaopinYuyueText(String zhaopinYuyueText) {
        this.zhaopinYuyueText = zhaopinYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getZhaopinYuyueYesnoTypes() {
        return zhaopinYuyueYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setZhaopinYuyueYesnoTypes(Integer zhaopinYuyueYesnoTypes) {
        this.zhaopinYuyueYesnoTypes = zhaopinYuyueYesnoTypes;
    }
    /**
	 * 获取：回复
	 */
    public String getZhaopinYuyueYesnoText() {
        return zhaopinYuyueYesnoText;
    }


    /**
	 * 设置：回复
	 */
    public void setZhaopinYuyueYesnoText(String zhaopinYuyueYesnoText) {
        this.zhaopinYuyueYesnoText = zhaopinYuyueYesnoText;
    }
    /**
	 * 获取：投递时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：投递时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
