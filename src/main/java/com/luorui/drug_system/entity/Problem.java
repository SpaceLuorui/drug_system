package com.luorui.drug_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 罗锐
 * @date 2023/4/27
 * 问题药品
 */
@Data
@TableName(value = "problem")
public class Problem implements Serializable {
    /*主键*/
    //@TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*药品名称*/
    private String dname;
    /*数量*/
    private Integer dcount;
    /*价格*/
    private Integer dprice;
    /*原因*/
    private String reason;
    /*操作时间*/
    private Date createtime;
}
