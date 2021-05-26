
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

    

public class MinhaListaOrdenavel implements Serializable{
    
    private ArrayList<PessoaIMC> lista = new ArrayList();
    public void add (PessoaIMC p){
        this.lista.add(p);
    }
    public PessoaIMC get (int i){
        return this.lista.get(i);
    }
    public int getSize(){
        return this.lista.size();
    }
    public PessoaIMC Pess(int n){
        return this.lista.get(n);
    }
    public int size(){
        return lista.size();
    }

    public void Ordena(int i){
        /*1.Alfabetica (A-Z)
        2.Alfabetica (Z-A)
        3.Menor Peso
        4.Maior Peso
        5.Menor Altura
        6.Maior Altura
        7.Maior IMC
        8.Menor IMC
        9.Genero*/

        if(i==1){
            Collections.sort(this.lista,new NomeC());
        }else if(i==2){
            Collections.sort(this.lista,new NomeD());
        }else if(i==3){
            Collections.sort(this.lista,new PesoC());
        }
        else if(i==4){
            Collections.sort(this.lista,new PesoD());
        }else if(i==5){
            Collections.sort(this.lista,new AlturaC());
        }else if(i==6){
            Collections.sort(this.lista,new AlturaD());
        }else if(i==7){
            Collections.sort(this.lista,new IMCC());
        }else if(i==8){
            Collections.sort(this.lista,new IMCD());
        }else if(i==9){
            Collections.sort(this.lista,new Genero());
        }
                
                
                
            
        
            
    }
}

class NomeC implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        String a = p2.getNome(), b =  p1.getNome();
        a=a.substring(0,1).toUpperCase().concat(a.substring(1));b=b.substring(0,1).toUpperCase().concat(b.substring(1));
            if(a.compareTo(b)<0){
                
                return 1;
            }else if(a.compareTo(b)>0){
                return -1;
            }
            else{return 0;}
        

    }
                    
}
class Genero implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        boolean pf1, pf2;
        pf2 =  p2.getSexo();
        pf1 =  p1.getSexo();
        
        if(pf2){
            return 1;
        }else{
            return -1;
        }
    }
                    
}
class IMCD implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        double pf1, pf2, r;
        pf2 =  p2.getIMC();
        pf1 =  p1.getIMC();
        r=pf2-pf1;
        if(r>0){
            return 1;
        }else if (r<0){
            return -1;
        }
        else{
            return 0;
        }
        
    }
                
}

class IMCC implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        double pf1, pf2;
        pf2 =  p2.getIMC();
        pf1 =  p1.getIMC();
        pf2=pf2 - pf1;
        if(pf2>0){
            return -1;
        }else if (pf2<0){
            return 1;
        }
        else{
            return 0;
        }
    }             
}

class AlturaD implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        double pf1, pf2;
        pf2 =  p2.getAltura();
        pf1 =  p1.getAltura();
        pf2=pf2 - pf1;
        if(pf2>0){
            return 1;
        }else if (pf2<0){
            return -1;
        }
        else{
            return 0;
        }
    }           
}

class AlturaC implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        double pf1, pf2;
        pf2 =  p2.getAltura();
        pf1 = p1.getAltura();
        pf2=pf2 - pf1;
        if(pf2>0){
            return -1;
        }else if (pf2<0){
            return 1;
        }
        else{
            return 0;
        }
    }          
}

class PesoD implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        double pf1, pf2;
        pf2 =  p2.getPeso();
        pf1 = p1.getPeso();
        pf2= pf2 - pf1;
        if(pf2>0){
            return 1;
        }else if (pf2<0){
            return -1;
        }
        else{
            return 0;
        }
    }          
}

class PesoC implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
            double pf1, pf2;
            
            
        pf2 =  p2.getPeso();
        pf1 =  p1.getPeso();
        pf2= pf2-pf1;
        if(pf2>0){
            return -1;
        }else if (pf2<0){
            return 1;
        }
        else{
            return 0;
        }
            
        }
        
}


class NomeD implements Comparator<PessoaIMC>{
    public int compare (PessoaIMC p1, PessoaIMC p2){ 
        String a= p2.getNome(), b=  p1.getNome();
        a=a.substring(0,1).toUpperCase().concat(a.substring(1));b=b.substring(0,1).toUpperCase().concat(b.substring(1));
        if(a.compareTo(b)<0){
            return -1;
        }else if(a.compareTo(b)>0){
            return 1;
        }
        else{return 0;}
    }
}