package com.zzz.service;

import com.zzz.dto.LocalAuthExcution;
import com.zzz.entity.LocalAuth;
import com.zzz.exceptions.LocalAuthOperationException;

import java.util.Date;

public interface LocalAuthService {
    /*通过账号和密码获取平台信息
    * */
    LocalAuth getLocalAuthByUsernameAndPwd(String username,String password);

    /*通过userId获取平台账号信息
    * */
    LocalAuth getLocalAuthByUserId(long userId);
    /*
    *修改平台账号登录密码
    * */
    LocalAuthExcution modifyLocalAuth(Long userId , String username, String password, String newPassWord )throws LocalAuthOperationException;
}
