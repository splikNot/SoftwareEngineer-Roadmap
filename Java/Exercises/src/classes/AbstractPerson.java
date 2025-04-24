package classes;

public abstract class AbstractPerson {
    String name;
    Double income;

    @SuppressWarnings("unused")
    public abstract Double incomeTax();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setIncome(Double income){
        this.income = income;
    }

    public Double getIncome(){
        return income;
    }
}
