package be.ugent.rushhour.view;
import java.awt.geom.Path2D;

public class RoundedCornerRectangle extends Path2D.Double {

    public RoundedCornerRectangle(
            double x,
            double y,
            double width,
            double height,
            double radius,
            boolean topLeft,
            boolean topRight,
            boolean bottomLeft,
            boolean bottomRight) {

        double r = Math.min(radius,
                Math.min(width / 2, height / 2));

        moveTo(x + (topLeft ? r : 0), y);

        // Top edge
        lineTo(x + width - (topRight ? r : 0), y);

        if (topRight) {
            quadTo(
                    x + width,
                    y,
                    x + width,
                    y + r);
        }

        // Right edge
        lineTo(
                x + width,
                y + height - (bottomRight ? r : 0));

        if (bottomRight) {
            quadTo(
                    x + width,
                    y + height,
                    x + width - r,
                    y + height);
        }

        // Bottom edge
        lineTo(
                x + (bottomLeft ? r : 0),
                y + height);

        if (bottomLeft) {
            quadTo(
                    x,
                    y + height,
                    x,
                    y + height - r);
        }

        // Left edge
        lineTo(
                x,
                y + (topLeft ? r : 0));

        if (topLeft) {
            quadTo(
                    x,
                    y,
                    x + r,
                    y);
        }

        closePath();
    }
}
