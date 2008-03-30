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
import database.bean.Formulario;
import forms.FormularioForm;

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
 * Classe que testa a classe FormularioForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaFormularioForm extends TestCase {

	
	private FormularioForm formularioForm;
	
	public TestaFormularioForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		formularioForm = new FormularioForm();
	}

	/**
	 * Test method for {@link forms.FormularioForm#getFormulario()}.
	 */
	public final void testGetFormulario() {
		Formulario Formulario = new Formulario();
		formularioForm.setFormulario(Formulario);
		assertEquals(Formulario, formularioForm.getFormulario());
		Formulario Formulario2 = new Formulario();
		formularioForm.setFormulario(Formulario2);
		assertEquals(Formulario2, formularioForm.getFormulario());
	}

	/**
	 * Test method for {@link forms.FormularioForm#setFormulario(database.bean.Formulario)}.
	 */
	public final void testSetFormulario() {
		Formulario Formulario = new Formulario();
		formularioForm.setFormulario(Formulario);
		assertEquals(Formulario, formularioForm.getFormulario());
		Formulario Formulario2 = new Formulario();
		formularioForm.setFormulario(Formulario2);
		assertEquals(Formulario2, formularioForm.getFormulario());
		formularioForm.setFormulario(null);
		assertEquals(null, formularioForm.getFormulario());
	}

}
