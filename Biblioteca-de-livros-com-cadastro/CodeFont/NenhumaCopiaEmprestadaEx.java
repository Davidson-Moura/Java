package lp2g15.biblioteca;

public class NenhumaCopiaEmprestadaEx extends Exception{
    public NenhumaCopiaEmprestadaEx(){
        super("Nenhuma copia encontrada.");
    }

    public NenhumaCopiaEmprestadaEx(String msg){
        super(msg);
    }

    
    public NenhumaCopiaEmprestadaEx(String msg, Throwable cause){
        super(msg, cause);
    }
}
