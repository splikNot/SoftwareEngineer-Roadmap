package entities;

public class OutSourcedEmployee extends Employee {

    private Double additionalCharge;

    public OutSourcedEmployee(){
        super();
    }

    public OutSourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge){
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }
    // Não preciso criar os gets e setters da classe pai novamente, tudo herdado
    public Double getAddtionalCharge() {
        return additionalCharge;
    }

 
    public void setAddtionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment() {
        return super.payment() + additionalCharge * 1.1;
    }

}
