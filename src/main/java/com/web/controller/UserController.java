package com.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


    @RequestMapping(value = {"/baiviet"}, method = RequestMethod.GET)
    public String baiviet() {
        return "user/baiviet";
    }

    @RequestMapping(value = {"/chitietbaiviet"}, method = RequestMethod.GET)
    public String chitietbaiviet() {
        return "user/chitietbaiviet";
    }

    @RequestMapping(value = {"/dangnhap"}, method = RequestMethod.GET)
    public String dangnhap() {
        return "user/dangnhap";
    }

    @RequestMapping(value = {"/index","/"}, method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = {"/taikhoan"}, method = RequestMethod.GET)
    public String taikhoan() {
        return "user/taikhoan";
    }


    @RequestMapping(value = {"/timdonhang"}, method = RequestMethod.GET)
    public String timdonhang() {
        return "user/timdonhang";
    }
}
