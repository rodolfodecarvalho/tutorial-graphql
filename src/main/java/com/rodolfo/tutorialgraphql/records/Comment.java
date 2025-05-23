package com.rodolfo.tutorialgraphql.records;

public record Comment(
        String id,
        String content,
        String postId) {
}