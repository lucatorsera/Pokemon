
public class Fugir extends Evento{
	public void action(Treinador ativo){
		int i;
		for(i=0; i<6; i++){
			if(ativo.getPokemon(i)!=null)
				ativo.getPokemon(i).tomarDano(999999);
		}
	}
	public String description(Treinador ativo){
		return ativo.getNome() + " fugiu da batalha!";
	}
}
