package com.app.vn.controller.post;


import com.app.vn.common.model.PaggingResult;
import com.app.vn.common.model.Post;
import com.app.vn.common.model.User;
import com.app.vn.service.post.PostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping("private")
public class PostController {

    private PostService postService;

    @Inject
    private PaggingResult result;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("post/get")
    @ApiOperation(
            value = "Danh sách người dùng(Có phân trang)",
            notes = "Dùng cho chức năng lấy danh sách người dùng."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lấy dữ liệu thành công."),
            @ApiResponse(code = 400, message = "Có lỗi xảy ra khi lấy dữ liệu người dùng!")
    })
    public ResponseEntity<PaggingResult> get(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                             @RequestParam(required = false,defaultValue = "50") int pageSize){
        Page<Post> users = postService.getPosts(pageNumber,pageSize);
        result.setTotalItem(users.getTotalElements());
        result.setTotalPage(users.getTotalPages());
        result.setItemList(users.getContent());
        return new ResponseEntity<PaggingResult>(result, HttpStatus.OK);
    }
}
