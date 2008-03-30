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

import database.bean.Controle;
import forms.ClasseForm;
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
 * Classe que testa a classe ClasseForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */
public class TestaClasseForm extends TestCase {

	ClasseForm classe1 = new ClasseForm();
	ClasseForm classe2 = new ClasseForm();
	
	/**
	 * Construtor
	 */
	public TestaClasseForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link forms.ClasseForm#getControle()}.
	 */
	public void testGetControle() {
		Controle controle = new Controle();
		controle.setClasse("2� via");
		classe1.setControle(controle);
		assertEquals("2� via", classe1.getControle().getClasse());
		Controle controle2 = new Controle();
		controle2.setClasse("Atendimento");
		classe2.setControle(controle2);
		assertEquals("Atendimento", classe2.getControle().getClasse());
	}

	/**
	 * Test method for {@link forms.ClasseForm#setControle(database.bean.Controle)}.
	 */
	public void testSetControle() {
		Controle controle = new Controle();
		controle.setClasse("2� via");
		classe1.setControle(controle);
		assertEquals("2� via", classe1.getControle().getClasse());
		Controle controle2 = new Controle();
		controle2.setClasse("Atendimento");
		classe1.setControle(controle2);
		assertEquals("Atendimento", classe1.getControle().getClasse());
	}

}
