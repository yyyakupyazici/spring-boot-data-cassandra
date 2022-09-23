package com.bezkoder.spring.data.cassandra.model;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Table
@Builder
public class UserFollowers {
    @PrimaryKey
    private int id;
    private List<Integer> followerList;

}
