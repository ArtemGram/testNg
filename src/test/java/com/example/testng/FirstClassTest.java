package com.example.testng;

import org.testng.annotations.*;


public class FirstClassTest {

    @BeforeTest
    public void setUp() {
        System.out.print("First test execution "); //
    }

    @Test(alwaysRun = true,
            groups = {"sanity", "regression"},
            description = "testNumberOne",
            priority = 1
           /* dependsOnGroups = "smoke"*/)
    public void testNumber1() {
        System.out.println(getClass().getName());
        System.out.println("test Group Sanity");
    }

    @Test(groups="smoke")
    public void testNumber2() {
        System.out.println("SHOULD NOT BEING PRINTED");
    }

    @Test(groups="sanity",
    priority = 2)
    @Parameters({"par1","par2"})
    public void testNumber3(String par1, String par2)
    {
        System.out.println(par1 + par2);
    }

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                {"Artem","Molodets"},
                {"Sasha","Krasava"}
        };
    }

    @Test(groups="sanity",
    dataProvider = "data",
    priority = 3)
    public void testNumber4(String a, String b) {
        System.out.println(a + b);
    }

    @AfterTest (
            dependsOnGroups = "sanity"
    )
    public void tearDown() {
        System.out.println("Tear down");
    }

}