package com.web.api;

import com.web.entity.Banner;
import com.web.servive.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banner")
@CrossOrigin
public class BannerApi {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/public/search")
    public ResponseEntity<?> search(@RequestParam("q") String search, Pageable pageable){
        Page<Banner> banners = bannerService.search(search,pageable);
        return new ResponseEntity<>(banners,HttpStatus.OK);
    }

    @GetMapping("/public/find-by-page")
    public ResponseEntity<?> findByType(@RequestParam(value = "page") String page){
        List<Banner> banners = bannerService.findByPageName(page);
        return new ResponseEntity<>(banners,HttpStatus.OK);
    }


}
