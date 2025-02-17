package com.entity.vo;

import com.entity.ZhaopinYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 兼职报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhaopin_yuyue")
public class ZhaopinYuyueVO implements Serializable {
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
     * 招聘
     */

    @TableField(value = "zhaopin_id")
    private Integer zhaopinId;


    /**
     * 备注
     */

    @TableField(value = "zhaopin_yuyue_text")
    private String zhaopinYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "zhaopin_yuyue_yesno_types")
    private Integer zhaopinYuyueYesnoTypes;


    /**
     * 回复
     */

    @TableField(value = "zhaopin_yuyue_yesno_text")
    private String zhaopinYuyueYesnoText;


    /**
     * 投递时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：招聘
	 */
    public Integer getZhaopinId() {
        return zhaopinId;
    }


    /**
	 * 获取：招聘
	 */

    public void setZhaopinId(Integer zhaopinId) {
        this.zhaopinId = zhaopinId;
    }
    /**
	 * 设置：备注
	 */
    public String getZhaopinYuyueText() {
        return zhaopinYuyueText;
    }


    /**
	 * 获取：备注
	 */

    public void setZhaopinYuyueText(String zhaopinYuyueText) {
        this.zhaopinYuyueText = zhaopinYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getZhaopinYuyueYesnoTypes() {
        return zhaopinYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setZhaopinYuyueYesnoTypes(Integer zhaopinYuyueYesnoTypes) {
        this.zhaopinYuyueYesnoTypes = zhaopinYuyueYesnoTypes;
    }
    /**
	 * 设置：回复
	 */
    public String getZhaopinYuyueYesnoText() {
        return zhaopinYuyueYesnoText;
    }


    /**
	 * 获取：回复
	 */

    public void setZhaopinYuyueYesnoText(String zhaopinYuyueYesnoText) {
        this.zhaopinYuyueYesnoText = zhaopinYuyueYesnoText;
    }
    /**
	 * 设置：投递时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：投递时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
