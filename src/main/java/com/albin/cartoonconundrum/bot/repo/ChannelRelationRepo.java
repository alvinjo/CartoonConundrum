package com.albin.cartoonconundrum.bot.repo;

import com.albin.cartoonconundrum.bot.domain.ChannelRelation;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ChannelRelationRepo extends CrudRepository<ChannelRelation, String> {

}
