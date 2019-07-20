package com.zzz.service;

import com.zzz.entity.HeadLine;

import java.io.IOException;
import java.util.List;

public interface HeadLineService {
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
