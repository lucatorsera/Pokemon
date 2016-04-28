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
		//opcao1 = atacar, trocar de pokemon, item ou fugir
		//opcao2 = qual ataque/pokemon/item
		Evento novo;
		int i;
		for(i=0; i<opcao1.length; i++){
			switch(opcao1[i]){
				case 1:
					novo = new Atacar(opcao2[i]);
					break;
				case 2:
					novo = new Trocar(opcao2[i]);
					break;
				case 3:
					novo = new Item(opcao2[i]);
					break;
				case 4:
					novo = new Fugir();
					break;
				default:
					novo = null;
					break;
			}
			if(novo!=null)
				this.add(novo);
		}
	}
}
public class Controller {
	private EventSet[] es;
	private Evento[] acao;
	public void run(Treinador[] player, boolean wild){
		es = new EventSet[2];
		es[0] = new EventSet();
		es[1] = new EventSet();
		acao = new Evento[2];
		if(wild)
			es[0].setEventos(Treinador.getRed(1), Treinador.getRed(2));
		else
			es[0].setEventos(Treinador.getAsh(1), Treinador.getAsh(2));
		es[1].setEventos(Treinador.getGary(1), Treinador.getGary(2));
		acao = new Evento[2];
		int vencedor = -1;
		int atual = 0;
		while(vencedor<0){
			acao[0] = es[0].getNext();  // 0 --- Ash
			acao[1] = es[1].getNext(); // 1 -- Gary
			if(wild){
				double aux = Math.random();
				if(aux<0.25)
					acao[1] = new Atacar(0);
				if(aux>=0.25&&aux<0.5)
					acao[1] = new Atacar(1);
				if(aux>=0.5&&aux<0.75)
					acao[1] = new Atacar(2);
				if(aux>=0.75)
					acao[1] = new Fugir();
			}
			if(acao[0]==null||acao[1]==null){
				System.out.println("Erro");
				return;
			}
			//Decidir quem vai primeiro
			if(acao[0].getPrioridade()<acao[1].getPrioridade())
				atual = 0;
			if(acao[1].getPrioridade()<acao[0].getPrioridade())
				atual = 1;
			if(acao[0].getPrioridade()==acao[1].getPrioridade()){
				if(player[1].pokemonAtivo().getSpeed()>player[0].pokemonAtivo().getSpeed())
					atual = 1;
				else
					atual = 0;
			}
			for(int i=0; i<2; i++){
				acao[atual].action(player[atual], player[1-atual]);
				System.out.println(acao[atual].description(player[atual]));
				vencedor = checar(player, atual);
				if(vencedor>=0)
					break;
				atual = 1-atual;
			}
		}
		System.out.println("A batalha acabou.");
		System.out.println(player[vencedor].getNome() + " foi vitorioso!");
	}
	public int checar(Treinador[] player, int checado){
		int vencedor = -1;
		if(player[checado].pokemonAtivo().getHP()==0){
			boolean perdeu = true;
			for(int i=0; i<player[checado].getNpokes(); i++)
				perdeu = perdeu&&(player[checado].pokemonAtivo().getHP()==0);
			if(perdeu)
				vencedor = 1-checado;
			else{
				Evento aux = new Trocar(1);
				while(acao[checado].getClass()!=aux.getClass())
					acao[checado] = es[checado].getNext(); //Na pratica, nunca vamos precisar dessa linha
				acao[checado].action(player[checado], player[1-checado]);
				System.out.println(acao[checado].description(player[checado]));
			}
		}
		return vencedor;
	}
}
