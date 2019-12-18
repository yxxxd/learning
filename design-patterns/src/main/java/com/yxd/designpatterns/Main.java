package com.yxd.designpatterns;

/**
 * @author yuxudong
 * @date 2019/11/22 21:45
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(output());
    }

    private static int output() {
        try{
            System.out.println("try-start...");
            //int a = 1/0;
            return 1;
        }catch (Exception e){
            System.out.println("catch-start...");
            return 2;
        }finally {
            System.out.println("finally-start...");
            return 3;
        }
    }
}
