import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * Usar BorderLayout e Grid
 * Duas Cartolinas(JPanel) Utilizando apenas CENTER e SOUTH
 * Grid Sul com 2 linhas e 2 colunas
 * Grid Centro com 2 linhas e 2 colunas, uma para Dialogo e outra para Inserção e result
 * */
public class Atvtexto extends JFrame implements ActionListener{

	
	JButton btTam;
	JButton btMas;
	JButton btMinus;
	JButton btLimpar;
	
	JLabel tx1, tx2;
	JTextField texto1, texto2;
	public void actionPerformed(ActionEvent e) {
		
		String t1;
		if(e.getSource()==btLimpar)
		{
			texto1.setText("");
			texto2.setText("");
		}
		else if(e.getSource()==btMas)
		{
			t1 = texto1.getText();
			texto1.setText(String.format("%s", t1.toUpperCase()));
		}
		else if(e.getSource()==btTam)
		{
			int tam = texto1.getText().length();
			texto2.setText(String.format("%d",tam));
		}
		else if(e.getSource()==btMinus)
		{
			t1 = texto1.getText();
			texto1.setText(String.format("%s", t1.toLowerCase()));
		}
		
	}//close action

	
	//constructor
	public Atvtexto() 
	{
		setLayout( new BorderLayout());
		btTam = new JButton("Tamanho");
		btMas = new JButton("Maiusculo");
		btMinus = new JButton("Minusculo");
		btLimpar = new JButton("Limpar");
		
		//Criando cartolina Centro;
		JPanel centro  = new JPanel(new GridLayout(2,2));
		tx1 = new JLabel("Digite um texto ", SwingConstants.RIGHT);
		tx2 = new JLabel("Tamanho ", SwingConstants.RIGHT);
		
		texto1 = new JTextField(100);
		texto2 = new JTextField(100);
		
		centro.add(tx1);
		centro.add(texto1);
		centro.add(tx2);
		centro.add(texto2);
		
		add(centro, BorderLayout.CENTER);
		
		JPanel sul = new JPanel(new GridLayout(2,2));
		sul.add(btTam);
		sul.add(btMas);
		sul.add(btMinus);
		sul.add(btLimpar);
		
		add(sul , BorderLayout.SOUTH);
		
		//Indicando que os botões terão ações
		btLimpar.addActionListener(this);
		btMas.addActionListener(this);
		btMinus.addActionListener(this);
		btTam.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Atvtexto tela = new Atvtexto(); 
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Tela Utiliza o padrão do windows de tela gráfica;
		tela.setSize(350,230);//Definindo os pixels da tela
		tela.setLocation(500,300);//Definindo onde a tela sera criado na sua tela;
		tela.setVisible(true);//Definindo que a tela é visivel
		
	}//close main


}//close Class
