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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO II
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Testes da classe Siscofi.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

import javax.servlet.ServletException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import controller.Siscofi;
import controller.Configuracao;
import exceptions.NotFoundInDBException;

public class TestaSiscofi extends TestCase {

	private Siscofi siscofi;

	public TestaSiscofi(String name) {
		super(name);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	
	public static Test suite() {
		return new TestSuite(TestaSiscofi.class);
	}
	
	protected void setUp() throws Exception {
		siscofi = Siscofi.getInstance();
	}

	public void testEncaminharAvaliacao() {
		assertFalse(siscofi.encaminharAvaliacao());
		Configuracao.setNchamaParaAvaliar(1);
		try {
			siscofi.chamarProximaSenha("especial", "");
		} catch (NullPointerException e) {
			fail("Classe ou IP n�o encontrado");
		}
		catch (ServletException e) {
			fail("Falha na conex�o com o Banco!");
			e.printStackTrace();
		} catch (NotFoundInDBException e) {
			fail("Falha na conex�o com o Banco!");
			e.printStackTrace();
		}
	}

	public void testAddAviso() {
		fail("Not yet implemented");
	}

	public void testGetTotalAvisos() {
		fail("Not yet implemented");
	}

	public void testTemAvisos() {
		fail("Not yet implemented");
	}

	public void testChamarSenhaEspecifica() {
		fail("Not yet implemented");
	}

	public void testEmiteSenha() {
		fail("Not yet implemented");
	}

	public void testGetControleClasse() {
		fail("Not yet implemented");
	}

	public void testGetListaClasses() {
		fail("Not yet implemented");
	}

	public void testGetListaControles() {
		fail("Not yet implemented");
	}

	public void testAddControle() {
		fail("Not yet implemented");
	}

	public void testRemoveControle() {
		fail("Not yet implemented");
	}

	public void testGetUltimaSenhaChamada() {
		fail("Not yet implemented");
	}

	public void testGetTotalSenhas() {
		fail("Not yet implemented");
	}

	public void testCreateClasse() {
		fail("Not yet implemented");
	}

	public void testResetBD() {
		fail("Not yet implemented");
	}

	public void testGerarXMLFlash() {
		fail("Not yet implemented");
	}

	public void testGetMensagem() {
		fail("Not yet implemented");
	}

	public void testGetNomeCentral() {
		fail("Not yet implemented");
	}

	public void testGetEntidade() {
		fail("Not yet implemented");
	}

	public void testGetTitulo() {
		fail("Not yet implemented");
	}

	public void testChamarNovamente() {
		fail("Not yet implemented");
	}

	public void testGetCorClasse() {
		fail("Not yet implemented");
	}

	public void testGetQuantidadeInicialSenhas() {
		fail("Not yet implemented");
	}

	public void testRemoverClasse() {
		fail("Not yet implemented");
	}

	public void testAlterarClasse() {
		fail("Not yet implemented");
	}

	public void testSetNomeImpressora() {
		fail("Not yet implemented");
	}

	public void testGetNomeImpressora() {
		fail("Not yet implemented");
	}

	public void testImprimeTeste() {
		fail("Not yet implemented");
	}

	public void testSetMensagem() {
		fail("Not yet implemented");
	}

	public void testSetCorMensagem() {
		fail("Not yet implemented");
	}

	public void testSetVariacao() {
		fail("Not yet implemented");
	}

	public void testSetFluxoChegada() {
		fail("Not yet implemented");
	}

	public void testSetTempoMinimo() {
		fail("Not yet implemented");
	}

	public void testSetTempoMaximo() {
		fail("Not yet implemented");
	}

	public void testGetVariacao() {
		fail("Not yet implemented");
	}

	public void testGetFluxoChegada() {
		fail("Not yet implemented");
	}

	public void testGetTempoMinimo() {
		fail("Not yet implemented");
	}

	public void testGetTempoMaximo() {
		fail("Not yet implemented");
	}

	public void testGetCorMensagem() {
		fail("Not yet implemented");
	}

	public void testSetSpeedMensagem() {
		fail("Not yet implemented");
	}

	public void testGetSpeedMensagem() {
		fail("Not yet implemented");
	}

	public void testSetIntervalMensagem() {
		fail("Not yet implemented");
	}

	public void testGetIntervalMensagem() {
		fail("Not yet implemented");
	}

	public void testSetShowClock() {
		fail("Not yet implemented");
	}

	public void testGetShowClock() {
		fail("Not yet implemented");
	}

	public void testSetClockPosition() {
		fail("Not yet implemented");
	}

	public void testGetClockPosition() {
		fail("Not yet implemented");
	}

	public void testSetRepeat() {
		fail("Not yet implemented");
	}

	public void testGetRepeat() {
		fail("Not yet implemented");
	}

	public void testSetBgColor() {
		fail("Not yet implemented");
	}

	public void testGetBgColor() {
		fail("Not yet implemented");
	}

	public void testInicializaSistema() {
		fail("Not yet implemented");
	}

	public void testFinalizaSistema() {
		fail("Not yet implemented");
	}

	public void testIsStarted() {
		fail("Not yet implemented");
	}

	public void testGetGuiche() {
		fail("Not yet implemented");
	}

	public void testContemIP() {
		fail("Not yet implemented");
	}

	public void testContemGuiche() {
		fail("Not yet implemented");
	}

	public void testGetIp() {
		fail("Not yet implemented");
	}

	public void testAddGuiche() {
		fail("Not yet implemented");
	}

	public void testRemoveGuiche() {
		fail("Not yet implemented");
	}

	public void testSalvaAvaliacaoAvaliacao() {
		fail("Not yet implemented");
	}

	public void testSalvaAvaliacaoStringStringStringStringStringStringString() {
		fail("Not yet implemented");
	}

	public void testGetAtendimentos() {
		fail("Not yet implemented");
	}

	public void testGetNunchamaParaAvaliar() {
		fail("Not yet implemented");
	}

	public void testSetNunchamaParaAvaliar() {
		fail("Not yet implemented");
	}

	public void testAlterarConfigBDConexao() {
		fail("Not yet implemented");
	}

	public void testAlterarConfigBDStringStringStringString() {
		fail("Not yet implemented");
	}

	public void testChamadaIniciada() {
		fail("Not yet implemented");
	}

	public void testGerarRelatorioAvaliacao() {
		fail("Not yet implemented");
	}

	public void testGerarResultadoAvaliacao() {
		fail("Not yet implemented");
	}

	public void testTestaConexaoBD() {
		fail("Not yet implemented");
	}

	public void testChamarProximaSenha() {
		fail("Not yet implemented");
	}

	public void testRegistraAtendente() {
		fail("Not yet implemented");
	}

	public void testGerarResultadoAtendimento() {
		fail("Not yet implemented");
	}

	public void testGerarRelatorioAtendimento() {
		fail("Not yet implemented");
	}

	public void testSalvarDadosEntregaTitulo() {
		fail("Not yet implemented");
	}

	public void testSalvarDadosTempoAvaliacao() {
		fail("Not yet implemented");
	}

}
