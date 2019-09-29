package com.horizon.server.search.listener;

import com.horizon.server.search.service.SearchService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreListener {

    @Autowired
    private SearchService searchService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "ho.search.insert.queue",durable = "true"),
            exchange = @Exchange(name = "ho.item.exchange",
                    type = ExchangeTypes.TOPIC,
                    ignoreDeclarationExceptions = "true"),
            key = {"item.insert","item.update"}
    ))
    public void listenInsert(Long sid){
        if (sid != null){
            searchService.insertOrUpdate(sid);
        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "ho.search.delete.queue",durable = "true"),
            exchange = @Exchange(name = "ho.item.exchange",
                    type = ExchangeTypes.TOPIC,
                    ignoreDeclarationExceptions = "true"),
            key = "item.delete"
    ))
    public void listenDelete(Long sid){
        if (sid != null){
            searchService.delete(sid);
        }
    }
}
