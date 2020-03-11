package trabAvaliativo;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;


public class baralhovetor 
{
	private Vector<carta>baralhoV = new Vector<carta>();
	
	//criando o baralho
	public baralhovetor()
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
				baralhoV.add(c);
			}//close for numcarta
		}//close for nipe
	}//close construtor baralho
	
	public void setBralhoV(Vector<carta>v)
	{
		this.baralhoV = v;
	}
	
	public void zeraBaralhoV()
	{
		baralhoV.clear();
	}
	
	public void adicionaV(carta v)//adiciona cartas no baralho
	{
		baralhoV.add(v);
	}
	
	public int qtdCartasV()//retorna o numero de cartas no baralho
	{
		return baralhoV.size();
	}

	public void embaralhaV()
	{
		Collections.shuffle(baralhoV);
	}
	
	public carta getCartaV(int posicao)//remover carta do vetor
	{
		carta v = baralhoV.get(posicao);
		baralhoV.remove(posicao);
		return v;
	}
	
	public String toStringV()//remover todas as cartas do vetor
	{
		String frase ="---BARALHO---\n";
		for(carta v:baralhoV)//este for utiliza a localização do ponteiro no vetor para se locomover
		{
			frase += v.toString();
		}
		return frase;
	}
	
}//close class baralho
