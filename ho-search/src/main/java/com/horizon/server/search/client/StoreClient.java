package com.horizon.server.search.client;

import com.horizon.server.itemInterface.api.StoreApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("item-service")
public interface StoreClient extends StoreApi {
}
