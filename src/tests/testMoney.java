package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import classes.Money;
import classes.Dollar;
import classes.Franc;

/**
 * Created by Guillaume on 18/01/2015.
 */
public class testMoney {

    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testMultiplication(){
        Money five = new Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication(){
        Money five = new Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testDifferentClassCurrency(){
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }

    @Test
    public void testDifferentClassEquality(){
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }
}