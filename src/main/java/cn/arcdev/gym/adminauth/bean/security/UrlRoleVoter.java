package cn.arcdev.gym.adminauth.bean.security;

import cn.arcdev.gym.adminauth.entity.Role;
import cn.arcdev.gym.adminauth.entity.UrlResource;
import cn.arcdev.gym.adminauth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Vote based on urls and roles.
 *
 * @author Kraken
 */
@Component("UrlRoleVoter")
@RequiredArgsConstructor
public class UrlRoleVoter implements AccessDecisionVoter<Object> {
    private static final String AUTHENTICATED_ATTRIBUTE = "authenticated";
    protected final RoleRepository roleRepository;

    @Override
    public boolean supports(ConfigAttribute attribute) {
        if (attribute.toString() != null && attribute.toString().equals(AUTHENTICATED_ATTRIBUTE)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        if (authentication == null) {
            return ACCESS_ABSTAIN;
        }
        if (!FilterInvocation.class.isInstance(object)) {
            return ACCESS_ABSTAIN;
        }
        String url = ((FilterInvocation) object).getRequestUrl();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            int result;
            Optional<Role> optionalRole = roleRepository.findRoleAndUrlResourcesByName(authority.getAuthority());
            if (optionalRole.isPresent()) {
                List<UrlResource> urlResources = optionalRole.get().getUrlResources();
                for (UrlResource urlResource : urlResources) {
                    if (Pattern.matches(urlResource.getRegex(), url)) {
                        return ACCESS_GRANTED;
                    }
                }
            }
        }
        return ACCESS_ABSTAIN;
    }
}
