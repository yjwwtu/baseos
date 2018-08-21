package com.cqwo.xxx.web.admin.controller;

import com.cqwo.xxx.services.Banks;
import com.cqwo.xxx.web.admin.model.BankListModel;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.web.admin.model.BankListModel;
import com.cqwo.xxx.core.domain.banks.BankRollInfo;
import com.cqwo.xxx.services.Banks;
import com.cqwo.xxx.web.admin.model.BankListModel;
import com.cqwo.xxx.web.framework.controller.BaseAdminController;
import com.cqwo.xxx.web.framework.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;


/**
 * 流水控制器
 */
@Controller(value = "AdminBankController")
public class BankController extends BaseAdminController {


    @Autowired
    private Banks banks;


    /**
     * 流水控制器
     *
     * @return
     */
    @RequestMapping(value = "bank/index")
    public ModelAndView index() {

        return View();
    }


    /**
     * 待处理列表
     *
     * @param pageSize
     * @param pageNumber
     * @return
     */

    @RequestMapping(value = "bank/list")
    public ModelAndView list(@RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "1") Integer pageNumber,
                             @RequestParam(defaultValue = "0") Integer state) throws IOException {

        Specification<BankRollInfo> condition = banks.getBankRollListCondition(state);

        Sort sort = new Sort(Sort.Direction.DESC, "id");

        Page<BankRollInfo> infoPage = banks.getBankRollList(pageSize, pageNumber, condition, sort);

        if (infoPage == null) {
            return PromptView("没有更多了...", false);
        }

        List<BankRollInfo> bankRollInfoList = infoPage.getContent();

        PageModel pageModel = new PageModel(pageSize, pageNumber, infoPage.getTotalPages());

        BankListModel model = new BankListModel(state, bankRollInfoList, pageModel);

        cwmUtils.SetAdminRefererCookie(response, MessageFormat.format("{0}?pageNumber={1}&pageSize={2}",
                cwmUtils.getRawUrl(),
                pageModel.getPageNumber(),
                pageModel.getPageSize()));


        return View(model);
    }


    /**
     * 财务处理失败,退回财务操作
     *
     * @param id 财务id
     * @return
     */
    @RequestMapping(value = "bank/returned", method = RequestMethod.GET)
    public ModelAndView returned(@RequestParam(defaultValue = "0") Integer id) {

        banks.returned(id, "流水处理失败", workContext.getUid());

        return PromptView("流水处理成功");
    }


    /**
     * 财务锁定
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "bank/locked", method = RequestMethod.GET)
    public ModelAndView locked(@RequestParam(defaultValue = "0") Integer id) {

        banks.returned(id, "流水处理失败", workContext.getUid());

        return PromptView("流水处理成功");
    }

    /**
     * 财务取消
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "bank/cancelled", method = RequestMethod.GET)
    public ModelAndView cancelled(@RequestParam(defaultValue = "0") Integer id) {
        return View();
    }

}
