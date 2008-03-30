package database.bean;

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

 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import controller.Configuracao;

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
 * Classe que implementa um bean que guarada as informações de configuração
 * do painel.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class ConfiguradorPainel {
	

	private String bgColor = Configuracao.getbgColor();
	private int showClock = Configuracao.getShowClock();
	private String mensagem = Configuracao.getMensagem();
	private String corMensagem = Configuracao.getCorMensagem();
	private int interval = Configuracao.getInterval();
	private int repeat = Configuracao.getRepeat();
	private String clockPosition = Configuracao.getClockPosition();
	private int speed = Configuracao.getSpeed();
	private int duracaoExibicao = Configuracao.getWarningTime();
	private int destacarUltimaSenha = Configuracao.getDestacarUltimaSenha();

	/**
	 * Metodo que determina a posição do relógio 
	 * @return a posição do relogio no painel (esquerda, centro ou direita)
	 */
	public String getClockPosition() {
		return clockPosition;
	}

	/**
	 * Metodo que retorna a cor de fundo do painel
	 * @return a cor de fundo do painel
	 */
	public String getBgColor() {
		return bgColor;
	}
	
	/**
	 * Metodo que modifica a cor de fundo do painel
	 * @param bgColor a cor de fundo do painel
	 */
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	/**
	 * Metodo que retorna um inteiro para verificar se o relogio 
	 * deve ou não aparecer no painel.
	 * @return 1 caso deva aparecer e 0 caso contrário
	 */
	public int getShowClock() {
		return showClock;
	}
	
	/**
	 * Metodo que modifica se deve o não aparecer o relógio no
	 * painel
	 * @param showClock
	 */
	public void setShowClock(int showClock) {
		this.showClock = showClock;
	}
	
	/**
	 * Metodo que retonra a mensagem que deve aparecer no painel
	 * @return a mensagem que deve aparecer no painel
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Metodo que modifica a mensagem 
	 * @param mensagem a mensagem
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	/**
	 * Metodo que rotorna o intervalo de tempo que um aviso 
	 * deve permanecer na tela
	 * @return o tempo de intervalo do aviso
	 */
	public int getInterval() {
		return interval;
	}
	
	/**
	 * Metodo que mofica o tempo de refresh do painel
	 * @param temporizadorMensagem o refreshTime
	 */
	public void setInterval(int temporizadorMensagem) {
		this.interval = temporizadorMensagem;
	}
	
	/**
	 * Metodo que retorna quantas vezes o aviso de chamada de uma
	 * senha deve aparecer (1,2 ou 3)
	 * @return um numero com a quantidade de vezes.
	 */
	public int getRepeat() {
		
		return repeat;
	}
	
	
	/**
	 * Metodo que modifica a quantidade de vezes que deve ser 
	 * chamada uma senha (quandas vezes deve aparecer em tela 
	 * cheia) 
	 * @param numRepeticoes o número de vezes
	 */
	public void setRepeat(int numRepeticoes) {
		this.repeat = numRepeticoes;
	}

	/**
	 * Metodo que retorna a cor da mensagem
	 * @return a cor da mensagem
	 */
	public String getCorMensagem() {
		return corMensagem;
	}

	/**
	 * Metodo que modifica a cor da mensagem
	 * @param mensagemCor a cor da mensagem
	 */
	public void setCorMensagem(String mensagemCor) {
		this.corMensagem = mensagemCor;
	}
	
	/**
	 * Metodo que retorna um configurador com as configurações
	 * contidas no arquivo de propriedades.
	 * @return um configurador de painel.
	 */
	public static ConfiguradorPainel getConfigurador(){
		ConfiguradorPainel confPainel = new ConfiguradorPainel();
		confPainel.setBgColor(Configuracao.getbgColor());
		confPainel.setMensagem(Configuracao.getMensagem());
		confPainel.setCorMensagem(Configuracao.getCorMensagem());
		confPainel.setRepeat(Configuracao.getRepeat());
		confPainel.setInterval(Configuracao.getInterval());
		confPainel.setShowClock(Configuracao.getShowClock());
		confPainel.setClockPosition(Configuracao.getClockPosition());
		confPainel.setSpeed(Configuracao.getSpeed());
		confPainel.setDestacarUltimaSenha(Configuracao.getDestacarUltimaSenha());
		confPainel.setDuracaoExibicao(Configuracao.getWarningTime());
		return confPainel;
	}

	/**
	 * Metodo que modifica a posição do relógio
	 * @param posicaoClock a posição do relógio
	 */
	public void setClockPosition(String posicaoClock) {
		this.clockPosition = posicaoClock;
	}

	/**
	 * Metodo que retorna a velocidade em que a mensagem deve passar 
	 * na tela
	 * @return a velocidade da mensagem
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Metodo que modifica a velocidade da mensagem
	 * @param speed a velocidade da mensagem
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}


	/**
	 * Metodo que modifica o configurador 
	 * @param confPainel o novo configurador.
	 */
	public static void setConfigurador(ConfiguradorPainel confPainel) {
		Configuracao.setbgColor(confPainel.getBgColor());
		Configuracao.setMensagem(confPainel.getMensagem());
		Configuracao.setCorMensagem(confPainel.getCorMensagem());
		Configuracao.setRepeat(confPainel.getRepeat());
		Configuracao.setInterval(confPainel.getInterval());
		Configuracao.setShowClock(confPainel.getShowClock());
		Configuracao.setClockPosition(confPainel.getClockPosition());
		Configuracao.setSpeed(confPainel.getSpeed());
		Configuracao.setDestacarUltimaSenha(confPainel.getDestacarUltimaSenha());
		Configuracao.setWarningTime(confPainel.getDuracaoExibicao());
		Configuracao.saveConfiguracao();
	}
	
	public static void setConfiguradorDefalt(){ 
		Configuracao.setConfiguracaoDefault();
	}

	/**
	 * Determina se será destacada a última senha. Valor 1 indica que será destacada, qualquer outro valor indica que não irá destacar.
	 * @return o valor de destacarUltimaSenha.
	 */
	public int getDestacarUltimaSenha() {
		return destacarUltimaSenha;
	}

	/**
	 * Altera o valor do destacarUltimaSenha.
	 * @param destacarUltimaSenha novo valor do destacarUltimaSenha. Valor 1 indica que será destacada, qualquer outro valor indica que não irá destacar.
	 */
	public void setDestacarUltimaSenha(int destacarUltimaSenha) {
		this.destacarUltimaSenha = destacarUltimaSenha;
	}

	/**
	 * Determina o tempo de exibicao em segundos.
	 * @return o valor de duracaoExibicao.
	 */
	public int getDuracaoExibicao() {
		return duracaoExibicao;
	}

	/**
	 * Altera o valor da tempo de exibicao.
	 * @param duracaoExibicao novo valor do tempo de exibicao em segundos 
	 */
	public void setDuracaoExibicao(int duracaoExibicao) {
		this.duracaoExibicao = duracaoExibicao;
	}
}
