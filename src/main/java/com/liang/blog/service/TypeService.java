package com.liang.blog.service;

import java.util.List;

import com.liang.blog.po.Type;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Type updateType(Long id, Type type);

    Type getTypeByName(String name);

    void deleteType(Long id);
}
