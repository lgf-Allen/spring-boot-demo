/**
 * 
 */
package com.allen.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * @author first
 *
 */
@Configuration
@EnableAuthorizationServer
public class SecurityOauth2Config extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
               .withClient("allen")
               .resourceIds("resourceId")
               .secret("secret")
               .accessTokenValiditySeconds(2000)
               .refreshTokenValiditySeconds(-1)
               .scopes("read" , "write")
               .authorizedGrantTypes("password" , "refresh_token");
    }
    
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                   .checkTokenAccess("isAuthenticated()");
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
