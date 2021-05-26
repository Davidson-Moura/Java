

import lp2g15.biblioteca.*;
import java.util.*;
import java.time.LocalDate;
import java.io.*;

public class Pn7X{
    static String nomeArquivoLivros="livros.dat";
    static String nomeArquivoUsuarios="usuarios.dat";
    static Biblioteca biblioteca;


    public static void main(String[] args){
        try{biblioteca= new Biblioteca(nomeArquivoLivros,nomeArquivoUsuarios);}catch(Exception e){}
        
        
        Scanner in = new Scanner( System.in );
        String line="lk";
        int r=0;
        try{
            Manutencao(1);
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        while(true){
            System.out.println("1- Manutencao\n2- Cadastro\n3- Emprestimos\n4- Relatorio\n5- Sair\n");
            
            while(true){
                try{
                    System.out.println("Digite a opcao: ");
                    line = in.nextLine();
                    r=Integer.parseInt(line);
                    if(r>0 && r<6){
                        break;
                    }else{
                        throw new Exception();
                    }
                }catch(Exception e2){
                    System.out.println("Digite apenas numeros de 1 a 5!");
                }
            }

            switch (r) {
                case 1:
                    System.out.println("1- Le arquivo\n2- Salvar em arquivo\n");
                    while(true){
                        try{
                            System.out.println("Digite a opcao: ");
                            line = in.nextLine();
                            r=Integer.parseInt(line);
                            if(r>0 && r<3){
                                break;
                            }else{
                                throw new Exception();
                            }
                        }catch(Exception e2){
                            System.out.println("Erro : Digite apenas numeros de 1 a 2!");
                        }
                    }
                    try{
                        Manutencao(r);
                    }catch(Exception e){
                        System.out.println("Erro: "+e);
                    }
                    break;
                    
                case 2:
                    System.out.println("1- Cadastrar livro\n2- Cadastrar usuario\n");
                    while(true){
                        try{
                            System.out.println("Digite a opcao: ");
                            line = in.nextLine();
                            r=Integer.parseInt(line);
                            if(r>0 && r<3){
                                break;
                            }else{
                                throw new Exception();
                            }
                        }catch(Exception e2){
                            System.out.println("Erro : Digite apenas numeros de 1 a 2!");
                        }
                    }
                    try{
                        Cadastro(r);
                        Manutencao(2);
                    }catch(Exception e){
                        System.out.println("Erro: "+e);
                    }
                    break;
                
                case 3:
                    System.out.println("1- Fazer emprestimo do livro\n2- Devolve um livro\n 3- Exibe devolção\n");
                    while(true){
                        try{
                            System.out.println("Digite a opcao: ");
                            line = in.nextLine();
                            r=Integer.parseInt(line);
                            if(r>0 && r<4){
                                break;
                            }else{
                                throw new Exception();
                            }
                        }catch(Exception e2){
                            System.out.println("Erro : Digite apenas numeros de 1 a 2!");
                        }
                    }
                    try{
                        Emprestimo(r);
                        Manutencao(2);
                    }catch(Exception e){
                        System.out.println("Erro: "+e);
                    }
                    break;
                case 4:
                    System.out.println("1- Exibir Livros\n2- Exibir usuarios\n3- Exibir detalhes de livro\n4-Exibir detalhes de usuario");
                    while(true){
                        try{
                            System.out.println("Digite a opcao: ");
                            line = in.nextLine();
                            r=Integer.parseInt(line);
                            if(r>0 && r<5){
                                break;
                            }else{
                                throw new Exception();
                            }
                        }catch(Exception e2){
                            System.out.println("Erro : Digite apenas numeros de 1 a 2!");
                        }
                    }
                    try{
                        Relatorio(r);
                    }catch(Exception e){
                        System.out.println("Erro: "+e);
                    }
                    break;
                case 5:
                    try{
                        Manutencao(2);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                    System.exit(1);
                    break;

                default:
                    break;
            }
        }
    }





    //------------------------------------------------------------------------------------------------------------------------


    public static void Manutencao(int i)throws Exception{//1=le arquivo; 2= salva arquivos
        try{
            if(i==1){
                biblioteca.leArquivo();
            }else if(i==2){
                biblioteca.salvaArquivo();
            }
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static void Cadastro(int i)throws Exception{//1==cadastrar livro; 2== cadastrar usuario; 
        Scanner in = new Scanner( System.in );
        String line="lk";
        if(i==1){
            
            Livro livro=RecebeLivro();
            System.out.println("info livro: \n"+livro.toString()+"\n");
            while(true){
                try{
                    System.out.println("Deseja salvar o livro(S/N): ");
                    line = in.nextLine();

                    if(line.compareTo("S")==0){
                        biblioteca.cadastraLivro(livro.getCodLivro(),livro);
                        Manutencao(2);
                        break;
                    }else if(line.compareTo("N")==0){
                        break;
                    }else{
                        System.out.println("O sistema aceita apenas 'S' ou 'N'.\n");
                    }
                    
                }catch(Exception e2){
                    System.out.println("Erro inesperado: "+e2+"\n");
                }
            }

        }else if(i==2){
            Usuario usuario=RecebeUsuario();
            System.out.println("info usuario: \n"+usuario.toString()+"\n");
            while(true){
                try{
                    System.out.println("Deseja salvar o usuario(S/N): ");
                    line = in.nextLine();

                    if(line.compareTo("S")==0){
                        biblioteca.cadastraUsuario(Integer.toString(usuario.getCodUsuario()),usuario);
                        Manutencao(2);
                        break;
                    }else if(line.compareTo("N")==0){
                        break;
                    }else{
                        System.out.println("O sistema aceita apenas 'S' ou 'N'.\n");
                    }
                    
                }catch(Exception e2){
                    System.out.println("Erro inesperado: "+e2+"\n");
                }
            }
        }
        
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static Livro RecebeLivro()throws Exception{
        Scanner in = new Scanner( System.in );
        String line="lk";

        String codLivro;
        String categoria, titulo;
        int quantidade;


        while(true){
            try{
                System.out.println("Digite o codigo do livro: ");
                line = in.nextLine();
                codLivro=line;
                break;
            }catch(Exception e2){
                System.out.println("Erro inesperado: "+e2+"\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite a categoria: ");
                line = in.nextLine();
                categoria=line;
                break;
            }catch(Exception e2){
                System.out.println("Erro inesperado: "+e2+"\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite o titulo: ");
                line = in.nextLine();
                titulo=line;
                break;
            }catch(Exception e2){
                System.out.println("Erro inesperado: "+e2+"\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite a quantidade: ");
                line = in.nextLine();
                quantidade=Integer.parseInt(line);
                break;
            }catch(Exception e2){
                System.out.println("Numero invalido, digite apenas numeros.\n");
            }
        }
        return new Livro(codLivro,titulo,categoria,quantidade);
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static Usuario RecebeUsuario()throws Exception{
        Scanner in = new Scanner( System.in );
        String line="lk";

        String nom;
        String datNac;
        String endere;
        int cod, dia, mes, ano;
        String codLivro;

        while(true){
            try{
                System.out.println("Digite o nome: ");
                line = in.nextLine();
                nom=line;
                break;
            }catch(Exception e2){
                System.out.println("Erro inesperado: "+e2+"\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite o codigo do usuario: ");
                line = in.nextLine();
                cod=Integer.parseInt(line);
                break;
            }catch(Exception e2){
                System.out.println("Numero invalido, digite apenas numeros.\n");
            }
        }
        while(true){
            int a=0;
            System.out.println("Digite a data de nascimento(xx/xx/xxxx): ");
            datNac = in.nextLine();
            try{
                if(datNac.length()!=10){throw new Exception ("Data invalida, use o formato xx/xx/xxxx ou xx-xx-xxxx.\n");}
                dia=Integer.parseInt(datNac.substring(0,2));
                if(dia>31){throw new Exception ("Dia invalido.\n");}
                a=1;
            }catch(Exception e){
                System.out.println(e);
            }
            if(a==1){
                try{
                    mes=Integer.parseInt(datNac.substring(3,5));
                    if(mes>12){throw new Exception ();}
                    a=2;
                }catch(Exception c){
                    System.out.println("Mes invalido!");
                }
            }
            if(a==2){
                try{
                    ano=Integer.parseInt(datNac.substring(6,10));
                    if(ano>3000){throw new Exception ();}
                    break;
                }catch(Exception f){
                    System.out.println ("Ano invalido!");
                }
            }
        }

        while(true){
            try{
                System.out.println("Digite a endereco: ");
                line = in.nextLine();
                endere=line;
                break;
            }catch(Exception e2){
                System.out.println("Erro inesperado: "+e2+"\n");
            }
        }
        
        return new Usuario(nom, datNac,  endere,cod);
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static void Emprestimo(int i){ // 1== fazer emprestimo do livro; 2==devolve o livro; 3== Exibe devolção;
        switch (i) {
            case 1:
                Emp();
                break;
            
            case 2:
                Dev();
                break;
            case 3:
                ExibirDevolu();
                break;
            default:
                break;
        }
    }

    public static void Emp(){
        Scanner in = new Scanner( System.in );
        String line="lk";
        Exibir();
        Livro codli;
        Usuario codus;

        while(true){
            try{
                System.out.println("Digite o codigo do Livro: ");
                line = in.nextLine();
                
                codli=biblioteca.getLivro(line);
                if(codli!=null){
                    break;
                }else{
                    throw new Exception("Livro Invalido!!");
                }
                
            }catch(Exception e2){
                System.out.println("Erro: "+e2+"\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite o codigo do Usuario: ");
                line = in.nextLine();
                
                codus=biblioteca.getUsuario(line);
                if(codus!=null){
                    break;
                }else{
                    throw new Exception("Usuario Invalido!!");
                } 
                
                
            }catch(Exception e2){
                System.out.println("Erro: Usuario invalido\n");
            }
        }
        try{
            biblioteca.emprestaLivro(codus,codli);System.out.println("\nEmprestimo foi bem sucedido.");     
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
    }


    public static void Dev(){
        Exibir();
        Scanner in = new Scanner( System.in );
        String line="lk";

        Livro codli;
        Usuario codus;

        while(true){
            try{
                System.out.println("Digite o codigo do Livro: ");
                line = in.nextLine();
                
                codli=biblioteca.getLivro(line);
                if(codli!=null){
                    break;
                }else{
                    throw new Exception("Livro Invalido!!");
                }
                
            }catch(Exception e2){
                System.out.println("Erro: Livro invalido!\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite o codigo do Usuario: ");
                line = in.nextLine();
                
                codus=biblioteca.getUsuario(line);
                
                if(codus!=null){
                    break;
                }else{
                    throw new Exception("Usuario Invalido!!");
                }
                
            }catch(Exception e2){
                System.out.println("Erro: Usuario invalido!\n");
            }
        }
        try{
            biblioteca.devolveLivro(codus,codli);System.out.println("\nDevolucao foi bem sucedido."); 
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
    }


    public static void ExibirDevolu(){

        Scanner in = new Scanner( System.in );
        String line="lk";
        Exibir();
        String codli;
        String codus;

        while(true){
            try{
                System.out.println("Digite o codigo do Livro: ");
                line = in.nextLine();
                biblioteca.getLivro(line);
                codli=line;
                if(codli!=null){
                    break;
                }else{
                    throw new Exception("Livro Invalido!!");
                }
                
            }catch(Exception e2){
                System.out.println("Erro: Livro invalido!\n");
            }
        }
        while(true){
            try{
                System.out.println("Digite o codigo do Usuario: ");
                line = in.nextLine();
                biblioteca.getUsuario(line);
                codus=line;
                if(codus!=null){
                    break;
                }else{
                    throw new Exception("Usuario Invalido!!");
                }
                
            }catch(Exception e2){
                System.out.println("Erro: Usuario invalido!\n");
            }
        }
        try{
            Usuario u = biblioteca.getUsuario(codus);
            System.out.println("Devolucao do usuario "+codus+":\n"+u.getEmprest(codli).toString());
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
        
    }

    public static  void Exibir(){
        Scanner in = new Scanner( System.in );
        String line="lk";

        int r=0;
        try{
            System.out.println("1-Exibir livros e usuarios.\n2-Exibir livros.\n3-Nao exibir nada.");

            while(true){
                try{
                    System.out.println("Digite a opcao escolida: ");
                    line = in.nextLine();
                    r=Integer.parseInt(line);
                    if(r>0 && r<4){
                        break;
                    }else{
                        throw new Exception("Digite apenas valores de 1 a 3.\n");
                    }
                    
                }catch(Exception e2){
                    System.out.println("Erro: "+e2+"\n");
                }
            }
            switch (r) {
                case 1:
                    try{
                        System.out.println("Livros:\n"+biblioteca.imprimeLivros());
                        
                    }catch(NullPointerException e){

                    }
                    try{
                        System.out.println("Usuarios:\n"+biblioteca.imprimeUsuarios());
                        
                    }catch(NullPointerException e){

                    }


                    
                    
                    break;
                
                case 2:
                    System.out.println("Livros:\n"+biblioteca.imprimeLivros());
                    break;
                
                case 3:
                    
                    break;
            
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static void Relatorio(int i){// livros;usuarios;detalhe usuario;detalhe livro
        Scanner in = new Scanner( System.in );
        String line="lk";
        try{
            switch (i) {
                case 1:
                    System.out.println(biblioteca.imprimeLivros());
                    break;
                
                case 2:
                    System.out.println(biblioteca.imprimeUsuarios());
                    break;
                case 3:
                    Livro cod;
            
                    while(true){
                        try{
                            System.out.println("Digite o codigo do Livro: ");
                            line = in.nextLine();
                            
                            cod=biblioteca.getLivro(line);
                            if(cod!=null){
                                break;
                            }
                            
                        }catch(Exception e2){
                            System.out.println("Erro: Livro invalido!\n");
                        }
                    }
                    System.out.println(cod.toString()+"\n"+cod.toHisotico());
                    break;
                case 4:
                    Usuario cod1;
                    while(true){
                        try{
                            System.out.println("Digite o codigo do Usuario: ");
                            line = in.nextLine();
                            
                            cod1=biblioteca.getUsuario(line);
                            if(cod1!=null){
                                break;
                            }
                            
                        }catch(Exception e2){
                            System.out.println("Erro: Usuario invalido!\n");
                        }
                    }
                    System.out.println(cod1.toString()+"\n"+cod1.toHisotico());
                    break;
            
                default:
                    break;
            }
        }catch(Exception e){
            System.out.println("Erro: "+e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------
}