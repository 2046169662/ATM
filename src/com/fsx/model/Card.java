package com.fsx.model;

import java.io.Serializable;

/**
 * 银行卡类
 */
public class Card implements Serializable {
    private static final long serialVersionUID = -8942237295834661898L;//序列号
    private String cardId;//卡号
    private String cardPasswd;//密码
    private double cardmoney;//余额
    private boolean cardStatus = true;//状态

    //构造方法
    public Card() {
    }

    public Card(String cardId, String cardPasswd) {
        this.cardId = cardId;
        this.cardPasswd = cardPasswd;
    }

    //get set
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardPasswd() {
        return cardPasswd;
    }

    public void setCardPasswd(String cardPasswd) {
        this.cardPasswd = cardPasswd;
    }

    public double getCardmoney() {
        return cardmoney;
    }

    public void setCardmoney(double cardmoney) {
        this.cardmoney = cardmoney;
    }

    public boolean isCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(boolean cardStatus) {
        this.cardStatus = cardStatus;
    }

    //toString方法
    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", cardPasswd='" + cardPasswd + '\'' +
                ", cardmoney=" + cardmoney +
                ", cardStatus=" + cardStatus +
                '}';
    }
}