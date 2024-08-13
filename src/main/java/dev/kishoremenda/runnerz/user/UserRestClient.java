package dev.kishoremenda.runnerz.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class UserRestClient {
    private final RestClient restClient;
    
    public UserRestClient(RestClient.Builder builder) {
        JdkClientHttpRequestFactory jdkClientHttpRequestfactory = new JdkClientHttpRequestFactory();
        jdkClientHttpRequestfactory.setReadTimeout(5000);
        this.restClient = builder.baseUrl("https://jsonplaceholder.typicode.com")
                .requestFactory(jdkClientHttpRequestfactory)
                .build();
    }

    public List<User> findAll() {
        return this.restClient.get().uri("/users").retrieve().body(new ParameterizedTypeReference<List<User>>() {
        });

    }

    public User findById(Integer id) {
        return this.restClient.get().uri("/users/{id}", id).retrieve().body(User.class);
    }
}
