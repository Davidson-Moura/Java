package lp2g15.biblioteca;
import java.util.*;
import java.time.LocalDate;
import java.io.Serializable;
 // Compiler version JDK 11.0.2

 public class Pessoa implements Serializable
 {
   private String nome;
   private GregorianCalendar dataNasc;
   
   public Pessoa(String nom, String datNac){
     this.nome=nom;
     this.dataNasc= new GregorianCalendar((Integer.parseInt(datNac.substring(6,10))-1),Integer.parseInt(datNac.substring(3,5)),Integer.parseInt(datNac.substring(0,2)));
   }
   public String toString(){
     return "Nome: "+this.nome+"\nData de nascimento: "+this.dataNasc.get(Calendar.DAY_OF_MONTH)+"/"+(this.dataNasc.get(Calendar.MONTH)+1)+"/"+this.dataNasc.get(Calendar.YEAR)+"\n";
   }
   public String getNome(){
     return this.nome;
   }
   public GregorianCalendar getDataN(){
      return this.dataNasc;
   }
   
 }