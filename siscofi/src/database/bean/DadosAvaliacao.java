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

import java.util.ArrayList;
import java.util.List;

import util.DataUtil;

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
 * Bean que armazena os resultados estatísticos das avaliações.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 * 
 */

public class DadosAvaliacao {
	
	//Perguntas
	private String questao1;
	private String questao2;
	private String questao3;
	private String questao4;
	private String questao5;
	private String questao6;
	private String questao7;
	
	//Alternativas das perguntas
	private String[] alternativas1 = new String[5];  
	private String[] alternativas2 = new String[5];
	private String[] alternativas3 = new String[5];
	private String[] alternativas4 = new String[5];
	private String[] alternativas5 = new String[5];
	
	List<String> respostas06 = new ArrayList<String>();
	List<String> respostas07 = new ArrayList<String>();
	
	//Número de avaliações utilizados na estatistica
	int total;
	
	//Data inicial do período da estatística
	String dataInicial;
	
	//Data final do período da estatística
	String dataFinal;

	/**
	 * Determina o alternativas1.
	 * @return o valor de alternativas1.
	 */
	public String[] getAlternativas1() {
		return alternativas1;
	}

	/**
	 * Altera o valor do alternativas1.
	 * @param alternativas1 novo valor do alternativas1.
	 */
	public void setAlternativas1(String[] alternativas1) {
		this.alternativas1 = alternativas1;
	}

	/**
	 * Determina o alternativas2.
	 * @return o valor de alternativas2.
	 */
	public String[] getAlternativas2() {
		return alternativas2;
	}

	/**
	 * Altera o valor do alternativas2.
	 * @param alternativas2 novo valor do alternativas2.
	 */
	public void setAlternativas2(String[] alternativas2) {
		this.alternativas2 = alternativas2;
	}

	/**
	 * Determina o alternativas3.
	 * @return o valor de alternativas3.
	 */
	public String[] getAlternativas3() {
		return alternativas3;
	}

	/**
	 * Altera o valor do alternativas3.
	 * @param alternativas3 novo valor do alternativas3.
	 */
	public void setAlternativas3(String[] alternativas3) {
		this.alternativas3 = alternativas3;
	}

	/**
	 * Determina o alternativas4.
	 * @return o valor de alternativas4.
	 */
	public String[] getAlternativas4() {
		return alternativas4;
	}

	/**
	 * Altera o valor do alternativas4.
	 * @param alternativas4 novo valor do alternativas4.
	 */
	public void setAlternativas4(String[] alternativas4) {
		this.alternativas4 = alternativas4;
	}

	/**
	 * Determina o alternativas5.
	 * @return o valor de alternativas5.
	 */
	public String[] getAlternativas5() {
		return alternativas5;
	}

	/**
	 * Altera o valor do alternativas5.
	 * @param alternativas5 novo valor do alternativas5.
	 */
	public void setAlternativas5(String[] alternativas5) {
		this.alternativas5 = alternativas5;
	}

	/**
	 * Determina o dataFinal.
	 * @return o valor de dataFinal.
	 */
	public String getDataFinal() {
		return dataFinal;
	}

	/**
	 * Altera o valor do dataFinal.
	 * @param dataFinal novo valor do dataFinal.
	 */
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	/**
	 * Determina o dataInicial.
	 * @return o valor de dataInicial.
	 */
	public String getDataInicial() {
		return dataInicial;
	}

	/**
	 * Altera o valor do dataInicial.
	 * @param dataInicial novo valor do dataInicial.
	 */
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	/**
	 * Determina o questao1.
	 * @return o valor de questao1.
	 */
	public String getQuestao1() {
		return questao1;
	}

	/**
	 * Altera o valor do questao1.
	 * @param questao1 novo valor do questao1.
	 */
	public void setQuestao1(String questao1) {
		this.questao1 = questao1;
	}

	/**
	 * Determina o questao2.
	 * @return o valor de questao2.
	 */
	public String getQuestao2() {
		return questao2;
	}

	/**
	 * Altera o valor do questao2.
	 * @param questao2 novo valor do questao2.
	 */
	public void setQuestao2(String questao2) {
		this.questao2 = questao2;
	}

	/**
	 * Determina o questao3.
	 * @return o valor de questao3.
	 */
	public String getQuestao3() {
		return questao3;
	}

	/**
	 * Altera o valor do questao3.
	 * @param questao3 novo valor do questao3.
	 */
	public void setQuestao3(String questao3) {
		this.questao3 = questao3;
	}

	/**
	 * Determina o questao4.
	 * @return o valor de questao4.
	 */
	public String getQuestao4() {
		return questao4;
	}

	/**
	 * Altera o valor do questao4.
	 * @param questao4 novo valor do questao4.
	 */
	public void setQuestao4(String questao4) {
		this.questao4 = questao4;
	}

