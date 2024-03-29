package controller;

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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

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
 * Classe que implementa um objeto que representa a configura��o do sistema.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class Configuracao {

	// Declara��o de vari�veis.
	public static final Properties properties;

	public static final Properties propertiesDefault;

	private static String path;

	private static int refreshTime;

	private static int warningTime;

	private static int interval;

	private static int showClock;

	private static int repeat;

	private static String bgColor;

	private static int speed;

	private static String nomeCentral;

	private static String titulo;

	private static String nomeDaImpressora;

	private static String clockPosition;

	private static String mensagem;

	private static String corMensagem;

	private static String nomeAplicacao;

	private static int NchamaParaAvaliar;

	private static int destacarUltimaSenha;

	private static double tempoAtendimentoMinimo;

	private static double tempoAtendimentoMaximo;

	private static double variacao;

	private static int exibirFundo;

	static {
		properties = new Properties();
		propertiesDefault = new Properties();
		loadConfiguracao();
	}

	private static void loadConfiguracao() {
		try {
			URL resource = Configuracao.class.getResource("config.properties");

			properties.load(new BufferedInputStream(resource.openStream()));
			path = determinarPath(resource);
			refreshTime = Integer.parseInt(properties
					.getProperty("refreshTime"));
			warningTime = Integer.parseInt(properties
					.getProperty("warningTime"));
			interval = Integer.parseInt(properties.getProperty("interval"));
			showClock = Integer.parseInt(properties.getProperty("clock"));
			repeat = Integer.parseInt(properties.getProperty("repeat"));
			bgColor = properties.getProperty("bgColor");
			speed = Integer.parseInt(properties.getProperty("speed"));
			nomeCentral = properties.getProperty("nomeCentral");
			titulo = properties.getProperty("titulo");
			clockPosition = properties.getProperty("posicaoClock");
			nomeDaImpressora = properties.getProperty("nomeDaImpressora");
			mensagem = properties.getProperty("mensagem");
			nomeAplicacao = properties.getProperty("nomeAplicacao");
			corMensagem = properties.getProperty("corMensagem");
			NchamaParaAvaliar = Integer.parseInt(properties
					.getProperty("NchamaParaAvaliar"));
			destacarUltimaSenha = Integer.parseInt(properties
					.getProperty("destacarUltimaSenha"));
			tempoAtendimentoMinimo = Double.parseDouble(properties
					.getProperty("tempoAtendimentoMinimo"));
			tempoAtendimentoMaximo = Double.parseDouble(properties
					.getProperty("tempoAtendimentoMaximo"));
			variacao = Double.parseDouble(properties.getProperty("variacao"));
			exibirFundo = Integer.parseInt(properties
					.getProperty("exibirFundo"));
		} catch (IOException e) {
			System.err.println(Configuracao.class
					.getResource("config.properties"));
		}
	}

	private static String determinarPath(URL resource) {
		String path = properties.getProperty("path");
		try {
			if (path.length() < 10) {
				File f = new File(resource.toURI());
				path = f.getAbsolutePath();
				path = path.replace("\\", "/");
				path = path.substring(0, path.length() - 45);
				setPath(path);
				saveConfiguracao();
			}
		} catch (URISyntaxException e) {
			// Path default
			path = "C:/Arquivos de programas/Apache Software Foundation/Tomcat 5.5/webapps/siscofi";
		}
		return path;
	}

	private static void loadConfiguracaoDefault() {
		try {
			URL resource = Configuracao.class
					.getResource("configDefault.properties");
			propertiesDefault.load(new BufferedInputStream(resource
					.openStream()));
			setPath(propertiesDefault.getProperty("path"));
			setRefreshTime(Integer.parseInt(propertiesDefault
					.getProperty("refreshTime")));
			setWarningTime(Integer.parseInt(propertiesDefault
					.getProperty("warningTime")));
			setInterval(Integer.parseInt(propertiesDefault
					.getProperty("interval")));
			setShowClock(Integer.parseInt(propertiesDefault
					.getProperty("clock")));
			setRepeat(Integer.parseInt(propertiesDefault.getProperty("repeat")));
			setBgColor(propertiesDefault.getProperty("bgColor"));
			setSpeed(Integer.parseInt(propertiesDefault.getProperty("speed")));
			setNomeCentral(propertiesDefault.getProperty("nomeCentral"));
			setTitulo(propertiesDefault.getProperty("titulo"));
			setClockPosition(propertiesDefault.getProperty("posicaoClock"));
			setNomeDaImpressora(propertiesDefault
					.getProperty("nomeDaImpressora"));
			setMensagem(propertiesDefault.getProperty("mensagem"));
			setCorMensagem(propertiesDefault.getProperty("corMensagem"));
			setCorMensagem(propertiesDefault.getProperty("duracaoSessao"));
			setNchamaParaAvaliar(Integer.parseInt(propertiesDefault
					.getProperty("NchamaParaAvaliar")));
			setExibirFundo(Integer.parseInt(propertiesDefault
					.getProperty("exibirFundo")));
			setNomeAplicacao(propertiesDefault.getProperty("nomeAplicacao"));
			setDestacarUltimaSenha(Integer.parseInt(propertiesDefault
					.getProperty("destacarUltimaSenha")));
			setTempoAtendimentoMinimo(Double.parseDouble(propertiesDefault
					.getProperty("tempoAtendimentoMinimo")));
			setTempoAtendimentoMaximo(Double.parseDouble(propertiesDefault
					.getProperty("tempoAtendimentoMaximo")));
			setVariacao(Double.parseDouble(propertiesDefault
					.getProperty("variacao")));
		} catch (IOException e) {
			System.err.println(Configuracao.class
					.getResource("configDefault.properties"));
		}

	}

	/**
	 * Metodo que set as configura��es do Sistema para as configura��es Default
	 */
	public static void setConfiguracaoDefault() {
		loadConfiguracaoDefault();
		saveConfiguracao();
	}

	/**
	 * Metodo que salva as configura��es no arquivo de propriedades
	 * "config.properties"
	 */
	public static void saveConfiguracao() {
		try {
			URL resource = Configuracao.class.getResource("config.properties");
			File f = new File(resource.toURI());
			OutputStream out = new FileOutputStream(f);
			properties
					.store(out,
							"Arquivo de configura��o do Sistema de Controle de filas - Siscofi");
			loadConfiguracao();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (URISyntaxException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Retorna o path da aplica��o
	 * 
	 * @return o path da aplica��o
	 */
	public static String getPath() {
		// TODO Est� dando problema na hora de pegar o path quando coloca-se "\"
		return path;
	}

	/**
	 * Retorna o menor tempo de atendimento que ser� considerado pelo sistema.
	 * Tempo de atendimentos inferior n�o ser�o considerados na coleta de dados
	 * de atendimento.
	 * 
	 * @return o tempoAtendimentoMinimo.
	 */
	public static double getTempoAtendimentoMinimo() {
		// TODO Est� dando problema na hora de pegar o path quando coloca-se "\"
		return tempoAtendimentoMinimo;
	}

	/**
	 * Retorna o tempo de atendimento. Os atendimentos cujo tempo for superior a
	 * esse tempo n�o ser�o contabilizados ao determinar o tempo m�dio de
	 * atendimento.
	 * 
	 * @return o tempoAtendimentoMaximo.
	 */
	public static double getTempoAtendimentoMaximo() {
		// TODO Est� dando problema na hora de pegar o path quando coloca-se "\"
		return tempoAtendimentoMaximo;
	}

	/**
	 * Retorna o fator que regula o tempo de atendimento. Um tempo de
	 * atendimento eh descartado se ele for maior que o tempo medio multiplicado
	 * por este fator ou se ele for menor que o tempo medio dividido por este
	 * fator
	 * 
	 * @return a variacao
	 */
	public static double getVariacao() {
		return variacao;
	}

	/**
	 * Metodo que retorna o tempo de refresh do painel.
	 * 
	 * @return o tempo de refresh
	 */
	public static int getRefreshTime() {
		return refreshTime;
	}

	/**
	 * Metodo que retorna o intervalo de tempo que um aviso deve permanecer na
	 * tela
	 * 
	 * @return o tempo de intervalo do aviso
	 */
	public static int getWarningTime() {
		return warningTime;
	}

	/**
	 * Metodo que retorna o inverlo de tempo em que a mensagem deve aparecer na
	 * tela.
	 * 
	 * @return o tempo que um aviso fica no paniel
	 */
	public static int getInterval() {
		return interval;
	}

	/**
	 * Metodo que pega a configura��o se o painel deve ou n�o conter um rel�gio
	 * 
	 * @return 1 caso afirmativo e 0 caso contr�rio
	 */
	public static int getShowClock() {
		return showClock;
	}

	/**
	 * Metodo que retorna quantas vezes o aviso de chamada de uma senha deve
	 * aparecer (1,2 ou 3)
	 * 
	 * @return um numero com a quantidade de vezes.
	 */
	public static int getRepeat() {
		return repeat;
	}

	/**
	 * Metodo que retorna a cor de fundo do painel
	 * 
	 * @return a cor de fundo do painel
	 */
	public static String getbgColor() {
		return bgColor;
	}

	/**
	 * Metodo que retorna a velocidade em que a mensagem deve passar na tela
	 * 
	 * @return a velocidade da mensagem
	 */
	public static int getSpeed() {
		return speed;
	}

	/**
	 * Metodo que retorna o nome da central onde o sistema est� instalado para
	 * ser colocada na senha.
	 * 
	 * @return o nome da central onde o sistema est� instalado.
	 */
	public static String getNomeCentral() {
		return nomeCentral;
	}

	/**
	 * Metodo que retorna o titulo que aparecer� na primeira linha da senha
	 * 
	 * @return o titulo.
	 */
	public static String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que retorna a cor de fundo do painel
	 * 
	 * @return a cor de fundo do painel.
	 */
	public static String getBgColor() {
		return bgColor;
	}

	/**
	 * Metodo que retorna a posi��o do rel�gio
	 * 
	 * @return a posi��o do rel�gio
	 */
	public static String getClockPosition() {
		return clockPosition;
	}

	/**
	 * Metodo que retonra a mensagem que deve aparecer no painel
	 * 
	 * @return a mensagem que deve aparecer no painel
	 */
	public static String getMensagem() {
		return mensagem;
	}

	/**
	 * Metodo que modifica a cor de fundo do painel
	 * 
	 * @param bgColor
	 *            a nova cor de fundo do painel
	 */
	public static void setBgColor(String bgColor) {
		Configuracao.bgColor = bgColor;
		properties.setProperty("bgColor", bgColor);
	}

	/**
	 * Metodo que retorna a cor da mensagem
	 * 
	 * @return a cor da mensagem
	 */
	public static String getCorMensagem() {
		return corMensagem;
	}

	/**
	 * Metodo que retorna um inteiro representando se o rel�gio deve ou n�o
	 * aparecer no painel
	 * 
	 * @param showClock
	 *            1 caso o rel�gio deva aparecer e 0 caso contr�rio
	 */
	public static void setShowClock(int showClock) {
		Configuracao.showClock = showClock;
		properties.setProperty("clock", showClock + "");

	}

	/**
	 * Metodo que modifica o intervalo de tempo em que a mensagem deve aparecer
	 * na tela
	 * 
	 * @param interval
	 *            o intervalo
	 */
	public static void setInterval(int interval) {
		Configuracao.interval = interval;
		properties.setProperty("interval", interval + "");

	}

	/**
	 * Metodo que modifia o nome da central que aparece na senha
	 * 
	 * @param nomeCentral
	 *            o nome da central
	 */
	public static void setNomeCentral(String nomeCentral) {
		Configuracao.nomeCentral = nomeCentral;
		properties.setProperty("nomeCentral", nomeCentral);

	}

	/**
	 * Metodo que altera o path onde se encontra a aplica��o
	 * 
	 * @param path
	 *            o path
	 */
	public static void setPath(String path) {
		Configuracao.path = path;
		properties.setProperty("path", path);

	}

	/**
	 * Metodo que altera o menor tempo de atendimento que ser� considerado na
	 * coleta de dados de atendimento.
	 * 
	 * @param tempoAtendimentoMinimo
	 *            o tempoAtendimentoMinimo.
	 */
	public static void setTempoAtendimentoMinimo(double tempoAtendimentoMinimo) {
		Configuracao.tempoAtendimentoMinimo = tempoAtendimentoMinimo;
		properties.setProperty("tempoAtendimentoMinimo", tempoAtendimentoMinimo
				+ "");

	}

	/**
	 * Metodo que altera o fator de multiplica��o do tempo m�dio de atendimento.
	 * Os atendimentos cujo tempo for superior ao tempo m�dio de atendimento
	 * multiplicado por este fator n�o ser�o considerados na determina��o do
	 * tempo m�dio de atendimento do sistema.
	 * 
	 * @param tempoAtendimentoMaximo
	 *            O tempoAtendimentoMaximo.
	 */
	public static void setTempoAtendimentoMaximo(double tempoAtendimentoMaximo) {
		Configuracao.tempoAtendimentoMaximo = tempoAtendimentoMaximo;
		properties.setProperty("tempoAtendimentoMaximo", tempoAtendimentoMaximo
				+ "");

	}

	/**
	 * Metodo que altera o fator que regula a variacao do tempo de atendimento.
	 * 
	 * @param variacao
	 *            O novo fator da variacao
	 */
	public static void setVariacao(double variacao) {
		Configuracao.variacao = variacao;
		properties.setProperty("variacao", variacao + "");
	}

	/**
	 * Metodo que mofica o tempo de refresh do painel
	 * 
	 * @param refreshTime
	 *            o refreshTime
	 */
	public static void setRefreshTime(int refreshTime) {
		Configuracao.refreshTime = refreshTime;
		properties.setProperty("refreshTime", refreshTime + "");
	}

	/**
	 * Metodo que modifica a quantidade de vezes que deve ser chamada uma senha
	 * (quandas vezes deve aparecer em tela cheia)
	 * 
	 * @param repeat
	 *            o n�mero de vezes
	 */
	public static void setRepeat(int repeat) {
		Configuracao.repeat = repeat;
		properties.setProperty("repeat", repeat + "");
	}

	/**
	 * Metodo que modifica a velocidade da mensagem
	 * 
	 * @param speed
	 *            a velocidade da mensagem
	 */
	public static void setSpeed(int speed) {
		Configuracao.speed = speed;
		properties.setProperty("speed", speed + "");
	}

	/**
	 * Metodo que modifica o titulo que aparece na senha
	 * 
	 * @param titulo
	 *            o t�tulo da mensagem.
	 */
	public static void setTitulo(String titulo) {
		Configuracao.titulo = titulo;
		properties.setProperty("titulo", titulo);
	}

	/**
	 * Metodo que modifica de quanto em quanto tempo deve aparecer a mensagem no
	 * painel
	 * 
	 * @param warningTime
	 *            o tempo.
	 */
	public static void setWarningTime(int warningTime) {
		Configuracao.warningTime = warningTime;
		properties.setProperty("warningTime", warningTime + "");
	}

	/**
	 * Metodo que retorna o nome da impressora
	 * 
	 * @return o nome da impressora
	 */
	public static String getNomeDaImpressora() {
		return nomeDaImpressora;
	}

	/**
	 * Metodo que modifica o nome da impressora
	 * 
	 * @param nomeDaImpressora
	 *            o nome da impressora.
	 */
	public static void setNomeDaImpressora(String nomeDaImpressora) {
		Configuracao.nomeDaImpressora = nomeDaImpressora;
		properties.setProperty("nomeDaImpressora", nomeDaImpressora);
	}

	/**
	 * Metodo que modifica a mensagem
	 * 
	 * @param mensagem
	 *            a mensagem
	 */
	public static void setMensagem(String mensagem) {
		Configuracao.mensagem = mensagem;
		properties.setProperty("mensagem", mensagem);
	}

	/**
	 * Metodo que modifica a cor da mensagem
	 * 
	 * @param corMensagem
	 *            a cor da mensagem
	 */
	public static void setCorMensagem(String corMensagem) {
		Configuracao.corMensagem = corMensagem;
		properties.setProperty("corMensagem", corMensagem);
	}

	/**
	 * Metodo que modifica a posi��o do rel�gio
	 * 
	 * @param posicaoClock
	 *            a posi��o do rel�gio
	 */
	public static void setClockPosition(String posicaoClock) {
		Configuracao.clockPosition = posicaoClock;
		properties.setProperty("posicaoClock", posicaoClock);
	}

	/**
	 * M�todo que determina nchamaParaAvaliar
	 * 
	 * @return o valor de nchamaParaAvaliar
	 */
	public static int getNchamaParaAvaliar() {
		return NchamaParaAvaliar;
	}

	/**
	 * Altera o valor da vari�vel nchamaParaAvaliar.
	 * 
	 * @param nchamaParaAvaliar
	 *            O novo valor de nchamaParaAvaliar.
	 */
	public static void setNchamaParaAvaliar(int nchamaParaAvaliar) {
		NchamaParaAvaliar = nchamaParaAvaliar;
		properties.setProperty("NchamaParaAvaliar", nchamaParaAvaliar + "");
	}

	/**
	 * M�todo que determina exibirFundo.
	 * 
	 * @return o valor de exibirFundo.
	 */
	public static int getExibirFundo() {
		return exibirFundo;
	}

	/**
	 * Altera o valor da vari�vel exibirFundo.
	 * 
	 * @param exibir
	 *            O novo valor de exibirFundo.
	 */
	public static void setExibirFundo(int exibir) {
		exibirFundo = exibir;
		properties.setProperty("exibirFundo", exibirFundo + "");
	}

	/**
	 * M�todo que determina o valor de destacarUltimaSenha. O valor 1 indica que
	 * ser� destacada e 0 (zero) ou qualquer outro valor determina que n�o ser�
	 * destacada.
	 * 
	 * @return o valor de destacarUltimaSenha.
	 */
	public static int getDestacarUltimaSenha() {
		return destacarUltimaSenha;
	}

	/**
	 * Altera o valor da vari�vel destacarUltimaSenha. O valor 1 indica que ser�
	 * destacada e 0 (zero) ou qualquer outro valor determina que n�o ser�
	 * destacada.
	 * 
	 * @param destacarUltimaSenha
	 *            O novo valor de destacarUltimaSenha.
	 */
	public static void setDestacarUltimaSenha(int destacarultimaSenha) {
		destacarUltimaSenha = destacarultimaSenha;
		properties.setProperty("destacarUltimaSenha", destacarultimaSenha + "");
	}

	/**
	 * @return o nome do nomeAplicacao
	 */
	public static String getNomeAplicacao() {
		return nomeAplicacao;
	}

	/**
	 * @param nomeAplicacao
	 *            Altera o nome do nomeAplicacao
	 */
	public static void setNomeAplicacao(String nomeAplicacao) {
		Configuracao.nomeAplicacao = nomeAplicacao;
		properties.setProperty("nomeAplicacao", nomeAplicacao);
	}

	public static void main(String[] args) {
		Configuracao.getbgColor();
	}

}