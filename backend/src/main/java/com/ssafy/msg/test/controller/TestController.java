package com.ssafy.msg.test.controller;


import com.ssafy.msg.test.model.dto.TestMongo;
import com.ssafy.msg.test.model.dto.TestRedis;
import com.ssafy.msg.test.model.repo.TestMongoRepository;
import com.ssafy.msg.test.model.repo.TestRedisRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j

@Tag(name = "Test", description = "테스트 관련 API")
public class TestController {

    private final TestMongoRepository testMongoRepository;
    private final TestRedisRepository testRedisRepository;

    @GetMapping("/mongo")
    public String testMongo() {
        testMongoRepository.deleteAll();

        testMongoRepository.save(TestMongo.builder().firstName("Alice").lastName("Smith").build());
        testMongoRepository.save(TestMongo.builder().firstName("Bob").lastName("Smith").build());

        System.out.println("TestDtos found with findAll():");
        System.out.println("-------------------------------");
        for (TestMongo testMongo : testMongoRepository.findAll()) {
            System.out.println(testMongo);
        }

        System.out.println();
        System.out.println("TestDto found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(testMongoRepository.findByFirstName("Alice"));

        System.out.println("TestDtos found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (TestMongo testMongo : testMongoRepository.findByLastName("Smith")) {
            System.out.println(testMongo);
        }
        return testMongoRepository.findAll().toString();
    }


    @GetMapping("/redis")
    public String testRedis() {
        TestRedis testRedis = new TestRedis(1L, "refreshToken");
        testRedisRepository.save(testRedis);

        return testRedisRepository.findAll().toString();
    }
}
