package com.link510.softgateway.web.api.controller;

import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.core.errors.SateCollect;
import com.link510.softgateway.web.api.model.BankListModel;
import com.link510.softgateway.core.domain.banks.BankRollInfo;
import com.link510.softgateway.core.domain.users.PartUserInfo;
import com.link510.softgateway.services.Banks;
import com.link510.softgateway.web.api.model.BankListModel;
import com.link510.softgateway.web.framework.controller.BaseApiController;
import com.link510.softgateway.web.framework.model.SimplePageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.link510.softgateway.core.errors.SateCollect.SUCCESS;


/**
 * 流水控制器
 */
@RestController(value = "ApiBankController")
public class BankController extends BaseApiController {


    @Autowired
    Banks banks;

    /**
     * 银行流水
     *
     * @return
     */
    @RequestMapping(value = {"bank/index", "bank/list"})
    @ResponseBody
    public String list(@RequestParam(defaultValue = "15") int pageSize, @RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "0") Integer state) {

        Specification<BankRollInfo> condition = banks.getUserBankRollListCondition(workContext.getUid(), state);
        Sort sort = null;


        PartUserInfo userInfo = users.getPartUserByUid(workContext.getUid());


        Page<BankRollInfo> infoPage = banks.getBankRollList(pageSize, pageNumber, condition, sort);


        if (infoPage == null) {
            return JsonView("没有更多的数据了");
        }

        SimplePageModel pageModel = new SimplePageModel(pageSize, pageNumber, infoPage.getTotalPages());


        BankListModel model = new BankListModel(userInfo, infoPage.getContent(), pageModel);

        return JsonView(SateCollect.SUCCESS, model, "流水加载成功");


    }

}
