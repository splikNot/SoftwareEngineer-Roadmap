package entities;

public class Employee {

    private String name;
    private Integer hours;
    private Double valuePerHour;

    //Constructor
    public Employee(){
        
    }

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.hours = hours;
        this.name = name;
        this.valuePerHour = valuePerHour;
    }

    //Getter and Setters
    public String getName() {
        return name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    //payment method
    public Double payment(){
        return hours*valuePerHour;
    }
}
