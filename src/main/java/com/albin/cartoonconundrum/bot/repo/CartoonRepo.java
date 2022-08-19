package com.albin.cartoonconundrum.bot.repo;

import com.albin.cartoonconundrum.bot.domain.Cartoon;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CartoonRepo extends CrudRepository<Cartoon, String> {

}