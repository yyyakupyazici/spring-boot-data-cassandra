package com.bezkoder.spring.data.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.bezkoder.spring.data.cassandra.model.UserFollowers;

public interface UserFollowersRepository extends CassandraRepository<UserFollowers, Integer> {

}
