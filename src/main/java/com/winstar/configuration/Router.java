package com.winstar.configuration;

import com.winstar.handler.AccountHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * router
 *
 * @author gradle
 */
@Configuration
public class Router {
    private final AccountHandler handler;

    @Autowired
    public Router(AccountHandler handler) {
        this.handler = handler;
    }


    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/api/account/{id}").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::handleAccount)
                .and(route(GET("/api/account").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::handleAccounts)
                        .and(route(POST("/api/account").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::handleAccountCreate)));
    }
}
