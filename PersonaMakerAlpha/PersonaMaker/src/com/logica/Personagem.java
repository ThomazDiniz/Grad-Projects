package com.logica;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import com.conexao.ConnectFactory;

public class Personagem {
	private String nome;
	private int idade;
	private char sexo;
	private String especialidade;
	private String objetivo;
	private String descricao1;
	private String descricao2;
	private String descricao3;
	private String titulo1;
	private String titulo2;
	private String titulo3;
	private String autor;
	private BufferedImage bfImg;
	private InputStream isImg;
	private File imgArq;
	
	public File getImgArq() {
		return imgArq;
	}

	public void setImgArq(File imgArq) {
		this.imgArq = imgArq;
	}

	public BufferedImage getBfImg() {
		return bfImg;
	}

	public void setBfImg(BufferedImage bfImg) {
		this.bfImg = bfImg;
	}

	public InputStream getIsImg() {
		return isImg;
	}

	public void setIsImg(InputStream isImg) {
		this.isImg = isImg;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Personagem(){//Personagem dummy como exemplo
		/*nome = "Zeca Pagodinho";
		autor = "vida";
		sexo = 'm';
		idade = 57;
		especialidade = "Música";
		objetivo = "Encantar o Brasil";
		titulo1 = "História";
		descricao1 = "Zeca Pagodinho, nome artístico de Jessé Gomes da Silva Filho, (Rio de Janeiro, 4 de fevereiro de 1959) é um cantor e compositor brasileiro. Gravou mais de 20 discos e é considerado um grande nome do gênero samba e pagode. O artista, que começou sua carreira nas rodas de samba dos bairros de Irajá e Del Castilho, subúrbio do Rio de Janeiro, tornou-se tão imensamente popular que seus shows chegam a ser contratados por cachês generosos, sendo realizados nas mais badaladas casas de espetáculo do país. Sempre fiel a suas características de irreverência e jocosidade, Zeca recebe também reconhecimento da crítica e de artístas e compositores consagrados. Nei Lopes afirma que o sambista é uma das poucas unanimidades nacionais, elevado ao patamar do mega-estrelato pop pelas gravadoras.";
		titulo2 = "Biografia";
		descricao2 = "Filho de Irinéia e Jessé, Zeca nasceu em Irajá onde desde pequeno passou a frequentar rodas de samba influenciado por sua família. Morou em vários bairros do Rio mas sempre demonstrou enorme apreço por Xerém (distrito de Duque de Caxias), na qual possui um sítio e uma escola de música para crianças carentes da região. Sua primeira gravação foi em 1983, com o samba Camarão que dorme a onda leva, de sua autoria e de Arlindo Cruz, a partir do convite de sua madrinha Beth Carvalho. Em 2003, no auge de sua carreira, foi o primeiro artista de Samba a gravar um especial de TV, CD e DVD pela MTV Brasil (tradicional reduto do pop rock).";
		titulo3 = "Discografia";
		descricao3 = "Deixe a vida me levar, vida leva eu. Sou feliz e agradeço por tudo que deus me deu.";
		*/
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getDescricao1() {
		return descricao1;
	}
	public void setDescricao1(String descricao1) {
		this.descricao1 = descricao1;
	}
	public String getDescricao2() {
		return descricao2;
	}
	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}
	public String getDescricao3() {
		return descricao3;
	}
	public void setDescricao3(String descricao3) {
		this.descricao3 = descricao3;
	}
	public String getTitulo1() {
		return titulo1;
	}
	public void setTitulo1(String titulo1) {
		this.titulo1 = titulo1;
	}
	public String getTitulo2() {
		return titulo2;
	}
	public void setTitulo2(String titulo2) {
		this.titulo2 = titulo2;
	}
	public String getTitulo3() {
		return titulo3;
	}
	public void setTitulo3(String titulo3) {
		this.titulo3 = titulo3;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
	public void conectaInsere() {
		Connection conexao = ConnectFactory.getConnection();
		System.out.println("Ok, Conectou!");
		
		System.out.println("Inserindo informações...");
		String query = "INSERT INTO personagens (nome, idade, sexo,"
												+ "especialidade, objetivo,"
												+ "autor, imagem,"
												+ "titulo1, descricao1,"
												+ "titulo2, descricao2,"
												+ "titulo3, descricao3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement st = ConnectFactory.criaPreparedStatement(conexao, query);
		System.out.println("Ok, criando o statement!");
		
		try {
			st.setString(1, nome);
			st.setInt(2, idade);
			st.setString(3, ""+sexo);
			st.setString(4, especialidade);
			st.setString(5, objetivo);
			st.setString(6, autor);
			
			File arq = new File("imagem.png");
			ImageIO.write(bfImg,"png",arq);
			FileInputStream img = new FileInputStream(arq);
			st.setBinaryStream(7, img, (int) arq.length());
			
			/*
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(bfImg, "png", os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			st.setBlob(7, is);
			*/
			
			st.setString(8, titulo1);
			st.setString(9, descricao1);
			st.setString(10, titulo2);
			st.setString(11, descricao2);
			st.setString(12, titulo3);
			st.setString(13, descricao3);
			
			if (st.execute()){
				//System.out.println("Query Executada deboas");
			}else{
				//System.out.println("Query não foi executada!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ok!");
		ConnectFactory.fechaConexao(conexao);
	}
	
	public void conectaPesquisa(String nome){
		Connection conexao = ConnectFactory.getConnection();
		System.out.println("Ok, Conectou!");
		
		System.out.println("Selecionando informações...");
		String query = "SELECT  nome, idade, sexo,"
								+ "especialidade, objetivo,"
								+ "autor, imagem,"
								+ "titulo1, descricao1,"
								+ "titulo2, descricao2,"
								+ "titulo3, descricao3 FROM personagens WHERE nome like ? LIMIT 1";
		PreparedStatement st = ConnectFactory.criaPreparedStatement(conexao, query);
		try {
			st.setString(1, "%"+nome+"%");
			ResultSet resultado = st.executeQuery();
			ResultSetMetaData resultadoMeta = st.getMetaData();
			
			try {
				atualizaComResult(resultado, resultadoMeta);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	public void atualizaComResult(ResultSet resultado, ResultSetMetaData resultadoMeta) throws SQLException, IOException{
		int colunas = resultadoMeta.getColumnCount();
		
		while(resultado.next()){
			setNome(resultado.getString(1));
			setIdade(resultado.getInt(2));
			setSexo(resultado.getString(3).charAt(0));
			setEspecialidade(resultado.getString(4));
			setObjetivo(resultado.getString(5));
			setAutor(resultado.getString(6));
			
			setTitulo1(resultado.getString(8));
			setTitulo2(resultado.getString(10));
			setTitulo3(resultado.getString(12));
			setDescricao1(resultado.getString(9));
			setDescricao2(resultado.getString(11));
			setDescricao3(resultado.getString(13));		
			setIsImg(resultado.getBinaryStream(7));
			setBfImg(ImageIO.read(isImg));
			
		}
		
		System.out.println("Ok!");
	}
	
}
