package com.tensquare.base.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tensquare.base.pojo.Label;

import java.util.List;
import java.util.Map;

public interface LabelService {
    List<Label> findAll();

    Label findById(String id);

    void add(Label label);

    void update(Label label);

    void delete(Label label);

    IPage search(Map whereMap, int page, int size);
}
