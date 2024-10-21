package com.example.kosa_first_project.WebConfig;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
public class RequestList<T> {
    private T data;
    private Pageable pageable;
}