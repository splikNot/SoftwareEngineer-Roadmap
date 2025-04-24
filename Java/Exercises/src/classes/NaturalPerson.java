package classes;

public class NaturalPerson extends AbstractPerson {
    Double healthExpenses;

    public NaturalPerson(String name,Double income,Double healthExpenses){
        this.name = name;
        this.income = income;
        this.healthExpenses = healthExpenses;

    }

    public void setHealthExpenses(Double healthExpenses){
        this.healthExpenses = healthExpenses;
    }
    
    public double getHealthExpenses(){
        return healthExpenses;
    }

    @Override
    public Double incomeTax(){
        Double tax;

        if(income < 20000.00){
            tax = income*(15.0/100);
        }
        else{
            tax = income*(25.0/100);
        }

        if (healthExpenses > 0){
            tax = tax - (healthExpenses/2);
        }

        return tax;

    }
}

