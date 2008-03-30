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
import util.Cor;

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
	 * Testa o m�todo getValorCor
	 */
	public void testGetValorCor() {
		assertEquals("FFFFFF", cor1.getValorCor());
		cor1.setValorCor("123456");
		assertEquals("123456", cor1.getValorCor());
		assertEquals("000000", cor2.getValorCor());
	}
	
	/**
	 * Testa o m�todo getNomeCor
	 */
	public void testGetNomeCor() {
		assertEquals("PRETO", cor1.getNomeCor());
		cor1.setNomeCor("BRANCO");
		assertEquals("BRANCO", cor1.getNomeCor());
		assertEquals("BRANCO", cor2.getNomeCor());
	}
	
	/**
	 * Testa o m�todo setValorCor
	 */
	public void testSetValorCor() {
		assertEquals("FFFFFF", cor1.getValorCor());
		cor1.setValorCor("123456");
		assertEquals("123456", cor1.getValorCor());
	}
	
	/**
	 * Testa o m�todo setNomeCor
	 */
	public void testSetNomeCor() {
		assertEquals("PRETO", cor1.getNomeCor());
		cor1.setNomeCor("BRANCO");
		assertEquals("BRANCO", cor1.getNomeCor());
	}	
	
	/**
	 * Testa o m�todo NomeValorCor
	 */
	public void testaNomeValorCor(){
		assertEquals("FF0000", Cor.NomeValorCor("verMELHO1"));
		assertEquals("00FF00", Cor.NomeValorCor("verDE1"));
	}
	
	/**
	 * Testa o m�todo NomeValorCor
	 */
	public void testaValorNomeCor(){
		assertEquals("VERMELHO1", Cor.ValorNomeCor("FF0000"));
		assertEquals("VERDE1", Cor.ValorNomeCor("00FF00"));
	}
}
