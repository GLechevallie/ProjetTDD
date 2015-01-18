package classes;

/**
 * Created by Guillaume on 18/01/2015.
 */
public class Dollar extends Money {
    
    public Dollar (int amount){
        this.amount = amount;
    }
    
    public Dollar times(int multiplier){
        return new Dollar(amount*multiplier);
    }
    
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount;
    }
}
