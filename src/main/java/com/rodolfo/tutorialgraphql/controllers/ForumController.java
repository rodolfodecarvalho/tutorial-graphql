package com.rodolfo.tutorialgraphql.controllers;

import com.rodolfo.tutorialgraphql.records.Comment;
import com.rodolfo.tutorialgraphql.records.Post;
import com.rodolfo.tutorialgraphql.services.CommentService;
import com.rodolfo.tutorialgraphql.services.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ForumController {

    private final PostService postService;

    private final CommentService commentService;

    @QueryMapping
    public Post getPostById(@Argument String id) {
        log.info("getPostById: {}", id);
        return postService.getPostById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId) {
        return commentService.createComment(content, postId);
    }

    @SchemaMapping
    public Collection<Comment> comments(Post post) {
        log.info("comments: {}", post.id());
        return commentService.findByPost(post.id());
    }
}