	/**
	 * Determina o questao5.
	 * @return o valor de questao5.
	 */
	public String getQuestao5() {
		return questao5;
	}

	/**
	 * Altera o valor do questao5.
	 * @param questao5 novo valor do questao5.
	 */
	public void setQuestao5(String questao5) {
		this.questao5 = questao5;
	}

	/**
	 * Determina o questao6.
	 * @return o valor de questao6.
	 */
	public String getQuestao6() {
		return questao6;
	}

	/**
	 * Altera o valor do questao6.
	 * @param questao6 novo valor do questao6.
	 */
	public void setQuestao6(String questao6) {
		this.questao6 = questao6;
	}

	/**
	 * Determina o questao7.
	 * @return o valor de questao7.
	 */
	public String getQuestao7() {
		return questao7;
	}

	/**
	 * Altera o valor do questao7.
	 * @param questao7 novo valor do questao7.
	 */
	public void setQuestao7(String questao7) {
		this.questao7 = questao7;
	}

	/**
	 * Determina o respostas06.
	 * @return o valor de respostas06.
	 */
	public List<String> getRespostas06() {
		return respostas06;
	}

	/**
	 * Altera o valor do respostas06.
	 * @param respostas06 novo valor do respostas06.
	 */
	public void setRespostas06(List<String> respostas06) {
		this.respostas06 = respostas06;
	}

	/**
	 * Determina o respostas07.
	 * @return o valor de respostas07.
	 */
	public List<String> getRespostas07() {
		return respostas07;
	}

	/**
	 * Altera o valor do respostas07.
	 * @param respostas07 novo valor do respostas07.
	 */
	public void setRespostas07(List<String> respostas07) {
		this.respostas07 = respostas07;
	}

	/**
	 * Determina o total.
	 * @return o valor de total.
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Altera o valor do total.
	 * @param total novo valor do total.
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
	/**
	 * Altera uma das questões.
	 * @param indice O número da questão a ser alterada. Valores de 01 a 07.
	 * @param questao O novo valor da questão.
	 */
	public void setQuestao(int indice, String questao){
		switch(indice){
		case 1:
			setQuestao1(questao);
			break;
		case 2:
			setQuestao2(questao);
			break;
		case 3:
			setQuestao3(questao);
			break;
		case 4:
			setQuestao4(questao);
			break;
		case 5:
			setQuestao5(questao);
			break;
		case 6:
			setQuestao6(questao);
			break;
		case 7:
			setQuestao7(questao);
			break;
		}
	}
	
	/**
	 * Determina um array contendo todas as alternativas pertencentes a uma pergunta n.
	 * @param indice Número da pergunta.
	 * @return Array de alternativas de pergunta.
	 */
	public String[] getAlternativas(int indice) {
		String[] alternativas = null;
		switch (indice) {
		case 1:
			alternativas = getAlternativas1();
			break;
		case 2:
			alternativas = getAlternativas2();
			break;
		case 3:
			alternativas = getAlternativas3();
			break;
		case 4:
			alternativas = getAlternativas4();
			break;
		case 5:
			alternativas = getAlternativas5();
			break;
		}
		return alternativas;
	}
	
	
	/**
	 * Altera as alternativas de uma questão
	 * @param indice O número da questão cujas alternativas serão alteradas. Valores de 01 a 05
	 * @param questao As novas alternativas da questão.
	 */
	public void setAlternativas(int indice, String[] alternativas){
		switch(indice){
		case 1:
			setAlternativas1(alternativas);
			break;
		case 2:
			setAlternativas2(alternativas);
			break;
		case 3:
			setAlternativas3(alternativas);
			break;
		case 4:
			setAlternativas4(alternativas);
			break;
		case 5:
			setAlternativas5(alternativas);
			break;
		}
	}

	public String getQuestao(int questao) {
		switch (questao) {
		case 1:
			return this.questao1;
		case 2:
			return this.questao2;
		case 3:
			return this.questao3;
		case 4:
			return this.questao4;
		case 5:
			return this.questao5;

		}
		return null;
	}
	
	@Override
	public String toString() {
		String alternativas = "";
		for(int i = 1; i <= 5; i++ ){
			String[] resps = getAlternativas(i);
			String concatenado = "";
			for(int k = 0; k < 5; k++){
				concatenado += resps[k];
				if (k < 4){
					concatenado += ", ";
				}
			}
			alternativas += "questao0" + i + ": " + getQuestao(i) + ":\n  " + concatenado + "\n"; 
		}
		return "estatisticas entre " + dataInicial + " e " + dataFinal + "\n total de avaliacoes = " + total + "\nResultados:\n" + alternativas + "respostas06=" + respostas06 + "\nrespostas07=" + respostas07;
	}
}
