package sorteio;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JOptionPane;


public class Vetor {
		Random rd = new Random();
		ArrayList<Integer> vetor;
		boolean ordenado;
		int ponteiro; 
		
		public Vetor() {//construtor
			ordenado = false;
			vetor = new ArrayList<Integer>(); 
			ponteiro = -1;
		}
		
		public void  geracao(){
			int i,n;
			for(i=0;i<100;i++) 
				{
					n= rd.nextInt(999);
					vetor.add(n);
				}
			ordenado = false; 
		}
		
		public int buscaexaustiva(int num) 
		{
			ponteiro = 0;
			
			while(ponteiro<vetor.size()&& num != vetor.get(ponteiro))
				{
					ponteiro++;
				}
			if(ponteiro < vetor.size()&& num==vetor.get(ponteiro))
			{
				return ponteiro;
			}else
				return -1;
		}
		
		public String ToString() 
		{
			String saida = "";
			for(int i = 0;i<vetor.size()/2;i++)
				{
					saida +=String.format("\n[%d]=%3d  [%d]=%3d",i,vetor.get(i),i+50,vetor.get(i+50));
				}
			return saida;
		}
		
		public void ordena()
		{
			Collections.sort(vetor);
			ordenado = true;
		}
		
		public static void main(String[] args) 
		{
			Vetor v = new Vetor();// Vetor == Classe // v == Objeto
			while(true)
			{
				String opcao = JOptionPane.showInputDialog(null,"-------Classe Vetor------\n"+
						"\n(1)Gerar um vetor com 100 elementos"+
						"\n(2)Exibe o vetor"+
						"\n(3)Busca Exaustiva"+
						"\n(4)Ordena o vetor"+
						"\n(5)Sair");
				opcao = opcao.toUpperCase();
				char m = opcao.charAt(0);
				switch(m) 
				{
				case '1':v.geracao();
					break;
					
				case '2': String saida=v.ToString();
					JOptionPane.showMessageDialog(null, saida);
					break;
				case '3': String valor = JOptionPane.showInputDialog(null,"Entre com um numero:");
					int num = Integer.parseInt(valor);
					int posicao = v.buscaexaustiva(num);
					if(posicao==-1)
					{
						saida="Nâo achou";
					}else
					{
						saida = String.format("Achou o Elemento na posição %d",posicao);
						JOptionPane.showMessageDialog(null, saida);
					}
					break;
				case '4':v.ordena();
					break;
					
				case '5':
					System.exit(0);
					break;
				}//close switch
			}//close while
		}//close main
		
}//close class
