package com.youkeda.app.dataobject;

import java.time.LocalDateTime;

public class VotesDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 价格
     */
    private double price;

    /**
     * 票名称
     */
    private String name;

    /**
     * 余票数量
     */
    private int stock;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreated;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
