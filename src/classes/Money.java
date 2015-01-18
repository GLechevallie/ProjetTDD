package classes;


/**
 * Created by Guillaume on 18/01/2015.
 */
abstract class Money {

    protected int amount;

    static Money dollar(int amount){
        return new Dollar(amount);
    }

    static Money franc(int amount){
        return new Franc(amount);
    }
    
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }
    
    abstract Money times(int multiplier){
        return new Money(amount * multiplier);
    }
}
