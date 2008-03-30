package util;

/**
 * Este arquivo é parte do programa Siscofi
 * 
 * Siscofi é um software livre; você pode redistribui-lo e/ou
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como
 * publicada pela Fundação do Software Livre (FSF); na versão 3 da
 * Licença.
 * 
 * Este programa é distribuído na esperança que possa ser útil,
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.

 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa um gerador de pdfs com o questionário
 * da avaliação do atendimento
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
	 * Metodo que retorna um document contendo as informações que o questionário
	 * deve conter.
	 * 
	 * @return um Document contendo as informacoes que o quetionário deve
	 *         conter.
	 */
	public Document geraPDF() {
		// Criação de um objeto document com pagina de tamanha A4.
		DocumentoPDF documento = new DocumentoPDF();
		Formulario formulario = Formulario.getFormulario();

		documento.setNome(Configuracao.getPath() + "/Questionario.pdf");
		documento.setCabecalho(
				"Relatório das Estatísticas de Avaliação do Atendimento",
				"Relatório das Estatísticas de Avaliação do Atendimento",
				"Carlos Trajano, Hamon Henriques e Rodrigo Lopes");
		documento.abrir();

		//Adiciona o titulo do documento
		documento.adicionaTitulo("Relatório das Estatísticas de Avaliação do Atendimento");
		documento.adicionaLinhaEmBranco(2);

		// Adiciona as Questões objetivas ao documento
		adicionaQuestoesObjetivas(documento, formulario);

		// Sexta Questão
		documento.adicionaParagrafo(new Paragraph("6- "	+ formulario.getQuestao6()));
		documento.adicionaLinhaEmBranco(8);

		// Setima Questão
		documento.adicionaParagrafo(new Paragraph("7- " + formulario.getQuestao7()));
		
		documento.fechar();
		return documento.getDocumento();
	}

	// Metodo que adiciona as questões objetivas ao documento
	private void adicionaQuestoesObjetivas(DocumentoPDF documento, Formulario formulario) {

		for (int i = 1; i <= 5; i++) {
			documento.adicionaParagrafo(new Paragraph(i + "- " + formulario.getQuestao(i)));
			String alternativas = this.getAlternativasParaAvaliacao(formulario,	i);
			documento.adicionaParagrafo(new Paragraph(alternativas));
			documento.adicionaLinhaEmBranco(1);
		}
	}

	// Metodo que retorna as altenativas seguidas de "( )" relativas a questão
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