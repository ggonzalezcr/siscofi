package database.bean;

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

import java.io.FileNotFoundException;
import java.util.Date;

import util.XMLUtil;
import controller.Configuracao;

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
 * Bean que armazena os dados de um formulário de avaliação.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */
public class Formulario {
	
	private final String QUESTAO1 = "O que você achou da cordialidade dos servidores que o atenderam desde que chegou aqui?";
	private final String QUESTAO2 = "Como você se deslocou  para os vários setores em que foi atendido?";
	private final String QUESTAO3 = "Os servidores que o atenderam demonstraram conhecimento do serviço?";
	private final String QUESTAO4 = "Quando saiu de casa, você já sabia quais os documentos que precisava trazer para receber o atendimento?";
	private final String QUESTAO5 = "A estrutura do local de atendimento (acessos, escadas, rampas , local espera, banheiros, guichê de atendimento, entrega de título, sistema de senhas, etc...)  lhe pareceu:";
	private final String QUESTAO6 = "O que foi melhor e pior no atendimento que você recebeu?";
	private final String QUESTAO7 = "Alguma ocorrência, sugestão, crítica ou reclamação que gostaria de deixar registrado?";
	private final String[] ALTERANTIVAS1 = {"péssima", "ruim", "razoável", "boa", "excelente"};
	private final String[] ALTERANTIVAS2 = {"com muita facilidade", "com facilidade", "estive meio perdido", "com dificuldade", "com muita dificuldade"};
	private final String[] ALTERANTIVAS3 = {"nenhum  conhecimento", "pouco", "algum", "muito", "total"};
	private final String[] ALTERANTIVAS4 = {"não sabia que precisava trazer documentos", "tinha ouvido falar de algum", "mais ou menos", "sabia, mas tinha alguma dúvida", "sabia de todos com segurança"};
	private final String[] ALTERANTIVAS5 = { "péssima", "ruim", "razoável",	"boa", "excelente" };
	// Atributos
	private String[] alternativas1 = new String[5];  
	private String[] alternativas2 = new String[5];
	private String[] alternativas3 = new String[5];
	private String[] alternativas4 = new String[5];
	private String[] alternativas5 = new String[5];
	private String questao1;
	private String questao2;
	private String questao3;
	private String questao4;
	private String questao5;
	private String questao6;
	private String questao7;
	
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private String resposta4;
	private String resposta5;
	private String resposta6;
	private String resposta7;
	
	/**
	 * Construtor
	 */
	public Formulario(){
		
	}

	/**
	 * Retorna o valor do atributo alternativas1
	 * @return o valor do atributo alternativas1
	 */
	public String[] getAlternativas1() {
		return alternativas1;
	}

	/**
	 * Altera o valor do atributo alternativas1
	 * @param alternativas1 O novo valor do atributo alternativas1 
	 */
	public void setAlternativas1(String[] alternativas1) {
		this.alternativas1 = alternativas1;
	}

	/**
	 * Retorna o valor do atributo alternativas2
	 * @return o valor do atributo alternativas2
	 */
	public String[] getAlternativas2() {
		return alternativas2;
	}

	/**
	 * Altera o valor do atributo alternativas2
	 * @param alternativas2 O novo valor do atributo alternativas2 
	 */
	public void setAlternativas2(String[] alternativas2) {
		this.alternativas2 = alternativas2;
	}

	/**
	 * Retorna o valor do atributo alternativas3
	 * @return o valor do atributo alternativas3
	 */
	public String[] getAlternativas3() {
		return alternativas3;
	}

	/**
	 * Altera o valor do atributo alternativas3
	 * @param alternativas3 O novo valor do atributo alternativas3 
	 */
	public void setAlternativas3(String[] alternativas3) {
		this.alternativas3 = alternativas3;
	}

	/**
	 * Retorna o valor do atributo alternativas4
	 * @return o valor do atributo alternativas4
	 */
	public String[] getAlternativas4() {
		return alternativas4;
	}

	/**
	 * Altera o valor do atributo alternativas4
	 * @param alternativas4 O novo valor do atributo alternativas4 
	 */
	public void setAlternativas4(String[] alternativas4) {
		this.alternativas4 = alternativas4;
	}

