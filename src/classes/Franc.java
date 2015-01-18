package classes;

/**
 * Created by Guillaume on 18/01/2015.
 */
public class Franc extends Money {

    public Franc (int amount){
        this.amount = amount;
    }

    public Money times(int multiplier){
        return new Franc(amount*multiplier);
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount;
    }
}
