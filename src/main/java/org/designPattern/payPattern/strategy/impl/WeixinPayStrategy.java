package org.designPattern.payPattern.strategy.impl;

import org.designPattern.payPattern.dao.OrderInfo;
import org.designPattern.payPattern.strategy.PayStrategy;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WeixinPayStrategy implements PayStrategy {
    @Override
    public boolean supports(String type) {
        return false;
    }

    @Override
    public String cashierPage(OrderInfo orderInfo) {
        return null;
    }

    @Override
    public boolean checkSign(HttpServletRequest request, String body) {
        return false;
    }

    @Override
    public Object signError() {
        return null;
    }

    @Override
    public Object signOk() {
        return null;
    }

    @Override
    public Map<String, Object> process(HttpServletRequest request, String body) {
        return null;
    }
}
