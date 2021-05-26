import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Color;
import java.io.*;
import java.lang.System.*;
import java.text.DecimalFormat; 

public class Applet extends JApplet implements ActionListener {

    
    



    JPopupMenu alerta;


    //botão cadastra
   JButton botao1;
   JPanel grupoBotao12;

    //botões de ordenação
   JButton bAltura,bPeso,bGenero,bNome,bIMC;
   JPanel grupoOrdena;

    //botões do sexo
   JComboBox botaoDeSelecao;
   JRadioButton opcao1, opcao2;

   //Titulos e componete de preenchimento
   JLabel titulo,titulo2,titulo3,titulo4,titulo5;
   JTextField campoDeNome,campoDeAtura,campoDePeso,campoDeData;
   JTextArea areaDeTexto;

   //Agrupamentos
   ButtonGroup grupoBotao;
   JPanel grupoBotaoPanel;
   JPanel a,s,grupoTexto,grupoTexto1,grupoTexto2,grupoTexto3;
   Panel p;
   Container cp;

   //Tabela 
   JScrollPane scrollList;
   JTable t;
    
   //lista de pessoas
   MinhaListaOrdenavel lista;

   //formatação
   DecimalFormat df = new DecimalFormat("#,###.00");

   //Variaveis de armazenamento 
    boolean sexo;
    String nome,altura, peso,data;
    boolean tAl=false,tPe=false,tNo=false,tIM=false;





    

public void init() {
    

    //Criando a lista
    lista = new MinhaListaOrdenavel();

    //Cadastro Exemplo
    lista.add(new Mulher("Eduarda","28/08/1994",1.45,60));
    lista.add(new Homem("Caio","29/09/1995",1.50,70));
    lista.add(new Mulher("Fabiana","30/10/1996",1.60,80));
    lista.add(new Homem("Gabriel","31/11/1997",1.70,90));
    lista.add(new Mulher("Ianca","01/07/1998",1.80,100));
    lista.add(new Homem("Joao","02/01/1998",1.90,25));
    lista.add(new Mulher("Agata","03/02/1999",1.10,30));
    lista.add(new Homem("Fernando","04/03/2000",1.20,40));
    lista.add(new Mulher("Bernarda","05/04/2001",1.40,50));
    lista.add(new Homem("Diego","06/05/2002",1.75,80));


      //botoes
      botao1 = new JButton("Cadastrar");
      botao1.addActionListener(this);

      grupoBotao12 = new JPanel();
      grupoBotao12.add(botao1);

      //Botoes de ordenação

      bAltura = new JButton("Altura");
      bPeso = new JButton("Peso");
      bNome = new JButton("Nome");
      bIMC = new JButton("IMC");
      bGenero = new JButton("Genero");

      //Design button
      bAltura.setPreferredSize(new Dimension(76, 30));
      bAltura.setBackground(Color.yellow);
        
      bPeso.setPreferredSize(new Dimension(76, 30));
      bPeso.setBackground(Color.yellow);
    
      bNome.setPreferredSize(new Dimension(76, 30));
      bNome.setBackground(Color.yellow);

      bIMC.setPreferredSize(new Dimension(76, 30));
      bIMC.setBackground(Color.yellow);

      bGenero.setPreferredSize(new Dimension(76, 30));
      bGenero.setBackground(Color.yellow);

      //Action ordena
      bAltura.addActionListener(this);
      bPeso.addActionListener(this);
      bNome.addActionListener(this);
      bIMC.addActionListener(this);
      bGenero.addActionListener(this);

      //organizando Layout
      grupoOrdena = new JPanel();
        grupoOrdena.add(bNome);
      grupoOrdena.add(bAltura);
      grupoOrdena.add(bPeso);
      grupoOrdena.add(bIMC);
      grupoOrdena.add(bGenero);

      //Titulos
      titulo2 = new JLabel("_______________________Pessoa IMC_________________________");
      titulo = new JLabel("    Nome    ");
      titulo3 = new JLabel("    Altura    ");
      titulo4 = new JLabel("    Peso     ");
      titulo5 = new JLabel("    Data de nascimento:     ");

      //botao do Sexo
      opcao1 = new JRadioButton("Homem");
      opcao2 = new JRadioButton("Mulher");
      
      //Action button
      opcao1.addActionListener(this);
      opcao2.addActionListener(this);


      grupoBotao = new ButtonGroup();
      grupoBotaoPanel = new JPanel();
      
      grupoBotao.add(opcao1);
      grupoBotao.add(opcao2);
      

      
      grupoBotaoPanel.add(opcao1);
      grupoBotaoPanel.add(opcao2);
     
      //Criando campos de texto
      
      campoDeNome = new JTextField(30);
      campoDeAtura = new JTextField(30);
      campoDePeso = new JTextField(30);
      campoDeData = new JTextField(20);

      //Agrupando nos paineis

      grupoTexto = new JPanel();

      grupoTexto.add(titulo);
      grupoTexto.add(campoDeNome);

      grupoTexto1 = new JPanel();

      grupoTexto1.add(titulo3);
      grupoTexto1.add(campoDeAtura);

      grupoTexto2 = new JPanel();

      grupoTexto2.add(titulo4);
      grupoTexto2.add(campoDePeso);

      grupoTexto3 = new JPanel();

      grupoTexto3.add(titulo5);
      grupoTexto3.add(campoDeData);

      //Action campos de texto

      campoDeNome.addActionListener(this);
      campoDeAtura.addActionListener(this);
      campoDePeso.addActionListener(this);
      campoDeData.addActionListener(this);
    


      //Content Pane

      cp = getContentPane();
      p = new Panel ();

      //paineis de Scroll

      areaDeTexto = new JTextArea();
      areaDeTexto.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(areaDeTexto, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setPreferredSize(new Dimension(400, 150));


      
      s = new JPanel ();
      t= new JTable(100,5);
      for(int i=0;i<lista.size();i++){
        t.setValueAt(lista.get(i).getNome(),i,0);
        t.setValueAt(String.valueOf(df.format(lista.get(i).getAltura())),i,1);
        t.setValueAt(String.valueOf(df.format(lista.get(i).getPeso())),i,2);
        t.setValueAt(String.valueOf(df.format(lista.get(i).getIMC())),i,3);
        
        if(lista.get(i).getSexo()){
            t.setValueAt("Homem",i,4);
            
        }else{
            t.setValueAt("Mulher",i,4);
        }  
        
        
      }
      s.add(t);
      
      scrollList = new JScrollPane(s, 
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scrollList.setPreferredSize(new Dimension(400, 150));

      //Finalizando nos paineis e container
      p.add(titulo2);
      p.add(grupoBotaoPanel);
      p.add(grupoTexto);
      p.add(grupoTexto1);
      p.add(grupoTexto2);
      p.add(grupoTexto3);
      p.add(grupoBotao12);
      p.add(grupoOrdena);
      p.add(scrollList);
      p.add(new JLabel("--Caixa de Status--"));
      p.add(scrollPane);
      cp.add(p);

      
      
   }

   public void Atualiza(){
    //t= new JTable(lista.size(),5);
      for(int i=0;i<lista.size();i++){
        t.setValueAt(lista.get(i).getNome(),i,0);
        t.setValueAt(String.valueOf(df.format(lista.get(i).getAltura())),i,1);
        t.setValueAt(String.valueOf(df.format(lista.get(i).getPeso())),i,2);
        t.setValueAt(String.valueOf(df.format(lista.get(i).getIMC())),i,3);
        
        if(lista.get(i).getSexo()){
            t.setValueAt("Homem",i,4);
            
        }else{
            t.setValueAt("Mulher",i,4);
        }  
        
      }
   }
   //Este metodo responde as acoes dos componentes
   public void actionPerformed(ActionEvent e) {

      if(e.getSource() instanceof JButton) {
         if(e.getSource()==botao1) {
            nome=campoDeNome.getText();
            altura=campoDeAtura.getText();
            peso=campoDePeso.getText();
            data=campoDeData.getText();

                
            
                int ano,mes,dia,n=0;
        double al=0,pe=0;
        try{
            pe=Double.parseDouble(peso);
            if(pe<20){throw new Exception("Peso minimo eh 20.\n");
            }else if(pe>200){throw new Exception("Peso maximo eh 200.\n");
            }n++;
            
        }catch(NumberFormatException e1){
            areaDeTexto.append("O peso deve ser um numero real!!!\n");
        }catch(Exception e2){
            areaDeTexto.append("Erro : "+e2+"\n");
        }

        try{
            al=Double.parseDouble(altura);
            if(al<1){throw new Exception("Altura minimo eh 1.\n");
            }else if(al>2.5){throw new Exception("Altura maximo eh 2.5.\n");
            }n++;
            
        }catch(NumberFormatException e1){
            areaDeTexto.append("A altura deve ser um numero real!!!\n");
        }catch(Exception e2){
            areaDeTexto.append("Erro : "+e2+"\n");
        }      


        try{
            if(data.length()!=10){throw new Exception ("Data invalida, use o formato xx/xx/xxxx ou xx-xx-xxxx.\n");}
            dia=Integer.parseInt(data.substring(0,2));
            if(dia>31){throw new Exception ("Dia invalido.\n");}n++;
        }catch(Exception a){
            areaDeTexto.append("Data invalida, use o formato xx/xx/xxxx ou xx-xx-xxxx.\n");
        }
        try{
            mes=Integer.parseInt(data.substring(3,5));
            if(mes>12 || mes<1){throw new Exception ();}n++;
            
        }catch(Exception c){
            areaDeTexto.append("Mes invalido!\n");
        }
    
    
        try{
            ano=Integer.parseInt(data.substring(6,10));
            if(ano>3000 || 1900>ano ){throw new Exception ();}n++;
            
        }catch(Exception f){
            areaDeTexto.append("Ano invalido!\n");
        }



         try{
              if(n==5){
                if(sexo){
                    lista.add(new Homem(nome,data,al,pe));
                }else{
                    lista.add(new Mulher(nome,data,al,pe));
                }
                areaDeTexto.append("Pessoa "+nome+" cadastrada.\n");
                Atualiza();
                
              }
            }catch(Exception a){
                areaDeTexto.append(a.toString()+"\n");
            }

                
            
                
         }
         else if(e.getSource()==bAltura){
             if(tAl){
                lista.Ordena(5);
                Atualiza();
                tAl=false;
             }else{
                lista.Ordena(6);
                Atualiza();
                tAl=true;
             }
             
         }
         else if(e.getSource()==bPeso){
            if(tPe){
                lista.Ordena(3);
                Atualiza();
                tPe=false;
             }else{
                lista.Ordena(4);
                Atualiza();
                tPe=true;
             }
         }
         else if(e.getSource()==bNome){
            if(tNo){
                lista.Ordena(1);
                Atualiza();
                tNo=false;
             }else{
                lista.Ordena(2);
                Atualiza();
                tNo=true;
             }
         }
         else if(e.getSource()==bGenero){
            lista.Ordena(9);
            Atualiza();
         }
         else if(e.getSource()==bIMC){
            if(tIM){
                lista.Ordena(7);
                Atualiza();
                tIM=false;
             }else{
                lista.Ordena(8);
                Atualiza();
                tIM=true;
             }
         }
      }
      if(e.getSource() instanceof JRadioButton) {
         if(opcao1.isSelected()) {
            sexo=true;
         }
         if(opcao2.isSelected()) {
            sexo=false;
         }
      }
   }

   class Panel extends JPanel {

      public void paintComponent (java.awt.Graphics g) {
             super.paintComponent(g);
      }
   }
}  













/*
<h1>Pessoa IMC</h1>
        <applet width="427" height="584" code="Applet.class">Seu browser não suporta Java.</applet>

id="http://152.92.236.11/~lp15/"
*/