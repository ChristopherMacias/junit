package edu.neumont.csc180.cmasias.Caculator;
import org.junit.jupiter.api.*;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static org.junit.jupiter.api.Assumptions.assumingThat;


public class testCalc {

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }
    @BeforeEach
    void setupThis(){
        System.out.println("@BeforeEach executed");
    }

    @Tag("Dev")
    @Test
    void testCalcOne(){
        System.out.println("======TEST ONE EXECUTED=======");
        Assertions.assertEquals(4,testCalculator.add(2,2));
    }
    @Tag("PROD")
    @Disabled
    @Test
    void testCalcTwo()
    {
        System.out.println("======TEST TWO EXECUTED=======");
        Assertions.assertEquals( 6 , testCalculator.add(2, 4));
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("DEV".equals(System.getenv("ENV")),
                () -> {
                    // perform these assertions only on the DEV server
                    Assertions.assertEquals(2, testCalculator.divide(4, 2));
                });

        // perform these assertions in all environments
        Assertions.assertEquals(42, testCalculator.multiply(6, 7));
        Assertions.assertEquals(1, testCalculator.sub(7, 6));
    }
    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach executed");
    }
    @AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }

    public void run() {

    }

    @Suite
    @SelectPackages("edu.neumont.csc180.cmasias.Calculator")

    public class JUnit5TestSuiteExample {
    }
    void testCase()
    {
        //Test will pass
        Assertions.assertNotEquals(3, testCalculator.add(2, 2));

        //Test will fail
        Assertions.assertNotEquals(4, testCalculator.add(2, 2), "Calculator.add(2, 2) test failed");

    }
    @Test
    void testOnDev()
    {
        System.setProperty("ENV", "DEV");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), testCalculator::message);
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
