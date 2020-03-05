package aula_05_03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class jogo extends JFrame implements ActionListener{

	baralho bar;
	List<carta> morto = new ArrayList<carta>();
	carta c;
	
	//Bot�es e Icon
	JButton btFechado, btAberto;
	Icon iconFechado, iconAberto, iconVazio;
	JButton btCriaBaralho, btEmbaralha, btZeraTudo, btExibe;
	
	public jogo()//construtor
	{
		setLayout(new BorderLayout());
		
		//monstando icones
		iconFechado = new ImageIcon(getClass().getResource("Baralho/fechado.png"));
		iconVazio 	= new ImageIcon(getClass().getResource("Baralho/fechado2.png"));
		//montando bot�es
		btFechado	= new JButton(iconFechado);
		btAberto	= new JButton(iconVazio);
		
		bar = new baralho();
		morto.clear();
		
		//CRIANDO O PAINEK DO CENTRO ONDE V�O ESTAR AS CARTAS
		JPanel painelcentro = new JPanel(new GridLayout(1,2));
		painelcentro.add(btFechado);
		painelcentro.add(btAberto);
		add(painelcentro, BorderLayout.CENTER);
		
		//CRIANDO O PAINEL DO SUL ONDE V�O ESTAR OS BOT�ES DE CRIAR, EMBARALHAR, LIMPAR E EXIBIR
		JPanel painelsul = new JPanel(new FlowLayout());
			//criando os bot�es
			btCriaBaralho  = new JButton("Criar Baralho");
			btEmbaralha    = new JButton("Embaralhar");
			btZeraTudo	   = new JButton("Limpar");
			btExibe		   = new JButton("Exibir");
			//
		painelsul.add(btCriaBaralho);
		painelsul.add(btEmbaralha);
		painelsul.add(btZeraTudo);
		painelsul.add(btExibe);
		
		add(painelsul, BorderLayout.SOUTH);
		
		btFechado.addActionListener(this);
		btCriaBaralho.addActionListener(this);
		btEmbaralha.addActionListener(this);
		btZeraTudo.addActionListener(this);
		btExibe.addActionListener(this);
	}
	
	//A��ES DOS BOT�ES DA CARTOLINA SUL 
	//Bot�es Criar Baralho--Embaralhar--Limpar--Exibir
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		//A��o Bot�o Criar Baralho
		if(e.getSource()==btCriaBaralho)
		{
			bar.zeraBaralho();
			morto.clear();
			bar = new baralho();
			btFechado.setIcon(iconFechado);
			btAberto.setIcon(iconVazio);
		}
		//A��o bot�o Embaralhar
		if(e.getSource()==btEmbaralha)
		{
			bar.embaralha();
		}
		//A��o bot�o limpar
		if(e.getSource()==btZeraTudo)
		{
			bar.zeraBaralho();
			btFechado.setIcon(iconVazio);
			btAberto.setIcon(iconVazio);
		}
		//A��o bot�o exibir
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
