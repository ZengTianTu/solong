package com.solong.jasongj.java.annotation;

/**
 * @Author znsong
 * @Date 2020/2/21 9:16
 */
@Component(identifier = "upper")
public class UpperCaseComponent {

    public String doWork(String input){
        if(input!=null){
            return input.toUpperCase();
        }else{
            return null;
        }
    }

}
