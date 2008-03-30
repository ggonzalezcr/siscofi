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

import java.util.Date;

import junit.framework.TestCase;
import database.bean.Avaliacao;

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
 * Classe que testa a classe Avaliacao
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class testaAvaliacao extends TestCase {

	private Avaliacao avaliacao = new Avaliacao();
	
	/**
	 * Construtor
	 * @param name O nome do teste
	 */
	public testaAvaliacao(String name) {
		super(name);
		avaliacao.setData(new Date());
		avaliacao.setResposta1("ok1");
		avaliacao.setResposta2("ok2");
		avaliacao.setResposta3("ok3");
		avaliacao.setResposta4("ok4");
		avaliacao.setResposta5("ok5");
		avaliacao.setResposta6("ok6");
		avaliacao.setResposta7("ok7");
		
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Testa o metodo getResposta1
	 */
	public void testGetResposta1() {
		assertEquals("ok1", avaliacao.getResposta1());
	}

	/**
	 * Testa o metodo setResposta1
	 */
	public void testSetResposta1() {
		avaliacao.setResposta1("ok01");
		assertEquals("ok01", avaliacao.getResposta1());
	}

	/**
	 * Testa o metodo getResposta2
	 */
	public void testGetResposta2() {
		assertEquals("ok2", avaliacao.getResposta2());
	}

	/**
	 * Testa o metodo setResposta2
	 */
	public void testSetResposta2() {
		avaliacao.setResposta2("ok02");
		assertEquals("ok02", avaliacao.getResposta2());
	}

	/**
	 *Testa o metodo getResposta3
	 */
	public void testGetResposta3() {
		assertEquals("ok3", avaliacao.getResposta3());
	}

	/**
	 * Testa o metodo setResposta3
	 */
	public void testSetResposta3() {
		avaliacao.setResposta3("ok03");
		assertEquals("ok03", avaliacao.getResposta3());
	}

	/**
	 * Testa o metodo getResposta4
	 */
	public void testGetResposta4() {
		assertEquals("ok4", avaliacao.getResposta4());
	}

	/**
	 * Testa o metodo setResposta4
	 */
	public void testSetResposta4() {
		avaliacao.setResposta4("ok04");
		assertEquals("ok04", avaliacao.getResposta4());
	}

	/**
	 * Testa o metodo getResposta5
	 */
	public void testGetResposta5() {
		assertEquals("ok5", avaliacao.getResposta5());
	}

	/**
	 *  Testa o metodo setResposta5
	 */
	public void testSetResposta5() {
		avaliacao.setResposta5("ok05");
		assertEquals("ok05", avaliacao.getResposta5());
	}

	/**
	 * Testa o metodo getResposta6
	 */
	public void testGetResposta6() {
		assertEquals("ok6", avaliacao.getResposta6());
	}

	/**
	 * Testa o metodo setResposta6
	 */
	public void testSetResposta6() {
		avaliacao.setResposta6("ok06");
		assertEquals("ok06", avaliacao.getResposta6());
	}

	/**
	 * Testa o metodo getResposta7
	 */
	public void testGetResposta7() {
		assertEquals("ok7", avaliacao.getResposta7());
	}

	/**
	 * Testa o metodo setResposta7
	 */
	public void testSetResposta7() {
		avaliacao.setResposta7("ok07");
		assertEquals("ok07", avaliacao.getResposta7());
	}
}
