package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity // DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@ToString
public class Article {

    @Id // 대표값을 지정! like a 주민번호
    @GeneratedValue // 1, 2, 3, .... 자동 생성 어노테이션!
    private Long id;

    @Column // 열이라는 걸 알려야함
    private String title;

    @Column
    private String content;
}
