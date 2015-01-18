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
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }
}
