package lp2g15.biblioteca;
import java.util.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class EmprestadoPara  implements Serializable{
    private int CodUser;
    private GregorianCalendar emp,dev;

    public EmprestadoPara(int a,GregorianCalendar b){
        this.CodUser=a;
        this.emp=b;
    }
    public EmprestadoPara(int a,GregorianCalendar b, GregorianCalendar c){
        this.CodUser=a;
        this.emp=b;
        this.dev=c;
    }
    public void setDev(GregorianCalendar de){
        this.dev= de;
    }
    public int getCodUser(){
        return this.CodUser;
    }
    public GregorianCalendar getEmp(){
        return this.emp;
    }
    public GregorianCalendar getDev(){
        return this.dev;
    }
    public String toString(){
        return ("Emprestado para: "+CodUser+"\nData de emprestimo: "+this.emp.get(Calendar.DAY_OF_MONTH)+"/"+(1+this.emp.get(Calendar.MONTH))+"/"+this.emp.get(Calendar.YEAR)+"\nData de devolucao: "+this.dev.get(Calendar.DAY_OF_MONTH)+"/"+(1+this.dev.get(Calendar.MONTH))+"/"+this.dev.get(Calendar.YEAR)+"\n");
    }
}
