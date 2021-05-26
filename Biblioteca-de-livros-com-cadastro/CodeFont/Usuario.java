package lp2g15.biblioteca;
import java.util.*;
import java.time.LocalDate;
import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable{
    private String endereco;
    private int codUsuario;
    ArrayList<Emprestimo> historico = new ArrayList();

    public Usuario(String nom,String datNac, String endere,int cod){
        super(nom, datNac);
        setCod(cod);
        setEndere(endere);
    }
    public void setCod(int c){
        this.codUsuario=c;
    }
    public void setEndere(String en){
        this.endereco=en;
    }
    public void addLivroHist(GregorianCalendar data, String cod){
        historico.add(new Emprestimo(data,cod));
    }
    public int getCodUsuario(){
        return this.codUsuario;
    }
    public GregorianCalendar getDataE(String nome)throws Exception{
        
        GregorianCalendar da= new GregorianCalendar();

        for(int i=0;i<this.historico.size();i++){
            if(this.historico.get(i).getCod().compareTo(nome)==0){
                this.historico.get(i).setDataD(da);
                return this.historico.get(i).getDataE();
            }
        }
        throw new Exception("Nao foi encontrado o livro.");
    }

    public void devolve(String a,GregorianCalendar b){
        for(int i=0;i<this.historico.size();i++){
            if((this.historico.get(i).getCod()).compareTo(a)==0){
                this.historico.get(i).setDataD(b);
                break;
            }
        }  
    }

    public String toString(){
        return (super.toString()+"Endereco: "+this.endereco+"\nCodigo do Usuario: "+this.codUsuario+"\n\n");
    }
    
    public String getEndereco(){
        return this.endereco;
    }

    public Emprestimo getEmprest(String a)throws Exception{
        for(int i=0;i<this.historico.size();i++){
            if(this.historico.get(i).getCod().compareTo(a)==0){
                return this.historico.get(i);
            }
        }
        throw new Exception("Não encontrado o emprestimo.");
    }
    public String toHisotico(){
        String fim="";
        int n=this.historico.size();
        for(int i=0;i<n;i++){
            fim=fim.concat((i+1)+":\n "+this.historico.get(i).toString()+"\n-------------------------------------------------------------\n");
        }
        return fim;
    }
    public GregorianCalendar getEmp(String nome)throws Exception{
        for(int i=0;i<this.historico.size();i++){
            if(this.historico.get(i).getCod().compareTo(nome)==0){
                return this.historico.get(i).getDataE();
            }
        }
        throw new Exception("Não encontrado o emprestimo.");
    }
    public String getNome(){
        return super.getNome();
    }
}
 