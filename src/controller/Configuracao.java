package controller;

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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que implementa um objeto que representa a configuração do sistema.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class Configuracao {

	// Declaração de variáveis.
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

	private static double fluxoChegada;

	private static int exibirFundo;
	
	private static String tipoLogin;
	
	private static String entidade;

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
			nomeAplicacao = properties.getProperty("nomeAplicacao");
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
			fluxoChegada = Double.parseDouble(properties
					.getProperty("fluxoChegada"));
			exibirFundo = Integer.parseInt(properties
					.getProperty("exibirFundo"));
			tipoLogin = properties.getProperty("tipoLogin");
			entidade = properties.getProperty("entidade");
		} catch (IOException e) {
			System.err.println(Configuracao.class
					.getResource("config.properties"));
		}
	}
	
	/**
	 * Determina o local de instalação da aplicação.
	 * @param resource referência para o arquivo de configurações do sistema.
	 * @return o path da aplicação.
	 */
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
			setbgColor(propertiesDefault.getProperty("bgColor"));
			setSpeed(Integer.parseInt(propertiesDefault.getProperty("speed")));
			setNomeCentral(propertiesDefault.getProperty("nomeCentral"));
			setTitulo(propertiesDefault.getProperty("titulo"));
			setTipoLogin(propertiesDefault.getProperty("tipoLogin"));
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
			setFluxoChegada(Double.parseDouble(propertiesDefault
					.getProperty("fluxoChegada")));
			
		} catch (IOException e) {
			System.err.println(Configuracao.class
					.getResource("configDefault.properties"));
		}

	}

	/**
	 * Metodo que set as configurações do Sistema para as configurações Default
	 */
	public static void setConfiguracaoDefault() {
		loadConfiguracaoDefault();
		saveConfiguracao();
	}

	/**
	 * Metodo que salva as configurações no arquivo de propriedades
	 * "config.properties"
	 */
	public static void saveConfiguracao() {
		try {
			URL resource = Configuracao.class.getResource("config.properties");
			File f = new File(resource.toURI());
			OutputStream out = new FileOutputStream(f);
			properties
					.store(out,
							"Arquivo de configuração do Sistema de Controle de filas - Siscofi");
			loadConfiguracao();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (URISyntaxException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Retorna o path da aplicação
	 * 
	 * @return o path da aplicação
	 */
	public static String getPath() {
		// TODO Está dando problema na hora de pegar o path quando coloca-se "\"
		return path;
	}

	/**
	 * Retorna o menor tempo de atendimento que será considerado pelo sistema.
	 * Tempo de atendimentos inferior não serão considerados na coleta de dados
	 * de atendimento.
	 * 
	 * @return o tempoAtendimentoMinimo em minutos.
	 */
	public static double getTempoAtendimentoMinimo() {
		// TODO Está dando problema na hora de pegar o path quando coloca-se "\"
		return tempoAtendimentoMinimo;
	}

	/**
	 * Retorna o tempo de atendimento. Os atendimentos cujo tempo for superior a
	 * esse tempo não serão contabilizados ao determinar o tempo médio de
	 * atendimento.
	 * 
	 * @return o tempoAtendimentoMaximo em minutos.
	 */
	public static double getTempoAtendimentoMaximo() {
		// TODO Está dando problema na hora de pegar o path quando coloca-se "\"
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
	 * @return o tempo de refresh em milissegundos.
	 */
	public static int getRefreshTime() {
		return refreshTime;
	}

	/**
	 * Metodo que retorna o intervalo de tempo que um aviso deve permanecer na
	 * tela
	 * 
	 * @return o tempo de intervalo do aviso em segundos.
	 */
	public static int getWarningTime() {
		return warningTime;
	}

	/**
	 * Metodo que retorna o inverlo de tempo em que a mensagem deve aparecer na
	 * tela.
	 * 
	 * @return o tempo que um aviso fica no paniel em segundos.
	 */
	public static int getInterval() {
		return interval;
	}

	/**
	 * Metodo que pega a configuração se o painel deve ou não conter um relógio
	 * 
	 * @return 1 caso afirmativo e 0 caso contrário
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
	 * Metodo que retorna o nome da central onde o sistema está instalado para
	 * ser colocada na senha.
	 * 
	 * @return o nome da central onde o sistema está instalado.
	 */
	public static String getNomeCentral() {
		return nomeCentral;
	}

	/**
	 * Metodo que retorna o titulo que aparecerá na primeira linha da senha
	 * 
	 * @return o titulo.
	 */
	public static String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que retorna a posição do relógio
	 * 
	 * @return a posição do relógio
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
	public static void setbgColor(String bgColor) {
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
	 * Metodo que altera a exibição o relógio 
	 * 
	 * @param showClock
	 *            1 caso o relógio deva aparecer e 0 caso contrário
	 */
	public static void setShowClock(int showClock) {
		if(showClock == 1){
			Configuracao.showClock = showClock;
			properties.setProperty("clock", showClock + "");		
		} else {
			Configuracao.showClock = 0;
			properties.setProperty("clock", "0");
		}
	}

	/**
	 * Metodo que modifica o intervalo de tempo em que a mensagem deve aparecer
	 * na tela
	 * 
	 * @param interval
	 *            o intervalo em segundos 
	 */
	public static void setInterval(int interval) {
		if(interval > 1){
			Configuracao.interval = interval;
			properties.setProperty("interval", interval + "");	
		}
	}

	/**
	 * Metodo que modifia o nome da central que aparece na senha
	 * 
	 * @param nomeCentral
	 *            o nome da central
	 */
	public static void setNomeCentral(String nomeCentral) {
		if(nomeCentral != null){
			Configuracao.nomeCentral = nomeCentral;
			properties.setProperty("nomeCentral", nomeCentral);			
		}
	}

	/**
	 * Metodo que altera o path onde se encontra a aplicação
	 * 
	 * @param path
	 *            o path
	 */
	public static void setPath(String path) {
		if(path != null){
			Configuracao.path = path;
			properties.setProperty("path", path);			
		}
	}

	/**
	 * Metodo que altera o menor tempo de atendimento que será considerado na
	 * coleta de dados de atendimento.
	 * 
	 * @param tempoAtendimentoMinimo
	 *            o tempoAtendimentoMinimo em minutos.
	 */
	public static void setTempoAtendimentoMinimo(double tempoAtendimentoMinimo) {
		if(tempoAtendimentoMinimo >= 0){
			Configuracao.tempoAtendimentoMinimo = tempoAtendimentoMinimo;
			properties.setProperty("tempoAtendimentoMinimo", tempoAtendimentoMinimo	+ "");	
		}
	}

	/**
	 * Metodo que altera o fator de multiplicação do tempo médio de atendimento.
	 * Os atendimentos cujo tempo for superior ao tempo médio de atendimento
	 * multiplicado por este fator não serão considerados na determinação do
	 * tempo médio de atendimento do sistema.
	 * 
	 * @param tempoAtendimentoMaximo
	 *            O tempoAtendimentoMaximo em minutos.
	 */
	public static void setTempoAtendimentoMaximo(double tempoAtendimentoMaximo) {
		if(tempoAtendimentoMaximo >= tempoAtendimentoMinimo){
			Configuracao.tempoAtendimentoMaximo = tempoAtendimentoMaximo;
			properties.setProperty("tempoAtendimentoMaximo", tempoAtendimentoMaximo	+ "");	
		}
	}

	/**
	 * Metodo que altera o fator que regula a variacao do tempo de atendimento.
	 * 
	 * @param variacao
	 *            O novo fator da variacao
	 */
	public static void setVariacao(double variacao) {
		if(variacao > 0){
			Configuracao.variacao = variacao;
			properties.setProperty("variacao", variacao + "");	
		}
	}

	/**
	 * Metodo que mofica o tempo de refresh do painel
	 * 
	 * @param refreshTime
	 *            o refreshTime em milissegundos.
	 */
	public static void setRefreshTime(int refreshTime) {
		if(refreshTime > 0){
			Configuracao.refreshTime = refreshTime;
			properties.setProperty("refreshTime", refreshTime + "");	
		}
	}

	/**
	 * Metodo que modifica a quantidade de vezes que deve ser chamada uma senha
	 * (quandas vezes deve aparecer em tela cheia)
	 * 
	 * @param repeat
	 *            o número de vezes
	 */
	public static void setRepeat(int repeat) {
		if(repeat > 0){
			Configuracao.repeat = repeat;
			properties.setProperty("repeat", repeat + "");	
		}
	}

	/**
	 * Metodo que modifica a velocidade da mensagem
	 * 
	 * @param speed
	 *            a velocidade da mensagem
	 */
	public static void setSpeed(int speed) {
		if(speed > 0){
			Configuracao.speed = speed;
			properties.setProperty("speed", speed + "");	
		}
	}

	/**
	 * Metodo que modifica o titulo que aparece na senha
	 * 
	 * @param titulo
	 *            o título da mensagem.
	 */
	public static void setTitulo(String titulo) {
		if(titulo != null){
			Configuracao.titulo = titulo;
			properties.setProperty("titulo", titulo);			
		}
	}

	/**
	 * Metodo que modifica de quanto em quanto tempo deve aparecer a mensagem no
	 * painel
	 * 
	 * @param warningTime
	 *            o tempo em segundos.
	 */
	public static void setWarningTime(int warningTime) {
		if(warningTime > 0){
			Configuracao.warningTime = warningTime;
			properties.setProperty("warningTime", warningTime + "");			
		}
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
	 * Metodo que modifica a posição do relógio
	 * 
	 * @param posicaoClock
	 *            a posição do relógio
	 */
	public static void setClockPosition(String posicaoClock) {
		Configuracao.clockPosition = posicaoClock;
		properties.setProperty("posicaoClock", posicaoClock);
	}

	/**
	 * Método que determina número de atendimentos entre cada avaliação.
	 * 
	 * @return o valor de nchamaParaAvaliar
	 */
	public static int getNchamaParaAvaliar() {
		return NchamaParaAvaliar;
	}

	/**
	 * Altera o valor do número de atendimentos entre cada avaliação.
	 * 
	 * @param nchamaParaAvaliar
	 *            O novo valor de nchamaParaAvaliar.
	 */
	public static void setNchamaParaAvaliar(int nchamaParaAvaliar) {
		if(nchamaParaAvaliar > 0){
			NchamaParaAvaliar = nchamaParaAvaliar;
			properties.setProperty("NchamaParaAvaliar", nchamaParaAvaliar + "");			
		}
	}

	/**
	 * Método que determina exibirFundo.
	 * 
	 * @return o valor de exibirFundo.
	 */
	public static int getExibirFundo() {
		return exibirFundo;
	}

	/**
	 * Altera o valor da variável exibirFundo. O valor 1 determina que o fundo deve ser exibido e zero (ou qualquer outro valor) determina que o fundo não será exibido.
	 * 
	 * @param exibir
	 *            O novo valor de exibirFundo.
	 */
	public static void setExibirFundo(int exibir) {
		if(exibir == 1){
			exibirFundo = exibir;
			properties.setProperty("exibirFundo", exibirFundo + "");
		} else{
			exibirFundo = 0;
			properties.setProperty("exibirFundo","0");
		}
	}

	/**
	 * Método que determina o valor de destacarUltimaSenha. O valor 1 indica que
	 * será destacada e 0 (zero) ou qualquer outro valor determina que não será
	 * destacada.
	 * 
	 * @return o valor de destacarUltimaSenha.
	 */
	public static int getDestacarUltimaSenha() {
		return destacarUltimaSenha;
	}

	/**
	 * Altera o valor da variável destacarUltimaSenha. O valor 1 indica que será
	 * destacada e 0 (zero) ou qualquer outro valor determina que não será
	 * destacada.
	 * 
	 * @param destacarultimaSenha
	 *            O novo valor de destacarUltimaSenha.
	 */
	public static void setDestacarUltimaSenha(int destacarultimaSenha) {
		if(destacarultimaSenha == 1){
			destacarUltimaSenha = destacarultimaSenha;
			properties.setProperty("destacarUltimaSenha", destacarultimaSenha + "");			
		} else{
			destacarUltimaSenha = 0;
			properties.setProperty("destacarUltimaSenha", "0");
		}
	}

	/**
	 * @return o nome do nomeAplicacao usado na URL.
	 */
	public static String getNomeAplicacao() {
		return nomeAplicacao;
	}

	/**
	 * @param nomeAplicacao
	 *            Altera o nome do nomeAplicacao usado na URL.
	 */
	public static void setNomeAplicacao(String nomeAplicacao) {
		Configuracao.nomeAplicacao = nomeAplicacao;
		properties.setProperty("nomeAplicacao", nomeAplicacao);
	}
	
		/**
	 * @return O fluxo de chegada na central
	 */
	public static double getFluxoChegada() {
		return fluxoChegada;
	}

	/**
	 * Altera o fluxo de chegada na central de atendimento
	 * @param fluxoChegada O novo fluxo de chegada da central
	 */
	public static void setFluxoChegada(double fluxoChegada) {
		if(fluxoChegada > 0){
			Configuracao.fluxoChegada = fluxoChegada;
			properties.setProperty("fluxoChegada", fluxoChegada + "");			
		}
	}
	
	/**
	 * @return o nome da entidade
	 */
	public static String getEntidade() {
		return entidade;
	}

	/**
	 * @param entidade
	 *            Altera o nome da entidade
	 */
	public static void setEntidade(String entidade) {
		Configuracao.entidade = entidade;
		properties.setProperty("entidade", entidade);
	}
	
	/**
	 * Determina o tipo de login.
	 * @return o valor do tipo de login.
	 */
	public static String getTipoLogin() {
		return tipoLogin;
	}

	/**
	 * Altera o tipo de login.
	 * @param tipoLogin Novo valor para o tipo de login.
	 */
	public static void setTipoLogin(String tipoLogin) {
		Configuracao.tipoLogin = tipoLogin;
		properties.setProperty("tipoLogin", tipoLogin);
	}

}