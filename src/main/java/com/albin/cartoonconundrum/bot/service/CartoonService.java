package com.albin.cartoonconundrum.bot.service;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class CartoonService {

    private JDA jda;

    private String token;

    public CartoonService(){
        try{
            initJDA(token);


        } catch (LoginException e) {
            e.printStackTrace();
        }
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
