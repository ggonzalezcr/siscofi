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

import database.bean.Conexao;
import junit.framework.TestCase;
import forms.ConfiguracaoBDForm;

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
 * Classe que testa a classe ConfiguracaoBDForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaConfiguracaoBDForm extends TestCase {
	
	private ConfiguracaoBDForm configuracaoBDForm1;
	private ConfiguracaoBDForm configuracaoBDForm2;

	/**
	 * @param arg0
	 */
	public TestaConfiguracaoBDForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		configuracaoBDForm1 = new ConfiguracaoBDForm();
		configuracaoBDForm2 = new ConfiguracaoBDForm();
	}

	/**
	 * Testa o metodo {@link forms.ConfiguracaoBDForm#getConexao()}.
	 */
	public final void testGetConexao() {
		Conexao c = new Conexao();
		configuracaoBDForm1.setConexao(c);
		assertEquals(c ,configuracaoBDForm1.getConexao());
		configuracaoBDForm2.setConexao(c);
		assertEquals(c, configuracaoBDForm2.getConexao());
	}

	/**
	 * Testa o metodo {@link forms.ConfiguracaoBDForm#setConexao(database.bean.Conexao)}.
	 */
	public final void testSetConexao() {
		Conexao c = new Conexao();
		configuracaoBDForm1.setConexao(c);
		assertEquals(c, configuracaoBDForm1.getConexao());
		Conexao c2 = new Conexao();
		configuracaoBDForm1.setConexao(c2);
		assertEquals(c2, configuracaoBDForm1.getConexao());
	}

}
