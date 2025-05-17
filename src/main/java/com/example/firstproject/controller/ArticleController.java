package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
//        System.out.println(form.toString()); --> 서버의 성능과 관련되기 때문에 logging으로 대체!

        // JPA 1. Dto를 변환! Entity!
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());

        // JPA 2. Repository에게 Entity를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println(saved.toString()); // id가 자동 설정되어 반환된 것을 확인가능!

        return "";
    }
}
