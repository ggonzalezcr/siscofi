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

import junit.framework.TestCase;
import database.bean.Formulario;
import forms.FormularioForm;

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
