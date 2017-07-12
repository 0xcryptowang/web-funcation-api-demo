package com.winstar.repository;

import com.winstar.domain.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * account repository
 *
 * @author gradle
 */
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {


}
