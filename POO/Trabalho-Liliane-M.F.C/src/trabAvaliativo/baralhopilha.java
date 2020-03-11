package trabAvaliativo;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;


public class baralhopilha 
{
	private Stack<carta>baralhoP = new Stack<carta>();
	
	//criando o baralho
	public baralhopilha()
	{
		int numcarta,i;
		char nipe = 'o';
		String nome;//variavel auxiliar
		carta p; //Objeto
		
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
				p = new carta(nome,numcarta,nipe);
				baralhoP.push(p);
			}//close for numcarta
		}//close for nipe
	}//close construtor baralho
	
	public void setBralhoP(Stack<carta>p)
	{
		this.baralhoP = p;
	}
	
	public void zeraBaralhoP()
	{
		baralhoP.clear();
	}
	
	public void adicionaP(carta p)//adiciona cartas no baralho
	{
		baralhoP.push(p);
	}
	
	public int qtdCartasP()//retorna o numero de cartas no baralho
	{
		return baralhoP.size();
	}

	public void embaralhaP()
	{
		Collections.shuffle(baralhoP);
	}
	
	public carta getCartaP()//remover carta do vetor
	{
		carta p = baralhoP.pop();
		return p;
	}
	
	public String toStringP()//remover todas as cartas do vetor
	{
		String frase ="---BARALHO---";
		for(carta p:baralhoP)//este for utiliza a localização do ponteiro no vetor para se locomover
		{
			frase += p.toString();
		}
		return frase;
	}
	
}//close class baralho
