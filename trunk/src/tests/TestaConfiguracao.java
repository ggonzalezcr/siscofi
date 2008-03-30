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

package tests;

import junit.framework.TestCase;
import controller.Configuracao;
import controller.TiposLogin;

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
 * Classe que testa a classe Configuracao
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TestaConfiguracao extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for {@link controller.Configuracao#getPath()}.
	 */
	public void testGetPath() {
		Configuracao.setPath("C:/Documents and Settings/workspace/siscofi/web");
		assertEquals("C:/Documents and Settings/workspace/siscofi/web", Configuracao.getPath());
		Configuracao.setPath("abc");
		assertEquals("abc", Configuracao.getPath());
	}

	/**
	 * Test method for {@link controller.Configuracao#getTempoAtendimentoMinimo()}.
	 */
	public void testGetTempoAtendimentoMinimo() {
		Configuracao.setTempoAtendimentoMinimo(2.0);
		assertEquals(2.0, Configuracao.getTempoAtendimentoMinimo());
		Configuracao.setTempoAtendimentoMinimo(1.0);
		assertEquals(1.0, Configuracao.getTempoAtendimentoMinimo());
	}

	/**
	 * Test method for {@link controller.Configuracao#getTempoAtendimentoMaximo()}.
	 */
	public void testGetTempoAtendimentoMaximo() {
		Configuracao.setTempoAtendimentoMaximo(15.0);
		assertEquals(15.0, Configuracao.getTempoAtendimentoMaximo());
		Configuracao.setTempoAtendimentoMaximo(10.0);
		assertEquals(10.0, Configuracao.getTempoAtendimentoMaximo());
	}

	/**
	 * Test method for {@link controller.Configuracao#getVariacao()}.
	 */
	public void testGetVariacao() {
		Configuracao.setVariacao(12.55);
		assertEquals(12.55, Configuracao.getVariacao());
		Configuracao.setVariacao(10.0);
		assertEquals(10.0, Configuracao.getVariacao());
	}

	/**
	 * Test method for {@link controller.Configuracao#getRefreshTime()}.
	 */
	public void testGetRefreshTime() {
		Configuracao.setRefreshTime(1255);
		assertEquals(1255, Configuracao.getRefreshTime());
		Configuracao.setRefreshTime(100);
		assertEquals(100, Configuracao.getRefreshTime());
	}

	/**
	 * Test method for {@link controller.Configuracao#getWarningTime()}.
	 */
	public void testGetWarningTime() {
		Configuracao.setWarningTime(1255);
		assertEquals(1255, Configuracao.getWarningTime());
		Configuracao.setWarningTime(100);
		assertEquals(100, Configuracao.getWarningTime());
	}

	/**
	 * Test method for {@link controller.Configuracao#getInterval()}.
	 */
	public void testGetInterval() {
		Configuracao.setInterval(1255);
		assertEquals(1255, Configuracao.getInterval());
		Configuracao.setInterval(100);
		assertEquals(100, Configuracao.getInterval());
	}

	/**
	 * Test method for {@link controller.Configuracao#getShowClock()}.
	 */
	public void testGetShowClock() {
		Configuracao.setShowClock(0);
		assertEquals(0, Configuracao.getShowClock());
		Configuracao.setShowClock(1);
		assertEquals(1, Configuracao.getShowClock());
	}

	/**
	 * Test method for {@link controller.Configuracao#getRepeat()}.
	 */
	public void testGetRepeat() {
		Configuracao.setRepeat(2);
		assertEquals(2, Configuracao.getRepeat());
		Configuracao.setRepeat(1);
		assertEquals(1, Configuracao.getRepeat());
	}

	/**
	 * Test method for {@link controller.Configuracao#getbgColor()}.
	 */
	public void testGetbgColor() {
		Configuracao.setbgColor("ab0045");
		assertEquals("ab0045", Configuracao.getbgColor());
		Configuracao.setbgColor("132465");
		assertEquals("132465", Configuracao.getbgColor());
	}

	/**
	 * Test method for {@link controller.Configuracao#getSpeed()}.
	 */
	public void testGetSpeed() {
		Configuracao.setSpeed(21);
		assertEquals(21, Configuracao.getSpeed());
		Configuracao.setSpeed(2);
		assertEquals(2, Configuracao.getSpeed());
	}

	/**
	 * Test method for {@link controller.Configuracao#getNomeCentral()}.
	 */
	public void testGetNomeCentral() {
		Configuracao.setNomeCentral("CG");
		assertEquals("CG", Configuracao.getNomeCentral());
		Configuracao.setNomeCentral("JP");
		assertEquals("JP", Configuracao.getNomeCentral());
	}

	/**
	 * Test method for {@link controller.Configuracao#getTitulo()}.
	 */
	public void testGetTitulo() {
		Configuracao.setTitulo("Atendimento ao eleitor");
		assertEquals("Atendimento ao eleitor", Configuracao.getTitulo());
	}

	/**
	 * Test method for {@link controller.Configuracao#getClockPosition()}.
	 */
	public void testGetClockPosition() {
		Configuracao.setClockPosition("21");
		assertEquals("21", Configuracao.getClockPosition());
		Configuracao.setClockPosition("500");
		assertEquals("500", Configuracao.getClockPosition());
	}

	/**
	 * Test method for {@link controller.Configuracao#getMensagem()}.
	 */
	public void testGetMensagem() {
		Configuracao.setMensagem("Mensagem aqui");
		assertEquals("Mensagem aqui", Configuracao.getMensagem());
		Configuracao.setMensagem("");
		assertEquals("", Configuracao.getMensagem());
	}

	/**
	 * Test method for {@link controller.Configuracao#setbgColor(java.lang.String)}.
	 */
	public void testSetbgColor() {
		Configuracao.setbgColor("ab0045");
		Configuracao.setbgColor("FFFFFF");
		assertEquals("FFFFFF", Configuracao.getbgColor());
		Configuracao.setbgColor("132465");
		assertEquals("132465", Configuracao.getbgColor());
	}

	/**
	 * Test method for {@link controller.Configuracao#getCorMensagem()}.
	 */
	public void testGetCorMensagem() {
		Configuracao.setCorMensagem("ab0045");
		Configuracao.setCorMensagem("FFFFFF");
		assertEquals("FFFFFF", Configuracao.getCorMensagem());
		Configuracao.setCorMensagem("132465");
		assertEquals("132465", Configuracao.getCorMensagem());
	}

	/**
	 * Test method for {@link controller.Configuracao#setShowClock(int)}.
	 */
	public void testSetShowClock() {
		Configuracao.setShowClock(0);
		assertEquals(0, Configuracao.getShowClock());
		Configuracao.setShowClock(132132);
		assertEquals(0, Configuracao.getShowClock());
		Configuracao.setShowClock(-1);
		assertEquals(0, Configuracao.getShowClock());
		Configuracao.setShowClock(1);
		assertEquals(1, Configuracao.getShowClock());
	}

	/**
	 * Test method for {@link controller.Configuracao#setInterval(int)}.
	 */
	public void testSetInterval() {
		Configuracao.setInterval(1255);
		assertEquals(1255, Configuracao.getInterval());
		Configuracao.setInterval(100);
		assertEquals(100, Configuracao.getInterval());
		Configuracao.setInterval(-10);
		assertEquals(100, Configuracao.getInterval());
	}

	/**
	 * Test method for {@link controller.Configuracao#setNomeCentral(java.lang.String)}.
	 */
	public void testSetNomeCentral() {
		Configuracao.setNomeCentral("CG");
		Configuracao.setNomeCentral("CJ");
		assertEquals("CJ", Configuracao.getNomeCentral());
		Configuracao.setNomeCentral("JP");
		assertEquals("JP", Configuracao.getNomeCentral());
	}

	/**
	 * Test method for {@link controller.Configuracao#setPath(java.lang.String)}.
	 */
	public void testSetPath() {
		Configuracao.setPath("abc");
		assertEquals("abc", Configuracao.getPath());
		Configuracao.setPath(null);
		assertEquals("abc", Configuracao.getPath());
	}

	/**
	 * Test method for {@link controller.Configuracao#setTempoAtendimentoMinimo(double)}.
	 */
	public void testSetTempoAtendimentoMinimo() {
		Configuracao.setTempoAtendimentoMinimo(2.0);
		assertEquals(2.0, Configuracao.getTempoAtendimentoMinimo());
		Configuracao.setTempoAtendimentoMinimo(1.0);
		assertEquals(1.0, Configuracao.getTempoAtendimentoMinimo());
		Configuracao.setTempoAtendimentoMinimo(0.0);
		assertEquals(0.0, Configuracao.getTempoAtendimentoMinimo());
		Configuracao.setTempoAtendimentoMinimo(0.00045);
		assertEquals(0.00045, Configuracao.getTempoAtendimentoMinimo());
	}

	/**
	 * Test method for {@link controller.Configuracao#setTempoAtendimentoMaximo(double)}.
	 */
	public void testSetTempoAtendimentoMaximo() {
		Configuracao.setTempoAtendimentoMaximo(0.01);
		assertEquals(0.01, Configuracao.getTempoAtendimentoMaximo());
		Configuracao.setTempoAtendimentoMaximo(10.04);
		assertEquals(10.04, Configuracao.getTempoAtendimentoMaximo());
	}

	/**
	 * Test method for {@link controller.Configuracao#setVariacao(double)}.
	 */
	public void testSetVariacao() {
		Configuracao.setVariacao(12.55);
		Configuracao.setVariacao(2.15);
		assertEquals(2.15, Configuracao.getVariacao());
		Configuracao.setVariacao(10.0);
		assertEquals(10.0, Configuracao.getVariacao());
	}

	/**
	 * Test method for {@link controller.Configuracao#setRefreshTime(int)}.
	 */
	public void testSetRefreshTime() {
		Configuracao.setRefreshTime(1255);
		Configuracao.setRefreshTime(1055);
		Configuracao.setRefreshTime(255);
		assertEquals(255, Configuracao.getRefreshTime());
		Configuracao.setRefreshTime(-1);
		assertEquals(255, Configuracao.getRefreshTime());
	}

	/**
	 * Test method for {@link controller.Configuracao#setRepeat(int)}.
	 */
	public void testSetRepeat() {
		Configuracao.setRepeat(2);
		assertEquals(2, Configuracao.getRepeat());
		Configuracao.setRepeat(0);
		assertEquals(2, Configuracao.getRepeat());
		Configuracao.setRepeat(1);
		assertEquals(1, Configuracao.getRepeat());
	}

	/**
	 * Test method for {@link controller.Configuracao#setSpeed(int)}.
	 */
	public void testSetSpeed() {
		Configuracao.setSpeed(21);
		assertEquals(21, Configuracao.getSpeed());
		Configuracao.setSpeed(-5);
		assertEquals(21, Configuracao.getSpeed());
		Configuracao.setSpeed(2);
		assertEquals(2, Configuracao.getSpeed());
	}

	/**
	 * Test method for {@link controller.Configuracao#setTitulo(java.lang.String)}.
	 */
	public void testSetTitulo() {
		Configuracao.setTitulo("Atendimento ao eleitor");
		assertEquals("Atendimento ao eleitor", Configuracao.getTitulo());
		Configuracao.setTitulo(null);
		assertEquals("Atendimento ao eleitor", Configuracao.getTitulo());
	}

	/**
	 * Test method for {@link controller.Configuracao#setWarningTime(int)}.
	 */
	public void testSetWarningTime() {
		Configuracao.setWarningTime(1255);
		Configuracao.setWarningTime(0);
		Configuracao.setWarningTime(-15);
		assertEquals(1255, Configuracao.getWarningTime());
		Configuracao.setWarningTime(100);
		assertEquals(100, Configuracao.getWarningTime());
	}

	/**
	 * Test method for {@link controller.Configuracao#getNomeDaImpressora()}.
	 */
	public void testGetNomeDaImpressora() {
		Configuracao.setNomeDaImpressora("HP7878");
		assertEquals("HP7878", Configuracao.getNomeDaImpressora());
		Configuracao.setNomeDaImpressora("Epson 98798CLA");
		assertEquals("Epson 98798CLA", Configuracao.getNomeDaImpressora());
	}

	/**
	 * Test method for {@link controller.Configuracao#setNomeDaImpressora(java.lang.String)}.
	 */
	public void testSetNomeDaImpressora() {
		Configuracao.setNomeDaImpressora("HP7878");
		Configuracao.setNomeDaImpressora("HP690A");
		assertEquals("HP690A", Configuracao.getNomeDaImpressora());
		Configuracao.setNomeDaImpressora("Epson 98798CLA");
		assertEquals("Epson 98798CLA", Configuracao.getNomeDaImpressora());
	}

	/**
	 * Test method for {@link controller.Configuracao#setMensagem(java.lang.String)}.
	 */
	public void testSetMensagem() {
		Configuracao.setMensagem("Mensagem aqui");
		assertEquals("Mensagem aqui", Configuracao.getMensagem());
		Configuracao.setMensagem("");
		Configuracao.setMensagem("----> Mensagem aqui <-----");
		assertEquals("----> Mensagem aqui <-----", Configuracao.getMensagem());
	}

	/**
	 * Test method for {@link controller.Configuracao#setCorMensagem(java.lang.String)}.
	 */
	public void testSetCorMensagem() {
		Configuracao.setCorMensagem("ab0045");
		Configuracao.setCorMensagem("FFFFFF");
		assertEquals("FFFFFF", Configuracao.getCorMensagem());
		Configuracao.setCorMensagem("132465");
		assertEquals("132465", Configuracao.getCorMensagem());
	}

	/**
	 * Test method for {@link controller.Configuracao#setClockPosition(java.lang.String)}.
	 */
	public void testSetClockPosition() {
		Configuracao.setClockPosition("21");
		assertEquals("21", Configuracao.getClockPosition());
		Configuracao.setClockPosition("500");
		Configuracao.setClockPosition("800");
		assertEquals("800", Configuracao.getClockPosition());
	}

	/**
	 * Test method for {@link controller.Configuracao#getNchamaParaAvaliar()}.
	 */
	public void testGetNchamaParaAvaliar() {
		Configuracao.setNchamaParaAvaliar(1255);
		assertEquals(1255, Configuracao.getNchamaParaAvaliar());
		Configuracao.setNchamaParaAvaliar(100);
		assertEquals(100, Configuracao.getNchamaParaAvaliar());
	}

	/**
	 * Test method for {@link controller.Configuracao#setNchamaParaAvaliar(int)}.
	 */
	public void testSetNchamaParaAvaliar() {
		Configuracao.setNchamaParaAvaliar(1255);
		Configuracao.setNchamaParaAvaliar(0);
		Configuracao.setNchamaParaAvaliar(-15);
		assertEquals(1255, Configuracao.getNchamaParaAvaliar());
		Configuracao.setNchamaParaAvaliar(100);
		assertEquals(100, Configuracao.getNchamaParaAvaliar());
	}

	/**
	 * Test method for {@link controller.Configuracao#getExibirFundo()}.
	 */
	public void testGetExibirFundo() {
		Configuracao.setExibirFundo(1);
		assertEquals(1, Configuracao.getExibirFundo());
		Configuracao.setExibirFundo(0);
		assertEquals(0, Configuracao.getExibirFundo());
	}

	/**
	 * Test method for {@link controller.Configuracao#setExibirFundo(int)}.
	 */
	public void testSetExibirFundo() {
		Configuracao.setExibirFundo(1);
		assertEquals(1, Configuracao.getExibirFundo());
		Configuracao.setExibirFundo(100);
		assertEquals(0, Configuracao.getExibirFundo());
		Configuracao.setExibirFundo(0);
		assertEquals(0, Configuracao.getExibirFundo());
	}

	/**
	 * Test method for {@link controller.Configuracao#getDestacarUltimaSenha()}.
	 */
	public void testGetDestacarUltimaSenha() {
		Configuracao.setDestacarUltimaSenha(1);
		assertEquals(1, Configuracao.getDestacarUltimaSenha());
		Configuracao.setDestacarUltimaSenha(0);
		assertEquals(0, Configuracao.getDestacarUltimaSenha());
	}

	/**
	 * Test method for {@link controller.Configuracao#setDestacarUltimaSenha(int)}.
	 */
	public void testSetDestacarUltimaSenha() {
		Configuracao.setDestacarUltimaSenha(1);
		assertEquals(1, Configuracao.getDestacarUltimaSenha());
		Configuracao.setDestacarUltimaSenha(0);
		assertEquals(0, Configuracao.getDestacarUltimaSenha());
		Configuracao.setDestacarUltimaSenha(12);
		assertEquals(0, Configuracao.getDestacarUltimaSenha());
	}

	/**
	 * Test method for {@link controller.Configuracao#getNomeAplicacao()}.
	 */
	public void testGetNomeAplicacao() {
		Configuracao.setNomeAplicacao("Siscofi");
		assertEquals("Siscofi", Configuracao.getNomeAplicacao());
		Configuracao.setNomeAplicacao("ADM");
		assertEquals("ADM", Configuracao.getNomeAplicacao());
	}

	/**
	 * Test method for {@link controller.Configuracao#setNomeAplicacao(java.lang.String)}.
	 */
	public void testSetNomeAplicacao() {
		Configuracao.setNomeAplicacao("Siscofi");
		Configuracao.setNomeAplicacao("Siscofi2");
		assertEquals("Siscofi2", Configuracao.getNomeAplicacao());
		Configuracao.setNomeAplicacao("ADM");
		assertEquals("ADM", Configuracao.getNomeAplicacao());
	}

	/**
	 * Test method for {@link controller.Configuracao#getFluxoChegada()}.
	 */
	public void testGetFluxoChegada() {
		Configuracao.setFluxoChegada(15.0);
		assertEquals(15.0, Configuracao.getFluxoChegada());
		Configuracao.setFluxoChegada(10.0);
		assertEquals(10.0, Configuracao.getFluxoChegada());
	}

	/**
	 * Test method for {@link controller.Configuracao#setFluxoChegada(double)}.
	 */
	public void testSetFluxoChegada() {
		Configuracao.setFluxoChegada(15.0);
		assertEquals(15.0, Configuracao.getFluxoChegada());
		Configuracao.setFluxoChegada(10.0);
		assertEquals(10.0, Configuracao.getFluxoChegada());
		Configuracao.setFluxoChegada(-5);
		assertEquals(10.0, Configuracao.getFluxoChegada());
	}

	/**
	 * Test method for {@link controller.Configuracao#getEntidade()}.
	 */
	public void testGetEntidade() {
		Configuracao.setEntidade("TJ");
		assertEquals("TJ", Configuracao.getEntidade());
		Configuracao.setEntidade("TRE");
		assertEquals("TRE", Configuracao.getEntidade());
	}

	/**
	 * Test method for {@link controller.Configuracao#setEntidade(java.lang.String)}.
	 */
	public void testSetEntidade() {
		Configuracao.setEntidade("TJ");
		Configuracao.setEntidade("TJB");
		assertEquals("TJB", Configuracao.getEntidade());
		Configuracao.setEntidade("TRE");
		assertEquals("TRE", Configuracao.getEntidade());
	}

	/**
	 * Test method for {@link controller.Configuracao#getTipoLogin()}.
	 */
	public void testGetTipoLogin() {
		Configuracao.setTipoLogin(TiposLogin.LOGIN_BD);
		assertEquals(TiposLogin.LOGIN_BD, Configuracao.getTipoLogin());
		Configuracao.setTipoLogin(TiposLogin.LOGIN_LDAP);
		assertEquals(TiposLogin.LOGIN_LDAP, Configuracao.getTipoLogin());
	}

	/**
	 * Test method for {@link controller.Configuracao#setTipoLogin(java.lang.String)}.
	 */
	public void testSetTipoLogin() {
		Configuracao.setTipoLogin(TiposLogin.LOGIN_BD);
		Configuracao.setTipoLogin("tanto faz");
		assertEquals("tanto faz", Configuracao.getTipoLogin());
		Configuracao.setTipoLogin(TiposLogin.LOGIN_LDAP);
		assertEquals(TiposLogin.LOGIN_LDAP, Configuracao.getTipoLogin());
	}

}
