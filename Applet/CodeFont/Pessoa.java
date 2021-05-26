

import java.io.*;
import java.util.*;
 // Compiler version JDK 11.0.2

 class Pessoa implements Serializable
 {
   private String nome;
   private GregorianCalendar dataNasc;
   
   public Pessoa(String nom, String datNac){
     this.nome=nom;
     this.dataNasc= new GregorianCalendar(Integer.parseInt(datNac.substring(6,10)),Integer.parseInt(datNac.substring(3,5)),Integer.parseInt(datNac.substring(0,2)));
   }
   public String toString(){
     return "Nome: "+this.nome+"\nData de nascimento: "+this.dataNasc.get(Calendar.DAY_OF_MONTH)+"/"+this.dataNasc.get(Calendar.MONTH)+"/"+this.dataNasc.get(Calendar.YEAR)+"\n";
   }
   public String getNome(){
     return nome;
   }
   
 }