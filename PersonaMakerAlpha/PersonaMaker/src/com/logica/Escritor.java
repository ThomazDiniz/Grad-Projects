package com.logica;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Line;

public class Escritor {
	
	public static void criaDocumento(Personagem personagem, String caminho){
		Document documento = new Document();
		
		try {
			//Cria uma instância
			PdfWriter escreve = PdfWriter.getInstance(documento, new FileOutputStream(caminho));
			//abre o documento
			documento.open();
			documento.setPageSize(PageSize.A4);
			
			
			//Guarda
			Paragraph nome = new Paragraph(personagem.getNome());
			Paragraph especialidade = new Paragraph("Especialidade: " + personagem.getEspecialidade());
			Paragraph objetivo = new Paragraph("Objetivo: " + personagem.getObjetivo());
			Paragraph idade = new Paragraph("Idade: " + personagem.getIdade() + " Anos");
			Paragraph titulo1 = new Paragraph(personagem.getTitulo1());
			Paragraph desc1 = new Paragraph(personagem.getDescricao1());
			Paragraph titulo2 = new Paragraph(personagem.getTitulo2());
			Paragraph desc2 = new Paragraph(personagem.getDescricao2());
			Paragraph titulo3 = new Paragraph(personagem.getTitulo3());
			Paragraph desc3 = new Paragraph(personagem.getDescricao3());
			
			//Imagem
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedImage bf = personagem.getBfImg();
			ImageIO.write(bf, "png", baos);
			Image img = Image.getInstance(baos.toByteArray());
			
			float w = img.getWidth();
			float h = img.getHeight();
			float escala = w/h;
			float tam = 130;
			img.setAlignment(Image.TEXTWRAP | Image.ALIGN_RIGHT);
			img.scaleAbsolute(tam, tam/escala);
			
			String sexo;
			if (personagem.getSexo() == 'm'){
				sexo = "Masculino";		
			} else {
				sexo = "Feminino";
			}
			
			//Alinhamento
			nome.setAlignment(Element.ALIGN_CENTER);
			titulo1.setAlignment(Element.ALIGN_JUSTIFIED);
			titulo2.setAlignment(Element.ALIGN_JUSTIFIED);
			titulo3.setAlignment(Element.ALIGN_JUSTIFIED);
			desc1.setAlignment(Element.ALIGN_JUSTIFIED);
			desc2.setAlignment(Element.ALIGN_JUSTIFIED);
			desc3.setAlignment(Element.ALIGN_JUSTIFIED);
			
			

			documento.add(img);
			documento.add(nome);
			documento.add(new Paragraph("Sexo: " + sexo));
			documento.add(especialidade);
			documento.add(objetivo);
			documento.add(idade);
			documento.add(Chunk.NEWLINE);
			documento.add(Chunk.NEWLINE);

			documento.add(titulo1);
			documento.add(desc1);
			documento.add(Chunk.NEWLINE);
			documento.add(Chunk.NEWLINE);
			documento.add(titulo2);
			documento.add(desc2);
			documento.add(Chunk.NEWLINE);
			documento.add(Chunk.NEWLINE);
			documento.add(titulo3);
			documento.add(desc3);
			documento.add(Chunk.NEWLINE);
			documento.add(Chunk.NEWLINE);
			
			documento.add(new Paragraph("Personagem escrito por: " + personagem.getAutor()));
			
			documento.newPage();
			
			//Fecha
			documento.close();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
