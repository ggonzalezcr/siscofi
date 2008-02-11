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
import database.bean.Atendimentos;
import forms.EstatisticasForm;

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
 * Classe que testa a classe EstatisticasForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaEstatisticasForm extends TestCase {

	private EstatisticasForm ef1;
	/**
	 * @param arg0
	 */
	public TestaEstatisticasForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		ef1 = new EstatisticasForm();
	}

	/**
	 * Testa o metodo {@link forms.EstatisticasForm#getAtendimentos()}.
	 */
	public final void testGetAtendimentos() {
		assertEquals(null, ef1.getAtendimentos());
		Atendimentos atendimentos = new Atendimentos();
		ef1.setAtendimentos(atendimentos);
		assertEquals(atendimentos, ef1.getAtendimentos());
		Atendimentos atendimentos2 = new Atendimentos();
		ef1.setAtendimentos(atendimentos2);
		assertEquals(atendimentos2, ef1.getAtendimentos());
	}

	/**
	 * Testa o metodo{@link forms.EstatisticasForm#setAtendimentos(database.bean.Atendimentos)}.
	 */
	public final void testSetAtendimentos() {
		assertEquals(null, ef1.getAtendimentos());
		Atendimentos atendimentos = new Atendimentos();
		ef1.setAtendimentos(atendimentos);
		assertEquals(atendimentos, ef1.getAtendimentos());
		Atendimentos atendimentos2 = new Atendimentos();
		ef1.setAtendimentos(atendimentos2);
		assertEquals(atendimentos2, ef1.getAtendimentos());
		ef1.setAtendimentos(null);
		assertEquals(null, ef1.getAtendimentos());
	}

}
