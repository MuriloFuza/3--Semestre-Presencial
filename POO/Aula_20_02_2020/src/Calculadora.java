/*
 *									CALCULADORA 
 *
 *	Botões de Operação no Leste
 *	Apresentação  de Resultado na parte central da tela
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout; //Trabalha com cinco áreas da tela, Norte, Centro, Oeste, Leste e SUL
import java.awt.GridLayout; /*Trabalha com uma grade, por exemplo uma grade de 5 linhas por 3 colunas 
e um espaço de pixels entre linhas e colunas*/
import java.awt.Panel;
import javax.swing.JButton;   

public class Calculadora extends JFrame{

	JButton btSoma;//Botão +
	JButton btDif;//Botão -
	JButton btMult;//Botão *
	JButton btDiv;//Botão /
	JButton btClear;//Botão C - Limpar
	
	JLabel tx1, tx2, tx3;//Caixas de dialogo com o usuario
	JTextField textoV1, textoV2, textoR;// Caixa de inserção dos números para o cálculo 
	public Calculadora() 
	{
		setLayout(new BorderLayout());//Vamos ter apenas Centro e Leste; Utilizaremos uma Grid Dentro do Centro
		btSoma = new JButton("+");
		btDif = new JButton("-");
		btMult = new JButton("X");
		btDiv = new JButton("/");
		btClear = new JButton("Clear");
		
		//Criar uma cartolina para poder colocar diversos botões de operação em uma região da tela
		JPanel leste = new JPanel(new GridLayout(5,1));
		leste.add(btSoma);
		leste.add(btDif);
		leste.add(btMult);
		leste.add(btDiv);
		leste.add(btClear);
		//Cartolina criada com 5 linhas e apenas uma coluna
		
		//Colocando cartolina na tela
		add(leste, BorderLayout.EAST);
	//-------------------------------------------
		//Criando outra cartolina para o centro
		JPanel centro = new JPanel(new GridLayout(3,2));
		tx1 = new JLabel("Entre com o valor 1 ", SwingConstants.RIGHT);
		tx2 = new JLabel("Entre com o valor 2 ", SwingConstants.RIGHT);
		tx3 = new JLabel("Resultado ", SwingConstants.RIGHT);
		//Criando as caixinhas para o usuário digitar
		textoV1 = new JTextField(10);
		textoV2 = new JTextField(10);
		textoR  = new JTextField(10);
		//Organizando os itens na cartolina centro sempre da esquerda para direita de cima para baixo;
		centro.add(tx1);
		centro.add(textoV1);
		centro.add(tx2);
		centro.add(textoV2);
		centro.add(tx3);
		centro.add(textoR);
		//Adiconando a cartolina centro a tela
		add(centro, BorderLayout.CENTER);
	}//Close Construtor
	
	public static void main(String[]args) {
		
		Calculadora tela = new Calculadora(); 
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Tela Utiliza o padrão do windows de tela gráfica;
		tela.setSize(350,230);//Definindo os pixels da tela
		tela.setLocation(500,300);//Definindo onde a tela sera criado na sua tela;
		tela.setVisible(true);//Definindo que a tela é visivel
		
			
	}//Close Main
	
}//Close Class Calculadora
