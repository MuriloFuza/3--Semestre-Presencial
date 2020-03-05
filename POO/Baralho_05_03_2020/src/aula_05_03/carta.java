package aula_05_03;

public class carta 
{
	private String imagem;
	private int numero;
	private char nipe;
	
	public carta()//Construtor para incializar o projeto "zerado"
	{
		this.imagem = "Baralho/fechado.PNG";
		this.numero = 0;
		this.nipe = 'o';
	}
	
	public carta(String nomeimagem, int num, char m)//construtor para carregar os dados das cartas
	{
		this.imagem = nomeimagem;
		this.numero = num;
		this.nipe   = m;
	}
	
	//Criar gets e sets
	//Set & Get Imagem
	public void setImagem(String nomeimagem)
	{
		this.imagem = nomeimagem;
	}
	
	public String getImagem()
	{
		return this.imagem;
	}
	
	//Set & Get Numero
	public void setNumero(int num)
	{
		this.numero = num;
	}
	
	public int getNumero()
	{
		return this.numero;
	}
	
	//Set & Get Nipe
	public void setNipe(char m)
	{
		this.nipe = m;
	}
	
	public char getNipe()
	{
		return this.nipe;
	}
	
	//toString
	public String toString()
	{
		String frase = "";
		switch(this.nipe)
		{
		case 'o':
			frase = "Ouro";
			break;
			
		case 'e':
			frase = "Espadas";
			break;
		
		case 'p':
			frase = "Paus";
			break;
		
		case 'c':
			frase = "Copas";
			
		default: 
			frase = "Nulo";
			break;
		}//close switch Nipe
		
		switch(this.numero)
		{
		case 1:
			frase += "AS";
			break;
			
		case 11:
			frase += "Valete";
			break;
			
		case 12:
			frase += "Dama";
			break;
			
		case 13:
			frase += "Rei";
			break;
			
		default:
			frase += "-- Nro:"+String.format("%d\n",this.numero);
			break;
		}//close switch Numeros Especiais
		return frase;
	}//close toString 
}//close class carta
