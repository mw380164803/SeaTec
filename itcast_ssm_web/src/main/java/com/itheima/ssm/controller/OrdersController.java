package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    //查询全部订单----未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView modelAndView=new ModelAndView();
//
//        List<Orders> lists=iOrdersService.findAll();
//
//        modelAndView.addObject("ordersList",lists);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//    }

    //@RequestParam 将请求参数绑定到控制器参数上(通过页面请求的参数来进行实时分页)
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true)int page,@RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView=new ModelAndView();

        List<Orders> lists=iOrdersService.findAll(page,size);
        //PageInfo是一个分页Bean
        PageInfo pageInfo=new PageInfo(lists);

        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-pages-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)int id){
        ModelAndView modelAndView=new ModelAndView();
        Orders orders=iOrdersService.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");

        return modelAndView;
    }
}
