
import java.io.*;
import java.util.*;
import java.text.DecimalFormat; 
import java.text.NumberFormat;

public class Mulher extends PessoaIMC implements Serializable{
    public DecimalFormat df = new DecimalFormat("#,###.00");
    public Mulher(String nome, String data, double altur, double pes){
        super(nome, data, altur, pes);
        String a = this.resultIMC();
    }
    public String resultIMC(){
        double imc = super.CalculaIMC(this.getAltura(),this.getPeso());
        super.setIMC(imc);
        if(imc<19){
            return "IMC: "+df.format(imc) + " Abaixo do peso ideal\n";
        }else if(imc>=19 && imc<=25.8){
            return "IMC: "+df.format(imc) + " Peso ideal\n";
        }else{
            return "IMC: "+df.format(imc) + " Acima do peso ideal\n";
        }
    }
    public boolean getSexo(){
        return false;
    }
}