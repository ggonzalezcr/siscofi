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
import database.bean.ConfiguradorPainel;
import forms.ConfiguracaoPainelForm;

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
