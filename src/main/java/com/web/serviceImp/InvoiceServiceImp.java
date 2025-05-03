package com.web.serviceImp;

import com.web.config.Environment;
import com.web.dto.request.InvoiceRequest;
import com.web.dto.response.CartResponse;
import com.web.dto.response.InvoiceResponse;
import com.web.entity.*;
import com.web.enums.PayType;
import com.web.enums.StatusInvoice;
import com.web.exception.MessageException;
import com.web.mapper.InvoiceMapper;
import com.web.models.QueryStatusTransactionResponse;
import com.web.processor.QueryTransactionStatus;
import com.web.repository.*;
import com.web.servive.InvoiceService;
import com.web.utils.CommonPage;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Component
public class InvoiceServiceImp implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private HistoryPayRepository historyPayRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    private VoucherRepository voucherRepository;


    @Autowired
    private CommonPage commonPage;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;



    @Autowired
    private ProductColorRepository productColorRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;





    @Override
    public List<InvoiceResponse> findByUser() {
        User user = userUtils.getUserWithAuthority();
        List<Invoice> invoices = invoiceRepository.findByUser(user.getId());
        List<InvoiceResponse> list = invoiceMapper.invoiceListToInvoiceResponseList(invoices);
        return list;
    }

    @Override
    public Page<InvoiceResponse> findAll(Date from, Date to, Pageable pageable) {
        if(from == null || to == null){
            from = Date.valueOf("2000-01-01");
            to = Date.valueOf("2200-01-01");
        }
        Page<Invoice> page = invoiceRepository.findByDate(from, to,pageable);
//        List<InvoiceResponse> list = invoiceMapper.invoiceListToInvoiceResponseList(page.getContent());
//        Page<InvoiceResponse> result = commonPage.restPage(page,list);
        return null;
    }


    @Override
    public InvoiceResponse findById(Long invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        if(invoice.isEmpty()){
            throw new MessageException("invoice id not found");
        }
//        if(invoice.get().getUserAddress().getUser().getId() != userUtils.getUserWithAuthority().getId()){
//            throw new MessageException("access denied");
//        }
        return invoiceMapper.invoiceToInvoiceResponse(invoice.get());
    }

    @Override
    public InvoiceResponse findByIdForAdmin(Long invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        if(invoice.isEmpty()){
            throw new MessageException("invoice id not found");
        }
        return null;
    }

    @Override
    public InvoiceResponse timKiemDonHang(Long id, String phone) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if(invoice.isEmpty()){
            throw new MessageException("Không tìm thấy đơn hàng");
        }
        if(!invoice.get().getUserAddress().getUser().getPhone().equals(phone) && !invoice.get().getPhone().equals(phone)){
            throw new MessageException("Số điện thoại hoặc mã đơn hàng không chính xác");
        }
        return invoiceMapper.invoiceToInvoiceResponse(invoice.get());
    }

    @Override
    public Page<InvoiceResponse> findAllFull(Date from, Date to, PayType payType, StatusInvoice statusInvoice, Pageable pageable) {
        if(from == null || to == null){
            from = Date.valueOf("2000-01-01");
            to = Date.valueOf("2200-01-01");
        }
        Page<Invoice> page = null;
        if(payType == null && statusInvoice == null){
            page = invoiceRepository.findByDate(from, to,pageable);
        }
        if(payType == null && statusInvoice != null){
            page = invoiceRepository.findByDateAndStatus(from, to, statusInvoice,pageable);
        }
        if(payType != null && statusInvoice == null){
            page = invoiceRepository.findByDateAndPaytype(from, to,payType,pageable);
        }
        if(payType != null && statusInvoice != null){
            page = invoiceRepository.findByDateAndPaytypeAndStatus(from, to,payType,statusInvoice,pageable);
        }

        List<InvoiceResponse> list = invoiceMapper.invoiceListToInvoiceResponseList(page.getContent());
        Page<InvoiceResponse> result = commonPage.restPage(page,list);
        return result;
    }
}
