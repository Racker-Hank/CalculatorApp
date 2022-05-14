package UI.components;

import inputHandler.Expr;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class GraphCanvas extends Canvas {
    private Map<Function, Color> functions;
    private double width;
    private double height;
    private final int lengthUnit = 30;
    private int horizontalUnits;
    private int verticalUnits;

    public GraphCanvas(Map<Function, Color> functions) {
        super(600, 600);
        this.functions = functions;

        horizontalUnits = (int) (width / lengthUnit);
        verticalUnits = (int) (height / lengthUnit);

        draw();
    }

    public void setFunctions(Map<Function, Color> functions) {
        this.functions = functions;
    }

    public void draw() {
        width = getWidth();
        height = getHeight();
//        System.out.println(width + " " + height);
        horizontalUnits = (int) (width / lengthUnit);
        verticalUnits = (int) (height / lengthUnit);
        GraphicsContext g = getGraphicsContext2D();
        g.setFill(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        drawAxes(g);
        for (Function function : functions.keySet()) {
            drawFunction(g, function.expr, functions.get(function));
        }
    }

    private void drawAxes(GraphicsContext g) {
        g.setStroke(Color.WHITE);
        g.setLineWidth(2);
        g.strokeLine(0, height/2, width, height/2);
        g.strokeLine(width/2, 0, width/2, height);

        for(int i = -horizontalUnits/2+1; i < horizontalUnits/2; i++) {
            g.setLineWidth(0.5);
            g.strokeLine(width/2 + i * width/horizontalUnits, height/2 - 5, width/2 + i * width/horizontalUnits, height/2 + 5);
            if(i < 0) {
                g.strokeText(String.valueOf(i), width * (i + (double)horizontalUnits/2) / horizontalUnits - 8, height / 2 + 25);
//                g.strokeText(String.valueOf(-i), width / 2 - 22, height * (i + horizontalUnits/2) / horizontalUnits + 3);
            } else if (i > 0) {
                g.strokeText(String.valueOf(i), width * (i + (double)horizontalUnits/2) / horizontalUnits - 3, height / 2 + 25);
//                g.strokeText(String.valueOf(-i), width / 2 - 25, height * (i + horizontalUnits/2) / horizontalUnits + 3);
            }
        }

        for(int i = -verticalUnits/2+1; i < verticalUnits/2; i++) {
            g.setLineWidth(0.5);
            g.strokeLine(width/2 - 5, height/2 + i * height/verticalUnits, width/2 + 5, height/2 + i * height/verticalUnits);
            if(i < 0) {
//                g.strokeText(String.valueOf(i), width * (i + verticalUnits/2) / verticalUnits - 8, height / 2 + 25);
                g.strokeText(String.valueOf(-i), width / 2 - 22, height * (i + (double)verticalUnits/2) / verticalUnits + 3);
            } else if (i > 0) {
//                g.strokeText(String.valueOf(i), width * (i + verticalUnits/2) / verticalUnits - 3, height / 2 + 25);
                g.strokeText(String.valueOf(-i), width / 2 - 25, height * (i + (double)verticalUnits/2) / verticalUnits + 3);
            }
        }

        g.strokeText("0", width/2 - 15, height/2 + 18);
    }

    private void drawFunction(GraphicsContext g, Expr function, Color color) {
        double x, y;          // A point on the graph.  y is f(x).
        double prevx, prevy;  // The previous point on the graph.

        double dx;  // Difference between the x-values of consecutive
        // points on the graph.

        double numPoints = 500;  // Number of points to draw on the graph.

        dx  = (horizontalUnits+4) / numPoints;

        //random color
        g.setStroke(color);
//        System.out.println(color);
//        g.setStroke(Color.RED);
        g.setLineWidth(2);

        /* Compute the first point. */

        x = (double) -(horizontalUnits+2)/2;
        y = function.value(x);

            /* Compute each of the other 300 points, and draw a line segment
               between each consecutive pair of points.  Note that if the
               function is undefined at one of the points in a pair, then
               the line segment is not drawn.  */

        for (int i = 1; i <= numPoints; i++) {

            prevx = x;           // Save the coords of the previous point.
            prevy = y;

            x = Math.round((x + dx) * 100.0) / 100.0;            // Get the coords of the next point.

            y = function.value(x);

            if ( (! Double.isNaN(y)) && (! Double.isNaN(prevy)) ) {
                // Draw a line segment between the two points.
                putLine(g, prevx, prevy, x, y);
            }
        }  // end for
    }

    void putLine(GraphicsContext g, double x1, double y1,
                 double x2, double y2) {
        // Draw a line segment from the point (x1,y1) to (x2,y2).
        // These values must be scaled to convert from coordinates
        // that go from -5 to 5 to the coordinates that are needed
        // for drawing on the canvas, which go from 0 to 600.
        // coordinates of the corresponding pixels.

        double a1, b1;   // Pixel coordinates corresponding to (x1,y1).
        double a2, b2;   // Pixel coordinates corresponding to (x2,y2).

//        double width = getWidth();     // Width of the canvas (600).
//        double height = getHeight();   // Height of the canvas (600).

        a1 =  (x1 + (double)horizontalUnits/2) / horizontalUnits * width ;
        b1 =  ((double)verticalUnits/2 - y1) / verticalUnits * height ;
        a2 =  (x2 + (double)horizontalUnits/2) / horizontalUnits * width ;
        b2 =  ((double)verticalUnits/2 - y2) / verticalUnits * height ;

        g.strokeLine(a1,b1,a2,b2);

    }  // end putLine()
}
