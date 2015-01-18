package classes;


/**
 * Created by Guillaume on 18/01/2015.
 */

public class Money implements Expression {

    protected int amount;
    
    protected String currency;

    public Money (int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount){
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount){
        return new Franc(amount, "CHF");
    }
    
    public String currency(){
        return currency;
    }
    
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount && currency.equals(money.currency);
    }
    
    public Money times(int multiplier){
        return new Money(amount*multiplier, currency);
    }
    
    public String toString(){
        return amount + " " + currency;
        
    }

    Expression plus(Money addend){
        return new Money(amount + addend.amount, currency);
    }
}
