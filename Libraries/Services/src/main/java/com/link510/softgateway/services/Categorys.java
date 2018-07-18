package com.link510.softgateway.services;

import com.link510.softgateway.core.domain.base.CategoryInfo;
import com.link510.softgateway.core.domain.base.MultiCategoryInfo;
import com.link510.softgateway.core.enums.categories.CateTypeEnums;
import com.link510.softgateway.core.model.MultiSelectListItem;
import com.link510.softgateway.core.model.SelectListItem;
import com.link510.softgateway.core.domain.base.CategoryInfo;
import com.link510.softgateway.core.domain.base.MultiCategoryInfo;
import com.link510.softgateway.core.enums.categories.CateTypeEnums;
import com.link510.softgateway.core.model.MultiSelectListItem;
import com.link510.softgateway.core.model.SelectListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqnews on 2017/4/11.
 */

//发现分类
@Service(value = "Categorys")
public class Categorys {
    @Resource(name = "CategorysData")
    com.link510.softgateway.data.Categorys categorys;


    @Autowired
    private Logs logs;

    //region  发现分类方法

    /**
     * 获得发现分类数量
     *
     * @param condition 条件
     * @return 返回数量
     **/
    public long getCategoryCount(Specification<CategoryInfo> condition) {

        try {
            return categorys.getCategoryCount(condition);
        } catch (Exception e) {
            logs.Write(e, "获得发现分类数量失败");
        }
        return 0;
    }

    /**
     * 创建一条发现分类数据
     *
     * @param CategoryInfo 发现分类模型
     * @return 返回创建信息
     **/
    public CategoryInfo createCategory(CategoryInfo CategoryInfo) {
        try {
            return categorys.createCategory(CategoryInfo);
        } catch (Exception e) {
            logs.Write(e, "创建一条发现分类数据失败");
        }
        return null;
    }

    /**
     * 更新一条发现分类数据
     *
     * @param CategoryInfo 发现分类模型
     **/
    public CategoryInfo updateCategory(CategoryInfo CategoryInfo) {
        try {
            return categorys.updateCategory(CategoryInfo);
        } catch (Exception e) {
            logs.Write(e, "更新一条发现分类数据异常");
        }

        return null;
    }

    /**
     * 删除一条发现分类数据
     *
     * @param cateId 发现分类模型
     **/
    public void deleteCategoryByCateId(Integer cateId) {
        try {
            categorys.deleteCategoryByCateId(cateId);
        } catch (Exception e) {
            logs.Write(e, "删除一条发现分类数据异常");
        }
    }

    /**
     * 批量删除一批发现分类数据
     **/
    public void deleteCategoryByCateIdList(String cateIdList) {
        try {
            categorys.deleteCategoryByCateIdList(cateIdList);
        } catch (Exception e) {
            logs.Write(e, "批量删除一批发现分类数据异常");
        }
    }

    /**
     * 获取一条发现分类数据
     *
     * @param cateId 发现分类模型
     **/
    public CategoryInfo getCategoryByCateId(Integer cateId) {
        try {
            return categorys.getCategoryByCateId(cateId);
        } catch (Exception e) {
            logs.Write(e, "获取一条发现分类数据");
        }

        return null;
    }


    /**
     * 获得发现分类数据列表
     *
     * @param condition 条件
     * @param sort      排序
     * @return 返回CategoryInfo
     **/
    public List<CategoryInfo> getCategoryList(Specification<CategoryInfo> condition, Sort sort) {

        List<CategoryInfo> CategoryList = new ArrayList<CategoryInfo>();
        try {

            CategoryList = categorys.getCategoryList(condition, sort);
        } catch (Exception e) {
            logs.Write(e, "获得发现分类数据列表异常");
        }

        return CategoryList;
    }


    /**
     * 获得发现分类数据列表
     *
     * @param pageSize   每页数
     * @param pageNumber 当前页数
     * @param condition  条件
     * @param sort       排序
     * @return 返回CategoryInfo
     **/
    public Page<CategoryInfo> getCategoryList(Integer pageSize, Integer pageNumber, Specification<CategoryInfo> condition, Sort sort) {

        Page<CategoryInfo> CategoryList = null;

        try {
            CategoryList = categorys.getCategoryList(pageSize, pageNumber, condition, sort);
        } catch (Exception e) {
            logs.Write(e, "获得发现分类数据列表异常");
        }

        return CategoryList;
    }

    /**
     * 获取所有分类
     *
     * @return
     */
    public List<CategoryInfo> getAllCateInfoList(){

        List<CategoryInfo> CategoryList = new ArrayList<>();

        try {
            CategoryList = categorys.getAllCateInfoList();
        } catch (Exception e) {
            logs.Write(e, "获取所有分类数据列表异常");
        }

        return CategoryList;
    }

    /**
     * 发现分类条件
     *
     * @param type 分类
     * @return
     */
    public Specification<CategoryInfo> getCateListCondition(Integer type) {
        return getCateListCondition(type, -1);
    }


    /**
     * 获取列表分类
     *
     * @param typeId
     * @param parentId
     * @return
     */
    public List<CategoryInfo> getCategoryList(Integer typeId, Integer parentId) {

        List<CategoryInfo> categoryInfoList = new ArrayList<>();

        try {

            categoryInfoList = categorys.getCategoryList(typeId, parentId);

        } catch (Exception ex) {

            logs.Write(ex, "获取列表分类");
        }

        return categoryInfoList;

    }

    /**
     * 获取圈子列表分类
     *
     * @return
     */
    public List<CategoryInfo> getForumCatgoryList() {
        return getForumCatgoryList(0);
    }
    /**
     * 获取圈子列表分类
     *
     * @param parentId
     * @return
     */
    public List<CategoryInfo> getForumCatgoryList(Integer parentId) {
        return getCategoryList(CateTypeEnums.Forum.getTypeId(), parentId);
    }

