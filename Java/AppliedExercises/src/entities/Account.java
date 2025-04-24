package entities;

import entities.exceptions.WithdrawException;

public class Account {

    private final int number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(String holder, int number, Double balance, Double withdrawLimit) {
        this.balance = balance;
        this.holder = holder;
        this.number = number;
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }


    //métodos
    public void deposit(Double value){
        balance += value;
    }

    // Na classe, no objeto lançamos a lógica da exceção, devemos declarar que um método
    // Pode lançar o erro que criamos
    // Aqui apenas lançamos a exceção, quem irá trata -la é o programa principal main com os blocos
    // try-catch

    public void withdraw(Double amount) throws WithdrawException{

        if (amount > withdrawLimit){
            throw new WithdrawException("Invalid Value: WithDraw limit exceded");
            
        }

        else {
            balance -= amount;
        }
    }

}
