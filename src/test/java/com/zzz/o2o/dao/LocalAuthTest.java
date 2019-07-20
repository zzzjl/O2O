package com.zzz.o2o.dao;

import com.zzz.dao.LocalAuthDao;
import com.zzz.entity.LocalAuth;
import com.zzz.entity.PersonInfo;
import com.zzz.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LocalAuthTest extends BaseTest {
    @Autowired
    private LocalAuthDao localAuthDao;
    @Test
   public  void testQueryLocalByUserNameAndPwd(){
        String username = "zzzjl";
        String password = "1";
        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
        System.out.println("localAuth: "+localAuth.getLocalAuthId()+ localAuth.getUsername());
    }
    @Test
    public  void testInsertLocalAuth(){
        String username = "zzzjl";
       LocalAuth localAuth =new LocalAuth();
       localAuth.setUsername("wowowo");
       localAuth.setLocalAuthId(2L);
       localAuth.setPassword("1");
       localAuth.setCreateTime(new Date());
       localAuth.setLastEditTime(new Date());
        PersonInfo personInfo =new PersonInfo();
        personInfo.setUserId(1L);
        localAuth.setPersonInfo(personInfo);
        int effnum;
        effnum = localAuthDao.insertLocalAuth(localAuth);
        System.out.println(effnum);
    }
    @Test
    public  void testupdateLocalAuth(){
        String username = "zzzjl";
        Long userId = 9527L;
        String password = "1";
        String newPassword = "123";
        Date lastEditDate = new Date();
        int effnum;
        effnum = localAuthDao.updateLocalAuth(userId,username,password,newPassword,lastEditDate);
        System.out.println(effnum);
    }
}
