package com.liang.blog.service;

import java.util.List;

import com.liang.blog.po.Blog;
import com.liang.blog.vo.BlogQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog SaveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
