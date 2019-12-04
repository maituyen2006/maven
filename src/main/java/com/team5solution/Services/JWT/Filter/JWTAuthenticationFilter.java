package com.team5solution.Services.JWT.Filter;

import com.google.gson.Gson;
import com.team5solution.Responses.ResponseApi;
import com.team5solution.Services.JWT.TokenAuthenticateService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication = TokenAuthenticateService.getAuthentication((HttpServletRequest) servletRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ExpiredJwtException e) {
            ResponseApi apiResonse = new ResponseApi();
            apiResonse.setSuccess(Boolean.FALSE);
            apiResonse.setCode(-9999);
            apiResonse.setMessage("Your login session has been expired!, please login again!");
            try {
                Gson gson = new Gson();
                servletResponse.getWriter().write(gson.toJson(apiResonse));
                servletResponse.getWriter().flush();
                servletResponse.getWriter().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
//            Logger.getLogger(JWTAuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
