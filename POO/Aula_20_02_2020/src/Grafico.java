									

									//Tema do dia:: Tela Gráfica

//Só apagar os comentarios e utilizar os métodos de Layout

import java.awt.BorderLayout; //Trabalha com cinco áreas da tela, Norte, Centro, Oeste, Leste e SUL
import java.awt.GridLayout; /*Trabalha com uma grade, por exemplo uma grade de 5 linhas por 3 colunas 
e um espaço de pixels entre linhas e colunas*/
import java.awt.FlowLayout; // "Vai inserindo e seja o que Deus quiser" - Liliane 2019;
import javax.swing.JButton;   
import javax.swing.JFrame; 

public class Grafico extends JFrame {
	
	private JButton btEsq = new JButton("Esq");
	private JButton btDir = new JButton("Dir");
	private JButton btCnt = new JButton("Cnt");
	
	private JButton btOeste = new JButton("Oeste");
	private JButton btLeste = new JButton("Leste");

	
	/*						EXEMPLO DE CONSTRUTOR COM FLOWLAYOUT
	public Grafico() 
	{
		setLayout(new FlowLayout());
		add(btEsq);
		add(btDir);
		add(btCnt);
	}//Close Public Grafico Constructor FlowLayout
	*/
	
	/*						EXEMPLO DE CONSTRUTOR COM GRIDLAYOUT
	public Grafico() 
	{
		setLayout(new GridLayout(3,2));
		add(btEsq);
		add(btCnt);
		add(btDir);
		add(btOeste);
		add(btLeste);
	}//Close Public Grafico Constructor GridLayout
	*/
	
	/*						EXEMPLO DE CONSTRUTOR COM BORDERLAYOUT
	public Grafico() 
	{
		setLayout(new BorderLayout());//é preciso dizer em qual região o botão vai ser colocado
		add(btEsq, BorderLayout.SOUTH);
		add(btCnt, BorderLayout.CENTER);
		add(btDir, BorderLayout.NORTH); 
		add(btOeste,BorderLayout.WEST);
		add(btLeste,BorderLayout.EAST);
	}//Close Public Grafico Constructor BorderLayout
	*/
	
	
	public static void main(String[]args) {
		
		Grafico tela = new Grafico(); 
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Tela Utiliza o padrão do windows de tela gráfica;
		tela.setSize(300,200);//Definindo os pixels da tela
		tela.setLocation(500,300);//Definindo onde a tela sera criado na sua tela;
		tela.setVisible(true);//Definindo que a tela é visivel
		
		
		
		
		
		
	}//Close Main
	
}//Close Class Grafico
