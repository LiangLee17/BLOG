package com.liang.blog.service;

import java.util.List;

import com.liang.blog.po.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);


    Tag updateTag(Long id, Tag tag);

    Tag getTagByName(String name);

    void deleteTag(Long id);
}
