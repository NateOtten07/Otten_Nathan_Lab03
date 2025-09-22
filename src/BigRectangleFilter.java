import java.awt.*;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x) {
        boolean ret = false;
        double perimeter = 0;
        Rectangle r = (Rectangle) x;

        perimeter = 2 * r.getHeight() + 2 * r.getWidth();

        if(perimeter > 10)
            {
            ret = true;
            }
        return ret;
    }

}
