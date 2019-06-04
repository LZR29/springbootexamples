package com.lzr.webflux.service;

import com.lzr.webflux.bean.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getUser(Long id);

    Mono<User> insertUser(User user);

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(Long id);

    Flux<User> findUsers(String userName, String note);
}
