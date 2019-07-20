package com.zzz.o2o.Service;

import com.zzz.entity.Area;
import com.zzz.o2o.BaseTest;
import com.zzz.service.AreaService;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList =areaService.getAreaList();
        System.out.println(areaList.toString());
        //assertEquals("广西",areaList.get(0).getAreaName());

    }


}
