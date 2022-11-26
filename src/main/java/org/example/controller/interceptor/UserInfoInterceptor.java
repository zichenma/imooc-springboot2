package org.example.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.GraceException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    /**
     *  拦截请求，访问 controller 之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String userId = request.getHeader("userId");
        String userToken = request.getHeader("userToken");
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(userToken)) {
            log.error("user authorization failed. Missing auth info");
            GraceException.display("user authorization failed. Missing auth info");
            return false;
        }
        // 假设正式的用户 id 是 1001， 用户 token 是 abcxyz
        if(!userId.equalsIgnoreCase("1001") || !userToken.equalsIgnoreCase("abcxyz")) {
            log.error("user authorization failed. You don't have access");
            GraceException.display("user authorization failed. You don't have access");
            return false;
        }
        /**
         * false: 请求被拦截
         * true: 请求被放行, 可以继续访问后面的 controller
         */
        return true;
    }

    /**
     * 请求访问到 controller 之后，渲染试图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 请求访问到 controller 之后，渲染试图之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
