package com.southwind.springboottest.entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@Entity
@Data
@Table(name="user")
public class User {
@JsonIgnoreProperties({"handler","hibernateLazyInitialize"})
@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
    Integer id;
    String username;
    String password;
    String role;

}

