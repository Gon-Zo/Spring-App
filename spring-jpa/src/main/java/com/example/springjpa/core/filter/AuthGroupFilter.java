package com.example.springjpa.core.filter;

import com.example.springjpa.core.exception.ErrorCode;
import com.example.springjpa.core.exception.WebException;
import com.example.springjpa.domain.group.Group;
import com.example.springjpa.domain.group.GroupRepository;
import com.example.springjpa.domain.groupmenu.GroupMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.springjpa.core.utils.WebUtils.getWebExceptionData;

/**
 * Create by park031517@gmail.com on 2020-08-5, 수
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Slf4j
public class AuthGroupFilter extends OncePerRequestFilter {

    private final GroupRepository groupRepository;

    private final GroupMenuRepository groupMenuRepository;

    public AuthGroupFilter(GroupRepository groupRepository, GroupMenuRepository groupMenuRepository) {
        this.groupRepository = groupRepository;
        this.groupMenuRepository = groupMenuRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String url = request.getRequestURI();

        log.info(" FILTER -> {} ", "AuthGroupFilter");

        log.info(" REQUEST URL -> {}", url);

        if (!url.startsWith("/api")) {
            filterChain.doFilter(request, response);
        }

        try {

            SecurityContext securityContext = SecurityContextHolder.getContext();

            Authentication authLoginUser = securityContext.getAuthentication();

            Collection<? extends GrantedAuthority> grantedAuthorities = authLoginUser.getAuthorities();

            List<String> groups = grantedAuthorities.stream()
                    .map(group -> group.getAuthority())
                    .collect(Collectors.toList());

            List<Group> groupList = groups.stream()
                    .map(group -> groupRepository.findByTitle(group))
                    .collect(Collectors.toList());

            List<String> urls = groupList.stream()
                    .map(group -> groupMenuRepository.findByGroups(group))
                    .flatMap(Collection::parallelStream)
                    .map(groupMenu -> groupMenu.getMenus().getUrl())
                    .collect(Collectors.toList());

            List<Boolean> isAuthUrl = new ArrayList<>();

            for (String str : urls) {
                isAuthUrl.add(StringUtils.equals(str, url));
            }

            long isAuthUrlCnt = isAuthUrl.stream().filter(authUrl -> authUrl.equals(Boolean.TRUE)).count();

            if (isAuthUrlCnt == 0) {
                log.error("is not access denied url -> {}", url);
                throw new WebException(ErrorCode.IS_NOT_ACCESS_DENIED_URL);
            } else {
                filterChain.doFilter(request, response);
            }

        } catch (WebException we) {
            we.getStackTrace();
            getWebExceptionData(we, response);
        }

    }


}
