package ui;

import functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionCreationByTableDialog extends JDialog {

    public FunctionCreationByTableDialog(JFrame parent, TabulatedFunctionFactory factory) {
        super(parent, "Создание функции по таблице", true);
        setSize(500, 300);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(null);

        JTextField sizeField = new JTextField("TEXT");
        sizeField.setBounds(50, 10, 400, 30);
        add(sizeField);

        JButton button = new JButton("Создать");
        button.setBounds(50, 100, 400, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTable(sizeField.getText());
            }
        });
        add(button);

        setVisible(true);
    }

    void displayException(String text) {
        JOptionPane.showMessageDialog(this, text, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }
    void createTable(String text) {
        try {
             int size = Integer.parseInt(text);
             if (size < 2) displayException("Функция должна иметь минимум 2 точки!");
             else {
             }
        } catch (NumberFormatException e) {
            displayException("Некорректный ввод, нужно ввести число!");
        }

    }
}
