
import java.io.*;
import java.util.*;
import java.text.DecimalFormat; 

import java.text.NumberFormat;


 public abstract class PessoaIMC extends Pessoa implements Serializable
 {
   public DecimalFormat df = new DecimalFormat("#,###.00");
   private double altura, peso,IMC;
   public PessoaIMC(String nome, String data, double altur, double pes){
     super(nome,data);
     this.altura=altur;
     this.peso=pes;
   }
   public void setAltura(double alt){
     altura=alt;
   }
   public void setPeso(double pes){
     peso=pes;
   }
   public double getAltura(){
     return altura;
   }
   public double getPeso(){
     return peso;
   }
   public double CalculaIMC(double altur, double pes){
     return pes/(altur*altur);
   }
   public abstract String resultIMC();
   public abstract boolean getSexo();
   public String toString(){
       return super.toString()+"Peso: "+df.format(peso)+"\nAltura: "+df.format(altura)+"\n";
   }
   public double getIMC(){
     return IMC;
   }
   public void setIMC(double a){
     this.IMC=a;
   }
 }