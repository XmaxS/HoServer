package com.horizon.server.search.repository;

import com.horizon.server.itemInterface.pojo.Store;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StoreRepository extends ElasticsearchRepository<Store,Long> {
}
