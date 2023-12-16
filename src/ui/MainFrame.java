package ui;

import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

import javax.swing.*;

public class MainFrame extends JFrame {
    protected TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
    public MainFrame() {
        super("Работа с функциями");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        new FunctionCreationByTableDialog(this, factory);
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
