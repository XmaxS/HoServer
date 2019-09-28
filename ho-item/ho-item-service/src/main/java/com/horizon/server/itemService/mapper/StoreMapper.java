package com.horizon.server.itemService.mapper;

import com.horizon.server.common.mapper.BaseMapper;
import com.horizon.server.itemInterface.pojo.Category;
import com.horizon.server.itemInterface.pojo.Store;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper extends BaseMapper<Store,Long> {

    @Insert("insert into tb_category_store (category_id, store_id) values (#{cid}, #{sid})")
    int insertCategoryStore(@Param("cid") Long cid, @Param("sid") Long sid);

    @Select("select * from tb_category where id in (select category_id from tb_category_store where store_id = #{sid})")
    List<Category> queryCategoryBySid(Long sid);

    @Delete("delete from tb_category_store where store_id = #{sid}")
    int deleteCategoryStoreBySid(Long sid);

    @Select("select * from tb_store where id in (select store_id from tb_category_store where category_id = #{cid})")
    List<Store> queryStoreByCid(Long cid);

}
