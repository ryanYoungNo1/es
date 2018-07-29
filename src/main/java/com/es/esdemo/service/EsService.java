package com.es.esdemo.service;


import com.es.esdemo.domain.Person;

import java.util.List;
import java.util.Optional;

public interface EsService {
    Optional<Person> findUserByMobileContainingOrNicknameContaining(String id);

    void save(Person person);

    List<Person> findUserByMobileAndNicknameContaining(String mobile, String nickname);
}
