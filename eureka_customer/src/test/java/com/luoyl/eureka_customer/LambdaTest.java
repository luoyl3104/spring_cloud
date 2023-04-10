package com.luoyl.eureka_customer;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class LambdaTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(getLong(str));

        /*try{
            System.out.print("随机输入一个十进制整数：");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            String s = Integer.toBinaryString(i);
            if (s.length()<16){
                int m = 16-s.length();
                for (int j=0;j<m;j++){
                    s = "0"+s;
                }
            }else if (s.length()>16){
                s = s.substring(15);
            }
            String s1 = Integer.toHexString(i);
            if (s1.length()<4){
                int m = 4-s1.length();
                for (int j=0;j<m;j++){
                    s1 = "0"+s1;
                }
            }else if (s1.length()>4){
                s1 = s1.substring(3);
            }
            char[] chars = s1.toCharArray();
            String s2="";
            for (char c : chars) {
                if (Character.isLowerCase(c)){
                    c = Character.toUpperCase(c);
                }
                s2 = s2 + c;
            }
            System.out.println(s+","+s2);
        }catch (Exception e){
            System.out.println("输入非法");
        }*/



        /*MathOperation add = (int a,int b) -> a+b;

        MathOperation sub = (a,b)-> a-b;

        MathOperation mult = (int a,int b)->{return a*b;};

        MathOperation div = (a,b) -> a/b;

        Logger logger = LoggerFactory.getLogger(LambdaTest.class);

        LambdaTest lambdaTest = new LambdaTest();

        logger.info("和："+lambdaTest.operate(3,4,add));
        logger.info("差："+lambdaTest.operate(3,4,sub));
        logger.info("积："+lambdaTest.operate(3,4,mult));
        logger.info("商："+lambdaTest.operate(3,4,div));


        GetService getService1 = (msg) -> logger.info("msg1:"+msg);

        GetService getService2 = msg -> logger.info("msg2:"+msg);

        getService1.sayMsg("aa");
        getService2.sayMsg("bb");*/

    }


    interface MathOperation{
        int operation(int a,int b);
    }
    interface GetService{
        void sayMsg(String msg);
    }
    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }

    @Test
    public void arrayLambda(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(i -> logger.info(""+i) );
    }

    @Test
    public void test(){

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        //最大值
        Optional<Integer> max = list.stream().max(Comparator.comparing(t -> t));
        //最小值
        Optional<Integer> min = list.stream().min(Comparator.comparing(i -> i));
        if (max.isPresent()){
            System.out.println(max.get());
            System.out.println(min.get());
        }

    }

    @Test
    public void test1(){
        System.out.println("十进制转16进制："+Integer.toHexString(15));
        System.out.println(Integer.toBinaryString(15));
    }

    private static int getLong(String str){
        String[] s = str.split(" ");
        return s[s.length-1].length();
    }


    @Test
    public void testStr(){
        String str = "2021年10月版";
        char[] chars = str.toCharArray();
        String s = String.valueOf(chars[4]);
        System.out.println(s);
        System.out.println(chars[4]);
        System.out.println(chars[chars.length-1]);
        System.out.println(chars[chars.length-2]);

        Boolean b = true;



    }



}
