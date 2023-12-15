package io;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;
import operations.TabulatedDifferentialOperator;
import operations.TabulatedFunctionOperationService;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("input/binary function.bin"))) {
            TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
            TabulatedFunction fun = FunctionsIO.readTabulatedFunction(stream, factory);
            System.out.println(fun.toString());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер и значения функции");
            TabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction fun = FunctionsIO.readTabulatedFunction(stream, factory);
            TabulatedDifferentialOperator derivative = new TabulatedDifferentialOperator();
            System.out.println(derivative.derive(fun).toString());
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
