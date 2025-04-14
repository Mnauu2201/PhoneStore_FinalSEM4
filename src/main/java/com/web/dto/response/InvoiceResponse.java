package com.web.dto.response;

@Getter
@Setter
public class InvoiceResponse {
    private Long id;

    private Date createdDate;

    private Time createdTime;

    private Double totalAmount;

    private String receiverName;

    private String phone;

    private String note;

    private String address;

    private PayType payType;

    private UserAdressResponse userAddress;

    private StatusInvoice statusInvoice;

    private Double shipCost;
}
