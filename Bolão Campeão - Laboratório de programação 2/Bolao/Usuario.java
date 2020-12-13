import java.io.Serializable;


public abstract class Usuario implements Serializable{
	private static final long serialVersionUID = -10607990104382974L;
	private String nome, nomeUsuario, senha;
	
	public Usuario(String nome, String nomeUsuario, String senha) throws DadoInvalidoException{
		if (nome == null || nome.equals(""))
			throw new DadoInvalidoException("Nome inválido");
		
		if (nomeUsuario == null || nomeUsuario.length() < 4 || nomeUsuario.length() > 16)
			throw new DadoInvalidoException("Nome de usuário inválido");
		
		if (senha == null || senha.length() < 8 || senha.length() > 16)
			throw new DadoInvalidoException("Insira uma senha que contenha entre 8 e 16 caracteres");
		
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		
		Usuario other = (Usuario) obj;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		return true;
	}
}
