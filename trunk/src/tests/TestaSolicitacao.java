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

import database.bean.Solicitacao;
import junit.framework.TestCase;

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
 * Classe que testa a classe Solicita��o
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
		solicitacao1.setClasse("2� via");
		assertEquals("2� via", solicitacao1.getClasse());
		solicitacao2.setClasse("Atendimento");
		assertEquals("Atendimento", solicitacao2.getClasse());
	}

	/**
	 * Test method for {@link database.bean.Solicitacao#setClasse(java.lang.String)}.
	 */
	public void testSetClasse() {
		solicitacao1.setClasse("2� via");
		assertEquals("2� via", solicitacao1.getClasse());
		solicitacao1.setClasse("Atendimento");
		assertEquals("Atendimento", solicitacao1.getClasse());
	}

}
