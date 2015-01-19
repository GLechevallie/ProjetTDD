package classes;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import classes.Money;
import classes.Dollar;
import classes.Franc;

import java.beans.Expression;

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
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication(){
        Money five = Money.franc(5);
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
    
    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        classes.Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
    
    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        classes.Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }
    
    @Test
    public void testReduceSum(){
        classes.Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }
    
    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
    
    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }
    
    @Test
    public void testArrayEquals(){
        assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
    }
    
    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }
    
    @Test
    public void testMixedAddition(){
        classes.Expression fiveBucks = Money.dollar(5);
        classes.Expression tenFrancs = Money.dollar(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }
}