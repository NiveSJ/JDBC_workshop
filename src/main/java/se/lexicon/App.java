package se.lexicon;

import se.lexicon.DBA.Icity;
import se.lexicon.DBA.cityImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Icity city= new cityImpl();
        System.out.println(city.findbyid(3));
    }
}
