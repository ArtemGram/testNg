package com.example.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class secondClassTest {
    protected static final boolean DEBUG_SCOPE = true;

    List<secondClassTest> students = new ArrayList<>();

    @BeforeTest
    public void setUp() {

    }

    @Test(enabled = DEBUG_SCOPE,
            alwaysRun = true,
            groups = {"sanity", "smoke", "regression"},
            description = "testNumberOne",
            priority = 6)
    public void testNumber1() {
        System.out.print("Enter a name of student 1: ");
    }

    @Test(groups="sanity,smoke")
    public void testNumber2() {

    }

    @AfterMethod
    public void tearDown() {
    }


}