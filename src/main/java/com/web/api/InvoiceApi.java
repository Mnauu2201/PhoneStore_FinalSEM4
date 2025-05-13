package com.web.api;
import com.web.dto.request.InvoiceRequest;
import com.web.dto.response.InvoiceResponse;
import com.web.entity.Category;
import com.web.enums.PayType;
import com.web.enums.StatusInvoice;
import com.web.servive.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/invoice")
@CrossOrigin
public class InvoiceApi {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/user/find-by-user")
    public ResponseEntity<?> findByUser(){
        List<InvoiceResponse> result = invoiceService.findByUser();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/user/find-by-id")
    public ResponseEntity<?> findByUser(@RequestParam("idInvoice") Long idInvoice){
        InvoiceResponse result = invoiceService.findById(idInvoice);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/public/tim-kiem-don-hang")
    public ResponseEntity<?> timKiemDonHang(@RequestParam("id") Long id, @RequestParam("phone") String phone){
        InvoiceResponse result = invoiceService.timKiemDonHang(id, phone);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
