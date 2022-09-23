package com.bezkoder.spring.data.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.bezkoder.spring.data.cassandra.model.User;

public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByName(String name);
}
