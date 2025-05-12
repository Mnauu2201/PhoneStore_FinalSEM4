package com.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


    @RequestMapping(value = {"/dangnhap"}, method = RequestMethod.GET)
    public String dangnhap() {
        return "user/dangnhap";
    }


    @RequestMapping(value = {"/diachi"}, method = RequestMethod.GET)
    public String diachi() {
        return "user/diachi";
    }


    @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String product() {
        return "user/product";
    }

    @RequestMapping(value = {"/quenmatkhau"}, method = RequestMethod.GET)
    public String quenmatkhau() {
        return "user/quenmatkhau";
    }


}
