package com.youkeda.category.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Category {

   private String id;
    private  String name;
    private  String description;
    private  String parentCategoryId;
    private List<Category> subCategoryList;
    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

}
