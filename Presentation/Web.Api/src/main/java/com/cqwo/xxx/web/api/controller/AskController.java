package com.cqwo.xxx.web.api.controller;

import com.cqwo.xxx.services.*;
import com.cqwo.xxx.web.api.model.ForumAddPostModel;
import com.cqwo.xxx.web.api.model.ForumPostModel;
import com.cqwo.xxx.web.api.model.ForumResultModel;
import com.cqwo.xxx.web.api.model.ForumShowModel;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.base.MultiCategoryInfo;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.enums.categories.CateTypeEnums;
import com.cqwo.xxx.core.helper.StringHelper;
import com.cqwo.xxx.web.api.model.*;
import com.cqwo.xxx.core.domain.base.AttachmentInfo;
import com.cqwo.xxx.core.domain.base.CategoryInfo;
import com.cqwo.xxx.core.domain.base.MultiCategoryInfo;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumPostInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.core.enums.categories.CateTypeEnums;
import com.cqwo.xxx.core.helper.DateHelper;
import com.cqwo.xxx.core.helper.StringHelper;
import com.cqwo.xxx.services.*;
import com.cqwo.xxx.web.api.model.*;
import com.cqwo.xxx.web.framework.controller.BaseApiController;
import com.cqwo.xxx.web.framework.model.SimplePageModel;
import com.cqwo.xxx.web.framework.validate.ValidateModel;
import com.cqwo.xxx.web.framework.validate.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.cqwo.xxx.core.errors.SateCollect.SUCCESS;

/**
 * 圈子
 */
@RestController(value = "ApiAskController")
public class AskController extends BaseApiController {

    Lock lock = new ReentrantLock();

    @Autowired
    private Forums forums;

    @Autowired
    private Categorys categorys;

    @Autowired
    private ForumPosts forumPosts;

    @Autowired
    private ForumAttachments forumAttachments;

    @Autowired
    private ForumPraises forumPraises;



    /**
     * 当前栏目
     */
    CateTypeEnums cateTypeEnums = CateTypeEnums.Ask;

    /**
     * 当前栏目id
     */
    Integer typeId = cateTypeEnums.getTypeId();

