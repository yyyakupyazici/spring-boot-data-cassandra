package com.bezkoder.spring.data.cassandra.service;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.data.cassandra.dto.UserFollowersDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageConsumerService {

    private final UserService userService;

    @KafkaListener(topics = "follower", groupId = "group_id")
    public void consume(@Payload UserFollowersDto userFollowerDto,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition)
            throws IOException {
        userService.saveUsersFollowers(userFollowerDto);
        log.info(String.format("#### -> Consumed message ->%s", userFollowerDto.toString()));
    }
}
