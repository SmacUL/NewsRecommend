package com.smacul.demo.service.serviceImpl;

import com.smacul.demo.bean.Customer;
import com.smacul.demo.dao.ArticleCustomerBehaviorDao;
import com.smacul.demo.dao.ArticleFeatureCountDao;
import com.smacul.demo.dao.CustomerCustomerFollowDao;
import com.smacul.demo.dao.CustomersDao;
import com.smacul.demo.model.CustomerBehaviorCountModel;
import com.smacul.demo.model.CustomerDynamicModel;
import com.smacul.demo.service.SelfService;
import com.smacul.demo.util.MD5;
import com.smacul.demo.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    CustomersDao customersDao;
    @Autowired
    ArticleCustomerBehaviorDao articleCustomerBehaviorDao;
    @Autowired
    CustomerCustomerFollowDao customerCustomerFollowDao;

    @Override
    public Customer cusLogin(String cusName, String cusPass) throws NoSuchAlgorithmException {
        String cryptString = MD5.MD5Creator(cusPass);
        Customer customer = customersDao.searchCusByName(cusName);
        if (customer != null && cryptString.equals(customer.getCusPass())) {
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public Integer cusRegister(String cusName, String cusPass) throws NoSuchAlgorithmException {
        String cryptString = MD5.MD5Creator(cusPass);
        if (customersDao.countCusByName(cusName) != 0) {
            return 3;
        }
        if (customersDao.insertCus(cusName, cryptString) == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public List<CustomerDynamicModel> getCusSelfDynamic(Integer cusId, Integer page, Integer pageSize) {
        Integer start = PageHandler.calcuStartNO(page, pageSize);
        return articleCustomerBehaviorDao.searchCusSelfDynamic(cusId, start, pageSize);
    }

    @Override
    public Customer getCusBasicInfo(Integer cusId) {
        return customersDao.searchCusFullByCusId(cusId);
    }

    /**
     * 统计用户的行为, 包括关注数, 粉丝数, 文章编辑数, 被点赞数.
     *
     * @param cusId
     * @return
     */
    @Override
    public CustomerBehaviorCountModel getCusCountInfo(Integer cusId) {
        CustomerBehaviorCountModel countModel = new CustomerBehaviorCountModel();
        countModel.setCusId(cusId);
        countModel.setFollowNum(customerCustomerFollowDao.countCusFollowNum(cusId));
        countModel.setFanNum(customerCustomerFollowDao.countCusFanNum(cusId));
        //countModel.setBeLikedNum(articleCustomerBehaviorDao.countCusBeLikedNum(cusId));
        countModel.setWriteNum(articleCustomerBehaviorDao.countCusWriteNum(cusId));
        return countModel;
    }

    //@Override
    //public Customer modifyCusSelfInfo(Customer customer) {
    //    //return customersDao.updateCusInfo(customer);
    //    if (customer.getCusPass() != null) {
    //
    //    }
    //}
}
