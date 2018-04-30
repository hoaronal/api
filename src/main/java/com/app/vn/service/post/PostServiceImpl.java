package com.app.vn.service.post;

import com.app.vn.common.model.Post;
import com.app.vn.repository.post.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository= postRepository;
    }
    @Override
    @Transactional
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Page<Post> getPosts(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        Specification<Post> specification = new Specification<Post>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                return cb.and(predicates.toArray(new Predicate[0]));
            }

        };
        return postRepository.findAll(specification, pageRequest);
    }
}
