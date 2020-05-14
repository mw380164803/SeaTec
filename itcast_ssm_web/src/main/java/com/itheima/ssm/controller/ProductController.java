package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<Product> lists=iProductService.findAll();
        System.out.println("流石小土猫");
        for(Product p:lists){
            System.out.println(p.getId()+" "+p.getProductPrice()+" "+p.getProductStatus()+" "+p.getCityName()+" "
            +p.getDepartureTime()+" "+p.getProductDesc()+" "+p.getProductName()+" "+p.getProductNum());
        }
        modelAndView.addObject("productList",lists);
        //利用setViewName指定跳转的位置
        modelAndView.setViewName("product-list1");

        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Product product){
        iProductService.save(product);
        return "redirect:findAll.do";
    }
}
