package com.hoangbui.shopping.dao.impl;

import com.hoangbui.shopping.dao.FinanceDAO;
import com.hoangbui.shopping.entity.FinanceEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(rollbackFor = Exception.class)
public class FinanceDAOImpl extends BaseDAOImpl<FinanceEntity> implements FinanceDAO<FinanceEntity> {
    @Override
    public int save(FinanceEntity instance) {
        return 0;
    }

    @Override
    public void update(FinanceEntity instance) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<FinanceEntity> findAll() {
        return null;
    }

    @Override
    public FinanceEntity findById(int id) {
        return null;
    }
}
