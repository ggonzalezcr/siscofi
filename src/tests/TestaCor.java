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
import util.Cor;

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
 * Testes da classe Cor.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaCor extends TestCase {

	//Atributos
	protected Cor cor1;

	protected Cor cor2;

	public TestaCor(String name) {
		super(name);

	}

	public static void main(String[] args) {

		junit.textui.TestRunner.run(suite());

	}

	protected void setUp() {
		cor1 = new Cor("PRETO", "FFFFFF");
		cor2 = new Cor("BRANCO", "000000");
	}

	public static Test suite() {
		return new TestSuite(TestaCor.class);
	}

	/**
	 * Testa o método getValorCor
	 */
	public void testGetValorCor() {
		assertEquals("FFFFFF", cor1.getValorCor());
		cor1.setValorCor("123456");
		assertEquals("123456", cor1.getValorCor());
		assertEquals("000000", cor2.getValorCor());
	}
	
	/**
	 * Testa o método getNomeCor
	 */
	public void testGetNomeCor() {
		assertEquals("PRETO", cor1.getNomeCor());
		cor1.setNomeCor("BRANCO");
		assertEquals("BRANCO", cor1.getNomeCor());
		assertEquals("BRANCO", cor2.getNomeCor());
	}
	
	/**
	 * Testa o método setValorCor
	 */
	public void testSetValorCor() {
		assertEquals("FFFFFF", cor1.getValorCor());
		cor1.setValorCor("123456");
		assertEquals("123456", cor1.getValorCor());
	}
	
	/**
	 * Testa o método setNomeCor
	 */
	public void testSetNomeCor() {
		assertEquals("PRETO", cor1.getNomeCor());
		cor1.setNomeCor("BRANCO");
		assertEquals("BRANCO", cor1.getNomeCor());
	}	
	
	/**
	 * Testa o método NomeValorCor
	 */
	public void testaNomeValorCor(){
		assertEquals("FF0000", Cor.NomeValorCor("verMELHO1"));
		assertEquals("00FF00", Cor.NomeValorCor("verDE1"));
	}
	
	/**
	 * Testa o método NomeValorCor
	 */
	public void testaValorNomeCor(){
		assertEquals("VERMELHO1", Cor.ValorNomeCor("FF0000"));
		assertEquals("VERDE1", Cor.ValorNomeCor("00FF00"));
	}
}
