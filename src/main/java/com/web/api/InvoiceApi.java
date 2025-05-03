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


    @GetMapping("/admin/find-by-id")
    public ResponseEntity<?> findByAdmin(@RequestParam("idInvoice") Long idInvoice){
        InvoiceResponse result = invoiceService.findById(idInvoice);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/admin/find-all")
    public ResponseEntity<?> findAll(@RequestParam(value = "from",required = false) Date from,
                                     @RequestParam(value = "to",required = false) Date to,
                                     @RequestParam(value = "paytype",required = false) PayType payType,
                                     @RequestParam(value = "status",required = false) StatusInvoice statusInvoice, Pageable pageable){
        Page<InvoiceResponse> result = invoiceService.findAllFull(from, to,payType, statusInvoice,pageable);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/admin/all-status")
    public ResponseEntity<?> allStatus(){
        List<StatusInvoice> result = Arrays.stream(StatusInvoice.class.getEnumConstants()).toList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/admin/update-status")
    public ResponseEntity<?> updateStatus(@RequestParam("idInvoice") Long idInvoice, @RequestParam("status") StatusInvoice statusInvoice){
        InvoiceResponse result = invoiceService.updateStatus(idInvoice, statusInvoice);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


}
