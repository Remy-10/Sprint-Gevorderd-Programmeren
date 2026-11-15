package be.ugent.rushhour.view;

import be.ugent.rushhour.model.DPoint;
import be.ugent.rushhour.model.IRushHourGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellView extends JPanel {

    public static final int CELL_WIDTH = 80;
    public static final int CELL_HEIGHT = 80;

    public static Point dragStart; // where the mouse is positioned when clicked

    private Color color;

    private int column;
    private int row;

    private boolean topLeftRounded;
    private boolean topRightRounded;
    private boolean bottomLeftRounded;
    private boolean bottomRightRounded;


    private IRushHourGame game;
    private RushHourView view;

    public CellView(RushHourView view, IRushHourGame game, int column, int row) {

        final class DirectionStepPair{
            public DPoint direction;
            public int step;
            public DirectionStepPair(DPoint direction, int step){
                this.direction = direction;
                this.step = step;
            }
        }

        this.view = view;
        this.game = game;
        this.column = column;
        this.row = row;

        color = Color.WHITE;

        setPreferredSize(
                new Dimension(
                        CELL_WIDTH,
                        CELL_HEIGHT));

        setOpaque(false);

        // mouselistener
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }

            // based on the position of the mouse (click point versus release point),
            // this code computes in what direction the mouse was dragged
            private DPoint computeDirection(Point dragEnd){
                DPoint direction = null;
                int x = dragEnd.x;
                int y = dragEnd.y;
                if(0<=x && x<=CELL_WIDTH){
                    if(y<0){
                        direction = new DPoint(0,-1);
                    }
                    else if(y>CELL_HEIGHT){
                        direction = new DPoint(0,1);
                    }
                }
                if(0<=y && y<=CELL_HEIGHT){
                    if(x<0){
                        direction = new DPoint(-1,0);
                    }
                    else if(x>CELL_WIDTH){
                        direction = new DPoint(1,0);
                    }
                }
                return direction;
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                Point dragEnd = e.getPoint();
                DPoint direction = computeDirection(dragEnd);

                if (direction != null) {
                    game.moveVehicleAt(new DPoint(column, row), direction);
                    view.updateBoard();
                    if(game.isSolved()){
                        JOptionPane.showMessageDialog(
                                view,
                                "Puzzle solved!");
                    }
                }
            }
        });
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRoundedCorners(boolean[] corners) {
        this.topLeftRounded = corners[0];
        this.topRightRounded = corners[1];
        this.bottomLeftRounded = corners[2];
        this.bottomRightRounded = corners[3];
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        Shape shape = createCellShape();
        g2.setColor(color);
        g2.fill(shape);
        g2.dispose();
    }

    private Shape createCellShape() {

        int radius = 30;

        int w = getWidth();
        int h = getHeight();

        return new RoundedCornerRectangle(
                0,
                0,
                w - 1,
                h - 1,
                radius,
                topLeftRounded,
                topRightRounded,
                bottomLeftRounded,
                bottomRightRounded);
    }
}
