package com.web.api;

import com.web.entity.Category;
import com.web.entity.Voucher;
import com.web.servive.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voucher")
@CrossOrigin
public class VoucherApi {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/public/findByCode")
    public ResponseEntity<?> findById(@RequestParam("code") String code, @RequestParam("amount") Double amount){
        Optional<Voucher> result = voucherService.findByCode(code, amount);
        return new ResponseEntity<>(result.get(),HttpStatus.OK);
    }
}
