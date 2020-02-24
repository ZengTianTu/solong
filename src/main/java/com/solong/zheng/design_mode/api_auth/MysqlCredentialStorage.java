package com.solong.zheng.design_mode.api_auth;

public class MysqlCredentialStorage implements CredentialStorage{

    @Override
    public String getPasswordByAppId(String appId) {
        return "123456";
    }
}
