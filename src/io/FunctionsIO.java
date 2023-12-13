package io;

import functions.Point;
import functions.TabulatedFunction;
import functions.Point;
import functions.TabulatedFunction;
import functions.factory.TabulatedFunctionFactory;

import javax.swing.text.NumberFormatter;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(function.getCount());
        for (Point point : function) {
            out.writeDouble(point.x);
            out.writeDouble(point.y);
        }
        out.flush();
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());
        for (Point point : function) {
            printWriter.printf("%f %f\n", point.x, point.y);
        }
        printWriter.flush();
    }

    static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        double[] xValue = new double[length];
        double[] yValue = new double[length];
        NumberFormat numberFormatter;
        numberFormatter = NumberFormat.getInstance(Locale.forLanguageTag("ru"));

        for (int i = 0; i < length; i++) {
            String[] pointsHalf = reader.readLine().split(" ");

            try {
                xValue[i] = numberFormatter.parse(pointsHalf[0]).doubleValue();
                yValue[i] = numberFormatter.parse(pointsHalf[1]).doubleValue();
            } catch (ParseException e) {
                throw new IOException(e);
            }
        }
        return factory.create(xValue, yValue);
    }



}