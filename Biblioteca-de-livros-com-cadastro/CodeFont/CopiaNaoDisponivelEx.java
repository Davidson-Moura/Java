package lp2g15.biblioteca;

public class CopiaNaoDisponivelEx extends Exception {

    public CopiaNaoDisponivelEx(){
        super("Copia Nao Disponivel.");
    }

    public CopiaNaoDisponivelEx(String msg){
        super(msg);
    }

    
    public CopiaNaoDisponivelEx(String msg, Throwable cause){
        super(msg, cause);
    }
}
