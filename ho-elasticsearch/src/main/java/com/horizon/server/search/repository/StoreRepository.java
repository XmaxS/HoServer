package com.horizon.server.search.repository;


import com.horizon.server.search.pojo.IndexStore;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StoreRepository extends ElasticsearchRepository<IndexStore,Long> {
}
