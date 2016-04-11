package Core;

import Core.Datas.Global;
import Core.Tools.DataUsers;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/blog", "/register")
                .permitAll()
                .anyRequest()
                .access("#oauth2.hasScope('read')")
                .and().addFilterAfter(csrfHeaderFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(Global.RESOURCE_ID);
    }

    private OncePerRequestFilter csrfHeaderFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                System.out.println(DataUsers.getInstance().users);
                if (SecurityContextHolder.getContext().getAuthentication() != null) {
                    for (int i = 0; i < DataUsers.getInstance().users.size(); i++) {
                        if (DataUsers.getInstance().users.get(i).get("accounts.username").equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
                            request.setAttribute("accounts.id", DataUsers.getInstance().users.get(i).get("accounts.id"));
                        }
                    }
                }
                filterChain.doFilter(request, response);
            }
        };
    }


}