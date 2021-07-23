package com.project.digitallibrary.dto;


import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.LinkedHashMap;
import java.util.Map;

public class Asset {
    private Integer id;
    private String category;
    private String subCategory;
    private Integer quantity;
    private String name;
    private String location;
    private AssetInfo details;
    private Map<String, Object> information = new LinkedHashMap<>();

    public Asset(Integer id, String category, String subCategory, Integer quantity, String name, String location, AssetInfo details, Map<String, Object> information) {
        this.id = id;
        this.category = category;
        this.subCategory = subCategory;
        this.quantity = quantity;
        this.name = name;
        this.location = location;
        this.details = details;
        this.information = information;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public AssetInfo getDetails() {
        return details;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDetails(AssetInfo details) {
        this.details = details;
    }

    public Map<String, Object> getInformation() {
        return information;
    }

    @JsonAnySetter
    public void setConfigDetails(String key, Object value) { information.put(key, value);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", details=" + details +
                ", information=" + information +
                '}';
    }
}
