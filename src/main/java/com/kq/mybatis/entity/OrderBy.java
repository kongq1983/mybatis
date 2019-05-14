package com.kq.mybatis.entity;

/**
 * OrderBy
 *
 * @author kq
 * @date 2019-05-14
 */
public class OrderBy {

    private String orderByField;
    private Integer orderBy;

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderBy{");
        sb.append("orderByField='").append(orderByField).append('\'');
        sb.append(", orderBy=").append(orderBy);
        sb.append('}');
        return sb.toString();
    }
}
