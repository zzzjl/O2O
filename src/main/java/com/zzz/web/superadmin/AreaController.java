package com.zzz.web.superadmin;

import com.zzz.entity.Area;
import com.zzz.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {
     private  Logger logger = (Logger) LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;
    //logger.info("====end====");


    @RequestMapping(value="/listarea" ,method=RequestMethod.GET)
    @ResponseBody


    private Map<String,Object> listArea(){
        logger.info("====start====");
        long startTime = System.currentTimeMillis();
        Map<String,Object> modelMap =new HashMap<String, Object>();
        List<Area> list= new ArrayList<Area>();
        try{
            list=areaService.getAreaList();
            modelMap.put("rows",list);
          //  System.out.println(modelMap.get("total"));
            modelMap.put("total",list.size());
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        long endTime=System.currentTimeMillis();
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("====end====");
        return modelMap;

    }
}
