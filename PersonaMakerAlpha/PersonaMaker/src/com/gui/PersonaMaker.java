package com.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.logica.Escritor;
import com.logica.Personagem;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class PersonaMaker {

	private JFrame frmPersonaMaker;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private JTextPane textPane;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private JLabel label_2;
	private Personagem personagem = new Personagem();
	private JTextField txtObjetivo;
	private JTextField textField_5;
	private JTextField txtAutor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonaMaker window = new PersonaMaker();
					window.frmPersonaMaker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonaMaker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPersonaMaker = new JFrame();
		frmPersonaMaker.setResizable(false);
		frmPersonaMaker.getContentPane().setBackground(SystemColor.menu);
		frmPersonaMaker.getContentPane().setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esvaziaCampos();
				JOptionPane jp = new JOptionPane();
				String str = jp.showInputDialog(frmPersonaMaker,"Digite o nome do personagem que você está procurando");
				
				personagem.conectaPesquisa(str);
				atualizaCampos(personagem);
			}
		});
		btnBuscar.setBounds(408, 527, 89, 23);
		frmPersonaMaker.getContentPane().add(btnBuscar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizaPersonagem(personagem);
				personagem.conectaInsere();
			}
		});
		btnNovo.setBounds(237, 527, 89, 23);
		frmPersonaMaker.getContentPane().add(btnNovo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		frmPersonaMaker.getContentPane().add(lblNome);
		
		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizaPersonagem(personagem);
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");   
				 
				int userSelection = fileChooser.showSaveDialog(frmPersonaMaker);
				 
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
					Escritor.criaDocumento(personagem,fileToSave.getAbsolutePath() + ".pdf");
				}
				
				
				
			}
		});
		btnGerarPdf.setBounds(599, 527, 112, 23);
		frmPersonaMaker.getContentPane().add(btnGerarPdf);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(196, 11, 46, 14);
		frmPersonaMaker.getContentPane().add(lblSexo);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(297, 11, 46, 14);
		frmPersonaMaker.getContentPane().add(lblIdade);
		
		JButton btnImagem = new JButton("Alterar Imagem");
		btnImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser img = new JFileChooser();
				img.showOpenDialog(null);
				File arq = img.getSelectedFile();
				personagem.setImgArq(arq);
				try {
					BufferedImage bsImg = ImageIO.read(arq);
					label_2.setIcon(new ImageIcon(bsImg));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnImagem.setBounds(626, 309, 130, 54);
		frmPersonaMaker.getContentPane().add(btnImagem);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 143, 20);
		frmPersonaMaker.getContentPane().add(textField);
		textField.setColumns(10);
		
		rdbtnM = new JRadioButton("M");
		buttonGroup.add(rdbtnM);
		rdbtnM.setSelected(true);
		rdbtnM.setBackground(SystemColor.menu);
		rdbtnM.setBounds(196, 35, 46, 23);
		frmPersonaMaker.getContentPane().add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		buttonGroup.add(rdbtnF);
		rdbtnF.setBackground(SystemColor.menu);
		rdbtnF.setBounds(244, 35, 46, 23);
		frmPersonaMaker.getContentPane().add(rdbtnF);
		
		textField_1 = new JTextField();
		textField_1.setBounds(297, 36, 46, 20);
		frmPersonaMaker.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 68, 67, 23);
		frmPersonaMaker.getContentPane().add(lblTitulo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 69, 86, 20);
		frmPersonaMaker.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 466, 83);
		frmPersonaMaker.getContentPane().add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 231, 466, 83);
		frmPersonaMaker.getContentPane().add(scrollPane_1);
		
		textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(64, 198, 86, 20);
		frmPersonaMaker.getContentPane().add(textField_3);
		
		JLabel label = new JLabel("Titulo:");
		label.setBounds(10, 197, 67, 23);
		frmPersonaMaker.getContentPane().add(label);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 359, 466, 83);
		frmPersonaMaker.getContentPane().add(scrollPane_2);
		
		textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(64, 326, 86, 20);
		frmPersonaMaker.getContentPane().add(textField_4);
		
		JLabel label_1 = new JLabel("Titulo:");
		label_1.setBounds(10, 325, 67, 23);
		frmPersonaMaker.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(599, 103, 185, 195);
		frmPersonaMaker.getContentPane().add(label_2);
		
		txtObjetivo = new JTextField();
		txtObjetivo.setColumns(10);
		txtObjetivo.setBounds(377, 36, 99, 20);
		frmPersonaMaker.getContentPane().add(txtObjetivo);
		
		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setBounds(377, 11, 46, 14);
		frmPersonaMaker.getContentPane().add(lblObjetivo);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(486, 11, 99, 14);
		frmPersonaMaker.getContentPane().add(lblEspecialidade);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(486, 36, 99, 20);
		frmPersonaMaker.getContentPane().add(textField_5);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(13, 467, 67, 23);
		frmPersonaMaker.getContentPane().add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(67, 468, 86, 20);
		frmPersonaMaker.getContentPane().add(txtAutor);
		frmPersonaMaker.setTitle("Persona Maker");
		frmPersonaMaker.setIconImage(Toolkit.getDefaultToolkit().getImage(PersonaMaker.class.getResource("/outros/icone.png")));
		frmPersonaMaker.setLocationRelativeTo(null);
		frmPersonaMaker.setBounds(200,100,800, 600);
		frmPersonaMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void atualizaCampos(Personagem personagem){
		textField.setText(personagem.getNome());
		if (personagem.getSexo() == 'm'){rdbtnM.setSelected(true);} else {rdbtnF.setSelected(true);}
		textField_1.setText(""+personagem.getIdade());
		textField_2.setText(personagem.getTitulo1());
		textField_3.setText(personagem.getTitulo2());
		textField_4.setText(personagem.getTitulo3());
		textPane.setText(personagem.getDescricao1());
		textPane_1.setText(personagem.getDescricao2());
		textPane_2.setText(personagem.getDescricao3());
		label_2.setIcon(new ImageIcon(personagem.getBfImg()));
		txtObjetivo.setText(personagem.getObjetivo());
		textField_5.setText(personagem.getEspecialidade());
		txtAutor.setText(personagem.getAutor());
	}
	private void esvaziaCampos(){
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textPane.setText("");
		textPane_1.setText("");
		textPane_2.setText("");
		txtObjetivo.setText("");
		textField_5.setText("");
		txtAutor.setText("");
	}
	private void atualizaPersonagem(Personagem personagem){
		personagem.setNome(textField.getText());
		if (rdbtnM.isSelected()){personagem.setSexo('m');} else {personagem.setSexo('f');}
		int idade = 0;
		try{
			idade = Integer.parseInt(textField_1.getText());
		} catch(Exception e){
			idade = 0;
		}
		personagem.setIdade(idade);
		personagem.setTitulo1(textField_2.getText());
		personagem.setTitulo2(textField_3.getText());
		personagem.setTitulo3(textField_4.getText());
		personagem.setDescricao1(textPane.getText());
		personagem.setDescricao2(textPane_1.getText());
		personagem.setDescricao3(textPane_2.getText());
		
		personagem.setObjetivo(txtObjetivo.getText());
		personagem.setEspecialidade(textField_5.getText());
		personagem.setAutor(txtAutor.getText());
		ImageIcon imgIcon = (ImageIcon) label_2.getIcon();
		Image img = imgIcon.getImage();
		personagem.setBfImg( (BufferedImage) img );
		
	}
}
