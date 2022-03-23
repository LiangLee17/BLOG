package com.liang.blog.dao;

import java.util.List;

import com.liang.blog.po.Blog;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog>{

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);
}
