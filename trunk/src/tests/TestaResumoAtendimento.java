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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import util.DataUtil;
import estatisticas.atendimento.DadosAtendimento;
import estatisticas.atendimento.ResumoAtendimento;

/*
* UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
* CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
* DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
* DISCIPLINA - PROJETO 2
* PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
* ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
* 			HAMON BARROS HENRIQUES
* 			RODRIGO LOPES
*/

/**
* Teste de Unidade para a classe DadosAtendimento
* 
* @author Carlos trajano
* @author Hamon Barros Henriques
* @author Rodrigo Lopes
* 
* @version 1.0
*/
public class TestaResumoAtendimento extends TestCase {
	
	private ResumoAtendimento ra1, ra2;
	private Date dateInicial1, dateInicial2, dateFinal1, dateFinal2;
	Map<String, Integer> atendentes1, atendentes2, classes1, classes2;
	Map<Integer, Integer> guiches1, guiches2;
	Map<String, String> percentualAtendente, percentualGuiche, percentualClasse;
	

	protected void setUp() throws Exception {
		DadosAtendimento da1, da2;
		atendentes1 = new HashMap<String, Integer>();
		guiches1 = new HashMap<Integer, Integer>();
		classes1 = new HashMap<String, Integer>();
		atendentes2 = new HashMap<String, Integer>();
		guiches2 = new HashMap<Integer, Integer>();
		classes2 = new HashMap<String, Integer>();
		percentualAtendente = new HashMap<String, String>();
		percentualClasse = new HashMap<String, String>();
		percentualGuiche = new HashMap<String, String>();
		
		
		da1 = new DadosAtendimento();
		da2 = new DadosAtendimento();
		
		atendentes1.put("joaol", 8);
		atendentes1.put("marianaa", 5);
		atendentes1.put("johnny", 2);
		guiches1.put(01, 10);
		guiches1.put(02, 5);	
		classes1.put("ABC", 10);
		classes1.put("SEI", 5);
		da1.setAtendenteAtendimentos(atendentes1);
		da1.setGuicheAtendimentos(guiches1);
		da1.setClasseAtendimentos(classes1);
		da1.setData(DataUtil.gerarData("01", "02", "07"));
		da1.setTotalAtendimentos(15);
		
		percentualAtendente.put("joaol", "53.3%");
		percentualAtendente.put("marianaa", "33.3%");
		percentualAtendente.put("johnny", "13.3%");
		
		percentualGuiche.put("01", "66.6%");
		percentualGuiche.put("02", "33.3%");
		
		percentualClasse.put("ABC", "66.6%");
		percentualClasse.put("SEI", "33.3%");
	
		da2.setAtendenteAtendimentos(atendentes2);
		da2.setClasseAtendimentos(classes2);
		da2.setGuicheAtendimentos(guiches2);
		da2.setData(DataUtil.gerarData("10", "11", "12"));
		da2.setTotalAtendimentos(0);
		
		List<DadosAtendimento> dados = new ArrayList<DadosAtendimento>();
		dados.add(da1);
		dados.add(da2);
		
		dateInicial1 = DataUtil.gerarData("12", "1O", "2007");
		dateFinal1 = DataUtil.gerarData("12", "1O", "2007");
		dateFinal2 = DataUtil.gerarData("10", "12", "2012");
//		ra1 = new ResumoAtendimento(dateInicial1, dateFinal1, dados);
//		ra2 = new ResumoAtendimento(dateInicial1, dateFinal2, new ArrayList<DadosAtendimento>());
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getAtendenteTotalAtendimento()}.
	 */
	public final void testGetAtendenteTotalAtendimento() {
		assertTrue(ra1.getTotalAtendimentos() == 15);
		assertTrue(ra2.getTotalAtendimentos() == 0);
		ra1.setTotalAtendimentos(25);
		assertTrue(ra1.getTotalAtendimentos() == 25);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getAtendentePercentualAtendimento()}.
	 */
	public final void testGetAtendentePercentualAtendimento() {
		for(String chave: percentualAtendente.keySet()){
			assertEquals(percentualAtendente.get(chave), ra1.getAtendentePercentualAtendimento().get(chave) );
		}
		assertTrue(ra2.getAtendentePercentualAtendimento().keySet().size() == 0);
		
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getGuichePercentualAtendimento()}.
	 */
	public final void testGetGuichePercentualAtendimento() {
		for(String chave: percentualGuiche.keySet()){
			assertEquals(percentualGuiche.get(chave), ra1.getGuichePercentualAtendimento().get(chave) );
		}
		assertTrue(ra2.getGuichePercentualAtendimento().keySet().size() == 0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getClassePercentualAtendimento()}.
	 */
	public final void testGetClassePercentualAtendimento() {
		for(String chave: percentualClasse.keySet()){
			assertEquals(percentualClasse.get(chave), ra1.getClassePercentualAtendimento().get(chave) );
		}
		assertTrue(ra2.getClassePercentualAtendimento().keySet().size() == 0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setAtendenteTotalAtendimento(java.util.Map)}.
	 */
	public final void testSetAtendenteTotalAtendimento() {
		for(String chave: atendentes1.keySet()){
			assertEquals(atendentes1.get(chave), ra1.getAtendenteTotalAtendimento().get(chave) );
		}
		assertTrue(ra2.getAtendenteTotalAtendimento().keySet().size() == 0);
		ra1.setAtendenteTotalAtendimento(atendentes2);
		assertTrue(ra1.getAtendenteTotalAtendimento().keySet().size() == 0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getClasseTotalAtendimento()}.
	 */
	public final void testGetClasseTotalAtendimento() {
		for(String chave: classes1.keySet()){
			assertEquals(classes1.get(chave), ra1.getClasseTotalAtendimento().get(chave) );
		}
		assertTrue(ra2.getClasseTotalAtendimento().keySet().size() == 0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setClasseTotalAtendimento(java.util.Map)}.
	 */
	public final void testSetClasseTotalAtendimento() {
		for(String chave: classes1.keySet()){
			assertEquals(classes1.get(chave), ra1.getClasseTotalAtendimento().get(chave) );
		}
		assertTrue(ra2.getClasseTotalAtendimento().keySet().size() == 0);
		ra1.setClasseTotalAtendimento(classes2);
		assertTrue(ra1.getClasseTotalAtendimento().keySet().size() == 0);
		ra2.setClasseTotalAtendimento(classes1);
		for(String chave: classes1.keySet()){
			assertEquals(classes1.get(chave), ra2.getClasseTotalAtendimento().get(chave) );
		}
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getDataFinal()}.
	 */
	public final void testGetDataFinal() {
		assertEquals(dateFinal1, ra1.getDataFinal());
		assertEquals(dateFinal2, ra2.getDataFinal());
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setDataFinal(java.util.Date)}.
	 */
	public final void testSetDataFinal() {
//		assertEquals(dateFinal1, ra1.getDataFinal());
//		assertEquals(dateFinal2, ra2.getDataFinal());
//		ra1.setDataFinal(dateFinal2);
//		assertEquals(dateFinal2, ra1.getDataFinal());
//		ra2.setDataFinal(dateFinal1);
//		assertEquals(dateFinal1, ra2.getDataFinal());
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getDataInicial()}.
	 */
	public final void testGetDataInicial() {
		assertEquals(dateInicial1, ra1.getDataInicial());
		assertEquals(dateInicial2, ra2.getDataInicial());
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setDataInicial(java.util.Date)}.
	 */
	public final void testSetDataInicial() {
//		assertEquals(dateInicial1, ra1.getDataInicial());
//		assertEquals(dateInicial2, ra2.getDataInicial());
//		ra1.setDataInicial(dateInicial2);
//		assertEquals(dateInicial2, ra1.getDataInicial());
//		ra2.setDataInicial(dateInicial1);
//		assertEquals(dateInicial1, ra2.getDataInicial());
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getGuicheTotalAtendimento()}.
	 */
	public final void testGetGuicheTotalAtendimento() {
		for(int chave: guiches1.keySet()){
			assertEquals(guiches1.get(chave), ra1.getGuicheTotalAtendimento().get(chave) );
		}
		assertTrue(ra2.getGuicheTotalAtendimento().keySet().size() == 0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setGuicheTotalAtendimento(java.util.Map)}.
	 */
	public final void testSetGuicheTotalAtendimento() {
		for(int chave: guiches1.keySet()){
			assertEquals(guiches1.get(chave), ra1.getGuicheTotalAtendimento().get(chave) );
		}
		assertTrue(ra2.getGuicheTotalAtendimento().keySet().size() == 0);
		ra1.setGuicheTotalAtendimento(guiches2);
		assertTrue(ra1.getGuicheTotalAtendimento().keySet().size() == 0);
		ra2.setGuicheTotalAtendimento(guiches1);
		for(int chave: guiches1.keySet()){
			assertEquals(guiches1.get(chave), ra2.getGuicheTotalAtendimento().get(chave) );
		}
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getMediaAtendente()}.
	 */
	public final void testGetMediaAtendente() {
		assertTrue(ra1.getMediaAtendente() == 5.0);
		ra1.setMediaAtendente(15.73);
		assertTrue(ra1.getMediaAtendente() == 15.73);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setMediaAtendente(int)}.
	 */
	public final void testSetMediaAtendente() {
		assertTrue(ra1.getMediaAtendente() == 5.0);
		ra1.setMediaAtendente(20.0);
		assertTrue(ra1.getMediaAtendente() == 20.0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getMediaClasse()}.
	 */
	public final void testGetMediaClasse() {
		assertTrue(ra1.getMediaClasse() == 7.5	);
		ra1.setMediaClasse(15.73);
		assertTrue(ra1.getMediaClasse() == 15.73);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setMediaClasse(int)}.
	 */
	public final void testSetMediaClasse() {
		ra1.setMediaClasse(15.73);
		assertTrue(ra1.getMediaClasse() == 15.73);
		ra1.setMediaClasse(15.45646);
		assertTrue(ra1.getMediaClasse() == 15.45646);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getMediaGuiche()}.
	 */
	public final void testGetMediaGuiche() {
		assertTrue(ra1.getMediaGuiche() == 7.5	);
		ra1.setMediaGuiche(15.73);
		assertTrue(ra1.getMediaGuiche() == 15.73);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setMediaGuiche(int)}.
	 */
	public final void testSetMediaGuiche() {
		ra1.setMediaGuiche(15.73);
		assertTrue(ra1.getMediaGuiche() == 15.73);
		ra1.setMediaGuiche(7.5);
		assertTrue(ra1.getMediaGuiche() == 7.5	);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#getTotalAtendimentos()}.
	 */
	public final void testGetTotalAtendimentos() {
		assertTrue(ra1.getTotalAtendimentos() == 15);
		assertTrue(ra2.getTotalAtendimentos() == 0);
	}

	/**
	 * Testa o método {@link estatisticas.atendimento.ResumoAtendimento#setTotalAtendimentos(int)}.
	 */
	public final void testSetTotalAtendimentos() {
		ra1.setTotalAtendimentos(25);
		assertTrue(ra1.getTotalAtendimentos() == 25);
		ra1.setTotalAtendimentos(15);
		assertTrue(ra1.getTotalAtendimentos() == 15);
		ra2.setTotalAtendimentos(0);
		assertTrue(ra2.getTotalAtendimentos() == 0);
	}

}
