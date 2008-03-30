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

import database.bean.Controle;
import forms.ClasseForm;
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
		controle.setClasse("2ª via");
		classe1.setControle(controle);
		assertEquals("2ª via", classe1.getControle().getClasse());
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
		controle.setClasse("2ª via");
		classe1.setControle(controle);
		assertEquals("2ª via", classe1.getControle().getClasse());
		Controle controle2 = new Controle();
		controle2.setClasse("Atendimento");
		classe1.setControle(controle2);
		assertEquals("Atendimento", classe1.getControle().getClasse());
	}

}
