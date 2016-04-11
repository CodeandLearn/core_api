package Core;

import Core.Plugins.Account.Login;
import Core.Datas.Global;
import Core.Tools.DataUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.HashMap;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    private TokenStore tokenStore = new InMemoryTokenStore();
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        System.out.println("AuthorizationServerEndpointsConfigurer");
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println("ClientDetailsServiceConfigurer");
        Login login = new Login();
        login.sqlGetUsers();
        for (int i = 0; i < login.getUser().size(); i++) {
            HashMap<String, Object> data = new HashMap<>();
            clients.inMemory().withClient(login.getUser().get(i).username)
                    .authorizedGrantTypes("client_credentials", "password", "refresh_token", "implicit")
                    .accessTokenValiditySeconds(60 * 60 * 24).refreshTokenValiditySeconds(60 * 60 * 24 * 5)
                    .authorities("USER").scopes("read").resourceIds(Global.RESOURCE_ID).secret(login.getUser().get(i).password);
            data.put("accounts.id", login.getUser().get(i).id);
            data.put("accounts.username", login.getUser().get(i).username);
            data.put("accounts.password", login.getUser().get(i).password);
            data.put("accounts.group_id", login.getUser().get(i).group_id);
            data.put("accounts.email", login.getUser().get(i).email);
            data.put("accounts.authorities", "USER");
            data.put("accounts.scopes", "read");
            data.put("accounts.resourceIds", Global.RESOURCE_ID);
            DataUsers.getInstance().users.add(data);
        }
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        System.out.println("tokenServices");
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(this.tokenStore);
        return tokenServices;
    }
}
