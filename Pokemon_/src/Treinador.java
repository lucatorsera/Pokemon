public class Treinador {
	private String nome;
	private Pokemon[] pokemons;
	public Treinador(String name, Pokemon[] mons){
		nome = name;
		pokemons = mons;
	}
	public String getNome(){
		return nome;
	}
	public int getNpokes(){
		return pokemons.length;
	}
	public Pokemon getPokemon(int i){
		if(i<=6)
			return pokemons[i];
		else
			return null;
	}
	public Pokemon pokemonAtivo(){
		return pokemons[0];
	}
	public void trocarPokemon(int i){
		Pokemon aux;
		aux = pokemons[0];
		pokemons[0] = pokemons[i];
		pokemons[i] = aux;
	}
	//
	private static int[] Ash1 = {0, 1, 2, 2, 1, 1, 1, 2, 1};
	private static int[] Ash2 = {0, 1, 2, 1, 1, 1, 2, 2, 0};
	private static int[] Gary1 = {0, 2, 1, 1, 2, 2, 1, 1};
	private static int[] Gary2 = {0, 1, 0, 1, 2, 1, 0, 3};
	private static int[] Red1 = {1, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 3, 3};
	private static int[] Red2 = {0, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1};
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
	static public int[] getRed(int i){
		if(i==1)
			return Red1;
		if(i==2)
			return Red2;
		else
			return null;
	}
}
