package com.team5solution.Services.JWT;

import com.google.gson.Gson;
import com.team5solution.Facades.AccountFacade;
import com.team5solution.Entities.Account;
import com.team5solution.Responses.ResponseApi;
import com.team5solution.Responses.ResponseAuth;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthenticateService {

    private static final long EXPIRATION_TIME = 3 * 60 * 60 * 1000;
    private static final String SECRET = "Team5Solution";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";


    public static void successAuthentication(HttpServletResponse res, String username) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        ResponseApi api = new ResponseApi();
        api.setSuccess(Boolean.TRUE);
        api.setCode(1);
        api.setMessage("Login Successful!.");
        ResponseAuth auth = new ResponseAuth(username, TOKEN_PREFIX + " " + JWT, expireDate);
        try {
            Account account = new AccountFacade().getByUsername(username);
            auth.setFullname(account.getLastName() + " " + account.getFirstName());
            auth.setId(account.getAccountId());
            auth.setRole(account.getRole());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        api.setData(auth);
        res.setStatus(HttpServletResponse.SC_OK);
        try {
            Gson gson = new Gson();
            res.getWriter().write(gson.toJson(api));
            res.getWriter().flush();
            res.getWriter().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void unSuccessAuthentication(HttpServletResponse res) {
        ResponseApi api = new ResponseApi();
        api.setSuccess(Boolean.FALSE);
        api.setCode(0);
        api.setMessage("Login failed. Please try again!.");
        res.setStatus(HttpServletResponse.SC_FORBIDDEN);
        try {
            Gson gson = new Gson();
            res.getWriter().write(gson.toJson(api));
            res.getWriter().flush();
            res.getWriter().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getUserName(HttpServletRequest request) throws Exception {
        String user = null;
        try {
            String token = request.getHeader(HEADER_STRING);
            if (token != null) {
                // parse the token.
                user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
            }
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    public static Authentication getAuthentication(HttpServletRequest request) throws Exception {
        Authentication auth = null;
        try {
            String token = request.getHeader(HEADER_STRING);
            if (token != null) {
                // parse the token.
                String user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
                if (user != null) {
                    auth = new UsernamePasswordAuthenticationToken(user, null, emptyList());
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return auth;
    }
}
