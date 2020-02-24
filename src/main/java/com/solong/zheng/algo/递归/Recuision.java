package com.solong.zheng.algo.递归;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author znsong
 * @Date 2019/11/15 18:42
 */
public class Recuision {

    public static void main(String[] args) {
        Recuision recuision = new Recuision();
        int f = recuision.f(7);

        int n = 6;
        int result = fa(n);
        map.forEach((k,v)->System.out.println(k+" // "+v));
 

        System.out.println(f);

        System.out.println((3+1)%8);

        System.out.println((6+1)%8);

        System.out.println(1%8);
    }

   /* int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f(n-1) + f(n-2);
    }*/


    int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; ++i) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }


    static Map map = new HashMap<Integer,Integer>();

    static Integer fa(Integer n){
        if(n == 2) return 2;
        if(n == 1) return 1;
        if(map.containsKey(n)){
            return (Integer) map.get(n);
        }
        Integer nn = fa(n-1)+fa(n-2);
        map.put(nn,nn);
        return nn;

    }

}
