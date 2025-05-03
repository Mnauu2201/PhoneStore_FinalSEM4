package com.web.api;
import com.web.entity.Category;
import com.web.entity.TradeMark;
import com.web.servive.CategoryService;
import com.web.servive.TradeMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trademark")
@CrossOrigin
public class TradeMarkApi {

    @Autowired
    private TradeMarkService tradeMarkService;


    @GetMapping("/public/findAll")
    public ResponseEntity<?> findAll(){
        List<TradeMark> tradeMarks = tradeMarkService.findAllList();
        return new ResponseEntity<>(tradeMarks, HttpStatus.OK);
    }

    @GetMapping("/public/search")
    public ResponseEntity<?> search(@RequestParam("q") String search,Pageable pageable){
        Page<TradeMark> result = tradeMarkService.search(search,pageable);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
