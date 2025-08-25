package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.PostService;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired private PostService postService;

    // [1] 게시물 등록

}
