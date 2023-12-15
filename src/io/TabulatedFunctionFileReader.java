package io;

import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try
            (BufferedReader readerArray = new BufferedReader(new FileReader("input/function.txt"));
            BufferedReader readerLinked = new BufferedReader(new FileReader("input/function.txt"))){

            TabulatedFunctionFactory factoryL = new LinkedListTabulatedFunctionFactory();
            TabulatedFunctionFactory factoryA = new ArrayTabulatedFunctionFactory();

            TabulatedFunction funL = FunctionsIO.readTabulatedFunction(readerLinked,factoryL);
            TabulatedFunction funA = FunctionsIO.readTabulatedFunction(readerArray,factoryA);

            System.out.println("Linked List:");
            System.out.println(funL);
            System.out.println("Array:");
            System.out.println(funA);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
