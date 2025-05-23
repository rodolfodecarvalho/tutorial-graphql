package com.rodolfo.tutorialgraphql.services;

import com.rodolfo.tutorialgraphql.records.Post;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostService {
    Map<String, Post> posts = new HashMap<>();

    public Collection<Post> createPost(String content) {
        Post post = new Post(UUID.randomUUID().toString(), content);
        posts.put(post.id(), post);
        return posts.values();
    }

    public Post getPostById(String id) {
        return posts.get(id);
    }
}
