package com.link510.softgateway.web.api.controller;

import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.link510.softgateway.core.errors.SateCollect;
import com.link510.softgateway.core.helper.RandomHelper;
import com.link510.softgateway.core.helper.TypeHelper;
import com.link510.softgateway.core.helper.WebHelper;
import com.link510.softgateway.services.WechatPayUtils;
import com.link510.softgateway.web.framework.controller.BaseApiController;
import com.link510.softgateway.core.helper.RandomHelper;
import com.link510.softgateway.core.helper.TypeHelper;
import com.link510.softgateway.core.helper.WebHelper;
import com.link510.softgateway.services.WechatPayUtils;
import com.link510.softgateway.web.api.model.WechatPayModel;
import com.link510.softgateway.web.framework.controller.BaseApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

import static com.link510.softgateway.core.errors.SateCollect.SUCCESS;


/**
 * api微信支付controller
 */
@RestController(value = "ApiWechatPayController")
public class WechatPayController extends BaseApiController {


    @Autowired
    private WechatPayUtils payUtils;

    @RequestMapping(value = "wechat/donation")
    @ResponseBody
    public String donation(@RequestParam(defaultValue = "0.1") double money) {


        //region 基本参数===========================


        String outTradeNo = RandomHelper.generateLowerString(10);

        //订单名称
        String subject = "来自小程序平台的捐赠";
        String detail = "来自小程序平台的捐赠:" + money;

        //付款金额
        int totalFee = (int) (money * 100);


        String openId = workContext.getOpenId();


        String attach = TypeHelper.DoubleToString(money);

        String ip = cwmUtils.getIP();

        String trade_type = WxPayConstants.TradeType.JSAPI;


        //服务器异步通知页面路径
        String notifyUrl = MessageFormat.format("http://{0}/wechat/notify", cwmConfig.getIconfigstrategy().getBaseConfig().getSiteurl());

        notifyUrl = WebHelper.disposeUrl(notifyUrl);

        logs.Write("notifyUrl:" + notifyUrl);

        //endregion  商户订单号

        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();

            orderRequest.setBody(subject);
            orderRequest.setDetail(detail);
            orderRequest.setAttach(attach);
            orderRequest.setOutTradeNo(outTradeNo);
            orderRequest.setTotalFee(totalFee);//元转成分
            orderRequest.setOpenid(openId);
            orderRequest.setSpbillCreateIp(ip);
            orderRequest.setNotifyUrl(notifyUrl);


            orderRequest.setTradeType(trade_type);

            WxPayMpOrderResult result = (WxPayMpOrderResult) payUtils.createOrder(orderRequest);

            if (result == null)
                return JsonView("创建支付失败");

            WechatPayModel model = new WechatPayModel();

            model.setNonceStr(result.getNonceStr());
            model.setPackageValue(result.getPackageValue());
            model.setPaySign(result.getPaySign());
            model.setTimeStamp(result.getTimeStamp());

            return JsonView(SateCollect.SUCCESS, result, "支付成功");

        } catch (Exception e) {
            logs.Write(MessageFormat.format("微信支付失败！订单号：{0},原因:{1}", outTradeNo, e.getMessage()));

            return JsonView("支付失败，请稍后重试！");
        }
    }


}
