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

import util.Cor;
import junit.framework.TestCase;
import controleChamada.Aviso;

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
 * Classe que testa a classe Aviso
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaAviso extends TestCase {
	
	private Aviso aviso1, aviso2;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		aviso1 = new Aviso();
		aviso1.setAvisar("0");
		aviso1.setCor(Cor.ValorNomeCor("PRETO"));
		aviso1.setGuiche("001");
		aviso1.setSenha("12");
		aviso2 = new Aviso();
	}

	/**
	 * Test method for {@link controleChamada.Aviso#getGuiche()}.
	 */
	public void testGetGuiche() {
		assertEquals("001", aviso1.getGuiche());
		assertEquals(null, aviso2.getGuiche());
		aviso2.setGuiche("002");
		assertEquals("002", aviso2.getGuiche());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#setGuiche(java.lang.String)}.
	 */
	public void testSetGuiche() {
		assertEquals("001", aviso1.getGuiche());
		aviso1.setGuiche("002");
		assertEquals("002", aviso1.getGuiche());
		aviso1.setGuiche(null);
		assertEquals(null, aviso1.getGuiche());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#getSenha()}.
	 */
	public void testGetSenha() {
		assertEquals("12", aviso1.getSenha());
		assertEquals(null, aviso2.getSenha());
		aviso2.setSenha("10");
		assertEquals("10", aviso2.getSenha());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#setSenha(java.lang.String)}.
	 */
	public void testSetSenha() {
		assertEquals("12", aviso1.getSenha());
		aviso1.setSenha("12");
		assertEquals("12", aviso1.getSenha());
		aviso1.setSenha(null);
		assertEquals(null, aviso1.getSenha());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#getAvisar()}.
	 */
	public void testGetAvisar() {
		assertEquals("0", aviso1.getAvisar());
		assertEquals(null, aviso2.getAvisar());
		aviso2.setAvisar("0");
		assertEquals("0", aviso2.getAvisar());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#setAvisar(java.lang.String)}.
	 */
	public void testSetAvisar() {
		assertEquals("0", aviso1.getAvisar());
		aviso1.setAvisar("1");
		assertEquals("1", aviso1.getAvisar());
		aviso1.setAvisar(null);
		assertEquals(null, aviso1.getAvisar());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#getCor()}.
	 */
	public void testGetCor() {
		assertEquals(Cor.ValorNomeCor("PRETO"), aviso1.getCor());
		assertEquals(null, aviso2.getCor());
		aviso2.setCor(Cor.ValorNomeCor("branco"));
		assertEquals(Cor.ValorNomeCor("branco"), aviso2.getCor());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#setCor(java.lang.String)}.
	 */
	public void testSetCor() {
		assertEquals(Cor.ValorNomeCor("preto"), aviso1.getCor());
		aviso1.setCor(Cor.ValorNomeCor("MARGENTA"));
		assertEquals(Cor.ValorNomeCor("MARGENTA"), aviso1.getCor());
		aviso1.setGuiche(null);
		assertEquals(null, aviso1.getCor());
	}

	/**
	 * Test method for {@link controleChamada.Aviso#toString()}.
	 */
	public void testToString() {
		assertEquals("guiche=001, senha=12", aviso1.toString());
		assertEquals("guiche=null, senha=null", aviso2.toString());
		aviso1.setGuiche("123");
		assertEquals("guiche=123, senha=12", aviso1.toString());
	}
}