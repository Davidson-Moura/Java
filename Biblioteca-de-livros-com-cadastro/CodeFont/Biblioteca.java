package lp2g15.biblioteca;

import java.time.*;
import java.io.*;
import java.util.*;

public class Biblioteca {
    private Hashtable<String, Usuario> usuarios = new Hashtable<>();
    private Hashtable<String, Livro> livros = new Hashtable<>();
    private ObjectOutputStream lio,uso;
    private ObjectInputStream lii,usi;
    private String arq1,arq2;
    private int N=0;

    public Biblioteca(String arq1,String arq2)throws Exception{
        this.arq1 = arq1;
        this.arq2= arq2;
        this.leArquivo();
        this.salvaArquivo();
    }

    public void cadastraUsuario(String cod,Usuario us) throws Exception{
        try{
            this.usuarios.put(cod,us);
        }catch(Exception e){
            throw new Exception("Erro: "+e);
        }
    }
    public void cadastraLivro(String cod,Livro li) throws Exception{
        N++;
        if(N>20){
            throw new Exception("Numero de Livros excedente.");
        }
        try{
            this.livros.put(cod,li);
        }catch(Exception e){
            throw new Exception("Erro: "+e);
        }
    }
    public void salvaArquivo()throws Exception{
        int n;
        
        
        try{
            this.lio=new ObjectOutputStream(new FileOutputStream(this.arq1));
            this.lio.writeObject(this.livros);
            this.lio.close();

            this.uso=new ObjectOutputStream(new FileOutputStream(this.arq2));
            this.uso.writeObject(this.usuarios);
            this.uso.close();
        }catch(FileNotFoundException e){

        }
        
        

    }
    public void leArquivo() throws ClassCastException{
        try{
            this.usi=new ObjectInputStream(new FileInputStream(this.arq2));
            this.usuarios=(Hashtable) this.usi.readObject();
            this.usi.close();
            this.lii=new ObjectInputStream(new FileInputStream(this.arq1));
            this.livros=(Hashtable) this.lii.readObject();
            this.lii.close();

            
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
    }
    public void emprestaLivro(Usuario co,Livro l)throws Exception{
        l.empresta();
        GregorianCalendar da= new GregorianCalendar();

        co.addLivroHist(da,l.getCodLivro());
    }
    public void devolveLivro(Usuario co,Livro l)throws Exception{
        l.devolve();
        GregorianCalendar da= new GregorianCalendar();

        co.devolve(l.getCodLivro(),da);
        l.devolve(co.getCodUsuario(),da);
        l.addUsuarioHist(co.getCodUsuario(),co.getEmp(l.getCodLivro()),da);
    }
    public String imprimeLivros()throws Exception{
        String fim="\n";
        int n=this.livros.size();
        int i= -1;

        ArrayList<Livro> Titulos= new ArrayList();


        try{
            for(String key:livros.keySet()){
                Titulos.add(this.livros.get(key));
            }
        }catch(NullPointerException e){
            throw new NullPointerException("");
        }

        Collections.sort(Titulos,new NomeL());
        
        try{
            for(int s=0;s<Titulos.size();s++){
                i++;
                fim=fim.concat((i+1)+"- "+Titulos.get(s).getCodLivro()+"\n");
            }
        }catch(NullPointerException e){
            throw new NullPointerException("");
        }
        
        
        return fim;
    }
    public String imprimeUsuarios()throws Exception{
        String fim="\n";
        int n=this.usuarios.size();
        int i=-1;
        ArrayList<Usuario> Nomes= new ArrayList();


        try{
            for(String key:usuarios.keySet()){
                Nomes.add(this.usuarios.get(key));
            }
        }catch(NullPointerException e){
            throw new NullPointerException("");
        }

        Collections.sort(Nomes,new NomeU());
        
        try{
            for(int s=0;s<Nomes.size();s++){
                i++;
                fim=fim.concat((i+1)+"- "+Nomes.get(s).getCodUsuario()+"\n");
            }
        }catch(NullPointerException e){
            throw new NullPointerException("");
        }
        
        return fim;
    }
    public Livro getLivro(String cod)throws Exception{
        return this.livros.get(cod);
    }

    public Usuario getUsuario(String cod)throws Exception{
        return this.usuarios.get(cod);
    }

    public void Ordena(){

    }
    
    
}
class NomeU implements Comparator<Usuario>{
    public int compare (Usuario p1, Usuario p2){ 
        String a = p2.getNome(), b =  p1.getNome();
            
            if(a.compareTo(b)<0){
                
                return 1;
            }else if(a.compareTo(b)>0){
                return -1;
            }
            else{return 0;}
        

    }
                    
}
class NomeL implements Comparator<Livro>{
    public int compare (Livro p1, Livro p2){ 
        String a = p2.getTitulo(), b =  p1.getTitulo();
            
            if(a.compareTo(b)<0){
                
                return 1;
            }else if(a.compareTo(b)>0){
                return -1;
            }
            else{return 0;}
        

    }
                    
}
