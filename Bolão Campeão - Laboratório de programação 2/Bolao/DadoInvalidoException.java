
public class DadoInvalidoException extends IllegalArgumentException {
	
	private static final long serialVersionUID = -4405774565128221767L;

	public DadoInvalidoException(){
		super("Os dados fornecidos n�o s�o v�lidos");
	}
	
	public DadoInvalidoException(String mensagem){
		super(mensagem);
	}
}
