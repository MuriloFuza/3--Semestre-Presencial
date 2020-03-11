package trabAvaliativo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.ArrayList;
import java.awt.GridLayout;

public class jogo extends JFrame implements ActionListener{

	baralhoarray bar;
	baralhoLE barLE;
	baralhopilha barP;
	baralhovetor barV;
	
	List<carta> morto = new ArrayList<carta>();
	carta c;

	
	//Botões e Icon
	JButton btFechado, btAberto,btLEFechado, btLEAberto, btPFechado, btPAberto,btVFechado, btVAberto;//V = Vetor , LE = lista Encadeada, P = Pilha
	Icon iconFechado, iconAberto, iconVazio;
	JButton btCriaBaralho, btEmbaralha, btZeraTudo, btExibe;//ArrayList
	JButton btLECriaBaralho, btLEEmbaralha, btLEZeraTudo, btLEExibe;//Lista Encadeada
	JButton btPCriaBaralho, btPEmbaralha, btPZeraTudo, btPExibe;//pilha
	JButton btVCriaBaralho, btVEmbaralha, btVZeraTudo, btVExibe;//Lista Encadeada
	JButton btCartasNoMonte;
	public jogo()//construtor
	{
	
		//Criando um container
		JPanel principal = new JPanel(new GridLayout(2,2));
		
		//Borda para a tela principal de todo o grid layhout 
		Border BAR = BorderFactory.createEtchedBorder();
		
//Borda para o baralho com sistema de Array List------------------------------------------
		Border borda = BorderFactory.createTitledBorder(BAR, "ArrayList");
		
		//montando icones
			iconFechado = new ImageIcon(getClass().getResource("Baralho/fechado.png"));
			iconVazio 	= new ImageIcon(getClass().getResource("Baralho/fechado2.png"));
		
		//montando botões
			
			//Icon Aberto
			btAberto			= new JButton(iconVazio);
			btLEAberto			= new JButton(iconVazio);
			btPAberto			= new JButton(iconVazio);
			btVAberto			= new JButton(iconVazio);
			//close Icon Aberto
			
			//Icon Fechado
			btFechado			= new JButton(iconFechado);
			btLEFechado			= new JButton(iconFechado);
			btPFechado			= new JButton(iconFechado);
			btVFechado			= new JButton(iconFechado);
			//Close Icon Fechado 
				
			//BtExibe
			btExibe		   		= new JButton("Exibir");
			btLEExibe			= new JButton("Exibir");
			btPExibe			= new JButton("Exibir");
			btVExibe			= new JButton("Exibir");
			//Close BtExibe
			
			//Criar Baralho
			btCriaBaralho  		= new JButton("Criar Baralho");
			btLECriaBaralho  	= new JButton("Criar Baralho");
			btPCriaBaralho  	= new JButton("Criar Baralho");
			btVCriaBaralho  	= new JButton("Criar Baralho");
			//Close btCriarBaralho
			
			//Embaralhar
			btEmbaralha    		= new JButton("Embaralhar");
			btLEEmbaralha    	= new JButton("Embaralhar");
			btPEmbaralha    	= new JButton("Embaralhar");
			btVEmbaralha    	= new JButton("Embaralhar");
			//Close Embaralhar
			
			//Limpar
			btZeraTudo	   		= new JButton("Limpar");
			btLEZeraTudo	   	= new JButton("Limpar");
			btPZeraTudo	   		= new JButton("Limpar");
			btVZeraTudo	   		= new JButton("Limpar");
			//Close btlimpar
				
			
	//Borda para o baralho com sistema de Array List------------------------------------------				
		bar = new baralhoarray();
		morto.clear();
				
		JPanel ARR = new JPanel(new FlowLayout());
		JPanel aux   = new JPanel(new FlowLayout());
		
		aux.add(btFechado);
		aux.add(btAberto);
		ARR.add(aux,BorderLayout.WEST);
		
		//JPanel para posição 2,1 no grid layout
		JPanel Pgrid = new JPanel(new GridLayout(5,1));
		Pgrid.add(btExibe);
		Pgrid.add(btCriaBaralho);
		Pgrid.add(btEmbaralha);
		Pgrid.add(btZeraTudo);
		
		ARR.add(Pgrid);
		ARR.setBorder(borda);
		
		principal.add(ARR);
		add(principal);
		
//Borda para o baralho com sistema de Lista Encadeada------------------------------------------	
		Border bordaLE = BorderFactory.createTitledBorder(BAR, "Lista Encadeada");
		JPanel LE 	  = new JPanel(new FlowLayout());
		JPanel auxLE  = new JPanel(new FlowLayout());
		
		barLE = new baralhoLE();

		
		auxLE.add(btLEFechado);
		auxLE.add(btLEAberto);
		LE.add(auxLE,BorderLayout.WEST);
		
		JPanel PgridLE = new JPanel(new GridLayout(4,1));
		PgridLE.add(btLEExibe);
		PgridLE.add(btLECriaBaralho);
		PgridLE.add(btLEEmbaralha);
		PgridLE.add(btLEZeraTudo);
		
		LE.add(PgridLE);
		LE.setBorder(bordaLE);
		
		principal.add(LE);
		add(principal);

//Borda para o baralho com sistema de Pilha------------------------------------------	
		Border bordaP = BorderFactory.createTitledBorder(BAR, "Pilha");
		JPanel P 	  = new JPanel(new FlowLayout());
		JPanel auxP   = new JPanel(new FlowLayout());
		
		barP = new baralhopilha();
		
		auxP.add(btPFechado);
		auxP.add(btPAberto);
		P.add(auxP,BorderLayout.WEST);
		
		JPanel PgridP = new JPanel(new GridLayout(4,1));
		PgridP.add(btPExibe);
		PgridP.add(btPCriaBaralho);
		PgridP.add(btPEmbaralha);
		PgridP.add(btPZeraTudo);
				
		P.add(PgridP);
		P.setBorder(bordaP);
				
		principal.add(P);
		add(principal);

//Borda para o baralho com sistema de Vetor------------------------------------------	
		Border bordaV = BorderFactory.createTitledBorder(BAR, "Vetor");
		JPanel V 	  = new JPanel(new FlowLayout());
		JPanel auxV   = new JPanel(new FlowLayout());
						
		barV = new baralhovetor();
		
		auxV.add(btVFechado);
		auxV.add(btVAberto);
		V.add(auxV,BorderLayout.WEST);
				
		JPanel PgridV = new JPanel(new GridLayout(4,1));
		PgridV.add(btVExibe);
		PgridV.add(btVCriaBaralho);
		PgridV.add(btVEmbaralha);
		PgridV.add(btVZeraTudo);
		
		V.add(PgridV);
		V.setBorder(bordaV);
						
		principal.add(V);
		add(principal);
		
		
		
//Indicando quais botões irão receber ações--------------
		
		//btFechado
		btFechado.addActionListener(this);
		btLEFechado.addActionListener(this);
		btPFechado.addActionListener(this);
		btVFechado.addActionListener(this);
		//Close btFechado
		
		//btCriaBaralho
		btCriaBaralho.addActionListener(this);
		btLECriaBaralho.addActionListener(this);
		btPCriaBaralho.addActionListener(this);
		btVCriaBaralho.addActionListener(this);
		//Close btCriaBaralho
		
		//BtExibe
		btExibe.addActionListener(this);
		btLEExibe.addActionListener(this);
		btPExibe.addActionListener(this);
		btVExibe.addActionListener(this);
		//Close btExibe
		
		//btEmbaralha
		btEmbaralha.addActionListener(this);
		btLEEmbaralha.addActionListener(this);
		btPEmbaralha.addActionListener(this);
		btVEmbaralha.addActionListener(this);
		//Close btEmbaralha
		
		//btZeraTudo
		btZeraTudo.addActionListener(this);
		btLEZeraTudo.addActionListener(this);
		btPZeraTudo.addActionListener(this);
		btVZeraTudo.addActionListener(this);
		//Close btZeraTudo
		
//Close Indicação de quais botões irão receber ações
		
	}
	
