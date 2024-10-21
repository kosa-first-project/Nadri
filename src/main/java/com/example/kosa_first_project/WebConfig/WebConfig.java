package com.example.kosa_first_project.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private String resourcePath = "/uploadImage/**"; // view에서 사용할 경로
    private String savePath = "C:\\kosa_first_project\\uploadImage\\"; // 프로젝트 루트의 uploadImage 폴더

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations("file:" + savePath); // file: 프로토콜 추가
    }
}
