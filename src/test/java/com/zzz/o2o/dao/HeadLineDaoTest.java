package com.zzz.o2o.dao;

import com.zzz.dao.HeadLineDao;
import com.zzz.entity.HeadLine;
import com.zzz.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeadLineDaoTest extends BaseTest {
    @Autowired
    private HeadLineDao headLineDao;
    @Test
    public void testQueryHeadLine(){
        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(0);
        List<HeadLine> headLineList = headLineDao.queryHeadLine(headLine);
        for (HeadLine hl:headLineList){
            System.out.println(hl.getLineName());
        }
        assertEquals(1,headLineList.size());

    }
}