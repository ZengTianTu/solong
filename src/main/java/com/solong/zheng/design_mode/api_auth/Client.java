package com.solong.zheng.design_mode.api_auth;

public class Client {
    public static void main(String[] args) {

        String requestUrl = "http://localhost/login" +
                "?token=YIv8yLTrUUk9KfoXT0/gkk9EXi1bmUq0vr8I0azCnfw=" +
                "&appId=123456" +
                "&timestamp=1581730218124";

        ApiAuthenticator apiAuthenticator = new DefaultApiAuthenticator();
        apiAuthenticator.auth(requestUrl);
    }
}