	//AÇÕES DOS BOTÕES DA CARTOLINA SUL 
	//Botões Criar Baralho--Embaralhar--Limpar--Exibir
	@Override
	
//BOTÕES DO BARALHO ARRAY LIST
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		//Ação Botão Criar Baralho
		if(e.getSource()==btCriaBaralho)
		{
			bar.zeraBaralho();
			morto.clear();
			bar = new baralhoarray();
			btFechado.setIcon(iconFechado);
			btAberto.setIcon(iconVazio);
		}
		//Ação botão Embaralhar
		if(e.getSource()==btEmbaralha)
		{
			bar.embaralha();
		}
		//Ação botão limpar
		if(e.getSource()==btZeraTudo)
		{
			bar.zeraBaralho();
			btFechado.setIcon(iconVazio);
			btAberto.setIcon(iconVazio);
		}
		//Ação botão exibir
		if(e.getSource()==btExibe)
		{
			String saida = bar.toString();
			JOptionPane.showMessageDialog(null,saida);
		}
		
		if(e.getSource()==btFechado)
		{
			if(bar.qtdCartas() > 0)
			{
				c = bar.getCarta(0);
				
				if(bar.qtdCartas() == 0) 
				{
					btFechado.setIcon(iconVazio);
				}
				String imagem;
				imagem = c.getImagem();
				iconAberto = new ImageIcon(getClass().getResource("Baralho/"+imagem));
				btAberto.setIcon(iconAberto);
				
			}
		}

//CLOSE BOTÕES DO ARRAYLIST
		
//BOTÕES DA LISTA ENCADEADA
		if(e.getSource()==btLECriaBaralho)
		{
			barLE.zeraBaralhoLE();
			morto.clear();
			barLE = new baralhoLE();
			btLEFechado.setIcon(iconFechado);
			btLEAberto.setIcon(iconVazio);
		}
		//Ação botão Embaralhar
		if(e.getSource()==btLEEmbaralha)
		{
			barLE.embaralhaLE();
		}
		//Ação botão limpar
		if(e.getSource()==btLEZeraTudo)
		{
			barLE.zeraBaralhoLE();
			btLEFechado.setIcon(iconVazio);
			btLEAberto.setIcon(iconVazio);
		}
		//Ação botão exibir
		if(e.getSource()==btLEExibe)
		{
			String saida = barLE.toStringLE();
			JOptionPane.showMessageDialog(null,saida);
		}
		
