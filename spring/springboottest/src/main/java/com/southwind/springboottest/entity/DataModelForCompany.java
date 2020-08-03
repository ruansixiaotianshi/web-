package com.southwind.springboottest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DataModelForCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //计算结果
    private Double result;
    //创建人
    private String createBy;
    //创建人角色
    private String createByRole;
}
