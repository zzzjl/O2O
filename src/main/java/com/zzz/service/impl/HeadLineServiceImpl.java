package com.zzz.service.impl;

import com.zzz.dao.HeadLineDao;
import com.zzz.entity.HeadLine;
import com.zzz.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;
    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException{
        return headLineDao.queryHeadLine(headLineCondition);
    }

}
