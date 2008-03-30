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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


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
 * Classe que implementa um documento PDF
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class DocumentoPDF {

	//Atributos de classe
	private Document document;
	private String nome;
	
	/**
	 * Construtor simples da classe
	 */
	public DocumentoPDF(){
		document = new Document(PageSize.A4);
	}
	
	/**
	 * Metodo que adiciona n linhas em branco ao documento
	 * @param numLinhas o numero de linhas em branco a serem adicionadas ao documento
	 */ 
	public void adicionaLinhaEmBranco(int numLinhas) {
		try {
			for (int i =0 ; i< numLinhas; i++){
				document.add(Chunk.NEWLINE);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}		
	}

	/**
	 *Metodo que retorna uma fonte ajustada para ser usada no t�tulo do docuemnto 
	 * @return uma fonte utilizada em titulos de documentos
	 */
	public Font getFonteTitulo() {
		Font fonte = new Font(Font.HELVETICA, Font.DEFAULTSIZE, Font.BOLDITALIC);
		fonte.setSize(16);
		return fonte;
	}
	
	/**
	 *	Metodo que adiciona um paragrafo ao documento 
	 * @param paragrafo o paragrafo a ser adicionado
	 */

	public void adicionaParagrafo(Paragraph paragrafo) {
		try {
			document.add(paragrafo);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que seta o nome e o caminho do arquivo pdf a ser criado.
	 * @param nome o nome do arquivo e o caminho.
	 */
	public void setNome(String nome) {
		try {
			PdfWriter.getInstance(document,
					new FileOutputStream(nome));
			this.nome = nome;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que retorna o nome do arquivo
	 * @return o nome do arquivo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que seta o cabe�alho do documento
	 * @param titulo o titulo do documento
	 * @param assunto o assunto do documento
	 * @param autor o autor do documento
	 */
	public void setCabecalho(String titulo, String assunto, String autor) {
		document.addTitle(titulo);
        document.addSubject(assunto);
        document.addAuthor(autor);
		
	}

	/**
	 * Metodo que abri o documento
	 */
	public void abrir() {
		document.open();
	}

	/**
	 * Metodo que fecha o documento
	 */
	public void fechar() {
		document.close();
	}

	/**
	 * Metodo que retorna o objeto Document utilizado para cria��o do documento
	 * @return o objeto Document utilizado para cria��o do documento
	 */
	public Document getDocumento() {
		return document;
	}

	public void adicionaTitulo(String titulo) {
		Paragraph title = new Paragraph(titulo,
				this.getFonteTitulo());
		title.setAlignment(Element.ALIGN_CENTER);
		try {
			document.add(title);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
	
}
