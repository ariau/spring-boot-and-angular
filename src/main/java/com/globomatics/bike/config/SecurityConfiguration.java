package com.globomatics.bike.config;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Value(value = "${auth0.apiAudience}")
  private String apiAudience;

  @Value(value = "${auth0.issuer}")
  private String issuer;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors();
    JwtWebSecurityConfigurer.forRS256(apiAudience, issuer)
        .configure(http)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/api/v1/bikes")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1/bikes")
        .hasAuthority("view:registrations")
        .antMatchers(HttpMethod.GET, "/api/v1/bikes/**")
        .hasAuthority("view:registration")
        .anyRequest()
        .authenticated().and().cors().configurationSource(corsConfigurationSource());
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Collections.singletonList("*")); // <-- you may change "*"
    configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
    configuration.setAllowCredentials(true);
    configuration.setAllowedHeaders(Arrays.asList(
        "Accept", "Origin", "Content-Type", "Depth", "User-Agent", "If-Modified-Since,",
        "Cache-Control", "Authorization", "X-Req", "X-File-Size", "X-Requested-With",
        "X-File-Name"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(
        new CorsFilter(corsConfigurationSource()));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
  }
}
