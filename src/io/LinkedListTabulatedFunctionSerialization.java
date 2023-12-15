package io;

import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;
import operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("output/serialized linked list functions.bin"))) {
            double[] x = {0, 1, 2, 3, 4, 5};
            double[] y = {2.6, 8.23, 9.45, 1.8, 0.5, 0.2};
            LinkedListTabulatedFunction fun1 = new LinkedListTabulatedFunction(x, y);
            TabulatedDifferentialOperator derivative = new TabulatedDifferentialOperator();
            TabulatedFunction fun2 = derivative.derive(fun1);
            TabulatedFunction fun3 = derivative.derive(fun2);

            FunctionsIO.serialize(stream, fun1);
            FunctionsIO.serialize(stream, fun2);
            FunctionsIO.serialize(stream, fun3);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("output/serialized linked list functions.bin"))) {
            System.out.println(FunctionsIO.deserialize(stream));
            System.out.println(FunctionsIO.deserialize(stream));
            System.out.println(FunctionsIO.deserialize(stream));
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
