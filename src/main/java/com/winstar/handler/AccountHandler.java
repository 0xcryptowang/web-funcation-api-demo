package com.winstar.handler;

import com.winstar.domain.Account;
import com.winstar.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * account handler
 *
 * @author gradle
 */
@Component
public class AccountHandler {

    private final AccountRepository repository;

    @Autowired
    public AccountHandler(AccountRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> handleAccounts(ServerRequest request) {
        return ServerResponse.ok().body(this.repository.findAll(), Account.class);
    }

    public Mono<ServerResponse> handleAccount(ServerRequest request) {
        return ServerResponse.ok().body(this.repository.findById(request.pathVariable("id")), Account.class);
    }

    public Mono<ServerResponse> handleAccountCreate(ServerRequest request) {
        Mono<Account> accountMono = request.bodyToMono(Account.class);
        return ServerResponse.ok().body(this.repository.insert(accountMono), Account.class);
    }
}
