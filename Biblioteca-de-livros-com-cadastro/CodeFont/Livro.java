package lp2g15.biblioteca;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

//Código do Livro (String)
//Título do Livro
//Categoria (que pode ser Aventura, Ficção, Romance, etc.)
//Quantidade (inteiro)
//Emprestados (inteiro)


public class Livro implements Serializable{
    
    private String codLivro;
    private String categoria, titulo;
    private int quantidade,emprestado;
    private ArrayList<EmprestadoPara> para= new ArrayList();

    public Livro(String cod, String ti, String ca,int qua)throws Exception{
        
        setCod(cod);
        setTitulo(ti);
        setCategoria(ca);
        setQuant(qua);
        
    }
    public Livro(String a){
        this.titulo=a;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getCodLivro(){
        return this.codLivro;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public int getQuantidade(){
        return this.quantidade;
    }
    public int getEmprestado(){
        return this.emprestado;
    }


    public void setCategoria(String a){
        
        this.categoria=a;
    }
    public void setCod(String a){
        this.codLivro=a;
    }
    public  void setTitulo (String ti) {
        this.titulo = ti;
    }
    public void setQuant(int n){
        this.quantidade=n;
    }
    public void empresta()throws CopiaNaoDisponivelEx{
        if(this.emprestado<this.quantidade){
            this.emprestado++;
        }else{
            throw new CopiaNaoDisponivelEx("Não a copias disponiveis.");
        }
    }
    public void devolve()throws NenhumaCopiaEmprestadaEx{
        if(this.emprestado>0){
            this.emprestado--;
            
        }else{
            throw new NenhumaCopiaEmprestadaEx("Não a copias disponiveis.");
        }
        
    }
    public void devolve(int a,GregorianCalendar b)throws NenhumaCopiaEmprestadaEx{
        for(int i=0;i<this.para.size();i++){
            if(this.para.get(i).getCodUser()==a){
                this.para.get(i).setDev(b);
                break;
            }
        }      
    }

    public void addUsuarioHist(int a,GregorianCalendar b, GregorianCalendar c){
        this.para.add(new EmprestadoPara(a,b,c));
    }

    public String toString(){
        return ("Código do Livro: "+this.codLivro+"\nTítulo do Livro: "+this.titulo+"\nCategoria: "+this.categoria+"\nQuantidade: "+this.quantidade+"\nEmprestados: "+this.emprestado+"\n\n");
    }
    public String toHisotico(){
        String fim="";
        int n=this.para.size();
        for(int i=0;i<n;i++){
            fim=fim.concat((i+1)+":\n "+this.para.get(i).toString()+"\n-------------------------------------------------------------\n");
        }
        return fim;
    }
}
