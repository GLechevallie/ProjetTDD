package classes;

import java.util.Hashtable;

/**
 * Created by Guillaume on 18/01/2015.
 */
public class Bank {

    private Hashtable rates = new Hashtable();
    
    Money reduce(Expression source, String to){
        return source.reduce(this, to);
    }
    
    int rate (String from, String to){
        if (from.equals(to)){
            return 1;
        }
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }
    
    void addRate(String from, String to, int rate){
        rates.put(new Pair(from, to), new Integer(rate));
        System.out.println("MàJ de la hastable : " + rates.get(new Pair(from, to)) + " " + from + " = 1 " + to); // Problème ici : la hashtable s'initialise mal. Pourquoi ?
    }
}
