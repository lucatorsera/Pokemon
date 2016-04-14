class EventSet {
	private Evento[] events = new Evento[100];
	private int index = 0;
	private int next = 0;
	public void add(Evento e){
		if(index>=events.length)
			return;
		events[index++] = e;
	}
	public Evento getNext(){
		boolean looped = false;
		int start = next;
		do{
			next = (next+1)%events.length;
			if(start==next)
				looped = true;
			if((next == (start+1)%events.length)&&looped)
				return null;
		}while(events[next] == null);
		return events[next];
	}
	public void removeCurrent(){
		events[next] = null;
	}
	public void setEventos(int opcao1[], int opcao2[]){
		//opção1 = atacar, trocar de pokemon, item ou fugir
		//opcao2 = qual ataque ou qual pokemon
		Evento novo;
		int i;
		for(i=0; i<opcao1.length; i++){
			if(opcao1[i]==1)
				novo = new Atacar(opcao2[i]);
			if(opcao1[i]==2)
				novo = new Trocar(opcao2[i]);
			if(opcao1[i]==3)
				novo = new Item();
			if(opcao1[i]==4)
				novo = new Fugir();
			if(novo!=null)
				this.add(novo);
		}
	}
}
public class Controller {
	private EventSet[] es = new EventSet[2];
	public void run(Treinador p1, Treinador p2){
		es[0].setEventos(Treinador.getAsh(1), Treinador.getAsh(2));
		es[1].setEventos(Treinador.getGary(1), Treinador.getGary(2));
		Evento[] acao = new Evento[2];
		int vencedor = 0;
		int vaiPrimeiro;
		while(vencedor==0){
			acao[0] = es[0].getNext();
			acao[1] = es[1].getNext();
			if(acao[0]==null||acao[1]==null){
				System.out.println("Erro");
				return;
			}
			while(!acao[0].ehValido){
				acao[0] = es[0].getNext();
			}
			while(!acao[1].ehValido){
				acao[1] = es[1].getNext();
			}
			if()
		}
	}
	
}
