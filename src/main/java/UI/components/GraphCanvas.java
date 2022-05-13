package UI.components;

import inputHandler.Expr;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class GraphCanvas extends Canvas {
    private List<Expr> functions;

    public GraphCanvas(List<Expr> functions) {
        super(600, 600);
        this.functions = functions;
        draw();
    }

    public void setFunctions(List<Expr> functions) {
        this.functions = functions;
    }

    public List<Expr> getFunctions() {
        return functions;
    }

    public void draw() {
        GraphicsContext g = getGraphicsContext2D();
        g.setFill(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        drawAxes(g);
        for (Expr function : functions) {
            drawFunction(g, function);
        }
    }

    private void drawAxes(GraphicsContext g) {
        double width = getWidth();
        double height = getHeight();
        g.setStroke(Color.WHITE);
        g.setLineWidth(2);
        g.strokeLine(0, height/2, width, height/2);
        g.strokeLine(width/2, 0, width/2, height);

//        for(int i = -5; i < 5; i++) {
//            g.setLineWidth(0.5);
//            g.strokeLine(width/2 + i * width/10, 0, width/2 + i * width/10, height);
//            g.strokeLine(0, height/2 + i * height/10, width, height/2 + i * height/10);
//        }

        for(int i = -4; i < 5; i++) {
            g.setLineWidth(0.5);
            g.strokeLine(width/2 + i * width/10, height/2 - 10, width/2 + i * width/10, height/2 +10);
            g.strokeLine(width/2 - 10, height/2 + i * height/10, width/2 + 10, height/2 + i * height/10);
            if(i < 0) {
                g.strokeText(String.valueOf(i), width * (i + 5) / 10 - 8, height / 2 + 25);
                g.strokeText(String.valueOf(-i), width / 2 - 22, height * (i + 5) / 10 + 3);
            } else if (i > 0) {
                g.strokeText(String.valueOf(i), width * (i + 5) / 10 - 3, height / 2 + 25);
                g.strokeText(String.valueOf(-i), width / 2 - 25, height * (i + 5) / 10 + 3);
            }
        }

        g.strokeText("0", width/2 - 25, height/2 + 25);
    }

    private void drawFunction(GraphicsContext g, Expr function) {
        double x, y;          // A point on the graph.  y is f(x).
        double prevx, prevy;  // The previous point on the graph.

        double dx;  // Difference between the x-values of consecutive
        // points on the graph.

        double numPoints = 500;  // Number of points to draw on the graph.

        dx  = 10.0 / numPoints;

        //random color
        g.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
//        g.setStroke(Color.RED);
        g.setLineWidth(2);

        /* Compute the first point. */

        x = -5.0;
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

//            if (x > -2.1 && x < -1.9) {
//                System.out.println(x + " " + y);
//            }
//            System.out.println(x + " " + y);

        }  // end for
    }

    void putLine(GraphicsContext g, double x1, double y1,
                 double x2, double y2) {
        // Draw a line segment from the point (x1,y1) to (x2,y2).
        // These values must be scaled to convert from coordinates
        // that go from -5 to 5 to the coordinates that are needed
        // for drawing on the canvas, which go from 0 to 600.
        // coordinates of the corresponding pixels.

//        if (Math.abs(y1) > 10000 || Math.abs(y2) > 10000) {
//            // Only draw lines for reasonable y-values.
//            // This should not be necessary, but I'm not sure
//            // how GraphicsContext will handle very large values.
//            return;
//        }

        double a1, b1;   // Pixel coordinates corresponding to (x1,y1).
        double a2, b2;   // Pixel coordinates corresponding to (x2,y2).

        double width = getWidth();     // Width of the canvas (600).
        double height = getHeight();   // Height of the canvas (600).

        a1 = (int)( (x1 + 5) / 10 * width );
        b1 = (int)( (5 - y1) / 10 * height );
        a2 = (int)( (x2 + 5) / 10 * width );
        b2 = (int)( (5 - y2) / 10 * height );

        g.strokeLine(a1,b1,a2,b2);

    }  // end putLine()
}
