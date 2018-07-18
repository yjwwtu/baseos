package com.link510.softgateway.web.controller;


import com.link510.softgateway.core.cache.CWMCache;
import com.link510.softgateway.core.config.CWMConfig;
import com.link510.softgateway.core.data.rdbs.repository.users.UserRepository;
import com.link510.softgateway.services.Authors;
import com.link510.softgateway.services.SMSes;
import com.link510.softgateway.services.Users;
import com.link510.softgateway.web.framework.controller.BaseWebController;
import com.link510.softgateway.core.cache.CWMCache;
import com.link510.softgateway.core.config.CWMConfig;
import com.link510.softgateway.core.data.rdbs.repository.users.UserRepository;
import com.link510.softgateway.services.Authors;
import com.link510.softgateway.services.SMSes;
import com.link510.softgateway.services.Users;
import com.link510.softgateway.web.framework.controller.BaseWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeController")
public class HomeController extends BaseWebController {

    @Autowired
    SMSes smSes;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CWMCache cwmCache;

    @Autowired
    Users users;

    @Autowired
    Authors authors;

    @Autowired
    CWMConfig cwmConfig;

    @RequestMapping(value = "/")
    public ModelAndView index() {

//        List<AuthorRoleInfo> authorRoleList = authors.getUserAuthorRoleList(1);
//
//        System.out.println("authorRoleList:" + authorRoleList.toString());
//
//        cwmConfig.getIconfigstrategy().SaveBaseConfig(new BaseConfigInfo());
//        cwmConfig.getIconfigstrategy().SaveEmailConfig(new EmailConfigInfo());
//        cwmConfig.getIconfigstrategy().SaveSMSConfig(new SMSConfigInfo());
//        cwmConfig.getIconfigstrategy().SaveWechatConfig(new WechatConfigInfo());
//
//        System.out.println(cwmConfig.getIconfigstrategy().getBaseConfig());
//
//
//        List<AuthorActionInfo> ationList = authors.getUserAuthorActionList(1);
//
//        System.out.println("ationList:" + ationList.toString());
//
//        Sort sort = new Sort(Sort.Direction.DESC, "uid");
//
//        Page<PartUserInfo> userInfoPage = users.getPartUserList(10, 1, new Specification<PartUserInfo>() {
//            @Override
//            public Predicate toPredicate(Root<PartUserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//                List<Predicate> list = new ArrayList<Predicate>();
//
//                Predicate[] p = new Predicate[list.size()];
//
//                query.where(cb.and(list.toArray(p)));
//
//                model.addAttribute("paymentInfo", 1);
//                model.addAttribute("re", 2);
//
//                return query.getGroupRestriction();
//            }
//        }, sort);
//
//        for (PartUserInfo info : userInfoPage.getContent()) {
//
//            System.out.println("Success List :" + info.toString());
//
//        }
//

        return Redirect("/login");

        //return View("index");
    }


    @RequestMapping(value = "/403")
    public ModelAndView err403() {
        return View("403");
    }



}
