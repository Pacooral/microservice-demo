package org.software.gatewayservice.filter;

import org.software.gatewayservice.MSresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入全局过滤器");
        // 获取请求路径等信息
        String requestPath = exchange.getRequest().getPath().toString();
        System.out.println(requestPath);
        // 判断是否是需要跳过全局过滤器的请求
        if (requestPath.contains("/signin")) {
            // 如果是特定路径，则跳过过滤器逻辑，直接进入下一个过滤器或路由处理
            System.out.println("跳过过滤器逻辑，直接进入下一个过滤器或路由处理");
            return chain.filter(exchange);
        }
        if (requestPath.contains("/signup")) {
            // 如果是特定路径，则跳过过滤器逻辑，直接进入下一个过滤器或路由处理
            System.out.println("跳过过滤器逻辑，直接进入下一个过滤器或路由处理");
            return chain.filter(exchange);
        }
        return doFilter(exchange, chain);
    }
    private Mono<Void> doFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 全局过滤器的实际逻辑
        // 可以在这里进行安全认证、日志记录等全局操作
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        String password = exchange.getRequest().getQueryParams().getFirst("password");
        System.out.println(username);
        System.out.println(password);
        if(username == null || password == null || username.length() == 0 || password.length() == 0) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        //调用user-service的登录接口
        String userServiceUrl = "http://user-service/signin/name?username=" + username + "&password=" + password;
        MSresponse result = restTemplate.getForObject(userServiceUrl, MSresponse.class);
        System.out.println(result);
        if(result == null || !result.getMessage().equals("OK")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
}
