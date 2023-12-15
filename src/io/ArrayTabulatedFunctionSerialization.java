package io;

import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.TabulatedFunction;
import operations.TabulatedDifferentialOperator;

import java.io.*;

public class ArrayTabulatedFunctionSerialization {
        public static void main(String[] args) {
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("output/serialized array functions.bin"))) {
                        double[] x = {0, 1, 2, 3, 4, 5};
                        double[] y = {4.6, 7.23, 9.45, 3.8, 1.9, 0.2};
                        ArrayTabulatedFunction fun1 = new ArrayTabulatedFunction(x, y);
                        TabulatedDifferentialOperator derivative = new TabulatedDifferentialOperator();
                        TabulatedFunction fun2 = derivative.derive(fun1);
                        TabulatedFunction fun3 = derivative.derive(fun2);

                        FunctionsIO.serialize(stream, fun1);
                        FunctionsIO.serialize(stream, fun2);
                        FunctionsIO.serialize(stream, fun3);
                } catch (IOException exception) {
                        exception.printStackTrace();
                }

                try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream("output/serialized array functions.bin"))) {
                        System.out.println("\n");
                        System.out.println(FunctionsIO.deserialize(stream));
                        System.out.println("\n");
                        System.out.println(FunctionsIO.deserialize(stream));
                        System.out.println("\n");
                        System.out.println(FunctionsIO.deserialize(stream));
                } catch (IOException | ClassNotFoundException exception) {
                        exception.printStackTrace();
                }
        }

}
