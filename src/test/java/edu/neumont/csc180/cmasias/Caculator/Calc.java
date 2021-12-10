package edu.neumont.csc180.cmasias.Caculator;
import org.junit.jupiter.api.*;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.testng.annotations.Test;
import java.util.Random;



public class Calc {

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll");
    }
    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }
    @Tag("Dev")
    @Test
    void testCalcOne(){
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4,Calculator.add(2,2));
    }
    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }
    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
    @Suite
    @SelectPackages("edu.neumont.csc180.cmasias.Caculator")

    public class JUnit5TestSuiteExample {
    }
    void testCase()
    {
        //Test will pass
        Assertions.assertNotEquals(3, Calculator.add(2, 2));

        //Test will fail
        Assertions.assertNotEquals(4, Calculator.add(2, 2), "Calculator.add(2, 2) test failed");

    }
    @Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), Calc::message);
    }

    @Test
    void testOnProd()
    {
        System.setProperty("ENV", "PROD");
        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
    }

    private static String message () {
        return "TEST Execution Failed :: ";
    }

}
