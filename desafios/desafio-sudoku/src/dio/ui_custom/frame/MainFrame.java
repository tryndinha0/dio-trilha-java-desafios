package dio.ui_custom.frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dio.ui_custom.panel.MainPanel;

public class MainFrame extends JFrame{
    public MainFrame(final Dimension dimension, final JPanel MainPanel){
        super("Sudoku");
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(MainPanel);
    }
}
