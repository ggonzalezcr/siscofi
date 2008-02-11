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
import database.bean.Atendimentos;
import forms.EstatisticasForm;

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
