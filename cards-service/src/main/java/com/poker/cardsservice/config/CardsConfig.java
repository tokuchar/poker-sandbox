package com.poker.cardsservice.config;

import com.poker.cardsservice.api.CardsApi;
import com.poker.cardsservice.repo.DealRepo;
import com.poker.cardsservice.service.DealService;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@EnableRedisRepositories
public class CardsConfig {
    private final RedisServer redis;

    public CardsConfig() {
            redis = RedisServer.builder()
                    .build();
    }

    @PostConstruct
    void postConstruct() {
        redis.start();
    }

    @PreDestroy
    void preDestroy() {
        redis.stop();
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }

    @Bean
    DealService dealService(DealRepo dealRepo) {
        return new DealService(dealRepo);
    }

    @Bean
    CardsApi cardsApi(DealService dealService){
        return new CardsApi(dealService);
    }

    @Bean
    VavrModule vavrModule() {
        return new VavrModule();
    }

}
