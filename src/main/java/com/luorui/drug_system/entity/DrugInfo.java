package com.luorui.drug_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.luorui.drug_system.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 罗锐
 * @date 2023/4/27
 * 药品信息
 */
@Data
@TableName(value = "druginfo.sql")
public class DrugInfo implements Serializable {
    /*主键*/
    //@TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*药品名称*/
    private String name;
    /*药厂名称*/
    private String supplier;
    /*生产时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;
    /*保质期（月）*/
    private String warrenty;
    /*药品编码*/
    private String number;
    /*价格*/
    private Float price;
    /*库存*/
    private Integer stock;
    /*生产时间转换成年月日*/
    public String getProducttimeStr(){
        return DateUtil.dateConvert(producttime);
    }
}
