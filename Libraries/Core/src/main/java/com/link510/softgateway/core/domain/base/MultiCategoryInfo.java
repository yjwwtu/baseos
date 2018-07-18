package com.link510.softgateway.core.domain.base;


import java.util.ArrayList;
import java.util.List;

/**
 * 分层分类,二级分类来用
 */
public class MultiCategoryInfo {

    /**
     * 主分类
     */
    private CategoryInfo categoryInfo;


    /**
     * 子分类列表
     */
    private List<CategoryInfo> itemList;

    public MultiCategoryInfo() {
    }

    public MultiCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
        this.itemList = new ArrayList<>();
    }

    public MultiCategoryInfo(CategoryInfo categoryInfo, List<CategoryInfo> itemList) {
        this.categoryInfo = categoryInfo;
        this.itemList = itemList;
    }



    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public List<CategoryInfo> getItemList() {
        return itemList;
    }

    public void setItemList(List<CategoryInfo> itemList) {
        this.itemList = itemList;
    }


    @Override
    public String toString() {
        return "MultiCategoryInfo{" +
                "categoryInfo=" + categoryInfo +
                ", itemList=" + itemList +
                '}';
    }
}
