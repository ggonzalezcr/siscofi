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

import database.bean.Solicitacao;
import junit.framework.TestCase;

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
 * Classe que testa a classe Solicitação
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaSolicitacao extends TestCase {

	Solicitacao solicitacao1 = new Solicitacao();
	Solicitacao solicitacao2 = new Solicitacao();
	
	/**
	 * Construtor
	 */
	public TestaSolicitacao(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link database.bean.Solicitacao#getSenhaASerChamada()}.
	 */
	public void testGetSenhaASerChamada() {
		solicitacao1.setSenhaASerChamada("SGV01");
		assertEquals("SGV01", solicitacao1.getSenhaASerChamada());
		solicitacao2.setSenhaASerChamada("ATD01");
		assertEquals("ATD01", solicitacao2.getSenhaASerChamada());
	}

	/**
	 * Test method for {@link database.bean.Solicitacao#setSenhaASerChamada(java.lang.String)}.
	 */
	public void testSetSenhaASerChamada() {
		solicitacao1.setSenhaASerChamada("SGV01");
		assertEquals("SGV01", solicitacao1.getSenhaASerChamada());
		solicitacao1.setSenhaASerChamada("SGV02");
		assertEquals("SGV02", solicitacao1.getSenhaASerChamada());		
	}

	/**
	 * Test method for {@link database.bean.Solicitacao#getClasse()}.
	 */
	public void testGetClasse() {
		solicitacao1.setClasse("2ª via");
		assertEquals("2ª via", solicitacao1.getClasse());
		solicitacao2.setClasse("Atendimento");
		assertEquals("Atendimento", solicitacao2.getClasse());
	}

	/**
	 * Test method for {@link database.bean.Solicitacao#setClasse(java.lang.String)}.
	 */
	public void testSetClasse() {
		solicitacao1.setClasse("2ª via");
		assertEquals("2ª via", solicitacao1.getClasse());
		solicitacao1.setClasse("Atendimento");
		assertEquals("Atendimento", solicitacao1.getClasse());
	}

}
