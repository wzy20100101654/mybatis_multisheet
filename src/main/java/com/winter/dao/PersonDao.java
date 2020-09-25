package com.winter.dao;

import com.winter.domain.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
}
