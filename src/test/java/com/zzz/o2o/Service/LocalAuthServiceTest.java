package com.zzz.o2o.Service;


import com.zzz.dto.LocalAuthExcution;
import com.zzz.entity.LocalAuth;
import com.zzz.o2o.BaseTest;
import com.zzz.service.LocalAuthService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LocalAuthServiceTest extends BaseTest {
    @Autowired
    private LocalAuthService localAuthService;
@Test
    public void TestgetLocalAuthByUsernameAndPwd() {
        String username = "zzzjl";
        String password = "123";
        LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, password);
        System.out.println("localAuth: "+localAuth.getLocalAuthId()+ localAuth.getUsername());
    }
    @Test
    public void TestmodifyLocalAuth(){
      Long userId =9527L;
        String username = "zzzjl";
        String password = "123";
        String newPassword ="1";
        LocalAuthExcution localAuthExcution =localAuthService.modifyLocalAuth(userId,username,password,newPassword);
        System.out.println(localAuthExcution.getStateInfo());

    }



}
