package com.liang.blog.service;

import java.util.List;
import java.util.Map;

import com.liang.blog.po.Blog;
import com.liang.blog.vo.BlogQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    Page<Blog> listBlog(Long tagId, Pageable pageable);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    Blog getAndConvert(Long id);

    Blog SaveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
