package com.gonzo.jpa.core.filter;

import com.gonzo.jpa.core.exception.WebException;
import com.gonzo.jpa.core.utils.WebUtils;
import com.gonzo.jpa.domain.member.Member;
import com.gonzo.jpa.domain.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GroupSessionFilter extends OncePerRequestFilter {

    private final MemberRepository memberRepository;

    public GroupSessionFilter(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String url = request.getRequestURI();

        try {

            HttpSession httpSession = request.getSession(true);

            List<String> groups = (List<String>) httpSession.getAttribute("groups");

            List<Boolean> booleanList = new ArrayList<>();

            groups.forEach( group -> booleanList.add(memberRepository.findByName(group).equals(url)));

            filterChain.doFilter(request, response);

        } catch (WebException we) {

            we.printStackTrace();

            WebUtils.showToResultText(we, response);

        }

    }

}
