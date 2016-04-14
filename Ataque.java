class Ataque{
	private String nome;
	private int tipo;
	private int danoBase;
	private int dano;
	private double modificador;
	private boolean critico;
	public Ataque(String name, int type, int dmg){
		nome = name;
		tipo = type;
		setPrioridade(4);
		danoBase = dmg;
	}
	//Vamos assumir que ativo está vivo
	public void action(Pokemon ativo, Pokemon oponente){
		dano = danoBase;
		if(this.tipo==ativo.getT1() || this.tipo==ativo.getT2())
			dano = dano*3/2; //Ver STAB na Bulbapedia
		modificador = tabela[this.tipo][oponente.getT1()]*tabela[this.tipo][oponente.getT2()];
		dano = dano*modificador;
		critico = false;
		//Se o programa pudesse ter aleatoriedade, implementariamos ataques criticos
		if(critico)
			dano *= 2;
		oponente.tomarDano(dano);
	}
	public String description(Pokemon ativo){
		String res = new String();
		res = ativo.getNome() + " usou " + this.nome + "!";
		if(critico)
			res += " Ataque crítico!";
		if(modificador>1.0)
			res += " Foi super efetivo!";
		if(modificador<1.0){
			if(modificador==0)
				res += " Mas o ataque nao teve efeito...";
			else
				res += " Não foi muito efetivo...";
		}
		if(dano==0)
			res += " Nada aconteceu.";
		else
			res += " " + dano + " de dano!";
		return res;
	}
}

public class Atacar extends Evento{
	
}