package com.albin.cartoonconundrum.bot.service;

import com.albin.cartoonconundrum.bot.domain.Cartoon;
import com.albin.cartoonconundrum.bot.repo.CartoonRepo;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartoonService {

    private JDA jda;

    private String token;

    @Autowired
    private CartoonRepo cartoonRepo;

    public CartoonService(){
//        try{
//            initJDA(token);
//
//
//        } catch (LoginException e) {
//            e.printStackTrace();
//        }
    }

    @PostConstruct
    public void tt(){
        System.out.println(cartoonRepo);
    }

    public Cartoon test(){
        return cartoonRepo.get("1");
    }

    private void initJDA(String token) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(token);

        // Disable parts of the cache
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);
        // Disable compression (not recommended)
        builder.setCompression(Compression.NONE);
        // Set activity (like "playing Something")
        builder.setActivity(Activity.watching("TV"));

        jda = builder.build();
    }

}
