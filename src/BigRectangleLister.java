import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BigRectangleLister
{
    static final int TOTAL_RECTANGLES = 50;
    static Random gen = new Random();
    static ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
    static BigRectangleFilter filter;

    public static void main(String[] args)
    {
        int counter = 0;
        createDataSet();
        filter = new BigRectangleFilter();

        for(Rectangle rec: rects)
        {
            if(filter.accept(rec))
            {
                counter++;
                System.out.printf("Rectangle #%3d Accepted: %5.2f\t%5.2f\t%5.2f\n", counter, rec.getHeight(), rec.getWidth(),2 * rec.getHeight(), 2 * rec.getWidth());

            }
        }
        System.out.println("\n" + counter + " accepted out of " + rects.size());
    }

    private static void createDataSet()
    {
        int height = 0;
        int width = 0;

        for(int r = 0; r < TOTAL_RECTANGLES; r++)
        {
            height = gen.nextInt(4) + 1;
            width = gen.nextInt(4) + 1;
            rects.add(new Rectangle(width, height));

        }

    }

}
