package com.link510.softgateway.web.admin.controller;


import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.enums.bank.BankState;
import com.link510.softgateway.core.helper.DateHelper;
import com.link510.softgateway.web.admin.model.BankExamineModel;
import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.enums.bank.BankState;
import com.link510.softgateway.core.helper.DateHelper;
import com.link510.softgateway.services.Banks;
import com.link510.softgateway.web.admin.model.BankExamineModel;
import com.link510.softgateway.web.framework.controller.BaseAdminController;
import com.link510.softgateway.web.framework.validate.ValidateModel;
import com.link510.softgateway.web.framework.validate.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 流水提现部分controller
 */
@Controller(value = "AdminBankCashController")
public class BankCashController extends BaseAdminController {

    @Autowired
    Banks banks;


    private Lock lock = new ReentrantLock();


    /**
     * 财务审核
     *
     * @return
     */
    @RequestMapping(value = "bank/cash/confirm", method = RequestMethod.GET)
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
    @RequestMapping(value = "bank/cash/confirm", method = RequestMethod.POST)
    public ModelAndView confirm(BankExamineModel model) {

        lock.lock();
        try {
            ValidationResult result = ValidateModel.validateEntity(model);

            if (result.isNotErrors()) {

                Integer id = model.getId();

                if (id <= 0)
                    return PromptView("不正确的付款信息");

                BankRollInfo info = banks.getBankRollById(id);

                if (info == null)
                    return PromptView("不正确的付款信息");

                if (info.getState() >= BankState.Confirming.getIndex())
                    return PromptView("不正确的操作动作");


                boolean isSuccess = banks.confirm(model.getId(), model.getActionDes(), workContext.getUid());

                if (isSuccess)

                    return PromptView("财务审核完成");

            }

            return PromptView("财务审核失败");

        } catch (Exception ex) {


        } finally {
            lock.unlock();
        }


        return PromptView("财务审核失败");

    }


//    /**
//     * 提现到账
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "bank/cash/completed", method = RequestMethod.GET)
//    public ModelAndView cashCompleted(@RequestParam(defaultValue = "0") Integer id) {
//
//        banks.cashCompleted(id, workContext.getUid());
//
//        return View();
//    }

}
