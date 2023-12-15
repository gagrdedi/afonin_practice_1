package io;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        try (BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream("output/array function.bin"));
             BufferedOutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream("output/linked list function.bin"))) {
            double[] x = {0, 1, 2};
            double[] y = {3, 4, 5};
            ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x, y);
            LinkedListTabulatedFunction fun2 = new LinkedListTabulatedFunction(x, y);
            FunctionsIO.writeTabulatedFunction(outputStream1, fun1);
            FunctionsIO.writeTabulatedFunction(outputStream2, fun2);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
