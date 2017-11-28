package br.org.fitec.cpi.tdd.ex1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NegativeNumberException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String SEP = " ";
    private static final String MESSAGE = "negatives not allowed: ";

    public NegativeNumberException(double[] numbersNotAllowed) {
	super(MESSAGE + Arrays.stream(numbersNotAllowed).mapToObj(Double::toString).collect(Collectors.joining(SEP)));
    }

}
