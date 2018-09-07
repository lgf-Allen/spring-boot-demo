/**
 * 
 */
package com.allen.spring.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author first
 *
 */
public class ClientInformationResolver implements HandlerMethodArgumentResolver {

    /**
     * 判断方法是否加了@Client_Information
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Client_Information.class) != null;

    }

    /**
     * 解析添加了@Client_Information的header,setDeviceId.
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String deviceId = webRequest.getHeader("client_information");
        ClientInformation information = new ClientInformation();
        information.setDeviceId(deviceId);
        return information;
    }

}
