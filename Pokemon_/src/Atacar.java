/* class Ataque{
	private String nome;
	private int tipo;
	private int danoBase;
	private int dano;
	private double modificador;
	private boolean critico;
	private boolean matou;
	public Ataque(String name, int type, int dmg){
		nome = name;
		tipo = type;
		danoBase = dmg;
	}
	//Vamos assumir que ativo esta vivo
	public void action(Pokemon ativo, Pokemon oponente){
		dano = danoBase;
		if(this.tipo==ativo.getT1() || this.tipo==ativo.getT2())
			dano = (dano*3)/2; //Ver STAB na Bulbapedia
		modificador = 1;
		modificador = tabela[this.tipo][oponente.getT1()]*tabela[this.tipo][oponente.getT2()];
		dano = (int)(dano*modificador);
		critico = false;
		//Se o programa pudesse ter aleatoriedade, implementariamos ataques criticos
		if(critico)
			dano *= 2;
		oponente.tomarDano(dano);
		matou = (oponente.getHP() == 0);
	}
	public String description(Pokemon ativo){
		String res = new String();
		res = ativo.getNome() + " usou " + this.nome + "!";
		if(critico)
			res += " Ataque critico!";
		if(modificador>1.0)
			res += " Foi super efetivo!";
		if(modificador<1.0){
			if(modificador==0)
				res += " Mas o ataque nao teve efeito...";
			else
				res += " Nao foi muito efetivo...";
		}
		if(dano==0)
			res += " Nada aconteceu.";
		else
			res += " " + dano + " de dano!";
		if(matou)
			res += "\nO pokemon oponente desmaiou!";
		return res;
	}
	private static final double[][] tabela = {
			{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
			{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
			{1.0, 2.0, 1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 0.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0},
			{1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0},
			{1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0},
			{1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0},
			{1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0},
			{1.0, 1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0},
			{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0},
			{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 2.0, 0.5},
			{1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5},
			{1.0, 1.0, 1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5},
			{1.0, 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5},
			{1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0},
			{1.0, 1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0},
			{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0}
			
			/*Tipos
			0 = null
			1 = normal
			2 = fighting
			3 = flying
			4 = poison
			5 = ground
			6 = rock
			7 = bug
			8 = ghost
			9 = fire
			10 = water
			11 = grass
			12 = electric
			13 = psychic
			14 = ice
			15 = dragon

			Usamos a type chart da Geracao 1 de Poekemon, que é diferente da chart de outras geracoes
			O "null" representa a ausencia de um tipo
			*/
	};
}
*/
public class Atacar extends Evento{
	private Ataque atk;
	private int qual;
	public Atacar(int q){
		super(4);
		qual = q;
	}
	public void action(Treinador ativo, Treinador oponente){
		atk = ativo.pokemonAtivo().getAtaque(qual);
		atk.action(ativo.pokemonAtivo(), oponente.pokemonAtivo());
	}
	public String description(Treinador ativo){
		return atk.description(ativo.pokemonAtivo());
	}
}
