public class Mapa {
	private static int m[][] = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0},
								{0, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 0, 0}};
	private static int position[] = {0, 0};
	 
	public void mov (int direcao, int m[][], int v[]){
		int i, j;
		i = v[0];
		j = v[1];
		if (direcao == 1){             // esquerda
			if (j == 0){
				System.out.println ("Fim do mapa. Escolha outra direção");
			}
			else {
				v[1]--;
			}
		}
		if (direcao == 2){            // direita
			if (j == m[i].length) {
				System.out.println ("Fim do mapa. Escolha outra direção.");
			}
			else {
				v[1]++;
			}
		}
		if (direcao == 3){            // cima
			if (i == 0){
				System.out.println ("Fim do mapa. Escolha outra direção.");
			}
			else {
				v[0]--;
			}
		}
		if (direcao == 4){            // baixo
			if (i == m.length){
				System.out.println ("Fim do mapa. Escolha outra direção.");
			}
			else {
				v[0]++;
			}
		}
	}
	
	public boolean ehGramado (int m[][], int v[]){
		int i, j;
		i = v[0];
		j = v[1];
		if (m[i][j] == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public int[] getPosition(){
		return position;
	}
	
	public void encontro(Treinador player){
		Pokemon[] mons = new Pokemon[1];
		mons[0] = new Pokemon("Rattata", 72, 1, 0, 30);
		Ataque[] atks = new Ataque[3];
		atks[0] = new Ataque("Tackle", 1, 35);
		atks[1] = new Ataque("Quick Attack", 1, 40);
		atks[2] = new Ataque("Swift", 1, 60);
		mons[0].setAtaques(atks);
		Treinador opp = new Treinador("WILD RATTATA", mons);
		Controller c = new Controller();
		Treinador[] treinadores = new Treinador[2];
		treinadores[0] = player;
		treinadores[1] = opp;
		c.run(treinadores, true);
	}
	
	public static void main(String[] args) {
		Mapa map = new Mapa();
		Pokemon[] pokemons = new Pokemon[2];
		pokemons[0] = new Pokemon("Bulbasaur", 45, 11, 4, 95);
		pokemons[1] = new Pokemon("Rhydon", 40, 5, 6, 160);
		Ataque atks[] = new Ataque[1];
		atks[0] = new Ataque("Tackle", 1, 35);
		pokemons[0].setAtaques(atks);
		pokemons[1].setAtaques(atks);
		Treinador player = new Treinador("Young Red", pokemons);
		int direction;
		while (true){	
			direction =  1 + (int)(Math.random() * (4 - 1) + 1);          // a cada rodada a dire��o � aleat�ria
			map.mov(direction, m, position);
			if (map.ehGramado(m, position)){
				double rand = Math.random();
				if (rand < 0.2){
					map.encontro(player); // encontrou pokemon selvagem
					break;
				}
			}
		}
	}	
}
