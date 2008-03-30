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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import util.DataUtil;
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
 * Classe que testa a classe DadosAvaliacao
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaDadosAvaliacao extends TestCase {
	
	protected DadosAvaliacao da;
	protected List<String> resp6;
	protected List<String> resp7;
	protected String[] alter = {"alternativas1","alternativas2","alternativas3","alternativas4","alternativas5"};
	
	/**
	 * Construtor
	 */
	public TestaDadosAvaliacao(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		da = new DadosAvaliacao();
		da.setAlternativas1(alter);
		da.setAlternativas2(alter);
		da.setAlternativas3(alter);
		da.setAlternativas4(alter);
		da.setAlternativas5(alter);
		da.setDataFinal(DataUtil.gerarData("01", "02", "2008").toString());
		da.setDataInicial(DataUtil.gerarData("01", "01", "2008").toString());
		da.setQuestao1("questao1");
		da.setQuestao2("questao2");
		da.setQuestao3("questao3");
		da.setQuestao4("questao4");
		da.setQuestao5("questao5");
		da.setQuestao6("questao6");
		da.setQuestao7("questao7");
		resp6 = new ArrayList<String>();
		da.setRespostas06(resp6);
		resp7 = new ArrayList<String>();
		da.setRespostas07(resp7);	
	}

	/**
	 * Testa o  metodo getAlternativas1().
	 */
	public void testGetAlternativas1() {
		assertEquals(alter, da.getAlternativas1());
	}

	/**
	 * Testa o metodo setAlternativas1().
	 */
	public void testSetAlternativas1() {
		String[] alternativas = {"a","b","c"};
		da.setAlternativas1(alternativas);
		assertEquals(alternativas, da.getAlternativas1());
	}

	/**
	 * Testa o metodo getAlternativas2().
	 */
	public void testGetAlternativas2() {
		assertEquals(alter, da.getAlternativas2());
	}

	/**
	 * Testa o metodo setAlternativas2().
	 */
	public void testSetAlternativas2() {
		String[] alternativas = {"a","b","c"};
		da.setAlternativas2(alternativas);
		assertEquals(alternativas, da.getAlternativas2());
	}

	/**
	 * Testa o metodo getAlternativas3().
	 */
	public void testGetAlternativas3() {
		assertEquals(alter, da.getAlternativas3());
	}

	/**
	 * Testa o metodo setAlternativas3().
	 */
	public void testSetAlternativas3() {
		String[] alternativas = {"a","b","c"};
		da.setAlternativas3(alternativas);
		assertEquals(alternativas, da.getAlternativas3());
	}

	/**
	 * Testa o metodo getAlternativas4().
	 */
	public void testGetAlternativas4() {
		assertEquals(alter, da.getAlternativas4());
	}

	/**
	 * Testa o metodo setAlternativas4().
	 */
	public void testSetAlternativas4() {
		String[] alternativas = {"a","b","c"};
		da.setAlternativas4(alternativas);
		assertEquals(alternativas, da.getAlternativas4());
	}

	/**
	 * Testa o metodo getAlternativas5().
	 */
	public void testGetAlternativas5() {
		assertEquals(alter, da.getAlternativas5());
	}

	/**
	 * Testa o metodo setAlternativas5().
	 */
	public void testSetAlternativas5() {
		String[] alternativas = {"a","b","c"};
		da.setAlternativas5(alternativas);
		assertEquals(alternativas, da.getAlternativas5());
	}

	/**
	 * Testa o metodo getDataFinal().
	 */
	public void testGetDataFinal() {
		assertEquals(DataUtil.gerarData("01", "02", "2008").toString(), da.getDataFinal().toString());
	}

	/**
	 * Testa o metodo setDataFinal().
	 */
	public void testSetDataFinal() {
		da.setDataFinal(DataUtil.gerarData("02", "03", "2008").toString());
		assertEquals(DataUtil.gerarData("02", "03", "2008").toString(), da.getDataFinal());
	}

	/**
	 * Testa o metodo getDataInicial().
	 */
	public void testGetDataInicial() {
		assertEquals(DataUtil.gerarData("01", "01", "2008").toString(), da.getDataInicial().toString());
	}

	/**
	 * Testa o metodo setDataInicial().
	 */
	public void testSetDataInicial() {
		da.setDataInicial(DataUtil.gerarData("02", "02", "2008").toString());
		assertEquals(DataUtil.gerarData("02", "02", "2008").toString(), da.getDataInicial());
	}

	/**
	 * Testa o metodo getQuestao1().
	 */
	public void testGetQuestao1() {
		assertEquals("questao1", da.getQuestao1());
	}

	/**
	 * Testa o metodo setQuestao1().
	 */
	public void testSetQuestao1() {
		da.setQuestao1("nova_questao1");
		assertEquals("nova_questao1", da.getQuestao1());
	}

	/**
	 * Testa o metodo getQuestao2().
	 */
	public void testGetQuestao2() {
		assertEquals("questao2", da.getQuestao2());
	}

	/**
	 * Testa o metodo setQuestao2().
	 */
	public void testSetQuestao2() {
		da.setQuestao2("nova_questao2");
		assertEquals("nova_questao2", da.getQuestao2());
	}

	/**
	 * Testa o metodo getQuestao3().
	 */
	public void testGetQuestao3() {
		assertEquals("questao3", da.getQuestao3());
	}

	/**
	 * Testa o metodo setQuestao3().
	 */
	public void testSetQuestao3() {
		da.setQuestao3("nova_questao3");
		assertEquals("nova_questao3", da.getQuestao3());
	}

	/**
	 * Testa o metodo getQuestao4().
	 */
	public void testGetQuestao4() {
		assertEquals("questao4", da.getQuestao4());
	}

	/**
	 * Testa o metodo setQuestao4().
	 */
	public void testSetQuestao4() {
		da.setQuestao4("nova_questao4");
		assertEquals("nova_questao4", da.getQuestao4());
	}

	/**
	 * Testa o metodo getQuestao5().
	 */
	public void testGetQuestao5() {
		assertEquals("questao5", da.getQuestao5());
	}

	/**
	 * Testa o metodo setQuestao5().
	 */
	public void testSetQuestao5() {
		da.setQuestao5("nova_questao5");
		assertEquals("nova_questao5", da.getQuestao5());
	}

	/**
	 * Testa o metodo getQuestao6().
	 */
	public void testGetQuestao6() {
		assertEquals("questao6", da.getQuestao6());
	}

	/**
	 * Testa o metodo setQuestao6().
	 */
	public void testSetQuestao6() {
		da.setQuestao6("nova_questao6");
		assertEquals("nova_questao6", da.getQuestao6());
	}

	/**
	 * Testa o metodo getQuestao7().
	 */
	public void testGetQuestao7() {
		assertEquals("questao7", da.getQuestao7());
	}

	/**
	 * Testa o metodo setQuestao7().
	 */
	public void testSetQuestao7() {
		da.setQuestao7("nova_questao7");
		assertEquals("nova_questao7", da.getQuestao7());
	}

	/**
	 * Testa o metodo getRespostas06().
	 */
	public void testGetRespostas06() {
		List<String> l = new ArrayList<String>();
		assertEquals(l, da.getRespostas06());
	}

	/**
	 * Testa o metodo setRespostas06().
	 */
	public void testSetRespostas06() {
		da.getRespostas06().add("Verdade");
		List<String> l = new ArrayList<String>();
		l.add("Verdade");
		assertEquals(l, da.getRespostas06());
	}

	/**
	 * Testa o metodo getRespostas07().
	 */
	public void testGetRespostas07() {
		List<String> l = new ArrayList<String>();
		assertEquals(l, da.getRespostas07());
	}

	/**
	 * Testa o metodo setRespostas07().
	 */
	public void testSetRespostas07() {
		da.getRespostas07().add("Verdade");
		List<String> l = new ArrayList<String>();
		l.add("Verdade");
		assertEquals(l, da.getRespostas07());
	}

	/**
	 * Testa o metodo getTotal().
	 */
	public void testGetTotal() {
		assertEquals(0, da.getTotal());
	}

	/**
	 * Testa o metodo setTotal().
	 */
	public void testSetTotal() {
		da.setTotal(10);
		assertEquals(10, da.getTotal());
	}

	/**
	 * Testa o metodo setQuestao().
	 */
	public void testSetQuestao() {
		da.setQuestao(1, "questao");
		assertEquals("questao", da.getQuestao1());
	}

	/**
	 * Testa o metodo getAlternativas().
	 */
	public void testGetAlternativas() {
		assertEquals(alter, da.getAlternativas(1));
	}

	/**
	 * Testa o metodo setAlternativas().
	 */
	public void testSetAlternativas() {
		String[] a = {"a", "b"};
		da.setAlternativas(1, a);
		assertEquals(a, da.getAlternativas1());
	}

	/**
	 * Testa o metodo getQuestao().
	 */
	public void testGetQuestao() {
		assertEquals("questao1", da.getQuestao(1));
	}

	/**
	 * Testa o metodo toString().
	 */
	public void testToString() {
		assertEquals("estatisticas entre Tue Jan 01 00:00:00 GMT-03:00 2008 e Fri Feb 01 00:00:00 GMT-03:00 2008\n" +
					 " total de avaliacoes = 0\n" + "Resultados:\n" + "questao01: questao1:\n" +
					 "  alternativas1, alternativas2, alternativas3, alternativas4, alternativas5\n" +
					 "questao02: questao2:\n" +
					 "  alternativas1, alternativas2, alternativas3, alternativas4, alternativas5\n" +
					 "questao03: questao3:\n" +
					 "  alternativas1, alternativas2, alternativas3, alternativas4, alternativas5\n" +
					 "questao04: questao4:\n" +
					 "  alternativas1, alternativas2, alternativas3, alternativas4, alternativas5\n" +
					 "questao05: questao5:\n" +
					 "  alternativas1, alternativas2, alternativas3, alternativas4, alternativas5\n" +
					 "respostas06=[]\n" + "respostas07=[]" 
				 , da.toString());
	}

}
