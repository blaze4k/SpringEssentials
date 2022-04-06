package com.mychatterbox;

import com.mychatterbox.hello.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MyChatterboxApplicationTests {

  @Autowired private HelloWorldController helloWorldController;

  @Test
  void contextLoads() {
    assertThat(helloWorldController).isNotNull();
  }
}
