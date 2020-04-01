package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 * */
public class Orders {

    private Integer id;
    private String  orderNum;//订单号
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date    orderTime;//下单时间
    private String orderTimeStr;
    private Integer peopleCount;//出行人数
    private String orderDesc;//目的地
    private Integer payType;//支付方式，0：微信 1：支付宝
    private String payTypeStr;
    private Integer orderStatus;//订单状态，0：未支付 1：已支付
    private String orderStatusStr;

    private List<Traveller> travellers;
    private Product product;//产品
    private Member member;//会员信息(联系人信息)

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtils.dateToString(orderTime,"yyyy-MM-dd HH:mm");
        }

        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        return payType==0?"微信":"支付宝";
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        return orderStatus==0?"未支付":"已支付";
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
