package ui;

import exceptions.ArrayIsNotSortedException;
import functions.TabulatedFunction;
import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabulatedFunctionFrame extends JDialog {
    private static TabulatedFunction function;
    private static TabulatedFunctionFactory functionFactory;
    private JTable pointTable;
    private final JTextField numOfPoints;
    private final DefaultTableModel tableModel;
    private boolean arrIsType;
    private static boolean status;

    public static TabulatedFunction getFunction() {
        return function;
    }

    public static boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TabulatedFunctionFrame(JFrame parent, boolean arrType) {
        super(parent, "Табличные функции", true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(470, 300);
        arrIsType = arrType;
        numOfPoints = new JTextField(5);
        JButton createButton = new JButton("Создать");
        createButton.setFont(new Font("Arial", Font.BOLD, 16));
        createButton.setHorizontalAlignment(JLabel.CENTER); //
        setStatus(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                createTableFunction();
            }
        });
        JButton createFunctionButton = new JButton("Создать функцию");
        createFunctionButton.setFont(new Font("Arial", Font.BOLD, 16));
        createFunctionButton.setHorizontalAlignment(JLabel.CENTER); //

        tableModel = new DefaultTableModel();
        tableModel.addColumn("X");
        tableModel.addColumn("Y");
        pointTable = new JTable(tableModel);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setLayout(new FlowLayout());
        JLabel Question = new JLabel("Введите количество точек:");
        Question.setFont(new Font("Arial", Font.BOLD, 16));
        Question.setHorizontalAlignment(JLabel.CENTER); //
        contentPane.add(Question, BorderLayout.NORTH);
        createFunctionButton.setFont(new Font("Arial", Font.BOLD, 16));
        createFunctionButton.setHorizontalAlignment(JLabel.CENTER); //
        contentPane.add(numOfPoints, BorderLayout.NORTH);
        contentPane.add(createButton, BorderLayout.NORTH);
        contentPane.add(createFunctionButton, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(pointTable), BorderLayout.CENTER);
        setContentPane(contentPane);

        createFunctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTabulatedFunction();
            }
        });

        setVisible(true);
    }

    private void createTableFunction() {
        try {
            int count = Integer.parseInt(numOfPoints.getText());
            if (count < 2) {
                JOptionPane.showMessageDialog(this, "Требуется минимум 2 точки", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
            } else {
                tableModel.setRowCount(0);
                for (int i = 0; i < count; ++i) {
                    Object[] rowData = new Object[2];
                    rowData[0] = JOptionPane.showInputDialog("Введите X" + (i + 1));
                    rowData[1] = JOptionPane.showInputDialog("Введите Y" + (i + 1));
                    tableModel.addRow(rowData);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Некорректный ввод! Попробуйте еще раз!", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTabulatedFunction() {
        setStatus(true);
        int count = Integer.parseInt(numOfPoints.getText());
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        try {
            for (int i = 0; i < count; ++i) {
                xValues[i] = Double.parseDouble(tableModel.getValueAt(i, 0).toString());
                yValues[i] = Double.parseDouble(tableModel.getValueAt(i, 1).toString());
            }
            functionFactory = arrIsType ? new ArrayTabulatedFunctionFactory() : new LinkedListTabulatedFunctionFactory();
            function = functionFactory.create(xValues, yValues);
            System.out.println("Табличная функция: " + function);
            dispose();
        } catch (NumberFormatException e) {
            setStatus(false);
            JOptionPane.showMessageDialog(this, "Некорректный ввод! Попробуйте еще раз!", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIsNotSortedException e) {
            setStatus(false);
            JOptionPane.showMessageDialog(this, "Таблица не отсортирована", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
        }
    }
}