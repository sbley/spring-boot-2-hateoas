package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class IndexControllerTest {

    @Autowired private TestRestTemplate clientRestTemplate;

    @Test
    public void responseShouldContainLinks() {
        final ResponseEntity<ResourceSupport> response = clientRestTemplate.getForEntity("/", ResourceSupport.class);
        assertThat(response.getBody().getLink("self")).isNotNull();
    }
}
