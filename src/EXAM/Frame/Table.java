package EXAM.Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table extends JTable {
    public DefaultTableModel model;

    public Table(Object columns[]){
        model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        setModel(model);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.BLACK);
        setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        setRowHeight(20);
    }
}