package com.albin.cartoonconundrum.bot.repo;

import com.albin.cartoonconundrum.bot.domain.Cartoon;
import com.albin.cartoonconundrum.bot.domain.Discord;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DiscordRepo extends CrudRepository<Discord, String> {

}
