
public class DadoInvalidoException extends IllegalArgumentException {
	
	private static final long serialVersionUID = -4405774565128221767L;

	public DadoInvalidoException(){
		super("Os dados fornecidos não são válidos");
	}
	
	public DadoInvalidoException(String mensagem){
		super(mensagem);
	}
}
