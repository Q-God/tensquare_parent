package com.tensquare.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName LabelServiceImpl
 * @Description TODO
 * @Author Q
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll() {
        return labelDao.selectList(null);
    }

    @Override
    public Label findById(String id) {
        return labelDao.selectById(id);
    }

    @Override
    public void add(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.insert(label);
    }

    @Override
    public void update(Label label) {
        labelDao.updateById(label);
    }

    @Override
    public void delete(Label label) {
        labelDao.deleteById(label.getId());
    }

    @Override
    public IPage search(Map whereMap, int page, int size) {
        QueryWrapper<Label> wrapper = new QueryWrapper<>();
        wrapper.allEq(whereMap);
        //分页查询
        IPage<Label> pages = new Page<>(page, size);
        return labelDao.selectPage(pages, wrapper);
    }
}