	/**
	 * Retorna o valor do atributo alternativas5
	 * @return o valor do atributo alternativas5
	 */
	public String[] getAlternativas5() {
		return alternativas5;
	}

	/**
	 * Altera o valor do atributo alternativas5
	 * @param alternativas5 O novo valor do atributo alternativas5 
	 */
	public void setAlternativas5(String[] alternativas5) {
		this.alternativas5 = alternativas5;
	}

	/**
	 * Retorna o valor do atributo questao1
	 * @return o valor do atributo questao1
	 */
	public String getQuestao1() {
		return questao1;
	}

	/**
	 * Altera o valor do atributo questao1
	 * @param questao1 O novo valor do atributo questao1 
	 */
	public void setQuestao1(String questao1) {
		this.questao1 = questao1;
	}

	/**
	 * Retorna o valor do atributo questao2
	 * @return o valor do atributo questao2
	 */
	public String getQuestao2() {
		return questao2;
	}

	/**
	 * Altera o valor do atributo questao2
	 * @param questao2 O novo valor do atributo questao2 
	 */
	public void setQuestao2(String questao2) {
		this.questao2 = questao2;
	}

	/**
	 * Retorna o valor do atributo questao3
	 * @return o valor do atributo questao3
	 */
	public String getQuestao3() {
		return questao3;
	}

	/**
	 * Altera o valor do atributo questao3
	 * @param questao3 O novo valor do atributo questao3 
	 */
	public void setQuestao3(String questao3) {
		this.questao3 = questao3;
	}

	/**
	 * Retorna o valor do atributo questao4
	 * @return o valor do atributo questao4
	 */
	public String getQuestao4() {
		return questao4;
	}

	/**
	 * Altera o valor do atributo questao4
	 * @param questao4 O novo valor do atributo questao4 
	 */
	public void setQuestao4(String questao4) {
		this.questao4 = questao4;
	}

	/**
	 * Retorna o valor do atributo questao5
	 * @return o valor do atributo questao5
	 */
	public String getQuestao5() {
		return questao5;
	}

	/**
	 * Altera o valor do atributo questao5
	 * @param questao5 O novo valor do atributo questao5 
	 */
	public void setQuestao5(String questao5) {
		this.questao5 = questao5;
	}

	/**
	 * Retorna a questão 6
	 * @return A questão 6
	 */
	public String getQuestao6() {
		return questao6;
	}

	/**
	 * Altera a questao 6
	 * @param questao6 A nova questão
	 */
	public void setQuestao6(String questao6) {
		this.questao6 = questao6;
	}

	/**
	 * Retorna a questao 7
	 * @return A questao 7
	 */
	public String getQuestao7() {
		return questao7;
	}
	
	/**
	 * Retorna a questao do indice passado como parametros
	 * @param indice O indice da questao. Valores de 1 a 7.
	 * @return A questao do indice
	 */
	public String getQuestao(int indice){
		String resposta = "";
		switch (indice) {
		case 1:
			resposta = getQuestao1();
			break;
		case 2:
			resposta = getQuestao2();
			break;
		case 3:
			resposta = getQuestao3();
			break;
		case 4:
			resposta = getQuestao4();
			break;
		case 5:
			resposta = getQuestao5();
			break;
		case 6:
			resposta = getQuestao6();
			break;
		case 7:
			resposta = getQuestao7();
			break;
		}
		return resposta;

	}

	/**
	 * Altera a questao 7
	 * @param questao7 A nova questao
	 */
	public void setQuestao7(String questao7) {
		this.questao7 = questao7;
	}

	/**
	 * Retorna o formulario que está gravado no XML
	 * @return O formulario que está gravado no XML
	 */
	public static Formulario getFormulario(){
		XMLUtil<Formulario> xmlUtil = new XMLUtil<Formulario>();
		Formulario formulario = null;
		try {
			String path = Configuracao.getPath();
			formulario =  xmlUtil.readXML(path + "/formulario.xml");
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado!");
			e.printStackTrace();
		}
		return formulario;
	}
	
