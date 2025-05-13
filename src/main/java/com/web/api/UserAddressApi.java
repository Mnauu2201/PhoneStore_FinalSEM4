package com.web.api;

import com.web.dto.request.UserAdressRequest;
import com.web.dto.response.UserAdressResponse;
import com.web.entity.Category;
import com.web.servive.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user-address")
@CrossOrigin
public class UserAddressApi {

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/user/my-address")
    public ResponseEntity<?> findAll(Pageable pageable){
        List<UserAdressResponse> result = userAddressService.findByUser();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }



}
