package com.horizon.server.search;

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

    @Test
    public void createdIndex(){
        template.createIndex(IndexStore.class);
    }

}