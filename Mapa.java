package Ex_02;

public class Mapa {
	private static int m[][] = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0}};
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
	
	public int ehGramado (int m[][], int v[]){
		int i, j;
		i = v[0];
		j = v[1];
		if (m[i][j] == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int[] getPosition(){
		return position;
	}
	
	public void encontro(Treinador player){
		Pokemon[] mons = new Pokemon[1]
		mons[0] = new Pokemon("Rattata", 72, 1, 0, 30);
		Ataque[] atks = new Ataque[3];
		Ataque[0] = new Ataque("Tackle", 1, 35);
		Ataque[1] = new Ataque("Quick Attack", 1, 40);
		Ataque[2] = new Ataque("Swift", 1, 60);
		mons[0].setAtaques(atks);
		Treinador opp = new Treinador("WILD RATTATA", mons);
		Controlador c;
		Treinador[] treinadores = new Treinador[2];
		treinadores[0] = player;
		treinadores[1] = opp;
		c.run(treinadores);
	}
	
	public static void main(String[] args) {
		Mapa map = new Mapa();
		
		if (map.ehGramado(m, position)){
				double rand = Math.random();
				if (rand < 0.2){
					map.encontro(); // encontrou pokemon selvagem
				}
			}
		}
	

}
