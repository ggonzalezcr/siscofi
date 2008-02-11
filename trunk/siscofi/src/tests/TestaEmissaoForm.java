/**
 * 
 */
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

import junit.framework.TestCase;
import database.bean.Emissao;
import database.bean.Login;
import forms.EmissaoForm;

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
 * Classe que testa a classe EmissaoForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaEmissaoForm extends TestCase {

	
	private EmissaoForm emissaoForm;
	/**
	 * @param arg0
	 */
	public TestaEmissaoForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		emissaoForm = new EmissaoForm();
	}

	/**
	 * Testa o metodo {@link forms.EmissaoForm#getLogin()}.
	 */
	public final void testGetLogin() {
		Login login1 = new Login();
		Login login2 = new Login();
		emissaoForm.setLogin(login1);
		assertEquals(login1, emissaoForm.getLogin());
		emissaoForm.setLogin(login2);
		assertEquals(login2, emissaoForm.getLogin());
	}

	/**
	 * Testa o metodo {@link forms.EmissaoForm#setLogin(database.bean.Login)}.
	 */
	public final void testSetLogin() {
		Login login1 = new Login();
		Login login2 = new Login();
		emissaoForm.setLogin(login1);
		assertEquals(login1, emissaoForm.getLogin());
		emissaoForm.setLogin(login2);
		assertEquals(login2, emissaoForm.getLogin());
		emissaoForm.setLogin(null);
		assertEquals(null, emissaoForm.getLogin());
	}

	/**
	 * Testa o metodo {@link forms.EmissaoForm#getEmissao()}.
	 */
	public final void testGetEmissao() {
		Emissao e1 = new Emissao();
		Emissao e2 = new Emissao();
		emissaoForm.setEmissao(e1);
		assertEquals(e1,emissaoForm.getEmissao());
		emissaoForm.setEmissao(e2);
		assertEquals(e2,emissaoForm.getEmissao());
	}

	/**
	 * Testa o metodo {@link forms.EmissaoForm#setEmissao(database.bean.Emissao)}.
	 */
	public final void testSetEmissao() {
		Emissao e1 = new Emissao();
		Emissao e2 = new Emissao();
		emissaoForm.setEmissao(e1);
		assertEquals(e1,emissaoForm.getEmissao());
		emissaoForm.setEmissao(e2);
		assertEquals(e2,emissaoForm.getEmissao());
		emissaoForm.setEmissao(null);
		assertEquals(null,emissaoForm.getEmissao());
	}

	/**
	 * Testa o metodo {@link forms.EmissaoForm#reset()}.
	 */
	public final void testReset() {
		Emissao e1 = new Emissao();
		e1.setTotal(12);
		emissaoForm.setEmissao(e1);
		assertEquals(12, e1.getTotal());
		emissaoForm.reset();
		assertEquals(1, e1.getTotal());
	}

}
