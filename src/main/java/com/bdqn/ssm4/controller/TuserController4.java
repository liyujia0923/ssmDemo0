package com.bdqn.ssm4.controller;

import com.bdqn.ssm4.entity.Tuser4;
import com.bdqn.ssm4.service.TuserService4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 佳 on 2017/12/7.
 */
@Controller
@RequestMapping("user")
public class TuserController4 {
    @Resource
    private TuserService4 tuserService4;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Tuser4 tuser4, HttpSession session, Model model) {
        Tuser4 loginUser = tuserService4.login(tuser4);
        if (null != loginUser) {
            session.setAttribute("loginUser", loginUser);
            return "comm/main";
        }
        model.addAttribute("message", "用户名或密码错误");
        return "index";
    }

    @RequestMapping(value = "loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index_bootstrap";
    }
    }
