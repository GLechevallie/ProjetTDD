package classes;

/**
 * Created by Guillaume on 18/01/2015.
 */
public class Dollar extends Money {

    public Dollar (int amount, String currency){
        super(amount, currency);
    }

    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public String currency(){
        return currency;
    }

    public Money times(int multiplier){
        return new Money(amount*multiplier, currency);
    }
}
