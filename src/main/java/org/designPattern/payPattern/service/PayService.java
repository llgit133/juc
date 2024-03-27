package org.designPattern.payPattern.service;

import javax.servlet.http.HttpServletRequest;

public interface PayService {

    String payPage(String type, Long orderId);

    Object processNotify(HttpServletRequest request,String body);
}
