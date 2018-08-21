package com.cqwo.xxx.web.api.controller;


import com.cqwo.xxx.services.Banks;
import com.cqwo.xxx.services.Categorys;
import com.cqwo.xxx.web.api.model.UCenterHomeModel;
import com.cqwo.xxx.web.api.model.UCenterListModel;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.core.domain.users.PartUserInfo;
import com.cqwo.xxx.services.Banks;
import com.cqwo.xxx.services.Categorys;
import com.cqwo.xxx.web.api.model.SendCashModel;
import com.cqwo.xxx.web.api.model.UCenterHomeModel;
import com.cqwo.xxx.web.api.model.UCenterListModel;
import com.cqwo.xxx.web.framework.controller.BaseApiController;
import com.cqwo.xxx.web.framework.model.PageModel;
import com.cqwo.xxx.web.framework.validate.ValidateModel;
import com.cqwo.xxx.web.framework.validate.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.cqwo.xxx.core.errors.SateCollect.SUCCESS;


/**
 * 用户中心
 */
@RestController(value = "ApiUCenterController")
public class UCenterController extends BaseApiController {


    @Autowired
    private Categorys categorys;


    @Autowired
    private Banks banks;

    private Lock lock = new ReentrantLock();

    /**
     * Ucenter用户中心首页
     *
     * @return
     */
    @RequestMapping(value = "ucenter/index")
    public String index() {

        UCenterHomeModel model = new UCenterHomeModel(workContext.getUid(), workContext.getPartUserInfo(), workContext.getUserRankInfo());
        return JsonView(SUCCESS, model, "用户中心首页");

    }

    /**
     * 用户列表测试
     *
     * @return
     */
    @RequestMapping(value = "ucenter/list")
    public String list() {

        Page<PartUserInfo> userList = users.getPartUserList(1, 1, null, null);

        PageModel pageModel = new PageModel(userList.getSize(), userList.getNumber(), userList.getTotalPages());

        System.out.println(userList);

        UCenterListModel model = new UCenterListModel(userList.getContent(), pageModel);

        return JsonView(SUCCESS, model, "列表加载");
    }


    /**
     * 用户提现
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "ucenter/sendcash")
    @ResponseBody
    public String sendCash(SendCashModel model) {

        try {

            lock.lock();

            ValidationResult result = ValidateModel.validateEntity(model);


            if (result.isNotErrors()) {

                PartUserInfo userInfo = users.getPartUserByUid(workContext.getUid());

                if (userInfo == null || userInfo.getUid() <= 0) {
                    return JsonView("用户提现失败");
                }

                if (model.getMoney() > userInfo.getMoney()) {
                    return JsonView("用户余额不足");
                }


                BankRollInfo bankInfo = banks.sendCash(userInfo, model.getMoney());

                if (bankInfo == null || bankInfo.getId() <= 0) {

                    return JsonView("用户提现失败");
                }

                return JsonView(SUCCESS, bankInfo, "用户提现成功");

            }

            return JsonView("用户提现失败");

        } catch (Exception ex) {
            logs.Write(ex, "用户提现失败");
        } finally {

            lock.unlock();
        }

        return JsonView("用户提现失败");
    }

}
