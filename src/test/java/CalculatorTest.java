import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void createEmptyCalculator(){
        calculator = new Calculator();
    }

    @Test
    @Order(1)
    @Tag("Simple")
    public void testAddition(){

        assertEquals(10,calculator.add(5,5));
        assertEquals(4,calculator.add(1,3));
        assertEquals(17,calculator.add(8,9));
        int[] intArray = new int[]{3,6,5};
        int[] intArray2 = new int[]{15,7,8,6,3};
        assertEquals(14,calculator.add(intArray));
        assertEquals(39,calculator.add(intArray2));
    }

    @Test
    @Tag("Simple")
    @Order(3)
    public void testSubtraction(){
        assertEquals(10,calculator.subtract(15,5));
        assertEquals(-2,calculator.subtract(1,3));
        assertEquals(78,calculator.subtract(87,9));
        int[] intArray = new int[]{30,6,5,2,6};
        int[] intArray2 = new int[]{15,7,8};
        assertEquals(11,calculator.subtract(intArray));
        assertEquals(0,calculator.subtract(intArray2));
    }

    @Test
    @Tag("Simple")
    @Order(4)
    public void testMultiplication(){
        assertEquals(75,calculator.multiply(15,5));
        assertEquals(3,calculator.multiply(1,3));
        assertEquals(56,calculator.multiply(8,7));
        int[] intArray = new int[]{2,6,5};
        int[] intArray2 = new int[]{4,7,8};
        assertEquals(60,calculator.multiply(intArray));
        assertEquals(224,calculator.multiply(intArray2));
    }

    @Test
    @Tag("Simple")
    @Order(5)
    public void testDivision(){
        assertEquals(3,calculator.divide(15,5));
        assertEquals(8,calculator.divide(80,10));
        assertEquals(19,calculator.divide(57,3));
        int[] intArray = new int[]{360,6,2};
        int[] intArray2 = new int[]{950,2,5};
        assertEquals(30,calculator.divide(intArray));
        assertEquals(95,calculator.divide(intArray2));
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(16,0); });
    }

    @Test
    @Tag("Simple")
    public void testAmountOfNumbers(){
        int[] intArray = new int[]{3,6,5};
        int[] intArray2 = new int[]{15,7,8,6,3};
        int[] intArray3 = new int[]{15,7,8,6,3,9,124,249742};
        assertEquals(3,calculator.returnArraySize(intArray));
        assertEquals(5,calculator.returnArraySize(intArray2));
        assertEquals(8,calculator.returnArraySize(intArray3));
    }

    @RepeatedTest(10)
    @Tag("Advanced")
    public void testReturnsException(){
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(16,0); });
        assertThrows(ArithmeticException.class, () -> {
            calculator.pleaseOnlyEnterFractions(8); });
    }

    @DisplayName("A stupid test you shouldn't run")
    @Order(6)
    @Disabled("Disabled because its just stupid. Why do we have this method?")
    @Test
    @Tag("Bad")
    public void uselessTest(){
        assertEquals("Why did you run this?",calculator.uselessMethod());
    }

    @Order(2)
    @ParameterizedTest
    @Tag("Advanced")
    @CsvSource({"1, 1, 2", "2, 3, 5", "12,17,29", "237, 98, 335"})
    public void testParameterizedAddition(int a, int b, int sum){
        assertEquals(sum, a + b);
    }

    @DisplayName("My favourite test!")
    @Tag("Bad")
    @Test
    public void testGuessFavouriteNumber(){
        assertEquals(true, calculator.guessFavouriteNumber(21));
        assertEquals(false, calculator.guessFavouriteNumber(3));
        assertEquals(false, calculator.guessFavouriteNumber(14));
    }

    @AfterEach
    @Tag("Bad")
    public void testSomethingElse(){
        calculator = null;

    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("After all tests");
    }
}
