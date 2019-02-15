package com.course.testng;

import org.testng.annotations.Test;

/**
 * 依赖测试
 */
public class DepandTest {
    @Test
    public void test1(){
        System.out.println( "test1111 run....");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("Test22222 run...");
    }
}
