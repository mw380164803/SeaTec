package com.itheima.ssm.test;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import java.util.List;

public class test {
    @Autowired
    private IProductService iProductService;

    @Test
    public void run1(){
        List<Product> lists=iProductService.findAll();
        System.out.println(lists.size());
    }

}
