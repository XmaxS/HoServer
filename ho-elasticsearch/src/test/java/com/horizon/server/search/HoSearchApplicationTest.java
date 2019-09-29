package com.horizon.server.search;

import com.horizon.server.itemInterface.pojo.Store;
import com.horizon.server.search.client.StoreClient;
import com.horizon.server.search.pojo.IndexStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HoSearchApplicationTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private StoreClient storeClient;

    @Test
    public void createdIndex(){
        template.createIndex(IndexStore.class);
    }

    @Test
    public void storeClientTest(){
        Store store = storeClient.queryStoreBySid(3L);
        System.out.println(store);
    }

}