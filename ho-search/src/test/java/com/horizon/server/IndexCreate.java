package com.horizon.server;

import com.horizon.server.search.HoSearchApplication;
import com.horizon.server.search.pojo.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = HoSearchApplication.class)
@RunWith(SpringRunner.class)
public class IndexCreate {

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex(){
        template.createIndex(Store.class);
    }
}
