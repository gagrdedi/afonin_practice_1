package ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class InputTableModel extends AbstractTableModel {
    private final int size;
    private final Object[][] table;
    public InputTableModel(int size) {
        this.size = size;
        table = new Object[size][2];
        table[0][0] = "X";
        table[0][1] = "Y";
        /*for (int i = 1; i < size; i++) {
            table[i][0] = new JTextField("текст");
            table[i][1] = new JTextField("текст");
        }*/
    };
    @Override
    public int getRowCount() {
        return size;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return table[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return row != 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        table[rowIndex][columnIndex] = aValue;
    }
}
