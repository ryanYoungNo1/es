package com.es.esdemo.service.impl;


import com.es.esdemo.domain.Person;
import com.es.esdemo.mapper.EsBeanMapper;
import com.es.esdemo.service.EsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EsServiceImpl implements EsService {

    @Autowired
    private EsBeanMapper esBeanMapper;

    @Override
    public List<Person> findUserByMobileAndNicknameContaining(String mobile, String nickname) {
        List<Person> list = esBeanMapper.findUserByMobileContainingOrNicknameContaining(mobile, nickname);
        return list;
    }

    @Override
    public Optional<Person> findUserByMobileContainingOrNicknameContaining(String id) {
        return esBeanMapper.findById(id);
    }

    @Override
    public void save(Person person) {
        esBeanMapper.save(person);
    }
}
