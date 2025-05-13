package com.web.serviceImp;

import com.web.dto.request.UserAdressRequest;
import com.web.dto.response.UserAdressResponse;
import com.web.entity.User;
import com.web.entity.UserAddress;
import com.web.exception.MessageException;
import com.web.mapper.UserAddressMapper;
import com.web.repository.InvoiceRepository;
import com.web.repository.UserAddressRepository;
import com.web.servive.UserAddressService;
import com.web.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserAddressServiceImp implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAdressResponse> findByUser() {
        User user = userUtils.getUserWithAuthority();
        List<UserAddress> userAddresses = userAddressRepository.findByUser(user.getId());
        List<UserAdressResponse> responses = userAddressMapper.listUserAddToListResponse(userAddresses);
        return responses;
    }


}
