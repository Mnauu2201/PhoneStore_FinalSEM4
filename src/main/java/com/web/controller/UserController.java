package com.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


    @RequestMapping(value = {"/dangky"}, method = RequestMethod.GET)
    public String dangky() {
        return "user/dangky";
    }

    @RequestMapping(value = {"/dangnhap"}, method = RequestMethod.GET)
    public String dangnhap() {
        return "user/dangnhap";
    }

    @RequestMapping(value = {"/datlaimatkhau"}, method = RequestMethod.GET)
    public String datlaimatkhau() {
        return "user/datlaimatkhau";
    }

    @RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
    public String detail() {
        return "user/detail";
    }

    @RequestMapping(value = {"/quenmatkhau"}, method = RequestMethod.GET)
    public String quenmatkhau() {
        return "user/quenmatkhau";
    }

    @RequestMapping(value = {"/xacnhan"}, method = RequestMethod.GET)
    public String xacnhan() {
        return "user/xacnhan";
    }


}
