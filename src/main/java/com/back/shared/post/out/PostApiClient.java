package com.back.shared.post.out;

import com.back.shared.post.dto.PostDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostApiClient {
    private final RestClient restClient;

    public PostApiClient(@Value("${custom.global.internalBackUrl}") String internalBackUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(internalBackUrl + "/api/v1/post")
                .build();
    }

    // 자바의 타입 소거로 인해 런타임에는 List<PostDto> 정보가 사라진다.
    // ParameterizedTypeReference는 제네릭 타입 정보를 런타임까지 유지
    // Jackson이 List<PostDto>로 역직렬화할 수 있게 해준다.
    public List<PostDto> getItems() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
        });
    }

    public PostDto getItem(int id) {
        return restClient.get()
                .uri("/posts/%d".formatted(id))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
        });
    }
}
