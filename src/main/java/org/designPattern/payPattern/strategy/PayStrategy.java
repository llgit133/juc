package org.designPattern.payPattern.strategy;

import org.designPattern.payPattern.dao.OrderInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface PayStrategy {

    boolean supports(String type);

    String cashierPage(OrderInfo orderInfo);

    boolean checkSign(HttpServletRequest request, String body);

    Object signError();

    Object signOk();

    Map<String ,Object> process(HttpServletRequest request,String body);

}
