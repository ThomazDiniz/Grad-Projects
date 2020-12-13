
public class OperacaoNaoPermitidaException extends Exception{
	private static final long serialVersionUID = 7949897811850476670L;

	public OperacaoNaoPermitidaException(){
		super("A operacao perfomada não é permitida");
	}
	
	public OperacaoNaoPermitidaException(String mensagem){
		super(mensagem);
	}
	
}
