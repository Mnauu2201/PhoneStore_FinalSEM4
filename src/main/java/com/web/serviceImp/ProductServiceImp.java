package com.web.serviceImp;

import com.web.dto.request.ColorRequest;
import com.web.dto.request.ProductRequest;
import com.web.dto.request.StorageRequest;
import com.web.entity.*;
import com.web.enums.CategoryType;
import com.web.exception.MessageException;
import com.web.mapper.ProductMapper;
import com.web.repository.*;
import com.web.servive.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

@Component
@Repository
public class ProductServiceImp implements ProductService {


    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private TradeMarkRepository tradeMarkRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> search(String param, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Product> searchByAdmin(String param, Long categoryId, Long trademarkId, Pageable pageable) {
        if (param == null) {
            param = "";
        }
        Page<Product> page = null;
        if (categoryId == null && trademarkId == null) {
            page = productRepository.findByParam("%" + param + "%", pageable);
        }
        if (categoryId != null && trademarkId == null) {
            page = productRepository.findByParamAndCate("%" + param + "%", categoryId, pageable);
        }
        if (categoryId == null && trademarkId != null) {
            page = productRepository.findByParamAndTrademark("%" + param + "%", trademarkId, pageable);
        }
        if (categoryId != null && trademarkId != null) {
            page = productRepository.findByParamAndTrademarkAndCate("%" + param + "%", trademarkId, categoryId, pageable);
        }
        return page;
    }


    @Override
    public Product findByIdForAdmin(Long id) {
        Optional<Product> exist = productRepository.findById(id);
        if (exist.isEmpty()) {
            throw new MessageException("product not found");
        }
        return exist.get();
    }

    @Override
    public Page<Product> newProduct(Pageable pageable) {
        Page<Product> page = productRepository.newProduct(pageable);
        return page;
    }

    @Override
    public Page<Product> phuKien(Pageable pageable) {
        Page<Product> page = productRepository.phuKien(CategoryType.PHU_KIEN,pageable);
        return page;
    }


    @Override
    public Page<Product> bestsaler(Pageable pageable) {
        Page<Product> page = productRepository.bestSaler(CategoryType.DIEN_THOAI,pageable);
        return page;
    }

    @Override
    public Page<Product> sanPhamLienQuan(Pageable pageable, Long idTrademark, Long idCategory, Long idproduct) {
        Page<Product> page = null;
        if(idTrademark != null){
            System.out.println("san pham tt 1");
            page = productRepository.sanPhamLienQuan(CategoryType.DIEN_THOAI, idTrademark, idproduct,pageable);
        }
        if(idCategory != null){
            System.out.println("san pham tt 2");
            page = productRepository.sanPhamLienQuanCate(idCategory,idproduct,pageable);
        }
        return page;
    }

    @Override
    public Page<Product> locSanPham(Double smallPrice, Double largePrice, Long idCategory, String trademark, String search, Pageable pageable) {
        if(search == null){
            search = "";
        }
        search = "%"+search+"%";
        Page<Product> page = null;
        if(idCategory == null && trademark == null){
            page = productRepository.locSanPham(search, smallPrice, largePrice, pageable);
        }
        if(idCategory == null && trademark != null){
            page = productRepository.locSanPham(search, smallPrice, largePrice,trademark, pageable);
        }
        if(idCategory != null && trademark == null){
            page = productRepository.locSanPham(search, smallPrice, largePrice,idCategory, pageable);
        }
        if(idCategory != null && trademark != null){
            page = productRepository.locSanPham(search, smallPrice, largePrice,trademark, idCategory, pageable);
        }
        return page;
    }

}
