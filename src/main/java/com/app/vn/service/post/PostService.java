package com.app.vn.service.post;

import com.app.vn.common.model.Post;
import org.springframework.data.domain.Page;

public interface PostService {

    public Post add(Post post);

    public Post getById(long id);

    public Post getByCode(String code);

    public Page<Post> getPosts(int pageNumber, int pageSize);
}
