/**
 * 
 */
package com.allen.spring.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class ResourceController {

    @RequestMapping("/demo")
    public String demo(Principal principal) {
        return "Hello "+principal.getName()+", Auth 2.0 Resource Server, Access Granted by authentication server..";
    }
}
