package org.designPattern.payPattern.service.impl;

import org.designPattern.payPattern.dao.OrderInfo;
import org.designPattern.payPattern.service.PayService;
import org.designPattern.payPattern.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    List<PayStrategy> payStrategies;

    @Override
    public String payPage(String type, Long orderId) {

        // 1.查询数据库
        OrderInfo orderInfo = getOrderInfo(orderId);


        // 2.校验策略模式
        for (PayStrategy payStrategy : payStrategies) {
            if(payStrategy.supports(type)){
                return payStrategy.cashierPage(orderInfo);
            }
        }

        // 3.都不支持
        return "不支持这种方式";
    }

    private OrderInfo getOrderInfo(Long orderId) {
        return new OrderInfo();
    }

    @Override
    public Object processNotify(HttpServletRequest request, String body) {
        return null;
    }
}
