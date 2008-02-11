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

import junit.framework.Test;
import junit.framework.TestSuite;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * realiza todos os testes de unidades
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestaAtendimento.class);
		suite.addTestSuite(TestaAtendimentos.class);
		suite.addTestSuite(testaAvaliacao.class);
		suite.addTestSuite(TestaAvaliacaoDAO.class);
		suite.addTestSuite(TestaChamaSenha.class);
		suite.addTestSuite(TestaChamaSenhaForm.class);
		suite.addTestSuite(TestaClasseForm.class);
		suite.addTestSuite(TestaCofiguradorPainel.class);
		suite.addTestSuite(TestaConexao.class);
		suite.addTestSuite(TestaConfiguracaoBD.class);
		suite.addTestSuite(TestaConfiguracaoBDForm.class);
		suite.addTestSuite(TestaConfiguracaoPainelForm.class);
		suite.addTestSuite(TestaControle.class);
		suite.addTestSuite(TestaControleDAO.class);
		suite.addTestSuite(TestaCor.class);
		suite.addTestSuite(TestaEmissao.class);
		suite.addTestSuite(TestaEmissaoForm.class);
		suite.addTestSuite(TestaEstatisticasForm.class);
		suite.addTestSuite(TestaFormulario.class);
		suite.addTestSuite(TestaFormularioForm.class);
		suite.addTestSuite(TestaGeradorPDF.class);
		suite.addTestSuite(TestaGerenciadorGuiches.class);
		suite.addTestSuite(TestaLogin.class);
		suite.addTestSuite(TestaLoginDAO.class);
		suite.addTestSuite(TestaMensagem.class);
		suite.addTestSuite(TestaSenha.class);
		suite.addTestSuite(TestaSolicitacao.class);
		suite.addTestSuite(TestaStatus.class);
		suite.addTestSuite(TestaStatusDAO.class);
		suite.addTestSuite(TestaDadosAtendimento.class);
		suite.addTestSuite(TestaDadosAtendimentoDAO.class);
		suite.addTestSuite(TestaResumoAtendimento.class);
		suite.addTestSuite(TestaEntregaTitulo.class);
		suite.addTestSuite(TestaEntregaTituloDAO.class);
		suite.addTestSuite(TestaEntregaTituloForm.class);
		//suite.addTestSuite(TestaGerenciadorMensagem.class);
		//$JUnit-END$
		return suite;
	}

}
