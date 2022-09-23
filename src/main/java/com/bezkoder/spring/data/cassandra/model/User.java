package com.bezkoder.spring.data.cassandra.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Table
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @PrimaryKey
    private int id;
    private String name;
    private String surname;
    private List<Integer> followerlist;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime createdat;

}
