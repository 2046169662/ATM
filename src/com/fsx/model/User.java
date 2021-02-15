package com.fsx.model;

import java.io.Serializable;

/**
 * 用户类
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1115644117300726088L;     //序列号
    private String username;        //姓名
    private String idCard;          //身份证
    private String Phone;           //电话号码
    private Card card;              //银行卡

    //构造方法
    public User() {
    }

    public User(String username, String idCard, String phone, Card card) {
        this.username = username;
        this.idCard = idCard;
        Phone = phone;
        this.card = card;
    }

    //get set
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    //toString方法
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", Phone='" + Phone + '\'' +
                ", card=" + card +
                '}';
    }
}