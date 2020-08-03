package com.southwind.springboottest.repository;
import com.southwind.springboottest.entity.DataModel;
//import com.southwind.springboottest.entity.DataModelForCompany;
import com.southwind.springboottest.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataModelRepository extends JpaRepository<DataModel,Integer>{
    DataModel findByCreateByRole(String CreateByRole);

//    @Query(value = "select id,result,create_by,create_by_role from data_model", nativeQuery = true)
//    List<DataModelForCompany> findByCreateByRole();
}
