import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.List;
import java.util.ArrayList;

public class TelaGrafica extends JFrame implements ActionListener{

	JButton btmInsere, btmExibe;//Botões
	JTextField txtnome, txtdia, txtmes, txtano;//Caixa de inserção
	JLabel entranome;//Caixa de dialogo
	List<Pessoa>lista = new ArrayList<Pessoa>();
	
	public TelaGrafica()//'Bob' o Construtor da tela gráfica
	{
		setLayout(new BorderLayout());
		//Botões - Legendas
		btmInsere = new JButton("Insere");
		btmExibe = new JButton("Exibe");
		
		//Cartolina de cima
		JPanel cima = new JPanel(new FlowLayout());
		entranome = new JLabel("Entre com o nome");
		txtnome = new JTextField();
		txtnome.setColumns(15);
		
		cima.add(entranome);
		cima.add(txtnome);
		
		add(cima, BorderLayout.NORTH);
		
		//Cartolina de centro
		JPanel centro = new JPanel(new FlowLayout());
		txtdia = new JTextField(3);
		
		txtmes = new JTextField(3);

		txtano = new JTextField(4);

		
		centro.add(txtdia);
		centro.add(txtmes);
		centro.add(txtano);
		
		//Avisando que o botão deve funcionar
		btmInsere.addActionListener(this);
		btmExibe.addActionListener(this);
		
		//Criando as bordas
		Border b1 = BorderFactory.createEtchedBorder();
		Border b2 = BorderFactory.createTitledBorder("Data De Nascimento");
		centro.setBorder(b2);
		add(centro, BorderLayout.CENTER);
		
		
		//Criando cartolia Sul
		JPanel sul = new JPanel(new FlowLayout());
		sul.add(btmInsere);
		sul.add(btmExibe);
		
		add(sul, BorderLayout.SOUTH);
	}//Close TelaGrafica -- Construtor
	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btmInsere)
		{
			int dia,mes,ano;
			String nome;
			
			nome = txtnome.getText();//A variavel nome ia pegar o conteudo da caixa txtnome
			try
			{
				dia = Integer.parseInt(txtdia.getText());
				mes = Integer.parseInt(txtmes.getText());
				ano = Integer.parseInt(txtano.getText());
				
			}catch(NumberFormatException erro)//alem dos erros de letras vai e enfia um 13 pra sacanear (só lembrando que achar alguém que faz isso mata pra evitar se reproduzir)
				{
					dia = 1;
					mes = 1;
					ano = 1990;
				}
			Pessoa p = new Pessoa(nome,dia,mes,ano);//o p de Pessoa ja sera criado com os dados inseridos acima
			p.verificaSigno();//verifica o signo e carrega em p
			lista.add(p);//adiciona p na lista
			JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
			
			/*
			 * apaga o que estava inserido nas caixa de 
			 * dialogo e deixa as mesmas limpas para
			 * uma nova inserção.
			 */
			txtnome.setText("");
			txtdia.setText("");
			txtmes.setText("");
			txtano.setText("");
		}//close comandos do botão insere
		
		
		if(e.getSource() == btmExibe)
		{
			String texto = "";
			for(Pessoa p:lista)
			{
				texto += String.format("\n %s",p.toString());
			}
			JOptionPane.showMessageDialog(null,texto);//Depois do texto todo carregado exibe apenas uma vez;
		}//close comandos do botão exibe
	}//Close actionPerfomad
	
	
	
	public static void main(String[]args)
	{
		TelaGrafica tela = new TelaGrafica();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setSize(310,150);//Tamanho da tela
		tela.setLocation(500,300);//Cordenadas onde a tela sera iniciada na sua tela
		tela.setVisible(true);//A tela deve ser visivel	
	}//close main
}//close class TelaGrafica
