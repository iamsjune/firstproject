package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // constructor를 선언한 것 같은 기능 --> Refactoring
@ToString // toString을 선언한 것 같은 기능 --> Refactoring
public class ArticleForm {

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
