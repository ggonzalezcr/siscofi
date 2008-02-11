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
import util.Senha;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Testes da classe Senha.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class TestaSenha extends TestCase {

	protected Senha senha1;

	protected Senha senha2;

	protected Senha senha3;

	protected Senha senha4;

	protected Senha senha5;

	protected Senha senha6;

	public TestaSenha(String name) {

		super(name);

	}

	public static void main(String[] args) {

		junit.textui.TestRunner.run(suite());

	}

	protected void setUp() {

		senha1 = new Senha("Segunda Via", "1");

		senha2 = new Senha("Cadastro", "2");

		senha3 = new Senha("Tipo Guiche3", "3");

		senha4 = new Senha("Tipo Guiche3", "3");

		senha5 = new Senha("Tipo Guiche5", "5");

		senha6 = new Senha("Cadastro", "6");

	}

	public static Test suite() {

		return new TestSuite(TestaSenha.class);

	}

	/**
	 * Testa o m�todo equals()
	 */
	public void testEquals() {

		assertTrue(!senha1.equals(null));
		
		assertTrue(!senha1.equals(senha2));

		assertTrue(!senha6.equals(senha3));

	}

	/**
	 * testa o m�todo getNumero()
	 */
	public void testGetNumero() {

		assertEquals("1", "1", senha1.get_senha());

		assertEquals("2", "2", senha2.get_senha());

		assertEquals("3", "3", senha3.get_senha());

	}

	/**
	 * Testa o m�todo getTipoGuiche()
	 */
	public void testGetTipoGuiche() {

		assertEquals("1", "Segunda Via", senha1.get_tipoGuiche());

		assertEquals("2", "Cadastro", senha2.get_tipoGuiche());

		assertTrue("3", !senha3.get_tipoGuiche().equals("Cadastro"));

		assertEquals("4", "Tipo Guiche3", senha4.get_tipoGuiche());
	}

	/**
	 * Testa o m�todo getData()
	 */
	public void testGetData() {

		senha1.set_data("04/03/2007 06:45:12");
		assertEquals("1", "04/03/2007 06:45:12", senha1.get_data());
		
		senha2.set_data("31/05/2000 23:23:23");
		assertEquals("2", "31/05/2000 23:23:23", senha2.get_data());
	}


}