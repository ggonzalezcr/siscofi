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
import database.bean.ConfiguradorPainel;
import forms.ConfiguracaoPainelForm;

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
 * Classe que testa a classe ConfiguracaoPainelForm
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaConfiguracaoPainelForm extends TestCase {

	ConfiguracaoPainelForm cpf1;
	
	/**
	 * @param arg0
	 */
	public TestaConfiguracaoPainelForm(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		cpf1 = new ConfiguracaoPainelForm();
	}

	/**
	 * Testa o metodo {@link forms.ConfiguracaoPainelForm#getConfPainel()}.
	 */
	public final void testGetConfPainel() {
		ConfiguradorPainel cp = new ConfiguradorPainel();
		ConfiguradorPainel cp2 = new ConfiguradorPainel();
		cpf1.setConfPainel(cp);
		assertEquals(cp, cpf1.getConfPainel());
		cpf1.setConfPainel(cp2);
		assertEquals(cp2, cpf1.getConfPainel());
	}

	/**
	 * Testa o metodo {@link forms.ConfiguracaoPainelForm#setConfPainel(database.bean.ConfiguradorPainel)}.
	 */
	public final void testSetConfPainel() {
		ConfiguradorPainel cp1 = new ConfiguradorPainel();
		ConfiguradorPainel cp2 = new ConfiguradorPainel();
		cpf1.setConfPainel(cp1);
		assertEquals(cp1, cpf1.getConfPainel());
		cpf1.setConfPainel(cp2);
		assertEquals(cp2, cpf1.getConfPainel());
	}
}
