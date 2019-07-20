package com.zzz.dao;

import com.zzz.entity.Area;
import com.zzz.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeadLineDao {
    /*
    * 列出区域列表
    * @areaList
    * */
    List<HeadLine> queryHeadLine(@Param("headLineCondition")HeadLine headLineCondition);

}
