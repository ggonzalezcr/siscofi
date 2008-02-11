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
import util.Senha;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
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
	 * Testa o método equals()
	 */
	public void testEquals() {

		assertTrue(!senha1.equals(null));
		
		assertTrue(!senha1.equals(senha2));

		assertTrue(!senha6.equals(senha3));

	}

	/**
	 * testa o método getNumero()
	 */
	public void testGetNumero() {

		assertEquals("1", "1", senha1.get_senha());

		assertEquals("2", "2", senha2.get_senha());

		assertEquals("3", "3", senha3.get_senha());

	}

	/**
	 * Testa o método getTipoGuiche()
	 */
	public void testGetTipoGuiche() {

		assertEquals("1", "Segunda Via", senha1.get_tipoGuiche());

		assertEquals("2", "Cadastro", senha2.get_tipoGuiche());

		assertTrue("3", !senha3.get_tipoGuiche().equals("Cadastro"));

		assertEquals("4", "Tipo Guiche3", senha4.get_tipoGuiche());
	}

	/**
	 * Testa o método getData()
	 */
	public void testGetData() {

		senha1.set_data("04/03/2007 06:45:12");
		assertEquals("1", "04/03/2007 06:45:12", senha1.get_data());
		
		senha2.set_data("31/05/2000 23:23:23");
		assertEquals("2", "31/05/2000 23:23:23", senha2.get_data());
	}


}