package com.training.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

    @Test
    @DisplayName("Main class test")
    void main() {
        ApiApplication.main(new String[] {});
    }

}
