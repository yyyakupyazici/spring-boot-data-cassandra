package com.bezkoder.spring.data.cassandra.service;

import org.springframework.stereotype.Service;

import com.bezkoder.spring.data.cassandra.dto.UserDto;
import com.bezkoder.spring.data.cassandra.dto.UserFollowersDto;
import com.bezkoder.spring.data.cassandra.model.User;
import com.bezkoder.spring.data.cassandra.model.UserFollowers;
import com.bezkoder.spring.data.cassandra.repository.UserFollowersRepository;
import com.bezkoder.spring.data.cassandra.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFollowersRepository userFollowersRepository;
    private final MessageProducerService messageProducerService;

    public User saveUser(UserDto userDto) {
        User user = User.builder().id(userDto.getId()).name(userDto.getName()).surname(userDto.getSurname())
                .followerlist(userDto.getFollowerlist()).createdat(userDto.getCreatedat()).build();
        user = userRepository.save(user);
        UserFollowersDto userFollowersDto = UserFollowersDto.builder().id(user.getId())
                .followers(user.getFollowerlist()).build();
        messageProducerService.sendMessage(userFollowersDto);
        return user;
    }

    public UserFollowers saveUsersFollowers(UserFollowersDto userFollowersDto) {
        UserFollowers userFollowers = UserFollowers.builder().id(userFollowersDto.getId())
                .followerList(userFollowersDto.getFollowers()).build();
        return userFollowersRepository.save(userFollowers);
    }
}
