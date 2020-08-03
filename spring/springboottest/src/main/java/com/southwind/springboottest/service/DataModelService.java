package com.southwind.springboottest.service;

import com.southwind.springboottest.entity.DataModel;
import com.southwind.springboottest.entity.DataModelForCompany;
import com.southwind.springboottest.entity.User;
import com.southwind.springboottest.repository.DataModelMapper;
import com.southwind.springboottest.repository.DataModelRepository;
import com.southwind.springboottest.repository.UserRepository;
import com.southwind.springboottest.util.PaillierUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DataModelService {
    @Autowired
    DataModelRepository dataModelRepository;
    @Resource
    DataModelMapper dataModelMapper;
    @Autowired
    UserRepository userRepository;
//@Component (value = "dataModelMapper")
    public Page<DataModel> findAll(Pageable pageRequest, String createBy) {
        Page<DataModel> dataModelPage = null;
        DataModel dataModel = new DataModel();

        User user = userRepository.findByUsername(createBy);
        String role = user.getRole();
        //1.如果是浪潮人员，只可以查看id,result,createBy,createByRole,
        if ( "company".equals(role)) {
            ArrayList<DataModel> dataModelArrayList = new ArrayList<>();
            List<DataModel> dataModelForCompanyList = dataModelMapper.findByCreateByRole(role);
            //公司的單獨用了一個分頁。又點問題。後面再改PageImpl
            return new PageImpl<DataModel>(dataModelForCompanyList, pageRequest, dataModelForCompanyList.size());
        }else if ("user".equals(role) ) {
            //如果是用户，可以查看当前用户下数据
            dataModel.setCreateBy(createBy);
            Example<DataModel> modelExample = Example.of(dataModel);
            dataModelPage = dataModelRepository.findAll(modelExample,pageRequest);
        }else if ("gov".equals(role) ){
            //如果是政府，可以查看所有用户下数据
//            dataModel.setCreateBy(createBy);
            Example<DataModel> modelExample = Example.of(dataModel);
            dataModelPage = dataModelRepository.findAll(modelExample,pageRequest);
        }
        return dataModelPage;
    }
    public DataModel findById(Integer id) {
        DataModel dataModel = new DataModel();
        Optional<DataModel> optional = dataModelRepository.findById(id);
        if (optional.isPresent()) {
             dataModel = optional.get();
        }
        return dataModel;
    }

    public void deleteById(Integer id) {
         dataModelRepository.deleteById(id);
    }

    public DataModel encode(DataModel dataModel) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (dataModel != null && dataModel.getFund() != null && dataModel.getSecurity() != null) {
             result = PaillierUtil.encode(dataModel.getFund(), dataModel.getSecurity());
        }
        dataModel.setResult((Double) result.get("result"));
        dataModel.setFundEncode( result.get("fund_encode").toString());
        dataModel.setSecurityEncode( result.get("security_encode").toString());
        //查找当前用户角色
        User user = userRepository.findByUsername(dataModel.getCreateBy());
        String role = user.getRole();
        dataModel.setCreateByRole(role);
        dataModelRepository.save(dataModel);
        return dataModel;
    }
    public DataModel update(DataModel dataModel) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        if (dataModel != null && dataModel.getFund() != null && dataModel.getSecurity() != null) {
            result = PaillierUtil.encode(dataModel.getFund(), dataModel.getSecurity());
        }
        dataModel.setResult((Double) result.get("result"));
        dataModel.setFundEncode(result.get("fund_encode").toString());
        dataModel.setSecurityEncode(result.get("security_encode").toString());
        //查找当前用户角色
        User user = userRepository.findByUsername(dataModel.getCreateBy());
        String role = user.getRole();
        dataModel.setCreateByRole(role);
        dataModelRepository.saveAndFlush(dataModel);
        return dataModel;
    }
}