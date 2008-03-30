package tests;

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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import util.GeradorGraficosRelatorioAvaliacao;
import util.GeradorRelatorioAvaliacao;
import database.bean.DadosAvaliacao;

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
 * Classe que implementa o gerador de gr�ficos com informa��es
 * dos relat�rios de avalia��o
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaGeradorGraficosRelatorioAvaliacao extends TestCase {

	private GeradorGraficosRelatorioAvaliacao gerador;
	
	public TestaGeradorGraficosRelatorioAvaliacao(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		gerador = new GeradorGraficosRelatorioAvaliacao();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe
	 * TestaGeradorGraficosRelatorioAvaliacao
	 * 
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaGeradorGraficosRelatorioAvaliacao.class);
	}
	
	public void testGerarGraficosRelatorioAvaliacao(){
		try{
		DadosAvaliacao dados = new DadosAvaliacao();
		String[] alternativas = new String[5];
		alternativas[0]  = "20.00%";
		alternativas[1]  = "10.00%";
		alternativas[2]  = "30.00%";
		alternativas[3]  = "35.00%";
		alternativas[4]  = "50.00%";
		dados.setAlternativas1(alternativas);
		dados.setAlternativas2(alternativas);
		dados.setAlternativas3(alternativas);
		dados.setAlternativas4(alternativas);
		dados.setAlternativas5(alternativas);
		dados.setQuestao1("Questao1");
		dados.setQuestao2("Questao2");
		dados.setQuestao3("Questao3");
		dados.setQuestao4("Questao4");
		dados.setQuestao5("Questao5");
		gerador.gerarGraficos(dados);
		}catch (Exception e){
			fail("N�o foi possivel gerar os gr�ficos");
		}
	}
	
}
