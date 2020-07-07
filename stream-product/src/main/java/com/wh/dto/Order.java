package com.wh.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author wangwenhao
 * @description Order
 * @date 2020-07-07 11:21
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -7351639694988106986L;

    private Long orderNo;

    private String consumer;

    private Long consumerId;

    public Order() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(orderNo, order.orderNo) &&
                Objects.equals(consumer, order.consumer) &&
                Objects.equals(consumerId, order.consumerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNo, consumer, consumerId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", consumer='" + consumer + '\'' +
                ", consumerId=" + consumerId +
                '}';
    }
}
