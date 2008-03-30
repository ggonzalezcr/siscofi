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

package tests;

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
 * Classe que testa a classe ListaAviso
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

import javax.servlet.ServletException;

import junit.framework.TestCase;
import util.Cor;
import controleChamada.ListaAviso;

public class TestaListaAviso extends TestCase {

	private ListaAviso lista;

	protected void setUp() throws Exception {
		super.setUp();
		lista = new ListaAviso();
	}

	public void testAddAviso() {
		try {
			assertTrue(lista.getTotalAvisos() == 0);
			lista.addAviso("01", "01", Cor.NomeValorCor("preto"));
			assertTrue(lista.getTotalAvisos() == 1);
			lista.addAviso("02", "02", Cor.NomeValorCor("branco"));
			assertTrue(lista.getTotalAvisos() == 2);
		} catch (ServletException e) {
			fail("Não é possível gerar XML");
		}
	}

	/**
	 * Test method for {@link controleChamada.ListaAviso#isEmpty()}.
	 */
	public void testIsEmpty() {
		try {
			assertTrue(lista.isEmpty());
			lista.addAviso("01", "01", Cor.NomeValorCor("preto"));
			assertTrue(!lista.isEmpty());
		} catch (ServletException e) {
			fail("Não é possível gerar XML");
		}
	}

	/**
	 * Test method for {@link controleChamada.ListaAviso#getTotalAvisos()}.
	 */
	public void testGetTotalAvisos() {
		try {
			assertTrue(lista.getTotalAvisos() == 0);
			lista.addAviso("01", "01", Cor.NomeValorCor("preto"));
			assertTrue(lista.getTotalAvisos() == 1);
			lista.addAviso("02", "02", Cor.NomeValorCor("branco"));
			assertTrue(lista.getTotalAvisos() == 2);
			lista.chamadaIniciada("01");
			assertTrue(lista.getTotalAvisos() == 1);
		} catch (ServletException e) {
			fail("Não é possível gerar XML");
		}
	}

	/**
	 * Test method for {@link controleChamada.ListaAviso#chamadaIniciada(java.lang.String)}.
	 */
	public void testChamadaIniciada() {
		try {
			assertTrue(lista.getTotalAvisos() == 0);
			lista.addAviso("01", "01", Cor.NomeValorCor("preto"));
			assertTrue(lista.getTotalAvisos() == 1);
			lista.addAviso("02", "02", Cor.NomeValorCor("branco"));
			assertTrue(lista.getTotalAvisos() == 2);
			lista.chamadaIniciada("01");
			assertTrue(lista.getTotalAvisos() == 1);
			lista.chamadaIniciada("01");
			assertTrue(lista.getTotalAvisos() == 1);
			lista.chamadaIniciada("02");
			assertTrue(lista.getTotalAvisos() == 0);
		} catch (ServletException e) {
			fail("Não é possível gerar XML");
		}
	}

	/**
	 * Test method for {@link controleChamada.ListaAviso#pararChamadas()}.
	 */
	public void testPararChamadas() {
		try {
			assertTrue(lista.getTotalAvisos() == 0);
			lista.addAviso("01", "01", Cor.NomeValorCor("preto"));
			lista.addAviso("02", "02", Cor.NomeValorCor("preto"));
			assertEquals("", lista.getUltimaSenha());
			lista.chamadaIniciada("01");
			assertEquals("01", lista.getUltimaSenha());
			assertTrue(lista.getTotalAvisos() == 1);
			lista.pararChamadas();
			assertTrue(lista.getTotalAvisos() == 0);
			assertEquals("01", lista.getUltimaSenha());
		} catch (ServletException e) {
			fail("Não é possível gerar XML");
		}
	}
	
	/**
	 * Test method for {@link controleChamada.ListaAviso#getUltimaSenha()}.
	 */
	public void testGetUltimaSenha() {
		try {
			assertTrue(lista.getTotalAvisos() == 0);
			assertEquals("", lista.getUltimaSenha());
			lista.addAviso("01", "01", Cor.NomeValorCor("preto"));
			lista.addAviso("02", "02", Cor.NomeValorCor("branco"));
			assertEquals("", lista.getUltimaSenha());
			lista.chamadaIniciada("01");
			assertEquals("01", lista.getUltimaSenha());
			lista.chamadaIniciada("02");
			assertEquals("02", lista.getUltimaSenha());
		} catch (ServletException e) {
			fail("Não é possível gerar XML");
		}
	}

}
