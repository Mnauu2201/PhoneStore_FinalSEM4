package com.web.api;

import com.web.entity.Category;
import com.web.enums.CategoryType;
import com.web.servive.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/public/findAll")
    public ResponseEntity<?> findAll(){
        List<Category> categories = categoryService.findAllList();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/public/search")
    public ResponseEntity<?> search(@RequestParam("q") String search,Pageable pageable){
        Page<Category> categories = categoryService.search(search,pageable);
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/public/find-by-type")
    public ResponseEntity<?> findByType(@RequestParam(value = "type") CategoryType categoryType){
        List<Category> categories = categoryService.findByType(categoryType);
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/public/get-all-category-type")
    public ResponseEntity<?> getAllType(){
        List<CategoryType> type = Arrays.stream(CategoryType.class.getEnumConstants()).toList();
        return new ResponseEntity<>(type,HttpStatus.OK);
    }


}
