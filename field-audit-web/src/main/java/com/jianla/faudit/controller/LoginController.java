package com.jianla.faudit.controller;

import com.jianla.model.base.SessionInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String doLogin(Long orgId, HttpSession session){
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setOrgnizationId(orgId);
        session.setAttribute("sessionInfo",sessionInfo);
        return "redirect:/index";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
