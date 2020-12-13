
public class Administrador extends Usuario{

	private static final long serialVersionUID = 7593191303176810209L;

	public Administrador(String nome, String nomeUsuario, String senha) throws DadoInvalidoException {
		super(nome, nomeUsuario, senha);
	}
	
	public boolean finalizarPartida(Partida jogo, int golSelecao1, int golSelecao2){ //verificar se vai ser possivel reabrir uma partida fechada
		jogo.setJogoRealizado(true);
	}
	
	public boolean editarPartida(Partida jogo, int golSelecao1, int golSelecao2){
		jogo.setGolSelecao1(golSelecao1);
		jogo.setGolSelecao2(golSelecao2);
	}
	
	public void atualizarSelecoes(Partida jogo) throws Exception{
		if (jogo.getJogoRealizado() == false)
			throw new OperacaoNaoPermitidaException("Não é possível realizar essa operação em uma partida ainda não finalizada");
		jogo.atualizarSelecao(jogo.getSelecao1());
		jogo.atualizarSelecao(jogo.getSelecao2());
	}
	
	public void verificarApostas(Partida jogo) throws Exception{
		if (jogo.getJogoRealizado() == false)
			throw new OperacaoNaoPermitidaException("Não é possível realizar essa operação em uma partida ainda não finalizada");
		jogo.verificarApostas();
	}

}
