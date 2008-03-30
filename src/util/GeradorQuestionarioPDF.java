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

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;

import controller.Configuracao;
import database.bean.Formulario;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa um gerador de pdfs com o question�rio
 * da avalia��o do atendimento
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class GeradorQuestionarioPDF {

	/**
	 * Construtor simples da classe
	 */
	public GeradorQuestionarioPDF() {

	}

	/**
	 * Metodo que retorna um document contendo as informa��es que o question�rio
	 * deve conter.
	 * 
	 * @return um Document contendo as informacoes que o quetion�rio deve
	 *         conter.
	 */
	public Document geraPDF() {
		// Cria��o de um objeto document com pagina de tamanha A4.
		DocumentoPDF documento = new DocumentoPDF();
		Formulario formulario = Formulario.getFormulario();

		documento.setNome(Configuracao.getPath() + "/Questionario.pdf");
		documento.setCabecalho(
				"Relat�rio das Estat�sticas de Avalia��o do Atendimento",
				"Relat�rio das Estat�sticas de Avalia��o do Atendimento",
				"Carlos Trajano, Hamon Henriques e Rodrigo Lopes");
		documento.abrir();

		//Adiciona o titulo do documento
		documento.adicionaTitulo("Relat�rio das Estat�sticas de Avalia��o do Atendimento");
		documento.adicionaLinhaEmBranco(2);

		// Adiciona as Quest�es objetivas ao documento
		adicionaQuestoesObjetivas(documento, formulario);

		// Sexta Quest�o
		documento.adicionaParagrafo(new Paragraph("6- "	+ formulario.getQuestao6()));
		documento.adicionaLinhaEmBranco(8);

		// Setima Quest�o
		documento.adicionaParagrafo(new Paragraph("7- " + formulario.getQuestao7()));
		
		documento.fechar();
		return documento.getDocumento();
	}

	// Metodo que adiciona as quest�es objetivas ao documento
	private void adicionaQuestoesObjetivas(DocumentoPDF documento, Formulario formulario) {

		for (int i = 1; i <= 5; i++) {
			documento.adicionaParagrafo(new Paragraph(i + "- " + formulario.getQuestao(i)));
			String alternativas = this.getAlternativasParaAvaliacao(formulario,	i);
			documento.adicionaParagrafo(new Paragraph(alternativas));
			documento.adicionaLinhaEmBranco(1);
		}
	}

	// Metodo que retorna as altenativas seguidas de "( )" relativas a quest�o
	// passada como parametro
	private String getAlternativasParaAvaliacao(Formulario formulario, int numAlternativas) {

		String alternativas = "        ";
		switch (numAlternativas) {
		case 1:
			for (String alter : formulario.getAlternativas1()) {
				alternativas += "(  ) " + alter + "  ";
			}
			return alternativas;
		case 2:
			for (String alter : formulario.getAlternativas2()) {
				alternativas += "(  ) " + alter + "  ";
			}
			return alternativas;
		case 3:
			for (String alter : formulario.getAlternativas3()) {
				alternativas += "(  ) " + alter + "  ";
			}
			return alternativas;
		case 4:
			for (String alter : formulario.getAlternativas4()) {
				alternativas += "(  ) " + alter;
				String[] alter4 = formulario.getAlternativas4();
				if(!alter.equals(alter4[alter4.length - 1]))
					alternativas += "\n         ";
			}
			return alternativas;
		case 5:
			for (String alter : formulario.getAlternativas5()) {
				alternativas += "(  ) " + alter + "  ";
			}
			return alternativas;
		}
		return alternativas;
	}


}