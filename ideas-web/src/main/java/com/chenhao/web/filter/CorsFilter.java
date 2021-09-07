package com.chenhao.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-8-18 17:53
 */
@Component
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res= (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS");
        res.setHeader("Access-Control-Max-Age","3600");
        res.setHeader("Access-Control-Allow-Header","x-requested-with");
        chain.doFilter(request,response);
    }
}
