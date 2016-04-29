public class Item extends Evento{
	private int DiferencaHP;
	private int qual; //0 = item de cura, qual!=0 sao as pokebolas
	private boolean pegou;
	
	public Item(int q){
		super(3);
		qual = q;
	}
	public void action(Treinador ativo, Treinador oponente){
		if(qual==0){
			DiferencaHP = ativo.pokemonAtivo().getHPmax() -ativo.pokemonAtivo().getHP();
			ativo.pokemonAtivo().tomarDano(-50);
		}
		else{
			double catchRate = 1.0 - (double)oponente.pokemonAtivo().getHP()/oponente.pokemonAtivo().getHPmax();
			double rand = Math.random();
			if(qual==2) //Great Ball
				rand *= 1.5;
			if(rand<catchRate){
				oponente.pokemonAtivo().tomarDano(999999);
				pegou = true;
			}
			else
				pegou = false;
		}
	}
	public String description(Treinador ativo){
		String res = new String();
		if(qual==0){
			int healEfetivo;
			if(DiferencaHP>=50)
				healEfetivo = 50;
			else
				healEfetivo = DiferencaHP;
			res = ativo.getNome() + " usou uma poÃ§Ã£o de cura! " + ativo.pokemonAtivo().getNome() + " curou-se em " + healEfetivo + "!";
			if(ativo.pokemonAtivo().getHP()==ativo.pokemonAtivo().getHPmax())
				res+= " " + ativo.pokemonAtivo().getNome() + " estÃ¡ completamente curado.";
		}
		else{
			res += ativo.getNome() + " usou uma ";
			if(qual==1)
				res += "Pokebola.\n";
			else
				res += "Great Ball.\n";
			if(pegou)
				res += "O pokemon foi capturado!\n";
			else
				res += "Mas o pokemon conseguiu escapar!";
		}
		return res;
	}
}