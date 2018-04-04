package com.record.filter;

import com.record.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限拦截器
 * Created by robert.liang on 2014/9/12.
 */
public class UserAuthorizationFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorizationFilter.class);

    protected static final String SESSION_KEY_USER = "USER";

    private String[] excludeUrls;

    private static final String EXCLUDE_URLS = "excludeUrls";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String excludeUrl = filterConfig.getInitParameter(EXCLUDE_URLS);
        if (excludeUrl != null && excludeUrl.length() > 0) {
            excludeUrls = excludeUrl.split(";");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getServletPath();
        if (needCheck(path)) {
            User user = (User) req.getSession().getAttribute(SESSION_KEY_USER);
            if (user == null) {
                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.forward(req, res);
                return;
            }
            chain.doFilter(req, res);
            return;
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }

    private boolean needCheck(String url) {

        for (String exclude : excludeUrls) {
            if (url.contains(exclude)) {
                return false;
            }
        }
        if(url.endsWith(".css") || url.endsWith(".js")){
            return false;
        }
        return true;
    }

    public String[] getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(String[] excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

}
