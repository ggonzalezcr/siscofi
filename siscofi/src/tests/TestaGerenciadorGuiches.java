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
import controleChamada.GerenciadorGuiches;

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
 * Classe que testa a classe GerenciadorGuiches
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaGerenciadorGuiches extends TestCase {

	private GerenciadorGuiches gerenciadorGuiches;
	private String guiche1 = "guiche001";
	private String guiche2 = "guiche002";
	
	/**
	 * @param arg0
	 */
	public TestaGerenciadorGuiches(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		gerenciadorGuiches = new GerenciadorGuiches(1);
		gerenciadorGuiches.addGuiche(guiche1);
	}

	/**
	 * Testa o metodo {@link controleChamada.GerenciadorGuiches#existGuiche(java.lang.String)}.
	 */
	public final void testExistGuiche() {
		assertTrue(gerenciadorGuiches.existGuiche(guiche1));
		assertFalse(gerenciadorGuiches.existGuiche(guiche2));
		gerenciadorGuiches.addGuiche(guiche2);
		assertTrue(gerenciadorGuiches.existGuiche(guiche2));
		gerenciadorGuiches.removeGuiche(guiche2);
		assertFalse(gerenciadorGuiches.existGuiche(guiche2));
	}

	/**
	 * Testa o metodo {@link controleChamada.GerenciadorGuiches#addGuiche(java.lang.String)}.
	 */
	public final void testAddGuiche() {
		assertFalse(gerenciadorGuiches.existGuiche(guiche2));
		gerenciadorGuiches.addGuiche(guiche2);
		assertTrue(gerenciadorGuiches.existGuiche(guiche2));
	}

	/**
	 * Testa o metodo {@link controleChamada.GerenciadorGuiches#atualizaGuiche(java.lang.String)}.
	 */
	public final void testAtualizaGuiche() {
		Date data1 = gerenciadorGuiches.getUltimaAlteracao(guiche1);
		double c = 0;
		//Atraso para que o Date da atualização seja diferente do Date do add.
		for(long i = 0; i < 400000000; i++){
			c = c + (Math.sqrt(c*4654))+ 123456;
		}
		gerenciadorGuiches.atualizaGuiche(guiche1);
		Date data2 = gerenciadorGuiches.getUltimaAlteracao(guiche1);
		System.out.println(data1.getTime());
		System.out.println(data2.getTime());
		assertTrue(data2.after(data1));
	}

	/**
	 * Testa o metodo {@link controleChamada.GerenciadorGuiches#removeGuiche(java.lang.String)}.
	 */
	public final void testRemoveGuiche() {
		gerenciadorGuiches.addGuiche(guiche1);
		assertTrue(gerenciadorGuiches.existGuiche(guiche1));
		gerenciadorGuiches.removeGuiche(guiche1);
		assertFalse(gerenciadorGuiches.existGuiche(guiche1));
	}

	/**
	 * Testa o metodo {@link controleChamada.GerenciadorGuiches#getUltimaAlteracao(java.lang.String)}.
	 */
	public final void testGetUltimaAlteracao() {
		Date data1 = gerenciadorGuiches.getUltimaAlteracao(guiche1);
		gerenciadorGuiches.atualizaGuiche(guiche1);
		Date data2 = gerenciadorGuiches.getUltimaAlteracao(guiche1);
		assertTrue(data1 != data2);
	}

	/**
	 * Testa o metodo {@link controleChamada.GerenciadorGuiches#removeTudo()}.
	 */
	public final void testRemoveTudo() {
		assertTrue(gerenciadorGuiches.existGuiche(guiche1));
		gerenciadorGuiches.removeTudo();
		assertFalse(gerenciadorGuiches.existGuiche(guiche1));
	}

}
