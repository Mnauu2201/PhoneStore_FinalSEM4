package com.web.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.*;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_address")
@Getter
@Setter
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String fullname;

    private String phone;

    private String streetName;

    private Boolean primaryAddres;

    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Wards wards;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
