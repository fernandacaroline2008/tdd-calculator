package br.org.fitec.cpi.tdd.ex1;

public interface Calculator {
    public double add(String numbers) throws NegativeNumberException;

    public double subtract(String numbers) throws NegativeNumberException;

    public double multiply(String numbers) throws NegativeNumberException;

    public double divide(String numbers) throws NegativeNumberException;
}
