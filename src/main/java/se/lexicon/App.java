package se.lexicon;

import se.lexicon.DBA.Icity;
import se.lexicon.DBA.cityImpl;
import se.lexicon.model.city;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Icity city= new cityImpl();
        System.out.println(city.findbyid(4));
       // System.out.println("Find All\n");
        //System.out.println(city.findAll());
        System.out.println("\n find by code");

        //city.findByCode("ARG").forEach(System.out::println);
        System.out.println("\n find by Name");
        city.findByName("Franca").forEach(System.out::println);
        System.out.println("\n find by ");

        city.add(new city("Usalmpatti","IND","Madurai",12000));

    }
}
