
public class Treinador {
	private String nome;
	private Pokemon[] pokemons;
	public String getNome(){
		return nome;
	}
	public Pokemon getPokemon(int i){
		if(i<=6)
			return pokemons[i];
		else
			return null;
	}
	public void trocarPokemon(int i){
		Pokemon aux;
		aux = pokemons[0];
		pokemons[0] = pokemons[i];
		pokemons[i] = aux;
	}
	//
	private static int[] Ash1 = { 1, 2 };
	private static int[] Ash2 = {};
	private static int[] Gary1 = {};
	private static int[] Gary2 = {};
	static public int[] getAsh(int i){
		if(i==1)
			return Ash1;
		if(i==2)
			return Ash2;
		else
			return null;
	}
	static public int[] getGary(int i){
		if(i==1)
			return Gary1;
		if(i==2)
			return Gary2;
		else
			return null;
	}
}
