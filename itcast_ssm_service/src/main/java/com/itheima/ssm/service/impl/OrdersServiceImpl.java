package com.itheima.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page,int size) {
        //当前页页码值，每页显示条数
        PageHelper.startPage(page,size);

        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(int id) {
        return iOrdersDao.findById(id);
    }
}
