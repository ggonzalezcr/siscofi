package util;

/**
 * Este arquivo � parte do programa Siscofi
 * 
 * Siscofi � um software livre; voc� pode redistribui-lo e/ou
 * modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como
 * publicada pela Funda��o do Software Livre (FSF); na vers�o 3 da
 * Licen�a.
 * 
 * Este programa � distribu�do na esperan�a que possa ser �til,
 * mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
 * MERCADO ou APLICA��O EM PARTICULAR. Veja a
 * Licen�a P�blica Geral GNU para maiores detalhes.

 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que gera relat�rio em PDF.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import controller.Configuracao;
import database.bean.Formulario;

@Deprecated
public class GeradorPDF {

	
	public GeradorPDF(){
		
	}
	
	/**
	 * Metodo que retorna um document contendo as informa��es que o question�rio deve conter.
	 * @return um Document contendo as informacoes que o quetion�rio deve conter.
	 */
	public Document geraPDF(){
		//Cria��o de um objeto document com pagina de tamanha A4.
		Document document = new Document(PageSize.A4);
		Formulario formulario = Formulario.getFormulario();
		try {
			
			PdfWriter.getInstance(document,
					new FileOutputStream(Configuracao.getPath() + "/questionario.pdf"));

			document.addTitle("Question�rio de Avalia��o");
            document.addSubject("Formul�rio de avalia��o de atendimento");
            document.addAuthor("Carlos Trajano, Hamon Henriques e Rodrigo Lopes");
			document.open();
			
			Font fonte = new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.BOLDITALIC);
			fonte.setSize(16);
			Paragraph paragraph = new Paragraph ("Formul�rio de Avalia��o de Atendimento", fonte);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("1- " + formulario.getQuestao1()));
			String alternativas = "        ";
			for(String alter : formulario.getAlternativas1()){
				alternativas += "(  ) " + alter + "  ";
			}
			
			document.add(new Paragraph(alternativas));
			
			
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("2- " + formulario.getQuestao2()));
			alternativas = "        ";
			for(String alter : formulario.getAlternativas2()){
				alternativas += "(  ) " + alter + "  ";
			}
			document.add(new Paragraph(alternativas));
			
			document.add(Chunk.NEWLINE);
			
			
			document.add(new Paragraph("3- " + formulario.getQuestao3()));
			alternativas = "        ";
			for(String alter : formulario.getAlternativas3()){
				alternativas += "(  ) " + alter + "  ";
			}
			document.add(new Paragraph(alternativas));
			
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("4- " + formulario.getQuestao4()));
			alternativas = "        ";
			for(String alter : formulario.getAlternativas4()){
				alternativas += "(  ) " + alter + "  ";
			}
			document.add(new Paragraph(alternativas));
			
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("5- " +formulario.getQuestao5()));
			alternativas = "        ";
			for(String alter : formulario.getAlternativas5()){
				alternativas += "(  ) " + alter + "  ";
			}
			document.add(new Paragraph(alternativas));
			
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("6- " +formulario.getQuestao6()));
			
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			document.add(new Paragraph("7- " + formulario.getQuestao7()));
			
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		document.close();
		return document;
	}
	
	

}