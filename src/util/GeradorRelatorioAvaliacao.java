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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe gera relat�rios das estat�sticas das avalia��es em PDF. 
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.1
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import controller.Configuracao;
import database.bean.DadosAvaliacao;
import database.bean.Formulario;
import estatisticas.avaliacao.EstatisticaResposta;
import estatisticas.avaliacao.Estatisticas;

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
 * Classe que implementa o gerador de relat�rios das 
 * avalia��es realiazadas.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class GeradorRelatorioAvaliacao {

	private final String QUEBRA_LINHA = System.getProperty("line.separator");
	private final int numAlternativas = 5;
	private final int numQuestoesObjetivas = 5;
	private final int totalQuestoes = 7;

	/**
	 * Cria um novo GeradorRelatorioAvaliacao.
	 */
	public GeradorRelatorioAvaliacao() {
	}

	/**
	 * Metodo que retorna um document contendo as informa��es que o question�rio
	 * deve conter.
	 * 
	 * @return um Document contendo as informacoes que o quetion�rio deve
	 *         conter.
	 */
	public Document geraPDF(Estatisticas estatisticas, Date dataInicial,
			Date dataFinal) {
		// Cria��o de um objeto document com pagina de tamanha A4.
		Document document = new Document(PageSize.A4);
		Formulario formulario = Formulario.getFormulario();
		try {

			PdfWriter.getInstance(document, new FileOutputStream(Configuracao
					.getPath()
					+ "/admin/relatorioAvaliacao.pdf"));
			document
					.addTitle("Relat�rio das Estat�sticas de Avalia��o do Atendimento");
			document
					.addSubject("Relat�rio das Estat�sticas de Avalia��o do Atendimento");
			document
					.addAuthor("Carlos Trajano, Hamon Henriques e Rodrigo Lopes");
			document.open();

			Font fonte = new Font(Font.HELVETICA, Font.DEFAULTSIZE,
					Font.BOLDITALIC);
			fonte.setSize(16);
			Paragraph paragraph = new Paragraph(
					"Relat�rio de Avalia��o do Atendimento", fonte);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);

			Font fontePeriodo = new Font(Font.HELVETICA, Font.DEFAULTSIZE,
					Font.NORMAL);
			fontePeriodo.setSize(14);
			Paragraph periodo = new Paragraph("Per�odo: de "
					+ formataData(dataInicial) + " at� "
					+ formataData(dataFinal), fontePeriodo);
			periodo.setAlignment(Element.ALIGN_LEFT);
			document.add(periodo);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Map<Integer, EstatisticaResposta> respostas = estatisticas
					.getMapaEstatisticaResposta();
			// Itera��o sobre cada pergunta
			for (int i = 0; i < numQuestoesObjetivas; i++) {
				int contagem = estatisticas.getContagem();
				Map<Integer, Integer> mapaRespostas = respostas.get(i)
						.getContagemAlternativa();
				document.add(new Paragraph((i + 1) + "- "
						+ formulario.getQuestao(i + 1)));
				int contador = 1;
				// Itera��o sobre cada alternativa da pergunta da vez
				for (String alter : formulario.getAlternativas(i + 1)) {
					float resp = mapaRespostas.get(contador);
					float porcentagem = (float) (resp / contagem + 0.0);
					document.add(new Paragraph("        " + alter + ":  "
							+ formatarPorcentagem(porcentagem) + QUEBRA_LINHA));
					contador++;
				}
				document.add(Chunk.NEWLINE);
			}

			document.add(new Paragraph("6- " + formulario.getQuestao6()));
			for (String s : estatisticas.getRespostas06()) {
				document.add(new Paragraph("  " + s));
			}
			document.add(new Paragraph("7- " + formulario.getQuestao7()));
			for (String s : estatisticas.getRespostas07()) {
				document.add(new Paragraph("  " + s));
			}
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		document.close();
		return document;
	}

	/**
	 * Gera um bean contendo os dados da estatistica
	 * 
	 * @param estatisticas
	 * @param dataInicial
	 * @param dataFinal
	 * @return os dados das avalia��es no per�odo. Se n�o houver dados, retorna <b>null</b>.
	 */
	public DadosAvaliacao gerarDadosEstatisticos(Estatisticas estatisticas,
			Date dataInicial, Date dataFinal) {
		// Cria��o de um objeto document com pagina de tamanha A4.
		DadosAvaliacao dados = new DadosAvaliacao();
		Formulario formulario = Formulario.getFormulario();
		dados.setDataInicial(formataData(dataInicial));
		dados.setDataFinal(formataData(dataFinal));
		if(estatisticas.getContagem() <= 0){
			return null; 
		}
		dados.setTotal(estatisticas.getContagem());
		// define as quest�es
		for (int i = 1; i <= totalQuestoes; i++) {
			dados.setQuestao(i, formulario.getQuestao(i));
		}
		
		dados = gerarAlternativas(estatisticas, dados, formulario);

		List<String> respostas06 = new ArrayList<String>();
		for (String s : estatisticas.getRespostas06()) {
			respostas06.add(s);
		}
		dados.setRespostas06(respostas06);
		List<String> respostas07 = new ArrayList<String>();
		for (String s : estatisticas.getRespostas07()) {
			respostas07.add(s);
		}
		dados.setRespostas07(respostas07);
		return dados;
	}

	/**
	 * M�todo que gera uma String que representa os resultados de cada alternativa e armazena no bean dados.
	 * @param estatisticas Dados estatisticos.
	 * @param dados bean para armazenar os dados.
	 * @param formulario bean contendo as perguntas e alternativas.
	 */
	private DadosAvaliacao gerarAlternativas(Estatisticas estatisticas,
			DadosAvaliacao dados, Formulario formulario) {
		Map<Integer, EstatisticaResposta> respostas = estatisticas.getMapaEstatisticaResposta();
		// Itera��o sobre cada pergunta
		for (int i = 0; i < numQuestoesObjetivas; i++) {
			int contagem = estatisticas.getContagem();
			Map<Integer, Integer> mapaRespostas = respostas.get(i).getContagemAlternativa();
			int contador = 1;
			// Itera��o sobre cada alternativa da pergunta e contatena a pergunta com a respectiva porcentagem
			String[] porcentagens = new String[numAlternativas];
			for (String alter : formulario.getAlternativas(i + 1)) {
				float resp = mapaRespostas.get(contador);
				float porcentagem = (float) (resp / contagem + 0.0);
				porcentagens[contador-1] = alter + ": " +formatarPorcentagem(porcentagem);
				contador++;
			}
			dados.setAlternativas(i+1, porcentagens);
		}
		return dados;
	}

	/**
	 * Formata o texto de uma data para o formato dia / m�s/ ano
	 * 
	 * @param data
	 *            Data a aser formatada
	 * @return String que representa a data.
	 */
	private String formataData(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		return formatador.format(data);
	}

	/**
	 * Formata a String da porcentagem, utilizando o padr�o dd,d%, onde d
	 * representa um d�gito
	 * 
	 * @param porcentagem
	 *            porcentagem a ser formatada
	 * @return A porcentagem formatada
	 */
	private String formatarPorcentagem(float porcentagem) {
		String valor = Float.toString(porcentagem * 100) + 0.0000;
		valor = valor.substring(0, valor.indexOf(".") + 3) + "%";
		return valor;
	}

}
