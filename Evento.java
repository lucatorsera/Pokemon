abstract public class Evento {
	private int prioridade;
	private boolean valido;
	public Evento(int p){
		prioridade = p;
	}
	public void setPrioridade(int p){
		prioridade = p;
	}
	public int getPrioridade(){
		return prioridade;
	}
	public boolean ehValido(){
		return valido;
	}
	abstract public void action(Treinador ativo, Treinador oponente);
	abstract public String description(Treinador ativo);
}
