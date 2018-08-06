/**
 * 
 */
package com.allen.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class CookieController {

    @RequestMapping(path = "/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session");
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session,browser is " + sessionBrowser);
        }
        Cookie[] cookie = request.getCookies();
        if(cookie != null && cookie.length>0) {
            for (Cookie cookie2 : cookie) {
                System.out.println(cookie2.getName()+":"+cookie2.getValue());
            }
        }
        return "success";
    }
}
