package com.liang.blog.service;

import com.liang.blog.po.Type;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
