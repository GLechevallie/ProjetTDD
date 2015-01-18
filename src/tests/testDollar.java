package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import classes.Dollar;

/**
 * Created by Guillaume on 18/01/2015.
 */
public class testDollar {
    
    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }
}
