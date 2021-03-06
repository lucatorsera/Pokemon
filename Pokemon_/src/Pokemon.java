public class Pokemon {
	private String nome;
	private int baseSpeed;
	private int tipo1, tipo2;
	private int HPmax, HPatual;
	private Ataque[] ataques;
	//private double critRate;
	//Nao vamos usar criticos
	public Pokemon(String name, int speed, int tipoA, int tipoB, int HP){
		nome = name;
		baseSpeed = speed;
		tipo1 = tipoA;
		tipo2 = tipoB;
		HPmax = HP;
		HPatual = HPmax;
	}
	public void setAtaques(Ataque[] a){
		ataques = a;
	}
	public String getNome(){
		return nome;
	}
	public int getSpeed(){
		return baseSpeed;
	}
	public int getT1(){
		return tipo1;
	}
	public int getT2(){
		return tipo2;
	}
	public void tomarDano(int dano){
		HPatual = HPatual - dano;
		if(HPatual>HPmax)
			HPatual = HPmax;
		//Curar = dano negativo, mas nao pode curar acima do mÃ¡ximo
		if(HPatual<0)
			HPatual = 0;
	}
	public int getHP(){
		return HPatual;
	}
	public int getHPmax(){
		return HPmax;
	}
	public Ataque getAtaque(int i){
		if(i<0||i>=4)
			return null;
		return ataques[i];
	}
}

//crit rate = baseSpeed*100/512

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

*/
