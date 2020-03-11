package trabAvaliativo;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class baralhoarray 
{
	private List<carta>baralho = new ArrayList<carta>();
	
	//criando o baralho
	public baralhoarray()
	{
		int numcarta,i;
		char nipe = 'o';
		String nome;//variavel auxiliar
		carta c; //Objeto
		
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
				c = new carta(nome,numcarta,nipe);
				baralho.add(c);
			}//close for numcarta
		}//close for nipe
	}//close construtor baralho
	
	public void setBralho(List<carta>x)
	{
		this.baralho = x;
	}
	
	public void zeraBaralho()
	{
		baralho.clear();
	}
	
	public void adiciona(carta c)//adiciona cartas no baralho
	{
		baralho.add(c);
	}
	
	public int qtdCartas()//retorna o numero de cartas no baralho
	{
		return baralho.size();
	}

	public void embaralha()
	{
		Collections.shuffle(baralho);
	}
	
	public carta getCarta(int posicao)//remover carta do vetor
	{
		carta c = baralho.get(posicao);
		
		baralho.remove(posicao);
		return c;
	}
	
	public String toString()//remover todas as cartas do vetor
	{
		String frase ="---BARALHO---\n";
		for(carta c:baralho)//este for utiliza a localização do ponteiro no vetor para se locomover
		{
			frase += c.toString();
		}
		return frase;
	}
	
}//close class baralho
