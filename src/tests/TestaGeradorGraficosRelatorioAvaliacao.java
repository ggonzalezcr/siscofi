package tests;

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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa o gerador de gráficos com informações
 * dos relatórios de avaliação
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
			fail("Não foi possivel gerar os gráficos");
		}
	}
	
}
