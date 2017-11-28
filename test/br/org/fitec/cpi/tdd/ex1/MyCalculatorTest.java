package br.org.fitec.cpi.tdd.ex1;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyCalculatorTest {

    public final Calculator myCalculator = new MyCalculator();

    @Rule
    public final ExpectedException expectedExceptionNegativeNumbers = ExpectedException.none();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSumNoNumberSuccess() throws NegativeNumberException {
	String numbers = "";
	double result = myCalculator.add(numbers);
	Assert.assertThat(result, equalTo(0.0));

	numbers = null;
	result = myCalculator.add(numbers);
	Assert.assertThat(result, equalTo(0.0));
    }

    @Test
    public void testSumOnePositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "1";
	double result = myCalculator.add(numbers);
	Assert.assertThat(result, equalTo(1.0));

    }

    @Test
    public void testSumTwoPositiveNumbersSuccess() throws NegativeNumberException {
	String numbers = "1,2";
	double result = myCalculator.add(numbers);
	Assert.assertThat(result, equalTo(3.0));
    }

    @Test
    public void testSumAnyPositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "1,2,3,4,5,6,7,8,9,0";
	double result = myCalculator.add(numbers);
	Assert.assertThat(result, equalTo(45.0));
    }

    @Test
    public void testSumPositiveBigger1000NumberSuccess() throws NegativeNumberException {
	String numbers = "3, 1001, 1000, 5";
	double result = myCalculator.add(numbers);
	Assert.assertThat(result, equalTo(1008.0));
    }

    @Test
    public void testSumOneNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.add(numbers);
    }

    @Test
    public void testSumTwoNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -3.0 -1.0"));
	myCalculator.add(numbers);
    }

    @Test
    public void testSumPositiveNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.add(numbers);
    }

    @Test
    public void testSubtractNoNumberSuccess() throws NegativeNumberException {
	String numbers = "";
	double result = myCalculator.subtract(numbers);
	Assert.assertThat(result, equalTo(0.0));

	numbers = null;
	result = myCalculator.subtract(numbers);
	Assert.assertThat(result, equalTo(0.0));
    }

    @Test
    public void testSubtractOnePositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "1";
	double result = myCalculator.subtract(numbers);
	Assert.assertThat(result, equalTo(1.0));

    }

    @Test
    public void testSubtractTwoPositiveNumbersSuccess() throws NegativeNumberException {
	String numbers = "2,1";
	double result = myCalculator.subtract(numbers);
	Assert.assertThat(result, equalTo(1.0));
    }

    @Test
    public void testSubtractAnyPositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "8,3,1,0";
	double result = myCalculator.subtract(numbers);
	Assert.assertThat(result, equalTo(4.0));
    }

    @Test
    public void testSubtractPositiveBigger1000NumberSuccess() throws NegativeNumberException {
	String numbers = "1001, 1000, 5";
	double result = myCalculator.subtract(numbers);
	Assert.assertThat(result, equalTo(995.0));
    }

    @Test
    public void testSubtractOneNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.subtract(numbers);
    }

    @Test
    public void testSubtractTwoNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -3.0 -1.0"));
	myCalculator.subtract(numbers);
    }

    @Test
    public void testSubtractPositiveNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.subtract(numbers);
    }

    @Test
    public void testMultiplyNoNumberSuccess() throws NegativeNumberException {
	String numbers = "";
	double result = myCalculator.multiply(numbers);
	Assert.assertThat(result, equalTo(0.0));

	numbers = null;
	result = myCalculator.multiply(numbers);
	Assert.assertThat(result, equalTo(0.0));
    }

    @Test
    public void testMultiplyOnePositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "1";
	double result = myCalculator.multiply(numbers);
	Assert.assertThat(result, equalTo(1.0));

    }

    @Test
    public void testMultiplyTwoPositiveNumbersSuccess() throws NegativeNumberException {
	String numbers = "2,1";
	double result = myCalculator.multiply(numbers);
	Assert.assertThat(result, equalTo(2.0));
    }

    @Test
    public void testMultiplyAnyPositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "8,3,1,0";
	double result = myCalculator.multiply(numbers);
	Assert.assertThat(result, equalTo(0.0));
    }

    @Test
    public void testMultiplyPositiveBigger1000NumberSuccess() throws NegativeNumberException {
	String numbers = "1001, 1000, 5";
	double result = myCalculator.multiply(numbers);
	Assert.assertThat(result, equalTo(5000.0));
    }

    @Test
    public void testMultiplyOneNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.multiply(numbers);
    }

    @Test
    public void testMultiplyTwoNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -3.0 -1.0"));
	myCalculator.multiply(numbers);
    }

    @Test
    public void testMultiplyPositiveNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.multiply(numbers);
    }

    @Test
    public void testDivideNoNumberSuccess() throws NegativeNumberException {
	String numbers = "";
	double result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(0.0));

	numbers = null;
	result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(0.0));
    }

    @Test
    public void testDivideOnePositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "1";
	double result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(1.0));

    }

    @Test
    public void testDivideTwoPositiveNumbersSuccess() throws NegativeNumberException {
	String numbers = "2,1";
	double result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(2.0));
    }

    @Test
    public void testDivideTwoPositiveNumbersResultDecimalSuccess() throws NegativeNumberException {
	String numbers = "10,3";
	double result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(3.3));
    }

    @Test
    public void testDivideAnyPositiveNumberSuccess() throws NegativeNumberException {
	String numbers = "8,2,1";
	double result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(4.0));
    }

    @Test
    public void testDividePositiveBigger1000NumberSuccess() throws NegativeNumberException {
	String numbers = "1001, 1000, 5";
	double result = myCalculator.divide(numbers);
	Assert.assertThat(result, equalTo(200.0));
    }

    @Test
    public void testDivide0NumberShouldFailException() throws NegativeNumberException {
	String numbers = "8,3,1,0";

	expectedExceptionNegativeNumbers.expect(ArithmeticException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("/ by zero"));
	myCalculator.divide(numbers);
    }

    @Test
    public void testDivideOneNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.divide(numbers);
    }

    @Test
    public void testDivideTwoNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "-3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -3.0 -1.0"));
	myCalculator.divide(numbers);
    }

    @Test
    public void testDividePositiveNegativeNumberShouldFailException() throws NegativeNumberException {
	String numbers = "3,-1";
	expectedExceptionNegativeNumbers.expect(NegativeNumberException.class);
	expectedExceptionNegativeNumbers.expectMessage(CoreMatchers.is("negatives not allowed: -1.0"));
	myCalculator.divide(numbers);
    }

}
