package com.southwind.springboottest.controller;

import com.southwind.springboottest.entity.DataModel;
import com.southwind.springboottest.entity.Govern;
import com.southwind.springboottest.entity.Result;
import com.southwind.springboottest.entity.User;
import com.southwind.springboottest.repository.GovernRepository;
import com.southwind.springboottest.service.DataModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataManage")
public class DataManageController {
    @Autowired
    private DataModelService dataModelService;

    @GetMapping("/findAll/{page}/{size}/{createBy}")
    public  Page<DataModel> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("createBy") String createBy){
        Pageable pageable = PageRequest.of(page,size);
        Page<DataModel> modelPage = dataModelService.findAll(pageable,createBy);
        return modelPage;
    }

    @PostMapping("/save")
    public Result save(@RequestBody DataModel dataModel){
        DataModel dataModel1 = dataModelService.encode(dataModel);
        if (dataModel1.getResult().equals(0)) {
            return new Result(400, "数据保存失败");
        }else {
            return new Result(200, "数据保存成功",dataModel1);
        }
    }

    @GetMapping("/findById/{id}")
    public DataModel findById(@PathVariable("id") Integer id){
        return dataModelService.findById(id);
    }


//
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        dataModelService.deleteById(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody DataModel dataModel){
        DataModel model = dataModelService.update(dataModel);
        if(model != null){
            return new Result(200,"修改成功",model);
        }else{
            return new Result(400,"修改失败",model);
        }
    }
}
