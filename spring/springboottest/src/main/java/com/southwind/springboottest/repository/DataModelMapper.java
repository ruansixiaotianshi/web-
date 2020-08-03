package com.southwind.springboottest.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.southwind.springboottest.entity.DataModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//import com.southwind.springboottest.entity.DataModelForCompany;

public interface DataModelMapper extends BaseMapper<DataModel> {
    List<DataModel> findByCreateByRole(@Param("CreateByRole") String CreateByRole);

//    @Query(value = "select id,result,create_by,create_by_role from data_model", nativeQuery = true)
//    List<DataModelForCompany> findByCreateByRole();
}
