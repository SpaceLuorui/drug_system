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
 * 退货给供应商
 */
@Data
@TableName(value = "returnsupplier.sql")
public class ReturnSupplier implements Serializable {
    /*主键*/
    //@TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*药品名称*/
    private String dname;
    /*数量*/
    private Integer dcount;
    /*供应商名称*/
    private String sname;
    /*进货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;
    /*退货原因*/
    private String reason;
    /*退货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;


    /*进货时间转换成年月日*/
    public String getBuytimeStr(){
        return DateUtil.dateConvert(buytime);
    }
    /*退货时间转换成年月日*/
    public String getCreatetimeStr(){
        return DateUtil.dateConvert(createtime);
    }

}
