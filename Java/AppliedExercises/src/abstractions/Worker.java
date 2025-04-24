package abstractions;

import entities.Department;
import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import toolbox.HourContract;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department departament;
    private final List<HourContract> contracts = new ArrayList<>();

    public Worker(){
        
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartament() {
        return departament;
    }

    public void setDepartament(Department departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract newContract){
        contracts.add(newContract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){

        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();

        for (HourContract contract: contracts){
            // Transformando a váriavel cal na data do nosso contrato
            cal.setTime(contract.getDate());

            // A partir do nosso calendário pegamos os valores das datas
            int contractYear = cal.get(Calendar.YEAR);
        
            // O mês, por alguma razão desconhecida, começa no mês zero e precisamos somar um valor
            int contractMonth = 1 + cal.get(Calendar.MONTH);
            
            if (contractYear == year && contractMonth == month) {
                sum += contract.totalValue();
            }

        }

        return sum;
    }

}
