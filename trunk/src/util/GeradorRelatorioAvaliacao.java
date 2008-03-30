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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe gera relatórios das estatísticas das avaliações em PDF. 
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa o gerador de relatórios das 
 * avaliações realiazadas.
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
	 * Metodo que retorna um document contendo as informações que o questionário
	 * deve conter.
	 * 
	 * @return um Document contendo as informacoes que o quetionário deve
	 *         conter.
	 */
	public Document geraPDF(Estatisticas estatisticas, Date dataInicial,
			Date dataFinal) {
		// Criação de um objeto document com pagina de tamanha A4.
		Document document = new Document(PageSize.A4);
		Formulario formulario = Formulario.getFormulario();
		try {

			PdfWriter.getInstance(document, new FileOutputStream(Configuracao
					.getPath()
					+ "/admin/relatorioAvaliacao.pdf"));
			document
					.addTitle("Relatório das Estatísticas de Avaliação do Atendimento");
			document
					.addSubject("Relatório das Estatísticas de Avaliação do Atendimento");
			document
					.addAuthor("Carlos Trajano, Hamon Henriques e Rodrigo Lopes");
			document.open();

			Font fonte = new Font(Font.HELVETICA, Font.DEFAULTSIZE,
					Font.BOLDITALIC);
			fonte.setSize(16);
			Paragraph paragraph = new Paragraph(
					"Relatório de Avaliação do Atendimento", fonte);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);

			Font fontePeriodo = new Font(Font.HELVETICA, Font.DEFAULTSIZE,
					Font.NORMAL);
			fontePeriodo.setSize(14);
			Paragraph periodo = new Paragraph("Período: de "
					+ formataData(dataInicial) + " até "
					+ formataData(dataFinal), fontePeriodo);
			periodo.setAlignment(Element.ALIGN_LEFT);
			document.add(periodo);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Map<Integer, EstatisticaResposta> respostas = estatisticas
					.getMapaEstatisticaResposta();
			// Iteração sobre cada pergunta
			for (int i = 0; i < numQuestoesObjetivas; i++) {
				int contagem = estatisticas.getContagem();
				Map<Integer, Integer> mapaRespostas = respostas.get(i)
						.getContagemAlternativa();
				document.add(new Paragraph((i + 1) + "- "
						+ formulario.getQuestao(i + 1)));
				int contador = 1;
				// Iteração sobre cada alternativa da pergunta da vez
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
	 * @return os dados das avaliações no período. Se não houver dados, retorna <b>null</b>.
	 */
	public DadosAvaliacao gerarDadosEstatisticos(Estatisticas estatisticas,
			Date dataInicial, Date dataFinal) {
		// Criação de um objeto document com pagina de tamanha A4.
		DadosAvaliacao dados = new DadosAvaliacao();
		Formulario formulario = Formulario.getFormulario();
		dados.setDataInicial(formataData(dataInicial));
		dados.setDataFinal(formataData(dataFinal));
		if(estatisticas.getContagem() <= 0){
			return null; 
		}
		dados.setTotal(estatisticas.getContagem());
		// define as questões
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
	 * Método que gera uma String que representa os resultados de cada alternativa e armazena no bean dados.
	 * @param estatisticas Dados estatisticos.
	 * @param dados bean para armazenar os dados.
	 * @param formulario bean contendo as perguntas e alternativas.
	 */
	private DadosAvaliacao gerarAlternativas(Estatisticas estatisticas,
			DadosAvaliacao dados, Formulario formulario) {
		Map<Integer, EstatisticaResposta> respostas = estatisticas.getMapaEstatisticaResposta();
		// Iteração sobre cada pergunta
		for (int i = 0; i < numQuestoesObjetivas; i++) {
			int contagem = estatisticas.getContagem();
			Map<Integer, Integer> mapaRespostas = respostas.get(i).getContagemAlternativa();
			int contador = 1;
			// Iteração sobre cada alternativa da pergunta e contatena a pergunta com a respectiva porcentagem
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
	 * Formata o texto de uma data para o formato dia / mês/ ano
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
	 * Formata a String da porcentagem, utilizando o padrão dd,d%, onde d
	 * representa um dígito
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
