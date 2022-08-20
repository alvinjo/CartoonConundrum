package com.albin.cartoonconundrum.bot.repo;

import com.albin.cartoonconundrum.bot.domain.Cartoon;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartoonRepo {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Cartoon save(Cartoon cartoon){
        dynamoDBMapper.save(cartoon);
        return cartoon;
    }

    public Cartoon get(String cartoonId){
        return dynamoDBMapper.load(Cartoon.class, cartoonId);
    }

    public List<Cartoon> getAllExcluding(List<String> cartoonIds){
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        cartoonIds.forEach(cid -> expressionAttributeValues.put(":v1", new AttributeValue().withS(cid)));

        DynamoDBQueryExpression<Cartoon> queryExpression = new DynamoDBQueryExpression<Cartoon>()
                .withKeyConditionExpression("ID != :v1")
                .withExpressionAttributeValues(expressionAttributeValues);

        return new ArrayList<>(dynamoDBMapper.query(Cartoon.class, queryExpression));
    }

}
