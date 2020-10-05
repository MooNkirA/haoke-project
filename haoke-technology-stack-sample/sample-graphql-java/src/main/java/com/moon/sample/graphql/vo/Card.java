package com.moon.sample.graphql.vo;

import java.util.StringJoiner;

/**
 * 卡实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-5 21:55
 * @description
 */
public class Card {

    private String cardNumber;
    private Long userId;

    public Card() {
    }

    public Card(String cardNumber, Long userId) {
        this.cardNumber = cardNumber;
        this.userId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
                .add("cardNumber='" + cardNumber + "'")
                .add("userId=" + userId)
                .toString();
    }

}
