
public class Item extends Evento{
	int DiferencaHP;
	public void action(Pokemon ativo){
		DiferencaHP = ativo.getHPmax() -ativo.getHP();
		ativo.tomarDano(-50);
	}
	public String description(Pokemon ativo, Treinador player){
		int healEfetivo;
		if(DiferencaHP>=50)
			healEfetivo = 50;
		else
			healEfetivo = DiferencaHP;
		String res = new String();
		res = player.getNome() + " usou uma poção de cura! " + ativo.getNome + " curou-se em " + healEfetivo + "!";
		if(ativo.getHP()==ativo.getHPmax())
			res+= " " + ativo.getNome() + " está completamente curado.";
		return res;
	}
}
