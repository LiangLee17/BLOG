package com.liang.blog.service;

import com.liang.blog.po.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag tag);

    Tag getTagByName(String name);

    void deleteTag(Long id);
}
