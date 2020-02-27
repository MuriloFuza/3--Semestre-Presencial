import java.util.Calendar;

// O * serve para carregar todas as bibliotecas
public class Pessoa {
		private String nome;
		private int dianasc, mesnasc, anonasc;
		private String signo;
		
		//NA PROVA SERA COBRADO UM CONSTRUTOR QUE ZERA E UM QUE INSERE
		//NA PROVA SERA COBRADO GET E SET DE TODAS AS VARIAVEIS
		//construtor para iniciar zerado os dados dos usuario
		public Pessoa() 
		{
			this.nome = "";
			this.dianasc = 0;
			this.mesnasc = 0;
			this.anonasc = 0;
			this.signo = "";
		}
		//construtor utilizado para receber os dados do principal
		public Pessoa(String n, int d, int m, int a)
		{
			this.nome = n;
			this.dianasc = d;
			this.mesnasc = m;
			this.anonasc = a;
		}
		
		//metodo GET & SET
		public String getNome()//get para pegar o nome
		{
			return(this.nome);
		}
		public void SetNome(String n)//SET para carregar o n em .nome
		{
			this.nome = n;
		}
		//fecha GET & SET NOME
		
		//GET & SET DIA DE NASCIMENTO
		public int getDiaNasc()//get para pegar o dia de nascimento
		{
			return(this.dianasc);
		}
		public void setDiaNasc(int d)
		{
			this.dianasc = d;
		}
		//Fecha GET & SET DIA de nascimento
		
		//GET & SET MES DE NASCIMENTO
		public int getMesNasc()//get para pegar o mes de nascimento
		{
			return(this.mesnasc);
		}
		public void setMesNasc(int m)
		{
			this.mesnasc = m;
		}
		//Fecha GET & SET Mes de nascimento

		//GET & SET Ano de nascimento
		public int getAnoNasc()
		{
			return(this.anonasc);
		}
		public void setAnoNasc(int a)
		{
			this.anonasc = a;
		}
		//Fecha GET & SET Ano de nascimento
		
		//GET & SET SIGNO
		public String getSigno()
		{
			return(this.signo);
		}
		public void setSigno(String signo)
		{
			this.signo = signo;
		}
	
		
		public String toString()
		{
			String saida = "";
			saida = String.format("\n %s - %d-%d-%d - %s",this.nome,this.dianasc,this.mesnasc,this.anonasc,this.signo);
			return saida;
		}
		
		public int CalculaIdade()//metodo para calcular a idade do usuario
		{
			int idade = 0;
			Calendar datagora;
			datagora = Calendar.getInstance();//Pega a data do sistema
			int diagora = datagora.get(Calendar.DAY_OF_MONTH);
			int mesgora = datagora.get(Calendar.MONTH);
			int anogora = datagora.get(Calendar.YEAR);
			if((this.mesnasc > mesgora) || (this.mesnasc == mesgora) && (this.dianasc > diagora))
			{
				idade = anogora - this.anonasc -1;
			}
			else
			{
				idade = anogora - this.anonasc;
			}
			return idade;
		}//Close Calcula idade
		
		public void verificaSigno()
		{
			switch(mesnasc)
			{
				case 1:
				{
					if(dianasc < 20)
						this.signo = "Capricornio";
					else
						this.signo = "Aquario";
					break;
				}
				case 2:
				{
					if(dianasc < 20)
						this.signo = "Aquario";
					else
						this.signo = "Peixes";
					break;
				}
				case 3:
				{
					if(dianasc < 20)
						this.signo = "Peixes";
					else
						this.signo = "Aries";
					break;
				}
				case 4:
				{
					if(dianasc < 20)
						this.signo = "Aries";
					else
						this.signo = "Touro";
					break;
				}
				case 5:
				{
					if(dianasc < 20)
						this.signo = "Touro";
					else
						this.signo = "Gemeos";
					break;
				}
				case 6:
				{
					if(dianasc < 20)
						this.signo = "Gemeos";
					else
						this.signo = "Cancer";
					break;
				}
				case 7:
				{
					if(dianasc < 20)
						this.signo = "Cancer";
					else
						this.signo = "Leão";
					break;
				}
				case 8:
				{
					if(dianasc < 20)
						this.signo = "Leão";
					else
						this.signo = "Virgem";
					break;
				}
				case 9:
				{
					if(dianasc < 20)
						this.signo = "Virgem";
					else
						this.signo = "Libra";
					break;
				}
				case 10:
				{
					if(dianasc < 20)
						this.signo = "Libra";
					else
						this.signo = "Escopião";
					break;
				}
				case 11:
				{
					if(dianasc < 20)
						this.signo = "Escorpião";
					else
						this.signo = "Sagitário";
					break;
				}
				case 12:
				{
					if(dianasc < 20)
						this.signo = "Sagitário";
					else
						this.signo = "Capricornio";
					break;
				}
			}//close switch
		}//close class verificaSigno
		
}//Close class Pessoa

