package com.link510.softgateway.web.admin.controller;


import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.web.admin.model.BankExamineModel;
import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.helper.DateHelper;
import com.link510.softgateway.services.Banks;
import com.link510.softgateway.web.admin.model.BankExamineModel;
import com.link510.softgateway.web.framework.controller.BaseAdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.MessageFormat;

/**
 * 流水奖励部分controller
 */
@Controller(value = "AdminBankRewardController")
public class BankRewardController extends BaseAdminController {


    @Autowired
    private Banks banks;

    /**
     * 财务审核
     *
     * @return
     */
    @RequestMapping(value = "bank/reward/confirm", method = RequestMethod.GET)
    public ModelAndView rewardConfim(@RequestParam(defaultValue = "0") Integer id) {


        if (id <= 0) {
            return PromptView("流水加载失败");
        }

        BankRollInfo bankRollInfo = banks.getBankRollById(id);

        if (bankRollInfo == null || bankRollInfo.getId() <= 0) {
            return PromptView("流水加载失败");
        }

        Timestamp nowts = DateHelper.getTimestamp();

        String actionDesc = MessageFormat.format("管理{0}发起财务审核,时间:[{1}]", workContext.getNickName(), nowts);

        PartUserInfo userInfo = users.getPartUserByUid(bankRollInfo.getUid());

        BankExamineModel model = new BankExamineModel(id, actionDesc, userInfo, bankRollInfo);

        return View(model);
    }

    /**
     * 财务审核
     *
     * @return
     */
    @RequestMapping(value = "bank/reward/confirm", method = RequestMethod.POST)
    public ModelAndView examine(BankExamineModel model) {

        return View();

    }


    /**
     * 发放奖励到账
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "bank/reward/send", method = RequestMethod.GET)
    public ModelAndView sendGet(@RequestParam(defaultValue = "0") Integer id) {

        return View();
    }


}
