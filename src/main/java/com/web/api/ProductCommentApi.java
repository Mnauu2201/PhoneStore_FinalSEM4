package com.web.api;

import com.web.dto.request.CommentRequest;
import com.web.dto.request.UserAdressRequest;
import com.web.dto.response.ProductCommentResponse;
import com.web.dto.response.UserAdressResponse;
import com.web.servive.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product-comment")
@CrossOrigin
public class ProductCommentApi {

    @Autowired
    private ProductCommentService productCommentService;


    @DeleteMapping("/admin/delete")
    public ResponseEntity<?> deleteByAdmin(@RequestParam("id") Long id){
        productCommentService.deleteByAdmin(id);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/public/find-by-product")
    public ResponseEntity<?> findAll(@RequestParam("idproduct") Long idproduct){
        List<ProductCommentResponse> result = productCommentService.findByProductId(idproduct);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
