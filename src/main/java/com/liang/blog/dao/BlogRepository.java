package com.liang.blog.dao;

import java.util.List;

import com.liang.blog.po.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog>{

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);

    @Query("select b from Blog b where b.title like ?1 or b.description like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    Blog getBlogById(Long id);

    @Transactional
    @Modifying
    @Query("update Blog b set b.views = b.views + 1 where b.id = ?1")
    int updateViews(Long id);
}
