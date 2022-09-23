package com.bezkoder.spring.data.cassandra.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.bezkoder.spring.data.cassandra.dto.UserFollowersDto;

public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, UserFollowersDto> consumerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
        configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new DefaultKafkaConsumerFactory<>(configMap);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserFollowersDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserFollowersDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}