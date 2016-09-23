package com.jianla.argumentresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import com.jianla.model.base.SessionInfo;

public class SessionInfoArgumentResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter,
			NativeWebRequest webRequest) throws Exception {
		// TODO Auto-generated method stub
		 if (methodParameter.getParameterType().equals(SessionInfo.class)) {
	            return webRequest.getAttribute("sessionInfo", RequestAttributes.SCOPE_SESSION);
	        }
	        return UNRESOLVED;
	}
}
