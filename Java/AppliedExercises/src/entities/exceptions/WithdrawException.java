package entities.exceptions;

// Criamos uma exceção que herda a classe embutida do Java
public class WithdrawException extends Exception {

    private static final long serialVersionUID = 1L;

    public WithdrawException(String msg){
        super(msg);
    }
}
