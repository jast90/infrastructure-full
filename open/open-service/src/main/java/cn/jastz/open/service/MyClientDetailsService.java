package cn.jastz.open.service;

import cn.jastz.open.domain.MyClientDetails;
import cn.jastz.open.entity.App;
import cn.jastz.open.mapper.AppMapper;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhiwen
 */
@Service
public class MyClientDetailsService implements ClientDetailsService {
    @Autowired
    private AppMapper appMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        App app = appMapper.selectByPrimaryKey(clientId);
        if (app == null) {
            throw new ClientRegistrationException("client not exist");
        }
        MyClientDetails myClientDetails = new MyClientDetails();
        myClientDetails.setClientId(app.getAppId());
        myClientDetails.setClientSecret(app.getAppSecret());
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        myClientDetails.setAuthorities(authorities);
        myClientDetails.setScope(Sets.newHashSet("all"));
        myClientDetails.setAuthorizedGrantTypes(Sets.newHashSet("client_credentials", "authorization_code", "refresh_token", "password"));
        myClientDetails.setAutoApproveScopes(Sets.newHashSet("all"));
        return myClientDetails;
    }
}
