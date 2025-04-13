package com.web.entity;

import com.web.enums.PayType;
import com.web.enums.StatusInvoice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import com.nimbusds.openid.connect.sdk.assurance.evidences.Voucher;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Date createdDate;

    private Time createdTime;

    private Double totalAmount;

    private String receiverName;

    private String phone;

    private String address;

    private String note;

    private PayType payType;

    private StatusInvoice statusInvoice;

    private Timestamp statusUpdateDate;

    private Double shipCost;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private UserAddress userAddress;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;
}