		if(e.getSource()==btLEFechado)
		{
			if(barLE.qtdCartasLE() > 0)
			{
				c = barLE.getCartaLE(0);
				if(barLE.qtdCartasLE() == 0) 
				{
					btLEFechado.setIcon(iconVazio);
				}
				String imagem;
				imagem = c.getImagem();
				iconAberto = new ImageIcon(getClass().getResource("Baralho/"+imagem));
				btLEAberto.setIcon(iconAberto);
				
			}
		}
//CLOSE BOTÕES DA LISTA ENCADEADA
		

//BOTÕES DA PILHA
		if(e.getSource()==btPCriaBaralho)
		{
			barP.zeraBaralhoP();
			morto.clear();
			barP = new baralhopilha();
			btPFechado.setIcon(iconFechado);
			btPAberto.setIcon(iconVazio);
		}
		//Ação botão Embaralhar
		if(e.getSource()==btPEmbaralha)
		{
			barP.embaralhaP();
		}
		//Ação botão limpar
		if(e.getSource()==btPZeraTudo)
		{
			barP.zeraBaralhoP();
			btPFechado.setIcon(iconVazio);
			btPAberto.setIcon(iconVazio);
		}
		//Ação botão exibir
		if(e.getSource()==btPExibe)
		{
			String saida = barP.toStringP();
			JOptionPane.showMessageDialog(null,saida);
		}
		
		if(e.getSource()==btPFechado)
		{
			if(barP.qtdCartasP() > 0)
			{
				c = barP.getCartaP();
				if(barP.qtdCartasP() == 0) 
				{
					btPFechado.setIcon(iconVazio);
				}
				String imagem;
				imagem = c.getImagem();
				iconAberto = new ImageIcon(getClass().getResource("Baralho/"+imagem));
				btPAberto.setIcon(iconAberto);
				
			}
		}
//CLOSE BOTÕES DA PILHA
		
//BOTÕES DO VETOR
		if(e.getSource()==btVCriaBaralho)
		{
			barV.zeraBaralhoV();
			morto.clear();
			barV = new baralhovetor();
			btVFechado.setIcon(iconFechado);
			btVAberto.setIcon(iconVazio);
		}
		//Ação botão Embaralhar
		if(e.getSource()==btVEmbaralha)
		{
			barV.embaralhaV();
		}
		//Ação botão limpar
		if(e.getSource()==btVZeraTudo)
		{
			barV.zeraBaralhoV();
			btVFechado.setIcon(iconVazio);
			btVAberto.setIcon(iconVazio);
		}
		//Ação botão exibir
		if(e.getSource()==btVExibe)
		{
			String saida = barV.toStringV();
			JOptionPane.showMessageDialog(null,saida);
		}
		
		if(e.getSource()==btVFechado)
		{
			if(barV.qtdCartasV() > 0)
			{
				c = barV.getCartaV(0);
				if(barV.qtdCartasV() == 0) 
				{
					btVFechado.setIcon(iconVazio);
				}
				String imagem;
				imagem = c.getImagem();
				iconAberto = new ImageIcon(getClass().getResource("Baralho/"+imagem));
				btVAberto.setIcon(iconAberto);
				
			}
		}
//CLOSE BOTÕES DO VETOR
		
		
		
		
		
		
		
		
	}//close Action Performad
	
	
	public static void main(String[] args)
	{
		jogo j = new jogo();
		j.setTitle("League of Runeterra");//Titulo da tela
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.pack();//Aloca o tamanho da tela com base nas coias utilizadas
		j.setLocationRelativeTo(null);//Cria a tela grafica do jogo no centro da tela
		j.setVisible(true);
	}

}
