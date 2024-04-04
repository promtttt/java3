package com.example.testtest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private Integer orderNumber;
    private Date orderDate;
    private Date requriredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private Integer customerNumber;

}
