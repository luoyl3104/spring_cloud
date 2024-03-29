package com.luoyl.eureka_customer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class ArrayTest {


    @Test
    public void testTime(){
        //20201225
        LocalDate dateTime = LocalDate.of(2020, 12, 6);
        //20201204
        LocalDate localDate = LocalDate.of(2020,12,4);
        System.out.println(localDate.isBefore(dateTime));

    }

    @Test
    public void sortTest(){

        Logger logger = LoggerFactory.getLogger(ArrayTest.class);

        int a[] = {1,2,4,7,5,3};
        //冒泡
        /*for(int i = 1;i < a.length;i++){
            for(int j = 0;j < a.length-i;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }*/
        for (int i = 0;i<a.length-1;i++){
            for (int j = 0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    int t = a[j+1];
                    a[j+1] = a[j];
                    a[j] = t;
                }
            }
        }
        for (int i : a) {
            logger.warn(""+i);
        }
        //选择
        for (int i = 0;i<a.length;i++){
            for (int j = i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    int t = a[j];
                    a[j] =a[i];
                    a[i] = t;
                }
            }
        }
        logger.info("----------------");
        for (int i : a) {
            logger.warn(""+i);
        }
    }

    public static int[] Test(int[] a){
        int [] b =new int [1001];
        for (int i =0;i<1001;i++){
            b[i] = 0;
        }
        int len = a.length;
        for (int i =0;i<len;i++)
        {
            b[a[i]] = 1;
        }
        return b;
    }
    @Test
     public void test(){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] a =new int [n];
            for (int i =0;i<n;i++){
                a[i] = sc.nextInt();
            }
            int[] c = Test(a);
            int len = c.length;
            for (int i =0;i<len;i++){
                if(c[i] == 1){
                    System.out.println(i);
                }
            }
        }
    }

    @Test
    public void testD(){
        BigDecimal bigDecimal = new BigDecimal("56.12");
        System.out.println(bigDecimal.setScale(0,BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testC(){
        BigDecimal bigDecimal = new BigDecimal("1.05");
        BigDecimal bigDecimal1 = new BigDecimal("0.00");
        System.out.println(bigDecimal1.compareTo(bigDecimal));
    }

}
