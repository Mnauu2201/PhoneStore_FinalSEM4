package com.web.servive;

import com.web.dto.request.UserAdressRequest;
import com.web.dto.response.UserAdressResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserAddressService {

    public List<UserAdressResponse> findByUser();


}
