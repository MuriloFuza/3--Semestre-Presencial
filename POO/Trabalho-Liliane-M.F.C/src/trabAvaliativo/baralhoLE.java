package trabAvaliativo;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class baralhoLE
{
	private LinkedList<carta>baralhoLE = new LinkedList<carta>();
	
	//criando o baralho
	public baralhoLE()
	{
		int numcarta,i;
		char nipe = 'o';
		String nome;//variavel auxiliar
		carta l; //Objeto
		
		for(i = 0;i < 4;i++)
		{
			switch(i)
			{
			case 0:
				nipe = 'o';
				break;
			
			case 1:
				nipe = 'e';
				break;
				
			case 2:
				nipe = 'c';
				break;
				
			case 3:
				nipe = 'p';
				break;
			}//close switch nipe

			for(numcarta = 1;numcarta <= 13; numcarta++)
			{
				nome = String.format("%d",numcarta)+"-"+nipe+".png";
				l = new carta(nome,numcarta,nipe);
				baralhoLE.add(l);
			}//close for numcarta
		}//close for nipe
	}//close construtor baralho
	
	public void setBralhoLE(LinkedList<carta>y)
	{
		this.baralhoLE = y;
	}
	
	public void zeraBaralhoLE()
	{
		baralhoLE.clear();
	}
	
	public void adicionaLE(carta l)//adiciona cartas no baralho
	{
		baralhoLE.add(l);
	}
	
	public int qtdCartasLE()//retorna o numero de cartas no baralho
	{
		return baralhoLE.size();
	}

	public void embaralhaLE()
	{
		Collections.shuffle(baralhoLE);
	}
	
	public carta getCartaLE(int posicao)//remover carta do vetor
	{
		carta l = baralhoLE.get(posicao);
		baralhoLE.remove(posicao);
		return l;
	}
	
	public String toStringLE()//remover todas as cartas do vetor
	{
		String frase ="---BARALHO---\n";
		for(carta l:baralhoLE)//este for utiliza a localização do ponteiro no vetor para se locomover
		{
			frase += l.toString();
		}
		return frase;
	}
	
}//close class baralho
