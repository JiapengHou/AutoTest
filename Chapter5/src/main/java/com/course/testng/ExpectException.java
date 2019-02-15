package com.course.testng;

import org.testng.annotations.Test;

public class ExpectException {
    /**
     * 在我们期望为某个异常的时候
     * 比如; 我们传入了某个不合法的参数，程序抛出了一成
     * 也就是说我们预期结果的异常
     *
     */

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试。。。");
    }
    //这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void  runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();

    }
}
