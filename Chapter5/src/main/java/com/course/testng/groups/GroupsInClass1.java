package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsInClass1 {
    public void stu1(){
        System.out.println("GroupsInClass1中的stu11111111运行。。。");
    }
    public void stu2(){
        System.out.println("GroupsInClass1中的stu22222222运行。。。");
    }
}
