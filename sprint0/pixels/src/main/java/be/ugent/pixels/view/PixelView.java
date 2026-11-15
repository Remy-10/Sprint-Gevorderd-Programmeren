package be.ugent.pixels.view;

import be.ugent.pixels.model.PixelGrid;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelView extends JFrame {

    private final PixelGrid grid;

    public PixelView(PixelGrid grid) {
        this.grid = grid;

        createComponents();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createComponents() {

        JPanel boardPanel = new JPanel(
                new GridLayout(
                        grid.getHeight(),
                        grid.getWidth()));
        for (int row = 0; row < grid.getHeight(); row++) {
            for (int column = 0; column < grid.getWidth(); column++) {
                JPanel cell = new JPanel();
                cell.setPreferredSize(new Dimension(5,10));
                if(grid.getCellContent(column,row) == ' ' || grid.getCellContent(column,row) == '.') {
                    cell.setBackground(Color.WHITE);
                }
                else{
                    cell.setBackground(Color.BLACK);
                }
                boardPanel.add(cell);
            }
        }
        getContentPane().add(boardPanel);
    }
}