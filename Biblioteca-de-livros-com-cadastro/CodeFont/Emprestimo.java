package lp2g15.biblioteca;
import java.util.*;
import java.time.LocalDate;
import java.io.Serializable;

public class Emprestimo  implements Serializable{
    private GregorianCalendar dataEmpr= new GregorianCalendar(1,1,1970), dataDevo= new GregorianCalendar(1,1,1970);
    private String codLivro;

    public Emprestimo(GregorianCalendar data,String cod){
        setCod(cod);
        setDataE(data);
    }
    public void setDataE(GregorianCalendar d){
        this.dataEmpr=d; //new GregorianCalendar(Integer.parseInt(d.substring(6,10)),Integer.parseInt(d.substring(3,5)),Integer.parseInt(d.substring(0,2)));
    }
    public void setCod(String c){
        this.codLivro=c;
    }
    public String getCod(){
        return this.codLivro;
    }
    public GregorianCalendar getDataE(){
        return dataEmpr;
    }
    public void setDataD(GregorianCalendar data){
        dataDevo= data;
    }
    public GregorianCalendar getDataD(){
        return this.dataEmpr;
    }
    public String toString(){
        return ("Livro: "+codLivro+"\nData de emprestimo: "+this.dataEmpr.get(Calendar.DAY_OF_MONTH)+"/"+(1+this.dataEmpr.get(Calendar.MONTH))+"/"+this.dataEmpr.get(Calendar.YEAR)+"\nData de devolucao: "+this.dataDevo.get(Calendar.DAY_OF_MONTH)+"/"+(1+this.dataDevo.get(Calendar.MONTH))+"/"+this.dataDevo.get(Calendar.YEAR)+"\n");
    }
    
}
