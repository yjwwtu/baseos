package com.cqwo.xxx.web.admin.controller;


import com.cqwo.xxx.services.*;
import com.cqwo.xxx.web.admin.model.ForumListModel;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.web.admin.model.ForumListModel;
import com.cqwo.xxx.core.domain.forums.ForumInfo;
import com.cqwo.xxx.core.domain.forums.ForumVisitInfo;
import com.cqwo.xxx.services.*;
import com.cqwo.xxx.web.admin.model.ForumListModel;
import com.cqwo.xxx.web.framework.controller.BaseAdminController;
import com.cqwo.xxx.web.framework.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 圈子模块
 */
@Controller(value = "AdminForumController")
public class ForumController extends BaseAdminController {


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
     * 圈子首页
     *
     * @return
     */

    @RequestMapping(value = "forum/index")
    public ModelAndView index() {
        return View();
    }

    /**
     * 圈子列表
     *
     * @return
     */

    @RequestMapping(value = "forum/list")
    public ModelAndView list(@RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "1") Integer pageNumber,
                             @RequestParam(defaultValue = "0") Integer cateId,
                             @RequestParam(defaultValue = "") String keywords) {
        Specification<ForumInfo> condition = forums.getAdminForumListCondition(cateId, keywords);

        Sort sort = new Sort(Sort.Direction.DESC, "forumId");

        Page<ForumInfo> infoPage = forums.getForumList(pageSize, pageNumber, condition, sort);

        if (infoPage == null || infoPage.getContent().size() <= 0) {
            return PromptView("没有更多了...");
        }

        List<ForumInfo> forumInfoList = infoPage.getContent();


        PageModel pageModel = new PageModel(pageSize, pageNumber, infoPage.getTotalPages());

        System.out.println(pageModel.toString());

        ForumListModel model = new ForumListModel(cateId, keywords, forumInfoList, pageModel);

        return View(model);
    }

    /**
     * 圈子详情
     *
     * @return
     */

    @RequestMapping(value = "forum/detail")
    public ModelAndView detail(@RequestParam(defaultValue = "0") Integer forumId) {


        if (forumId <= 0) {
            return PromptView("报事不存在或发者错误");
        }

        ForumInfo forumInfo = forums.getForumByForumId(forumId);

        if (forumInfo == null || forumInfo.getForumId() <= 0) {
            return PromptView("报事不存在或发者错误");
        }


        ForumVisitInfo model = forums.LoadForumVisitInfo(forumInfo, -1);

        return View(model);
    }


    /**
     * 圈子附件列表
     *
     * @return
     */

    @RequestMapping(value = "forum/attach/list")
    public ModelAndView attachlist(@RequestParam(defaultValue = "10") Integer forumId) {

        return View();
    }



}
