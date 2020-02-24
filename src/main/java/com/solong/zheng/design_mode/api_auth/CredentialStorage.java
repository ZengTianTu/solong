package com.solong.zheng.design_mode.api_auth;

public interface CredentialStorage {
    String getPasswordByAppId(String appId);
}