	/**
	 * Gera um formulario com as questões e alterantivas default
	 */
	public void geraXMLDoFormulario(){
		XMLUtil<Formulario> xmlUtil = new XMLUtil<Formulario>();
		this.setQuestao1(QUESTAO1);
		this.setQuestao2(QUESTAO2);
		this.setQuestao3(QUESTAO3);
		this.setQuestao4(QUESTAO4);
		this.setQuestao5(QUESTAO5);
		this.setQuestao6(QUESTAO6);
		this.setQuestao7(QUESTAO7);
		this.setAlternativas1(ALTERANTIVAS1);
		this.setAlternativas2(ALTERANTIVAS2);
		this.setAlternativas3(ALTERANTIVAS3);
		this.setAlternativas4(ALTERANTIVAS4);
		this.setAlternativas5(ALTERANTIVAS5);
		try {
			String path = Configuracao.getPath();
			xmlUtil.writeXML(this, path + "/formulario.xml");
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado!");
		}
		
	}

	/**
	 * Método que determina resposta1
	 * @return o valor de resposta1
	 */
	public String getResposta1() {
		return resposta1;
	}

	/**
	 * Altera o valor da variável resposta1.
	 * @param resposta1 O novo valor de resposta1.
	 */
	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}

	/**
	 * Método que determina resposta2
	 * @return o valor de resposta2
	 */
	public String getResposta2() {
		return resposta2;
	}

	/**
	 * Altera o valor da variável resposta2.
	 * @param resposta2 O novo valor de resposta2.
	 */
	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
	}

	/**
	 * Método que determina resposta3
	 * @return o valor de resposta3
	 */
	public String getResposta3() {
		return resposta3;
	}

	/**
	 * Altera o valor da variável resposta3.
	 * @param resposta3 O novo valor de resposta3.
	 */
	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
	}

	/**
	 * Método que determina resposta4
	 * @return o valor de resposta4
	 */
	public String getResposta4() {
		return resposta4;
	}

	/**
	 * Altera o valor da variável resposta4.
	 * @param resposta4 O novo valor de resposta4.
	 */
	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
	}

	/**
	 * Método que determina resposta5
	 * @return o valor de resposta5
	 */
	public String getResposta5() {
		return resposta5;
	}

	/**
	 * Altera o valor da variável resposta5.
	 * @param resposta5 O novo valor de resposta5.
	 */
	public void setResposta5(String resposta5) {
		this.resposta5 = resposta5;
	}

	/**
	 * Método que determina resposta6
	 * @return o valor de resposta6
	 */
	public String getResposta6() {
		return resposta6;
	}

	/**
	 * Altera o valor da variável resposta6.
	 * @param resposta6 O novo valor de resposta6.
	 */
	public void setResposta6(String resposta6) {
		this.resposta6 = resposta6;
	}

	/**
	 * Método que determina resposta7
	 * @return o valor de resposta7
	 */
	public String getResposta7() {
		return resposta7;
	}

	/**
	 * Altera o valor da variável resposta7.
	 * @param resposta7 O novo valor de resposta7.
	 */
	public void setResposta7(String resposta7) {
		this.resposta7 = resposta7;
	}
	
	/**
	 * Cria um objeto avaliação que contém as respostas contidas no formulário.
	 * @return Uma avaliação.
	 */
	public Avaliacao geraAvaliacao(){
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setData(new Date());
		avaliacao.setResposta1(resposta1);
		avaliacao.setResposta2(resposta2);
		avaliacao.setResposta3(resposta3);
		avaliacao.setResposta4(resposta4);
		avaliacao.setResposta5(resposta5);
		avaliacao.setResposta6(resposta6);
		avaliacao.setResposta7(resposta7);
		return avaliacao;
	}

	/**
	 * Determina um array contendo todas as alternativas pertencentes a uma pergunta n.
	 * @param indice Número da pergunta.
	 * @return Array de alternativas de pergunta.
	 */
	public String[] getAlternativas(int indice) {
		String[] resposta = null;
		switch (indice) {
		case 1:
			resposta = getAlternativas1();
			break;
		case 2:
			resposta = getAlternativas2();
			break;
		case 3:
			resposta = getAlternativas3();
			break;
		case 4:
			resposta = getAlternativas4();
			break;
		case 5:
			resposta = getAlternativas5();
			break;
		}
		return resposta;
	}
	
}
