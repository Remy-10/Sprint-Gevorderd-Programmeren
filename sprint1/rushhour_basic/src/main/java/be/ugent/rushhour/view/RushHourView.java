package be.ugent.rushhour.view;

import be.ugent.rushhour.model.DPoint;
import be.ugent.rushhour.model.IRushHourGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RushHourView extends JFrame {

    private final IRushHourGame game;

    private CellView[][] cells;

    private Map<String, Color> colorTranslation = Stream.of(new Object[][]{
            {"rood", Color.RED},
            {"oranje", Color.ORANGE},
            {"geel",Color.YELLOW},
            {"groen",Color.GREEN},
            {"blauw",Color.CYAN},
            {"indigo",Color.BLUE},
            {"violet",Color.MAGENTA},
            {"roze",Color.PINK},
            {"wit",Color.WHITE},
            {"grijs",Color.LIGHT_GRAY},
            {"goud",new Color(255,204,5)},
            {"red",Color.RED},
            {"black",Color.BLACK},
            {"",Color.GRAY},
            {"empty",Color.GRAY} // no cars -> grey background
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Color) data[1]));

    public RushHourView(IRushHourGame game) {

        this.game = game;

        createComponents();
        updateBoard();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createComponents() {

        JPanel boardPanel = new JPanel(
                new GridLayout(
                        game.getRowCount(),
                        game.getColumnCount()));

        boardPanel.setBackground(Color.GRAY); // rounded cars -> grey background in corners

        cells = new CellView[game.getColumnCount()][game.getRowCount()];

        for (int row = 0; row < game.getRowCount(); row++) {
            for (int column = 0; column < game.getColumnCount(); column++) {
                CellView cell = new CellView(this, game, column, row);
                cells[column][row] = cell;
                boardPanel.add(cell);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // To show that clicking on a button does something - if 'moveVehicleAt' is implemented.
        // This same code (addActionListener) can be found in CellView-class,
        // where it makes sure that mouse-movements on a cell do something.
        // All of this code (up to "add(moveButton, BorderLayout.SOUTH)") can be omitted
        // without destroying the game.
        JButton moveButton = new JButton("Move vehicle away from 5th column, 3rd row, to the right");

        moveButton.addActionListener(e -> {
            game.moveVehicleAt(new DPoint(4,2), new DPoint(1,0));
            updateBoard();
            if (game.isSolved()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Puzzle solved!");
            }
        });
        add(moveButton, BorderLayout.SOUTH);
    }

    public void updateBoard() {
        for (int row = 0; row < game.getRowCount(); row++) {
            for (int column = 0; column < game.getColumnCount(); column++) {
                // define location (based on column and row)
                DPoint location = new DPoint(column, row);
                // ask for color at that location
                String colorString = game.getColorOfVehicleAt(location);
                Color color;
                if (colorString.startsWith("#")){
                    color = Color.decode(colorString);
                }
                else{
                    color = colorTranslation.get(colorString);
                }
                // ask for rounded corners at that location
                boolean[] roundedCorners = game.getRoundedCornersAt(location);
                // change view of the cell
                CellView cell = cells[column][row];
                cell.setColor(color);
                cell.setRoundedCorners(roundedCorners);
                cell.repaint();
            }
        }
    }
}