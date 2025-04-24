package classes;

public class JuridicPerson extends AbstractPerson{

    Integer employeesNumber;

    public JuridicPerson(String name,Double income,Integer employeesNumber){
        this.name = name;
        this.income = income;
        this.employeesNumber = employeesNumber;

    }

    @Override
    public Double incomeTax(){
        Double tax;

        if (employeesNumber > 10){
            tax = income*(14.0/100);
        }
        else{
            tax = income*(16.0/100);
        }

        return tax;
    }

}
