package com.bezkoder.spring.data.cassandra.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String name;
    private String surname;
    private List<Integer> followerlist;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime createdat;
}