    /**
     * 获取专家问答列表
     *
     * @return
     */
    public List<CategoryInfo> getAskCatgoryList() {
        return getAskCatgoryList(0);
    }

    /**
     * 获取专家问答列表
     *
     * @return
     */
    public List<CategoryInfo> getAskCatgoryList(Integer parentId) {

        return getCategoryList(CateTypeEnums.Ask.getTypeId(), parentId);
    }


    /**
     * 获取发现物种列表分类
     */
    public List<MultiCategoryInfo> getForumMultiCatgoryList() {
        List<CategoryInfo> categoryInfoList = getForumCatgoryList();

        List<MultiCategoryInfo> multiCategoryInfoList = new ArrayList<>();

        createMultiCatgoryList(multiCategoryInfoList, categoryInfoList);

        return multiCategoryInfoList;
    }

    public List<MultiCategoryInfo> getAskMultiCatgoryList() {

        List<CategoryInfo> categoryInfoList = getAskCatgoryList();

        List<MultiCategoryInfo> multiCategoryInfoList = new ArrayList<>();

        createMultiCatgoryList(multiCategoryInfoList, categoryInfoList);

        return multiCategoryInfoList;
    }


    /**
     * 获取报事列表分类
     *
     * @return
     */
    public List<CategoryInfo> getFindEventCatgoryList() {
        return getForumCatgoryList(-1);
    }

    /**
     * 获取报事列表分类
     *
     * @param parentId
     * @return
     */
    public List<CategoryInfo> getFindEventCatgoryList(Integer parentId) {
        return getCategoryList(CateTypeEnums.Event.getTypeId(), parentId);
    }

    /**
     * 获取发现物种列表分类
     */
    public List<MultiCategoryInfo> getFindEventMultiCatgoryList(Integer cateId) {

        List<CategoryInfo> categoryInfoList = getFindEventCatgoryList(cateId);

        List<MultiCategoryInfo> multiCategoryInfoList = new ArrayList<>();

        createMultiCatgoryList(multiCategoryInfoList, categoryInfoList);

        return multiCategoryInfoList;
    }


    /**
     * 获取发现物种列表分类
     *
     * @return
     */
    public List<CategoryInfo> getFindSpecieCatgoryList() {
        return getFindSpecieCatgoryList(0);
    }

    /**
     * 获取发现物种列表分类
     *
     * @param parentId
     * @return
     */
    public List<CategoryInfo> getFindSpecieCatgoryList(Integer parentId) {
        return getCategoryList(CateTypeEnums.Specie.getTypeId(), parentId);
    }

    /**
     * 获取发现物种列表分类
     */
    public List<MultiCategoryInfo> getFindSpecieMultiCatgoryList() {
        List<CategoryInfo> categoryInfoList = getFindSpecieCatgoryList();

        List<MultiCategoryInfo> multiCategoryInfoList = new ArrayList<>();

        createMultiCatgoryList(multiCategoryInfoList, categoryInfoList);

        return multiCategoryInfoList;
    }

    /**
     * 发现分类条件
     *
     * @param typeId     分类
     * @param parentId 上级id
     * @return
     */
    public Specification<CategoryInfo> getCateListCondition(Integer typeId, Integer parentId) {

        Specification<CategoryInfo> condition = null;

        try {
            condition = categorys.getCateListCondition(typeId, parentId);
        } catch (Exception ex) {
            logs.Write(ex, "发现分类条件");
        }

        return condition;
    }

    /**
     * 创建二维结构树
     *
     * @param cateSelectList
     * @param categoryInfoList
     */
    public void createCategoryTree(List<MultiSelectListItem> cateSelectList, List<CategoryInfo> categoryInfoList) {

        for (CategoryInfo cateInfo : categoryInfoList) {


            if (cateInfo == null || cateInfo.getCateId() <= 0 || cateInfo.getParentId() >= 1)
                continue;


            SelectListItem item = new SelectListItem();

            item.setText(cateInfo.getName());
            item.setValue(cateInfo.getCateId().toString());

            //categoryInfoList.remove(cateInfo);

            MultiSelectListItem items = new MultiSelectListItem(item);

            for (CategoryInfo subCateInfo : categoryInfoList) {

                if (subCateInfo.getParentId() == cateInfo.getCateId()) {

                    SelectListItem subItem = new SelectListItem();

                    subItem.setText(cateInfo.getName());
                    subItem.setValue(cateInfo.getCateId().toString());
                    items.itemList.add(subItem);
                }

            }

            cateSelectList.add(items);


        }

    }


    /**
     * 整理二级分类
     *
     * @param multiCategoryInfoList
     * @param categoryInfoList
     */
    public void createMultiCatgoryList(List<MultiCategoryInfo> multiCategoryInfoList, List<CategoryInfo> categoryInfoList) {


        if (multiCategoryInfoList == null)
            multiCategoryInfoList = new ArrayList<>();

        for (CategoryInfo cateInfo : categoryInfoList) {


            if (cateInfo == null || cateInfo.getCateId() <= 0 || cateInfo.getParentId() >= 1)
                continue;


            //CategoryInfoList.remove(cateInfo);

            MultiCategoryInfo items = new MultiCategoryInfo(cateInfo);

            for (CategoryInfo subCateInfo : categoryInfoList) {

                if (subCateInfo.getParentId() == cateInfo.getCateId()) {


                    items.getItemList().add(subCateInfo);
                }

            }

            multiCategoryInfoList.add(items);


        }
    }


    //endregion

}
