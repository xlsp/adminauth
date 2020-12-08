package cn.arcdev.gym.adminauth.config;

import cn.arcdev.gym.adminauth.filter.AuthExceptionTranslationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring web configurations.
 *
 * @author Kraken
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource(name = "UrlRoleVoter")
    private AccessDecisionVoter<Object> urlRoleVoter;

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(new AuthExceptionTranslationFilter(), ExceptionTranslationFilter.class)
                .authorizeRequests(authorize -> {
                    List<AccessDecisionVoter<?>> accessDecisionVoters = new ArrayList<>();
                    accessDecisionVoters.add(urlRoleVoter);
                    AccessDecisionManager accessDecisionManager = new UnanimousBased(accessDecisionVoters);
                    authorize.anyRequest().authenticated().accessDecisionManager(accessDecisionManager);
                }).exceptionHandling(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable).formLogin();
    }
}
