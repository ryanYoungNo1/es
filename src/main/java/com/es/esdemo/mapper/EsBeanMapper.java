package com.es.esdemo.mapper;


import com.es.esdemo.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EsBeanMapper extends ElasticsearchRepository<Person,String> {
    List<Person> findUserByMobileContainingOrNicknameContaining(String mobile, String nickname);

    @Override
    Optional<Person> findById(String s);
}
