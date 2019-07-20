package com.zzz.dao;

import com.zzz.entity.Area;

import java.util.List;

public interface AreaDao {
    /*
    * 列出区域列表
    * @areaList
    * */
    List<Area> queryArea();

}
