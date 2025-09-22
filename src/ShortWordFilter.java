public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        String s = (String) x;
        boolean ret = false;

        if(s.length() < 5)
            ret = true;

        return ret;

    }
}
