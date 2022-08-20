package com.albin.cartoonconundrum.bot.rest;

import com.albin.cartoonconundrum.bot.domain.Cartoon;
import com.albin.cartoonconundrum.bot.service.CartoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoon")
public class CartoonRest {

    @Autowired
    private CartoonService cartoonService;

    @GetMapping("/test")
    public Cartoon test(){
        return cartoonService.test();
    }

    @GetMapping("/testt")
    public String testt(){
        return "asd";
    }

}