    /**
     * 圈子首页
     *
     * @return
     */
    @RequestMapping(value = "ask/list")
    public String list(@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "0") Integer cateId) {

        Specification<ForumInfo> condition = forums.getForumListCondition(cateId);

        Sort sort = new Sort(Sort.Direction.DESC, "forumId");

        Page<ForumInfo> infoPage = forums.getForumList(pageSize, pageNumber, condition, sort);

        if (infoPage == null || infoPage.getContent().size() <= 0) {
            return JsonView(-1, "没有更多了...");
        }

        List<ForumVisitInfo> forumInfoList = new ArrayList<>();

        forums.LoadVisitList(forumInfoList, infoPage.getContent(), workContext.getUid());

        SimplePageModel pageModel = new SimplePageModel(pageSize, pageNumber, infoPage.getTotalPages());


        ForumListModel model = new ForumListModel(cateId, forumInfoList, pageModel);

        return JsonView(SUCCESS, model, "列表加载成功");
    }


    /**
     * 分类列表
     *
     * @param cateId
     * @return
     */
    @RequestMapping(value = "ask/catelist")
    public String cateList(@RequestParam(defaultValue = "0") Integer cateId) {

        List<MultiCategoryInfo> forumCategoryInfoList = categorys.getAskMultiCatgoryList();

        return JsonView(SUCCESS, forumCategoryInfoList, "问答分类列表");

    }

    /**
     * 发布
     *
     * @return
     */
    @RequestMapping(value = "ask/add", method = RequestMethod.POST)
    public String addPost(ForumAddPostModel model) {


        System.out.println(model.toString());

        ValidationResult result = ValidateModel.validateEntity(model);

        if (result.isNotErrors()) {

            Integer cateId = model.getCateId();


            CategoryInfo categoryInfo = categorys.getCategoryByCateId(cateId);

            if (categoryInfo == null || categoryInfo.getCateId() <= 0) {
                return JsonView("请选择正确的问答");
            }

            if (!categoryInfo.getTypeId().equals(typeId)) {
                return JsonView("不正确的分类");
            }

            ForumInfo forumInfo = forums.sendForum(workContext.getPartUserInfo(), categoryInfo, model.getBody(), model.getAt(), model.getLatitude(), model.getLongitude(), model.getAddress(), model.getMediaUrl(), model.getImgUrlList());

            if (forumInfo == null || forumInfo.getUid() <= 0) {
                return JsonView("请联系管理员,发贴失败");
            }

            ForumResultModel resultModel = new ForumResultModel(forumInfo.getForumId(), forumInfo);

            return JsonView(SUCCESS, resultModel, "发布成功");

        }

        return JsonView("发布失败:" + result.toString());

    }


    /**
     * 圈子浏览
     *
     * @param forumId
     * @return
     */
    @RequestMapping(value = "ask/show")
    public String show(@RequestParam(defaultValue = "0") Integer forumId, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNumber) {

        if (forumId <= 0) {
            return JsonView("圈子不存在或正在审核中");
        }


        ForumInfo forumInfo = forums.getForumByForumId(forumId);

        if (forumInfo == null || forumInfo.getForumId() <= 0) {
            return JsonView("圈子不存在回在审核中");
        }

        if (forumInfo.getIsShow() <= 0 && forumInfo.getUid() != workContext.getUid()) {
            return JsonView("圈子正在审核中");
        }


        /**
         * 圈子所属分类
         */
        CategoryInfo categoryInfo = categorys.getCategoryByCateId(forumInfo.getCateId());

        if (categoryInfo == null || categoryInfo.getCateId() <= 0) {
            return JsonView("圈子分类不存在");
        }


        /**
         * 发贴人信息
         */
        PartUserInfo userInfo = users.getPartUserByUid(forumInfo.getUid());

        if (userInfo == null || userInfo.getUid() <= 0) {
            return JsonView("作者已被禁用,水允许浏览");
        }


        /**
         * 最新回复
         */
        List<ForumPostInfo> forumPostInfoList = new ArrayList<>();
        SimplePageModel pageModel = new SimplePageModel();

        Page<ForumPostInfo> infoPage = forumPosts.getForumPostList(forumId, 10, 1);


        if (infoPage != null && infoPage.getTotalElements() >= 0) {
            forumPostInfoList = infoPage.getContent();
            pageModel = new SimplePageModel(pageSize, pageNumber, infoPage.getTotalPages());

        }
        /**
         * 附件列表
         */
        List<AttachmentInfo> forumAttachmentInfoList = forumAttachments.getAttachmentListByForumId(forumId);


        /**
         * 是否已点赞
         */
        boolean isPraise = forumPraises.isPraise(forumId, workContext.getUid());

        ForumShowModel model = new ForumShowModel(forumId, forumInfo, categoryInfo, userInfo, forumPostInfoList, forumAttachmentInfoList, isPraise, pageModel);

        return JsonView(SUCCESS, model, "圈子读取成功");
    }


    /**
     * 用户回帖
     *
     * @return
     */
    @RequestMapping(value = "ask/post", method = RequestMethod.POST)
    public String forumPost(ForumPostModel model) {


        lock.lock();
        try {

            ValidationResult result = ValidateModel.validateEntity(model);

            if (result.isNotErrors()) {

                Integer forumId = model.getForumId();

                ForumInfo forumInfo = forums.getForumByForumId(forumId);

                System.out.println(forumInfo.toString());
                if (forumInfo == null || forumInfo.getForumId() <= 0 || forumInfo.getIsDelete() >= 1) {
                    return JsonView("当前圈子不存在");
                }



                if (forumInfo.getIsShow() <= 0) {
                    return JsonView("当前圈子不允许回帖");
                }


                Integer nowTime = DateHelper.getUnixTimeStamp();

                ForumPostInfo postInfo = new ForumPostInfo();
                postInfo.setForumId(forumId);
                postInfo.setCateId(forumInfo.getCateId());
                postInfo.setUid(workContext.getUid());
                postInfo.setNickName(workContext.getNickName());
                postInfo.setAt(model.getAt());
                postInfo.setBody(model.getBody());
                postInfo.setTitle(StringHelper.getStringTitle(model.getBody(), 20));

                Integer layer = forumPosts.getForumPostLayer(forumId);
                postInfo.setLayer(layer);

                ForumPostInfo forumPostInfo = forumPosts.createForumPost(postInfo);

                if (forumPostInfo == null || forumPostInfo.getPostId() <= 0) {
                    return JsonView("发贴失败,请联系管理员");
                }

                return JsonView(SUCCESS, forumPostInfo.getPostId(), "回帖成功");
            } else {

                return JsonView("用户回帖失败:" + result.toString());
            }
        } catch (Exception ex) {
            logs.Write(ex, "回用户回贴失败");
        } finally {
            lock.unlock();
        }


        return JsonView("用户回帖失败");
    }

//    /**
//     * 点赞
//     *
//     * @param forumId
//     * @return
//     */
//    @RequestMapping(value = "ask/clickpraise")
//    public String clickPraise(@RequestParam(defaultValue = "0") Integer forumId) {
//
//        lock.lock();
//        try {
//
//
//            if (forumId <= 0)
//                return JsonView("点赞失败");
//
//            boolean isPraise = forumPraises.isPraise(forumId, workContext.getUid());
//
//
//            if (isPraise) {
//                return JsonView("请勿重复点赞");
//            }
//
//            ForumInfo forumInfo = forums.getForumByForumId(forumId);
//
//            if (forumInfo == null || forumInfo.getForumId() <= 0 || forumInfo.getIsShow() <= 0)
//                return JsonView("当前帖子不允许点赞");
//
//            if (forumInfo.getUid() == workContext.getUid())
//                return JsonView("不允许给自己点赞");
//
//            forumPraises.clickPraise(forumId, workContext.getPartUserInfo());
//
//            return JsonView(SUCCESS, "感谢您的赞美");
//
//
//        } catch (Exception ex) {
//
//
//        } finally {
//            lock.unlock();
//        }
//
//        return JsonView("点赞失败");
//    }


}
