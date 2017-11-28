package br.org.fitec.cpi.tdd.ex1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.DoublePredicate;

public class MyCalculator implements Calculator {

    private static final DoublePredicate filterNumbersAllowed = number -> number >= 0 && number <= 1000;
    private static final DoublePredicate filterNumbersNotAllowed = number -> number < 0;

    public double[] convertStringToArrayDouble(String numbersString) {
	if (numbersString == null || numbersString.isEmpty()) {
	    return new double[0];
	}
	return Arrays.stream(numbersString.split(",")).mapToDouble(number -> Integer.parseInt(number.trim())).toArray();
    }

    public double formatDecimal(double value) {
	BigDecimal bigDecimal = BigDecimal.valueOf(value).setScale(1, BigDecimal.ROUND_HALF_UP);
	return bigDecimal.doubleValue();
    }

    @Override
    public double add(String numbersString) throws NegativeNumberException {
	double[] numbers = convertStringToArrayDouble(numbersString);
	double[] numbersNotAllowed = Arrays.stream(numbers).filter(filterNumbersNotAllowed).toArray();
	double sum = Arrays.stream(numbers).filter(filterNumbersAllowed).sum();
	sum = formatDecimal(sum);

	if (numbersNotAllowed.length > 0) {
	    throw new NegativeNumberException(numbersNotAllowed);
	}

	return sum;
    }

    @Override
    public double subtract(String numbersString) throws NegativeNumberException {
	double[] numbers = convertStringToArrayDouble(numbersString);
	double[] numbersNotAllowed = Arrays.stream(numbers).filter(filterNumbersNotAllowed).toArray();
	double subtract = Arrays.stream(numbers).filter(filterNumbersAllowed).reduce((a, b) -> a - b).orElse(0.0);
	subtract = formatDecimal(subtract);

	if (numbersNotAllowed.length > 0) {
	    throw new NegativeNumberException(numbersNotAllowed);
	}

	return subtract;
    }

    @Override
    public double multiply(String numbersString) throws NegativeNumberException {
	double[] numbers = convertStringToArrayDouble(numbersString);
	double[] numbersNotAllowed = Arrays.stream(numbers).filter(filterNumbersNotAllowed).toArray();
	double multiply = Arrays.stream(numbers).filter(filterNumbersAllowed).reduce((a, b) -> a * b).orElse(0.0);
	multiply = formatDecimal(multiply);

	if (numbersNotAllowed.length > 0) {
	    throw new NegativeNumberException(numbersNotAllowed);
	}

	return multiply;
    }

    @Override
    public double divide(String numbersString) throws NegativeNumberException, ArithmeticException {
	double[] numbers = convertStringToArrayDouble(numbersString);
	double[] numbersNotAllowed = Arrays.stream(numbers).filter(filterNumbersNotAllowed).toArray();
	double divide = Arrays.stream(numbers).filter(filterNumbersAllowed).reduce((a, b) -> {

	    if (b == 0.0) {
		throw new ArithmeticException("/ by zero");
	    }
	    return a / b;
	}).orElse(0.0);
	divide = formatDecimal(divide);

	if (numbersNotAllowed.length > 0) {
	    throw new NegativeNumberException(numbersNotAllowed);
	}

	return divide;
    }

}
