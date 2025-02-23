package com.example.FuntimeQuiz;

import com.example.FuntimeQuiz.entity.User;
import com.example.FuntimeQuiz.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInit implements CommandLineRunner {

    private final UserRepository userRepository;

    public TestDataInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 샘플 데이터 저장
        User user1 = new User(null, "Alice", "alice@example.com");
        User user2 = new User(null, "Bob", "bob@example.com");

        userRepository.save(user1);
        userRepository.save(user2);

        // 저장된 데이터 조회
        System.out.println("==== 저장된 유저 목록 ====");
        userRepository.findAll().forEach(System.out::println);
    }
}
