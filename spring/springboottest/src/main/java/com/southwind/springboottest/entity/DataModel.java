package com.southwind.springboottest.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@Table(name="data_model")
public class DataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //公积金费用
    private String fund;
    //社保费用
    private String security;
    //公积金-加密结果
    private String fundEncode;
    //社保费用-加密结果
    private String securityEncode;
    //计算结果
    private Double result;
    //创建人
    private String createBy;
    //创建人角色
    private String createByRole;
}
