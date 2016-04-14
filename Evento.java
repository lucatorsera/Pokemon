
abstract public class Evento {
	private int prioridade;
	private boolean valido;
	public void setPrioridade(int p){
		prioridade = p;
	}
	public boolean ehValido(){
		return valido;
	}
	abstract public void action(Treinador ativo, Treinador oponent, int qual);
	abstract public String description(Treinador ativo);
}