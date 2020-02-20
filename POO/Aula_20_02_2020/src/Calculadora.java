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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;   
 
public class Calculadora extends JFrame implements ActionListener{  

	JButton btSoma;//Botão +
	JButton btDif;//Botão -
	JButton btMult;//Botão *
	JButton btDiv;//Botão /
	JButton btClear;//Botão C - Limpar
	
	JLabel tx1, tx2, tx3;//Caixas de dialogo com o usuario
	JTextField textoV1, textoV2, textoR;// Caixa de inserção dos números para o cálculo 
	
	public void actionPerformed(ActionEvent e)
 	{
		float num1, num2, resul;
		try 
		{
			num1 = Float.parseFloat(textoV1.getText());//comando para pegar o texto da caixa e tranformar em número e salva em num1;
			num2 = Float.parseFloat(textoV2.getText());//comando para pegar o texto da caixa e tranformar em número e salva em num2;
		}catch(NumberFormatException erro) 
			{
				num1 = 0;
				num2 = 0;
			}
		if(e.getSource()==btSoma)//Botão da soma foi precionado? 
		{
			//SIM
			resul = num1 + num2;
			textoR.setText(String.format("%5.2f",resul));//setText para imprimir o texto que esta contido em resul na caixa TextoR
		}else if(e.getSource()==btDif)//Botão da subtração
			{
				resul = num1 - num2;
				textoR.setText(String.format("%5.2f",resul));
			}
		else if(e.getSource()==btMult)//Botão da multiplicação
			{
				resul = num1 * num2;
				textoR.setText(String.format("%5.2f", resul));
			}
		else if(e.getSource()==btDiv)//Botão da divisão
			{
				resul = num1 / num2;
				textoR.setText(String.format("%5.2f", resul));
			}
		else if(e.getSource()==btClear)//Botão limpar a tela
			{
				textoV1.setText("");
				textoV2.setText("");
				textoR.setText("");
			}
		
	}//Close ActionPerformed 
	
	//Construtor
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
		
		//Indicando que os botões terão eventos
		btSoma.addActionListener(this);
		btDif.addActionListener(this);
		btMult.addActionListener(this);
		btDiv.addActionListener(this);
		btClear.addActionListener(this);
	}//Close Construtor
	
	public static void main(String[]args) {
		
		Calculadora tela = new Calculadora(); 
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Tela Utiliza o padrão do windows de tela gráfica;
		tela.setSize(350,230);//Definindo os pixels da tela
		tela.setLocation(500,300);//Definindo onde a tela sera criado na sua tela;
		tela.setVisible(true);//Definindo que a tela é visivel
		
			
	}//Close Main


	
}//Close Class Calculadora
