package ui;

import functions.factory.TabulatedFunctionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabulatedFunctionTableDialog extends JDialog {
    public TabulatedFunctionTableDialog(FunctionCreationByTableDialog parent, int size) {
        super(parent, "Введите координаты точек функции", true);
        setSize(100, 30 * (size + 3));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTable table = new JTable(new InputTableModel(size+1));
        table.setSize(100, 30 * (size + 2));
        table.setRowHeight(30);
        table.setCellEditor(new DefaultCellEditor(new JTextField()));
        add(table);

        JButton button = new JButton("Подтвердить");
        button.setSize(new Dimension(50, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFunction();
            }
        });
        add(button);

        setVisible(true);
    }

    private void createFunction() {

    }
}
