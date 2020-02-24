package com.solong.jasongj.java.annotation;

/**
 * @Author znsong
 * @Date 2020/2/21 9:21
 */
public class Client {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.jasong.annotation.UpperCaseComponent");
            if(aClass.isAnnotationPresent(Component.class)){
                Component annotation = aClass.getAnnotation(Component.class);
                String identifier = annotation.identifier();
                System.out.println("annotation为：" + identifier);
            }else{
                System.out.println("UpperCaseComponent is not annotated.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
