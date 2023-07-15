package com.amirkenesbay.payload;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    // не должен быть пустым, и должен содержать минимум 10 символов
    private String name;

    // должен быть формат email-а, то есть чтобы не мог отправить обычную строку и не должен быть пустым
    private String email;

    // не должен быть пустым и минимум должно быть 20 символов
    private String body;
}
