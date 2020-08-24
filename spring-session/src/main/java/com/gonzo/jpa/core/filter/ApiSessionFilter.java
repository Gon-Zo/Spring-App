package com.gonzo.jpa.core.filter;

import com.gonzo.jpa.core.exception.ErrorCode;
import com.gonzo.jpa.core.exception.WebException;
import com.gonzo.jpa.core.utils.WebUtils;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@NoArgsConstructor
public class ApiSessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        log.info("FILTER -> {}" , "ApiSessionFilter");

        try {

            HttpSession httpSession = request.getSession(true);

            String email = (String) httpSession.getAttribute("email");

            if(StringUtils.isEmpty(email)){

                throw new WebException(ErrorCode.NotFoundSession);

            }

            filterChain.doFilter(request, response);

        } catch (WebException we) {
            we.printStackTrace();
            WebUtils.showToResultText(we, response);
        }

    }

}
