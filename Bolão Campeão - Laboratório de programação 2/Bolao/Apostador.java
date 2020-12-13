import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Apostador extends Usuario implements Comparable<Apostador>{
	private static final long serialVersionUID = -4222458272282616321L;
	private int totalPontos, palpitesCertos, palpitesErrados;
	private Set<Aposta> listaApostas;
	
	public Apostador(String nome, String nomeUsuario, String senha) throws DadoInvalidoException {
		super(nome, nomeUsuario, senha);
		totalPontos = 0;
		palpitesCertos = 0;
		palpitesErrados = 0;
		listaApostas = new HashSet<Aposta>();
	}

	public int getTotalPontos() {
		return totalPontos;
	}

	public int getPalpitesCertos() {
		return palpitesCertos;
	}

	public int getPalpitesErrados() {
		return palpitesErrados;
	}
	
	public void setTotalPontos(int totalPontos) {
		this.totalPontos = totalPontos;
	}

	public void setPalpitesCertos(int palpitesCertos) {
		this.palpitesCertos = palpitesCertos;
	}

	public void setPalpitesErrados(int palpitesErrados) {
		this.palpitesErrados = palpitesErrados;
	}
	
	//chama adicionaAposta q funciona de maneira semelhante ao set de Apostador, adiciona a aposta no map de apostas da partida, usando o nome de usuario como chave
	public void setAposta(int palpSelecao1, int palpSelecao2, Partida jogo){ //verificar o que fazer se partida for null em todos esses métodos
		if (!(apostaFeita(jogo))){
			listaApostas.add(palpSelecao1, palpSelecao2);
			jogo.adicionaAposta(palpSelecao1, palpSelecao2, getNomeUsuario()); 
		}
		// chama o editaAposta de partida que funciona de maneira semelhante ao set de Apostador
		jogo.editaAposta(palpSelecao1, palpSelecao2, getNomeUsuario()); 
	}
	
	//verifica se o apostador já fez sua aposta na partida
	//chama o verifica aposta, que ve se o map de apostas da partida contem a chave com o nome do usuário
	private boolean apostaFeita(Partida jogo){ 
		return jogo.verificaAposta(getNomeUsuario()); 
	}
	
	public Aposta visualizaAposta(int jogo) throws Exception{
		if (jogo < 1 || jogo > listaApostas.size())
			throw new Exception("Jogo inválido");
		return listaApostas.get(jogo-1);
	}
	
	@Override
	public int compareTo(Apostador outroAp) {
		return getTotalPontos() - outroAp.getTotalPontos();
	}

	

}
