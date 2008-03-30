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

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
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
 * Testes da classe Estatisticas.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaEstatisticaResposta extends TestCase {

	private EstatisticaResposta estr;
	Map<Integer, Integer> mapaZero, mapaUm;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		estr = new EstatisticaResposta();
		mapaZero = new HashMap<Integer, Integer>();
		mapaUm = new HashMap<Integer, Integer>();
		for(int i = 1; i <= 5; i++){
				mapaZero.put(i, 0);
		}
		for(int i = 1; i <= 5; i++){
			mapaUm.put(i, 5);
		}
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#incrementaAlternativa(int)}.
	 */
	public void testIncrementaAlternativaInt() {
		assertEquals(0, estr.getValorAlternativa(1));
		estr.incrementaAlternativa(1);
		assertEquals(1, estr.getValorAlternativa(1));
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#incrementaAlternativa(int, int)}.
	 */
	public void testIncrementaAlternativaIntInt() {
		assertEquals(0, estr.getValorAlternativa(1));
		estr.incrementaAlternativa(1);
		estr.incrementaAlternativa(1,124);
		assertEquals(125, estr.getValorAlternativa(1));
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#getValorAlternativa(int)}.
	 */
	public void testGetValorAlternativa() {
		assertEquals(0, estr.getValorAlternativa(1));
		estr.incrementaAlternativa(1);
		assertEquals(1, estr.getValorAlternativa(1));
		assertEquals(0, estr.getValorAlternativa(2));
		assertEquals(0, estr.getValorAlternativa(3));
		assertEquals(0, estr.getValorAlternativa(4));
		assertEquals(0, estr.getValorAlternativa(5));
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#getContagemAlternativa()}.
	 */
	public void testGetContagemAlternativa() {
		assertTrue(estr.getContagemAlternativa().size() ==5);
		Map<Integer, Integer> mapa = estr.getContagemAlternativa();
		for(int i = 1; i <= 5; i++){
			assertEquals(new Integer(0), mapa.get(i));
		}
		
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#setContagemAlternativa(java.util.Map)}.
	 */
	public void testSetContagemAlternativa() {
		assertTrue(estr.getContagemAlternativa().size() ==5);
		Map<Integer, Integer> mapa = estr.getContagemAlternativa();
		for(int i = 1; i <= 5; i++){
			assertEquals(new Integer(0), mapa.get(i));
		}
		estr.setContagemAlternativa(mapaUm);
		mapa = estr.getContagemAlternativa();
		for(int i = 1; i <= 5; i++){
			assertEquals(new Integer(5), mapa.get(i));
		}
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#getEstatisticas()}.
	 */
	public void testGetEstatisticas() {
		assertEquals(null, estr.getEstatisticas());
		Estatisticas est = new Estatisticas();
		estr.setEstatisticas(est);
		assertEquals(est, estr.getEstatisticas());
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#setEstatisticas(estatisticas.avaliacao.Estatisticas)}.
	 */
	public void testSetEstatisticas() {
		Estatisticas est = new Estatisticas();
		estr.setEstatisticas(est);
		assertEquals(est, estr.getEstatisticas());
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#getId()}.
	 */
	public void testGetId() {
		assertTrue(estr.getId() == 0);
		estr.setId(10);
		assertTrue(estr.getId() == 10);
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#setId(int)}.
	 */
	public void testSetId() {
		assertTrue(estr.getId() == 0);
		estr.setId(10);
		assertTrue(estr.getId() == 10);
		estr.setId(-110);
		assertTrue(estr.getId() == -110);
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#getNumPergunta()}.
	 */
	public void testGetNumPergunta() {
		assertEquals(0, estr.getNumPergunta());
		estr.setNumPergunta(15);
		assertEquals(15, estr.getNumPergunta());
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#setNumPergunta(int)}.
	 */
	public void testSetNumPergunta() {
		assertEquals(0, estr.getNumPergunta());
		estr.setNumPergunta(15);
		assertEquals(15, estr.getNumPergunta());
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#getPergunta()}.
	 */
	public void testGetPergunta() {
		assertEquals("", estr.getPergunta());
		estr.setPergunta("???");
		assertEquals("???", estr.getPergunta());
	}

	/**
	 * Test method for {@link estatisticas.avaliacao.EstatisticaResposta#setPergunta(java.lang.String)}.
	 */
	public void testSetPergunta() {
		assertEquals("", estr.getPergunta());
		estr.setPergunta("???");
		assertEquals("???", estr.getPergunta());
	}

}
