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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.ServletException;

import util.DataUtil;
import util.GeradorGraficosAtendimentos;
import util.GeradorGraficosRelatorioAvaliacao;
import util.GeradorRelatorioAvaliacao;
import util.Impressao;
import util.XMLUtil;
import coletaDados.EntregaTitulo;
import coletaDados.TempoAvaliacao;

import com.lowagie.text.Document;

import controleChamada.Aviso;
import controleChamada.ListaAviso;
import database.AvaliacaoDAO;
import database.ControleDAO;
import database.DadosAtendimentoDAO;
import database.EntregaTituloDAO;
import database.EstatisticasDAO;
import database.LoginDAO;
import database.StatusDAO;
import database.TempoAvaliacaoDAO;
import database.bean.Atendimento;
import database.bean.Atendimentos;
import database.bean.Avaliacao;
import database.bean.Conexao;
import database.bean.Controle;
import database.bean.DadosAvaliacao;
import database.bean.Login;
import estatisticas.atendimento.DadosAtendimento;
import estatisticas.atendimento.ResumoAtendimento;
import estatisticas.atendimento.TempoMedioAtendimento;
import estatisticas.avaliacao.Estatisticas;
import estatisticas.avaliacao.GerenciadorEstatisticas;
import exceptions.ConnectionDBException;
import exceptions.NotFoundInDBException;
import exceptions.SenhaInvalidaException;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que acessa as funcionalidades da camada Model (lógica de negócio), no
 * padrão MVC.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.1
 */

public class Siscofi implements TiposLogin{
	
	// Atributos de classe
	private static Siscofi instanciaUnica = null;

	private static String path = Configuracao.getPath();

	private static final String AVISO_XML = path + "/admin/painel.xml";

	// private GerenciadorGuiches gerenciadorGuiches;

	private ListaAviso chamadas;

	private boolean isStarted;

	GerenciadorGuiches gerenciador;

	// Guarda os controles que estão no Banco de Dados
	private ConcurrentLinkedQueue<Controle> controles;

	private DadosAtendimento dadosAtendimento;

	// Contagem de quantos atendimentos foram chamados
	private int contadorAtendimento;

	private TempoMedioAtendimento tempoMedioAtendimento;

	/**
	 * Cria um novo objeto Siscofi
	 */
	private Siscofi() {
		isStarted = false;
	}

	/**
	 * Metodo que retorna uma instancia da classe Siscofi.
	 * 
	 * @return uma instancia da classe Siscofi
	 */
	public static Siscofi getInstance() {
		if (instanciaUnica == null) {
			// "lazy instantiation"
			instanciaUnica = new Siscofi();
			instanciaUnica.iniciarSistema();
		}
		return instanciaUnica;
	}

	/**
	 * Metodo que inicia o sistema
	 * 
	 */
	public void iniciarSistema() {
		try {
			chamadas = new ListaAviso();
			// gerenciadorGuiches = new
			// GerenciadorGuiches(Configuracao.getDuracaoSessao());
			isStarted = StatusDAO.isStarted();
			gerenciador = new GerenciadorGuiches();
			determinarDadosAtendimento();
			controles = new ConcurrentLinkedQueue<Controle>();
			ControleDAO cDAO = new ControleDAO();
			controles.addAll(cDAO.listaControles());
			tempoMedioAtendimento = new TempoMedioAtendimento();
			chamadas.pararChamadas();

		} catch (Exception e) {
			System.err.println("O sistema nao pode ser iniciado");
			e.printStackTrace();
		}
	}

	/**
	 * Método que carrega os dados sobre atendimento do banco de dados. Caso não
	 * haja dados, un novo objeto DadosAtendimento será criado
	 * 
	 */
	private void determinarDadosAtendimento() {
		if (isStarted) {
			Date data = DataUtil.getDataAtual();
			try {
				dadosAtendimento = new DadosAtendimentoDAO()
						.readDadosAtendimento(data);
			} catch (NotFoundInDBException e) {
			}
			if (dadosAtendimento == null) {
				dadosAtendimento = new DadosAtendimento();
			}
		}
	}

	public boolean encaminharAvaliacao() {
		boolean encaminhar = false;
		if (contadorAtendimento >= Configuracao.getNchamaParaAvaliar()) {
			contadorAtendimento = 0;
			encaminhar = true;
		}
		return encaminhar;
	}

	/**
	 * Metodo que adiciona um aviso ao Sistema
	 * 
	 * @param guiche
	 *            o guiche do aviso a ser adicionado
	 * @param senha
	 *            a senha que devera aparecer no aviso
	 * @param cor
	 *            a cor do aviso
	 * @throws ServletException
	 */
	public void addAviso(String guiche, String senha, String cor)
			throws ServletException {
		chamadas.addAviso(guiche, senha, cor);
		System.out.println("guiche " + guiche + " senha " + senha + " cor "
				+ cor);
	}

	/**
	 * Determina o total de avisos que estão no momento.
	 * 
	 * @return O total de avisos no sistema.
	 */
	public int getTotalAvisos() {
		return chamadas.getTotalAvisos();
	}

	/**
	 * Determina se avisos no sistema.
	 * 
	 * @return True caso tenha aviso no sistema e False em caso contrário.
	 */
	public boolean temAvisos() {
		return chamadas.isEmpty();
	}

	/**
	 * Metodo que chama uma determina senha
	 * 
	 * @param ip
	 *            O IP do guiche da senha a ser chamada
	 * @param senha
	 *            A senha a ser chamada
	 * @param classe
	 *            a classe da senha a ser chamada
	 * @throws SenhaInvalidaException
	 *             lançada quando a senha é invalida.
	 * @throws ServletException 
	 */
	public synchronized void chamarSenhaEspecifica(String ip, String senha, String classe)
			throws SenhaInvalidaException, ServletException {
		String guiche = getGuiche(ip);
		String cor = getControleClasse(classe).getCor();
		addAviso(guiche, senha, cor);
		coletarDadosAtendimento(guiche, classe);
	}

	/**
	 * Método que emite várias senhas de uma mesma classe. A emissão de uma
	 * senha consiste de incrementar o total de senhas emitidas.
	 * 
	 * @param controle
	 *            Objeto que contem as informações sobre a emissao solicitada.
	 * @throws NotFoundInDBException
	 *             Lançada se a emissao for referente a uma classe de
	 *             atendimento inexistente.
	 * @throws ServletException
	 */
	public void emiteSenha(Controle controle) throws NotFoundInDBException,
			ServletException {
		ControleDAO controleDAO = new ControleDAO();
		// Controle controle = controleDAO.readControle(emissao.getClasse());
		// Controle controle = getControleClasse(emissao.getClasse());
		// controle.incrementaQuantidade(emissao.getTotal());
		addControle(controle);
		controleDAO.writeControle(controle);
	}

	/**
	 * Método que determina o Controle de uma classe de atendimento.
	 * 
	 * @param classe
	 *            A classe solicitada.
	 * @return O controle de uma classe de atendimento.
	 */
	public Controle getControleClasse(String classe){
		for (Controle controle : controles)
			if (controle.getClasse().equals(classe))
				return controle;
		return null;
	}

	/**
	 * Determina todas as classes existentes no sistema.
	 * 
	 * @return Lista contendo os nomes de todas as classes do sistema.
	 */
	public List<String> getListaClasses() {
		List<String> listaClasses = new ArrayList<String>();
		for (Controle controle : controles) {
			listaClasses.add(controle.getClasse());
		}
		Collections.sort(listaClasses);
		return listaClasses;
		// ControleDAO controleDAO = new ControleDAO();
		// return controleDAO.listaClasses();
	}

	/**
	 * Determina todas controles existentes no sistema.
	 * 
	 * @return Lista contendo os controles de todas as classes do sistema.
	 * @throws ServletException
	 */
	public ConcurrentLinkedQueue<Controle> getListaControles()
			throws ServletException {
		// ControleDAO controleDAO = new ControleDAO();
		// return controleDAO.listaControles();
		return controles;
	}

	/**
	 * Adiciona ou atualiza um controle a lista de controles
	 * 
	 * @param controle
	 *            O controle a ser adicionado ou atualizado
	 */
	public void addControle(Controle controle) {
		boolean encontrou = false;
		for (Controle c : controles) {
			if (c.getClasse().equals(controle.getClasse())) {
				encontrou = true;
				break;
			}
		}
		if (encontrou)
			controles.remove(controle);
		controles.add(controle);
	}

	/**
	 * Remove um controle cuja classe é passada da lista de controles
	 */
	public void removeControle(String classe) {
		for (Controle c : controles) {
			if (c.getClasse().equals(classe)) {
				controles.remove(c);
				break;
			}
		}
	}

	/**
	 * Determina se a última senha chamada pelo sistema para uma dada classe de
	 * atendimento.
	 * 
	 * @param guiche
	 *            A classe do guiche a ser verificada.
	 * @return o número da última senha a ser chamada na classe ou zero, caso
	 *         nenhuma senha tenha sido chamada para aquela classe.
	 * @throws NotFoundInDBException
	 *             Lançada a classe de atendimento não existir.
	 */
	public String getUltimaSenhaChamada(String guiche)
			throws NotFoundInDBException {
		// ControleDAO DAO = new ControleDAO();
		// Controle controle = DAO.readControle(guiche);
		Controle controle = getControleClasse(guiche);
		return controle.getSenha();
	}

	/**
	 * Determina o total de senha emitidas para um guiche.
	 * 
	 * @param guiche
	 *            o guiche do qual determina o total de senha emitidas
	 * @return Total de senha para o guiche.
	 * @throws NotFoundInDBException
	 *             Lançada a classe de atendimento não existir.
	 */
	public int getTotalSenhas(String guiche) throws NotFoundInDBException {
		// ControleDAO DAO = new ControleDAO();
		// Controle controle = DAO.readControle(guiche);
		Controle controle = getControleClasse(guiche);
		return controle.getQuantidade();
	}

	/**
	 * Cria uma nova classe de guiche de atendimento.
	 * 
	 * @param nomeClasse
	 *            O nome da nova classe.
	 * @param prefixo
	 *            O prefixo que identifica o guiche
	 * @param cor
	 *            A cor da classe que será exibida no painel
	 * @param quantInicial
	 *            Define a quantidade inicial de senha que constarão no guiche
	 *            ao iniciar o sistema.
	 * @throws ServletException
	 */
	public void createClasse(String nomeClasse, String prefixo, String cor,
			int quantInicial) throws ServletException {
		Controle controle = new Controle();
		controle.setClasse(nomeClasse);
		controle.setUltimaSenha(0);
		controle.setQuantidade(quantInicial);
		controle.setQuantidadeInicial(quantInicial);
		controle.setPrefixo(prefixo);
		controle.setCor(cor);
		ControleDAO DAO = new ControleDAO();
		addControle(controle);
		DAO.writeControle(controle);
	}

	/**
	 * Apaga todos os dados do banco de dados
	 */
	public void resetBD() {
		ControleDAO DAO = new ControleDAO();
		DAO.generateTable();
		LoginDAO login = new LoginDAO();
		login.generateTable();
		Login l = new Login();
		login.writeLogin(l);
		new AvaliacaoDAO().generateTable();
		StatusDAO.generateTable();
		new EstatisticasDAO().generateTable();
		new DadosAtendimentoDAO().generateTable();
		new TempoAvaliacaoDAO().generateTable();
		new EntregaTituloDAO().generateTable();
		isStarted = StatusDAO.isStarted();
		iniciarSistema();
	}

	/**
	 * Metodo que gera um arquivo XML que será utilizado pelo arquivo flash
	 * 
	 * @param aviso
	 *            o aviso que constará no XML
	 * @throws ServletException
	 */
	public void gerarXMLFlash(Aviso aviso) throws ServletException {
		XMLUtil.geradorXMLPainel(controles, aviso, AVISO_XML);
	}

	/**
	 * Metodo que retorna uma lista com as mensagem que estão cadastradas no
	 * sistema
	 * 
	 * @return a lista com as mensagens cadastradas no sistema.
	 */
	public String getMensagem() {
		return Configuracao.getMensagem();
	}

	/**
	 * Metodo que retorna nome da central que está cadastrada no sistema
	 * 
	 * @return o nome da central cadastrada no sistema.
	 */
	public String getNomeCentral() {
		return Configuracao.getNomeCentral();
	}

	/**
	 * Metodo que retorna nome da entidade que está cadastrada no sistema
	 * 
	 * @return o nome da entidade cadastrada no sistema.
	 */
	public String getEntidade() {
		return Configuracao.getEntidade();
	}
	
	/**
	 * Metodo que retorna o titulo da central que está cadastrada no sistema
	 * 
	 * @return O titulo da central
	 */
	public String getTitulo() {
		return Configuracao.getTitulo();
	}

	/**
	 * Realiza a chamada da senha de uma classe de atendimento novamente
	 * 
	 * @param ip O IP do
	 *            O guiche que chama a senha
	 * @param classe
	 *            A classe de guiche que chama a senha
	 * @throws NotFoundInDBException
	 * @throws ServletException
	 */
	public synchronized void chamarNovamente(String ip, String classe,
			String senha) throws NotFoundInDBException, ServletException {
		String guiche = getGuiche(ip);
		String cor = getControleClasse(classe).getCor();
		addAviso(guiche, senha, cor);
		coletarDadosAtendimento(guiche, classe);
	}

	/**
	 * Determina a cor de exibição de uma classe de atendimento.
	 * 
	 * @param classe
	 *            Nome da classe de atendimento.
	 * @return o valor de hexaDecimal da cor da classe.
	 * @throws NotFoundInDBException
	 *             Lançada se a classe não for encontrada no banco de dados.
	 */
	public String getCorClasse(String classe) throws NotFoundInDBException {
		// ControleDAO controleDAO = new ControleDAO();
		// Controle controle = controleDAO.readControle(classe);
		Controle controle = getControleClasse(classe);
		return controle.getCor();
	}

	/**
	 * Determina a quantidade inicial de senhas em uma classe.
	 * 
	 * @param classe
	 *            Nome da classe de atendimento.
	 * @return quantidade de senhas na classe.
	 * @throws NotFoundInDBException
	 *             Lançada se a classe não for encontrada no banco de dados.
	 */
	public int getQuantidadeInicialSenhas(String classe)
			throws NotFoundInDBException {
		// ControleDAO controleDAO = new ControleDAO();
		// Controle controle = controleDAO.readControle(classe);
		Controle controle = getControleClasse(classe);
		return controle.getQuantidadeInicial();
	}

	/**
	 * Remove uma classe de atendimento do sistema.
	 * 
	 * @param classe
	 *            Nome da classe.
	 * @throws NotFoundInDBException
	 *             Lançada se a classe não for encontrada no banco de dados.
	 */
	public void removerClasse(String classe) throws NotFoundInDBException {
		ControleDAO controleDAO = new ControleDAO();
		removeControle(classe);
		controleDAO.removeControle(classe);
	}

	/**
	 * Altera uma nova classe de guiche de atendimento existente.
	 * 
	 * @param nomeClasse
	 *            O nome da nova classe.
	 * @param prefixo
	 *            O prefixo que identifica o guiche
	 * @param cor
	 *            A cor da classe que será exibida no painel
	 * @param quantInicial
	 *            Define a quantidade inicial de senha que constarão no guiche
	 *            ao iniciar o sistema.
	 * @throws NotFoundInDBException
	 *             Lançada se a classe não for encontrada no sistema.
	 * @throws ServletException
	 */
	public void alterarClasse(String nomeClasse, String prefixo, String cor,
			int quantInicial) throws NotFoundInDBException, ServletException {
		ControleDAO controleDAO = new ControleDAO();
		// Controle controle = controleDAO.readControle(nomeClasse);
		Controle controle = getControleClasse(nomeClasse);
		controle.setCor(cor);
		controle.setPrefixo(prefixo);
		controle.setQuantidadeInicial(quantInicial);
		addControle(controle);
		controleDAO.writeControle(controle);
	}

	/**
	 * Seta o nome da impressora no arquivo de configuração
	 * 
	 * @param nomeDaImpressora
	 *            O novo nome da impressora
	 */
	public void setNomeImpressora(String nomeDaImpressora) {
		Configuracao.setNomeDaImpressora(nomeDaImpressora);
		Configuracao.saveConfiguracao();
	}

	/**
	 * Retorna o nome da impressora que está no arquivo de configuração
	 * 
	 * @return O nome da impressora que está no arquivo de configuração
	 */
	public String getNomeImpressora() {
		return Configuracao.getNomeDaImpressora();
	}

	/**
	 * Imprime uma senha-teste usando a impressora que está no arquivo de
	 * configuração
	 */
	public void imprimeTeste() {
		Impressao impressao = new Impressao();
		String[] texto = { "Página de Teste", "    Teste", "Campina Grande",
				"SGV 00001", "dd/mm/aaaa hh:mm:ss" };
		impressao.imprime(texto);
	}

	/**
	 * Metodo que altera a mensagem do sistema
	 * 
	 * @param mensagem
	 */
	public void setMensagem(String mensagem) {
		Configuracao.setMensagem(mensagem);
	}

	/**
	 * Metodo que altera a cor da mensagem
	 * 
	 * @param cor
	 *            a cor da mensagem
	 */
	public void setCorMensagem(String cor) {
		Configuracao.setCorMensagem(cor);
	}

	/**
	 * Altera o fator da variacao
	 * 
	 * @param variacao
	 *            A nova variacao
	 */
	public void setVariacao(double variacao) {
		Configuracao.setVariacao(variacao);
		Configuracao.saveConfiguracao();
	}

	/**
	 * Altera o fluxo de chegada de eleitores na 
	 * central de atendimento
	 * 
	 * @param fluxoChegada O novo fluxo de chegada
	 */
	public void setFluxoChegada(double fluxoChegada){
		Configuracao.setFluxoChegada(fluxoChegada);
		Configuracao.saveConfiguracao();
	}
	
	/**
	 * Altera o valor minimo aceitável para que o tempo seja contabilizado
	 * 
	 * @param tempoMinimo
	 *            O novo tempo minimo
	 */
	public void setTempoMinimo(double tempoMinimo) {
		Configuracao.setTempoAtendimentoMinimo(tempoMinimo);
		Configuracao.saveConfiguracao();
	}

	/**
	 * Altera o valor maximo aceitável para que o tempo seja contabilizado
	 * 
	 * @param tempoMaximo
	 *            O novo valor maximo.
	 */
	public void setTempoMaximo(double tempoMaximo) {
		Configuracao.setTempoAtendimentoMaximo(tempoMaximo);
		Configuracao.saveConfiguracao();
	}

	/**
	 * Retorna o fator da variacao
	 * 
	 * @return O fator da variacao
	 */
	public double getVariacao() {
		return Configuracao.getVariacao();
	}

	/**
	 * Retorna o fluxo de chegada na central de atendimento
	 * 
	 * @return O fluxo de chegada na central de atendimento
	 */
	public double getFluxoChegada(){
		return Configuracao.getFluxoChegada();
	}
	
	/**
	 * Retorna o valor minimo aceitável para que o tempo seja contabilizado
	 * 
	 * @return O valor minimo
	 */
	public double getTempoMinimo() {
		return Configuracao.getTempoAtendimentoMinimo();
	}

	/**
	 * Retorna o valor maximo aceitável para que o tempo seja contabilizado
	 * 
	 * @return O valor maximo
	 */
	public double getTempoMaximo() {
		return Configuracao.getTempoAtendimentoMaximo();
	}

	/**
	 * Metodo que retorna a cor da mensagem
	 * 
	 * @return a cor da mensagem
	 */
	public String getCorMensagem() {
		return Configuracao.getCorMensagem();
	}

	/**
	 * Metodo que modifica a velocidade da mensagem
	 * 
	 * @param speed
	 *            a velocidade da mensagem.
	 */
	public void setSpeedMensagem(int speed) {
		Configuracao.setSpeed(speed);
	}

	/**
	 * Metodo que retorna a velocidade da mensagem
	 * 
	 * @return a velocidade da mensagem
	 */
	public int getSpeedMensagem() {
		return Configuracao.getSpeed();
	}

	/**
	 * Metodo que modifica o intervalo de tempo da mensagem
	 * 
	 * @param interval
	 *            o intevalo de tempo da mensagem
	 */
	public void setIntervalMensagem(int interval) {
		Configuracao.setInterval(interval);
	}

	/**
	 * Metodo que retorna o intervalo de tempo da mensagem
	 * 
	 * @return o intervalo de tempo da mensagem
	 */
	public int getIntervalMensagem() {
		return Configuracao.getInterval();
	}

	/**
	 * Metodo que altera a exibição do relógio no painel
	 * 
	 * @param showClock
	 *            1 para mostrar o relógio e 0 para não mostar.
	 */
	public void setShowClock(int showClock) {
		Configuracao.setShowClock(showClock);
	}

	/**
	 * Metodo que retorna 1 se o relógio estiver sendo mostrado no painel e 0
	 * caso contrário
	 * 
	 * @return 1 ou 0
	 */
	public int getShowClock() {
		return Configuracao.getShowClock();
	}

	/**
	 * Metodo que altera a posição do relógio
	 * 
	 * @param clockPosition
	 *            a posição do relógio (direita, esquerda ou centro).
	 */
	public void setClockPosition(String clockPosition) {
		Configuracao.setClockPosition(clockPosition);
	}

	/**
	 * Metodo que retona a posição do relógio no painel
	 * 
	 * @return a posição do relógio no painel.
	 */
	public String getClockPosition() {
		return Configuracao.getClockPosition();
	}

	/**
	 * Metodo que altera o número de repetições da chamada da senha
	 * 
	 * @param repeat
	 *            o número de repetições.
	 */
	public void setRepeat(int repeat) {
		Configuracao.setRepeat(repeat);
	}

	/**
	 * Metodo que retorna o número de repetições da chamada da senha
	 * 
	 * @return o número de repetições.S
	 */
	public int getRepeat() {
		return Configuracao.getRepeat();
	}

	/**
	 * Metodo que modifica a cor de fundo do painel
	 * 
	 * @param bgColor
	 *            a cor
	 */
	public void setBgColor(String bgColor) {
		Configuracao.setbgColor(bgColor);
	}

	/**
	 * Metodo que retorna a cor de fundo do painel
	 * 
	 * @return a cor de fundo do painel
	 */
	public String getBgColor() {
		return Configuracao.getbgColor();
	}

	/**
	 * Metodo que inicializa o sistema adicionando a quantidade inicial de cada
	 * classe. Ao ser inicializado, o sistema permite chamar e emitir senhas.
	 * 
	 * @return caso o sistema esteja iniciado retorna false e true caso
	 *         contrário
	 * @throws ServletException
	 */
	public boolean inicializaSistema() throws ServletException {
		if (!this.isStarted) {
			gerenciador = new GerenciadorGuiches();
			ControleDAO cDAO = new ControleDAO();
			controles = new ConcurrentLinkedQueue<Controle>();
			controles.addAll(cDAO.inicializaSistema());
			isStarted = true;
			StatusDAO.setStatusIsStarted(true);
			determinarDadosAtendimento();
			return true;
		}
		return false;
	}

	/**
	 * Metodo que finaliza o sistema zerando a ultima senha, a quantidade e o
	 * ultimo guichê.
	 * 
	 * @return caso o sistema esteja iniciado retorna true e false caso
	 *         contrário
	 * @throws ServletException
	 */
	public boolean finalizaSistema() throws ServletException {
		if (this.isStarted) {
			ControleDAO cDAO = new ControleDAO();
			cDAO.finalizaSistema();
			isStarted = false;
			StatusDAO.setStatusIsStarted(false);
			GerenciadorEstatisticas ge = new GerenciadorEstatisticas();
			ge.gerarEstatisticasAvaliacao();
			new DadosAtendimentoDAO().writeDadosAtendimento(dadosAtendimento);
			dadosAtendimento = null;
			return true;
		}
		return false;
	}

	/**
	 * Determina se o sistema está logado.
	 * 
	 * @return True se o sistema está logado e False em caso contrário.
	 */
	public boolean isStarted() {
		return isStarted;
	}

	/**
	 * Determina se um guichê está em atividade no sistema
	 * 
	 * @return retorna o guichê com o IP fornecido. Caso o guichê não exista no sistema, retorna uma string vazia.
	 */
	public String getGuiche(String ip) {
		return gerenciador.getGuiche(ip);
	}

	/**
	 * Verifica se um IP está cadastrado.
	 * 
	 * @param ip
	 *            IP a ser atualizado.
	 * @return True se o ip existir no sistema e False em caso contrário.
	 */
	public boolean contemIP(String ip) {
		return gerenciador.contemIP(ip);
	}

	/**
	 * Verifica se já existe um numero de guiche cadastrado
	 * 
	 * @param guiche
	 *            O numero do guiche a ser verificado
	 * @return True se houver ou False, caso contrario
	 */
	public boolean contemGuiche(String guiche) {
		return gerenciador.contemGuiche(guiche);
	}

	/**
	 * Retorna o ip de um guiche
	 * 
	 * @param guiche
	 *            O guiche que se quer recuperar o ip
	 * @return O ip de um guiche
	 */
	public String getIp(String guiche) {
		return gerenciador.getIp(guiche);
	}

	/**
	 * Adiciona um guichê ao gerenciador de guichês.
	 * 
	 * @param guiche
	 *            guichê a ser atualizado.
	 * @param ip O ip do guichê.
	 * @param controle O controle no qual o guichê foi logado.
	 * @param atendente o atendente logado no guichê.
	 */
	public void addGuiche(String ip, String guiche, String controle, String atendente) {
		gerenciador.addGuiche(ip, guiche, controle, atendente);
		determinaTempoAntedimento(guiche);
	}
	
	/**
	 * Adiciona um guichê ao gerenciador de guichês. Por default, o guichê será adicionado no controle. 
	 * 
	 * @param guiche
	 *            guichê a ser atualizado.
	 * @param ip O ip do guichê.
	 * @param atendente o atendente logado no guichê.
	 */
	public void addGuiche(String ip, String guiche, String atendente) {
		String controle = getListaClasses().get(0);
		addGuiche(ip, guiche, controle, atendente);
	}

	/**
	 * Remove um guichê do gerenciador de guichês.
	 * 
	 * @param ip O IP do
	 *            guichê a ser removido.
	 */
	public void removeGuiche(String ip) {
		try {
			gerenciador.removeGuiche(ip);
		} catch (Exception e) {
		}

	}

	/**
	 * Salva a avaliacao no banco de dados
	 * 
	 * @param avaliacao
	 * @throws ServletException
	 */
	public void salvaAvaliacao(Avaliacao avaliacao) throws ServletException {
		AvaliacaoDAO dao = new AvaliacaoDAO();
		dao.writeAvaliacao(avaliacao);
	}

	/**
	 * Salva a avaliacao no banco de dados
	 * 
	 * @param resposta1
	 *            Valor da resposta1.
	 * @param resposta2
	 *            Valor da resposta2.
	 * @param resposta3
	 *            Valor da resposta3.
	 * @param resposta4
	 *            Valor da resposta4.
	 * @param resposta5
	 *            Valor da resposta5.
	 * @param resposta6
	 *            Valor da resposta6.
	 * @param resposta7
	 *            Valor da resposta7.
	 * @throws ServletException
	 */
	public void salvaAvaliacao(String resposta1, String resposta2,
			String resposta3, String resposta4, String resposta5,
			String resposta6, String resposta7) throws ServletException {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setData(new Date());
		avaliacao.setResposta1(resposta1);
		avaliacao.setResposta2(resposta2);
		avaliacao.setResposta3(resposta3);
		avaliacao.setResposta4(resposta4);
		avaliacao.setResposta5(resposta5);
		avaliacao.setResposta6(resposta6);
		avaliacao.setResposta7(resposta7);
		this.salvaAvaliacao(avaliacao);
	}

	/**
	 * Determina os atendimentos do sistema.
	 * 
	 * @return Os atendimentos.
	 * @throws ServletException
	 */
	public Atendimentos getAtendimentos() throws ServletException {
		// ControleDAO dao = new ControleDAO();
		// List<Controle> controles = dao.listaControles();
		Atendimentos atendimentos = new Atendimentos();
		for (Controle c : controles) {
			Atendimento atendimento = new Atendimento();
			atendimento.setClasseAtendimento(c.getClasse());
			atendimento.setTotalAtendidos(c.getUltimaSenha());
			atendimento.setAtendimentosRestantes(c.getQuantidade());
			atendimentos.addAtendimento(atendimento);
		}
		return atendimentos;
	}

	/**
	 * Determina de quantos em quantos atendimentos um atendimento será
	 * encaminhado para avaliação.
	 * 
	 * @return de quantos em quantos.
	 */
	public int getNunchamaParaAvaliar() {
		return Configuracao.getNchamaParaAvaliar();
	}

	/**
	 * Altera de quantos em quantos atendimentos um atendimento será encaminhado
	 * para avaliação.
	 * 
	 * @param numero
	 *            de quantos em quantos será encaminhado.
	 */
	public void setNunchamaParaAvaliar(int numero) {
		Configuracao.setNchamaParaAvaliar(numero);
		Configuracao.saveConfiguracao();
	}

	/**
	 * Altera as configurações do banco de dados.
	 * 
	 * @param conexao
	 *            Objeto que representa as informações sobre uma conexão com um
	 *            banco de dados.
	 * @return True se alteração for realizada com sucesso e False em caso
	 *         contrário.
	 */
	public boolean alterarConfigBD(Conexao conexao) {
		boolean isAlterado = false;
		try {
			Conexao.save(conexao);
			isAlterado = true;
		} catch (NullPointerException e) {
		}
		return isAlterado;
	}

	/**
	 * Altera as configurações do banco de dados.
	 * 
	 * @param login
	 *            O login da BD.
	 * @param senha
	 *            A senha da BD.
	 * @param ip
	 *            O endereço IP do servidor de banco de dados.
	 * @param porta
	 *            A porta do do servidor de banco de dados.
	 * @return True se alteração for realizada com sucesso e False em caso
	 *         contrário.
	 */
	public boolean alterarConfigBD(String login, String senha, String ip,
			String porta) {
		Conexao con = new Conexao();
		con.setIp(ip);
		con.setPorta(porta);
		con.setLogin(login);
		con.setSenha(senha);
		return alterarConfigBD(con);
	}

	/**
	 * Confirma que a chamada atual já esta sendo realizada.
	 * 
	 * @throws ServletException
	 * 
	 */
	public void ChamadaIniciada(String ultimaSenhaChamada)
			throws ServletException {
		chamadas.chamadaIniciada(ultimaSenhaChamada);
	}

	/**
	 * Retorna um PDF das estatíticas geradas pela avaliação do atendimento ao
	 * eleitor.
	 * 
	 * @param dataInicial
	 *            Data inicial que se quer pesquisar
	 * @param dataFinal
	 *            Data final
	 * @return Um PDF com as estatísticas
	 * @throws NotFoundInDBException
	 */
	public Document gerarRelatorioAvaliacao(Date dataInicial, Date dataFinal)
			throws NotFoundInDBException {
		EstatisticasDAO estDAO = new EstatisticasDAO();
		List<Estatisticas> estatisticas = estDAO.listaDeEstatisticas(
				dataInicial, dataFinal);
		if (estatisticas.isEmpty())
			return null;
		GeradorRelatorioAvaliacao gra = new GeradorRelatorioAvaliacao();
		Estatisticas est = new Estatisticas();
		est.contabilizaEstatisticas(estatisticas);
		// TODO Colocar a lista de estatísticas em uma só
		return gra.geraPDF(est, dataInicial, dataFinal);
	}

	/**
	 * Gera dados estatísticos do período da avaliação.
	 * 
	 * @param dataInicial
	 *            Data inicial a data do início do período.
	 * @param dataFinal
	 *            Data final a data do fim do período.
	 * @return O resultado dos dados estatísticos gerados.
	 * @throws NotFoundInDBException
	 *             lançada se o período não for encontrado no banco de dados.
	 */
	public DadosAvaliacao gerarResultadoAvaliacao(Date dataInicial,
			Date dataFinal) throws NotFoundInDBException {
		EstatisticasDAO estDAO = new EstatisticasDAO();
		List<Estatisticas> estatisticas = estDAO.listaDeEstatisticas(
				dataInicial, dataFinal);
		if (estatisticas.isEmpty())
			return null;
		GeradorRelatorioAvaliacao gra = new GeradorRelatorioAvaliacao();
		Estatisticas est = new Estatisticas();
		est.contabilizaEstatisticas(estatisticas);
		// TODO Colocar a lista de estatísticas em uma só
		return gra.gerarDadosEstatisticos(est, dataInicial, dataFinal);
	}

	/**
	 * Testa a conexão com o Banco de Dados
	 * 
	 * @throws ConnectionDBException
	 */
	public void testaConexaoBD() throws ConnectionDBException {
		StatusDAO.TestaConexao();
	}

	/**
	 * Gera os graficos do relatorio de avaliação
	 * 
	 * @param dados
	 *            Dados das estatísticas
	 */
	public void GerarGraficosRelatorio(DadosAvaliacao dados) {
		GeradorGraficosRelatorioAvaliacao geradorGraficos = new GeradorGraficosRelatorioAvaliacao();
		geradorGraficos.gerarGraficos(dados);

	}

	public synchronized String chamarProximaSenha(String classe, String ip)
			throws ServletException, NotFoundInDBException {
		Controle controle = getControleClasse(classe);
		String guiche = getGuiche(ip);
		boolean sucesso = controle.avancar(guiche);
		contadorAtendimento++;
		if (sucesso && isStarted) {
			addControle(controle);
			new ControleDAO().writeControle(controle);
			addAviso(guiche, controle.getSenha(), controle.getCor());
			coletarDadosAtendimento(guiche, controle.getClasse());			
			return controle.getSenha();
		}
		return null;
	}

	/**
	 * Coleta dados sobre o atendimento de um guichê.
	 * 
	 * @param guiche
	 *            Id do guichê que iniciou atendimento.
	 * @param classe
	 *            A classe do atendimento.
	 */
	private void coletarDadosAtendimento(String guiche, String classe) {
		String atendente = getAtendente(guiche);
		int idGuiche = Integer.parseInt(guiche);
		if (determinaTempoAntedimento(guiche)) {
			double tempoMedio = tempoMedioAtendimento.getTempoMedio(guiche);
			dadosAtendimento.setTempoMedio(tempoMedio);
			dadosAtendimento.atualizaContagem(idGuiche, atendente, classe);
			new DadosAtendimentoDAO().writeDadosAtendimento(dadosAtendimento);
		}
	}

	/**
	 * Determina o tempo médio de atendimento e determina se o mesmo será
	 * registrado nas estatísticas. Um tempo médio de atendimento é registrado
	 * se a sua duração for entre o tempo máximo e o tempo mínimo de atendimento
	 * e se a sua variação em relação ao tempo médio do sistema não for maior
	 * que a variação máxima permitida.
	 * 
	 * @param guiche
	 *            Número do guichê que realizou a chamada.
	 * @return Retorna True se tempo de atendimnto deve ser registrado e False
	 *         em caso contrário
	 */
	private boolean determinaTempoAntedimento(String guiche) {
		long ultimoTempo = System.currentTimeMillis();
		double variacao = getVariacao();
		double tempoMinimo = getTempoMinimo();
		double tempoMaximo = getTempoMaximo();
		int contadorAtendimentos = dadosAtendimento.getTotalAtendimentos();
		return tempoMedioAtendimento.addTempoAtendimento(contadorAtendimentos,
				variacao, tempoMinimo, tempoMaximo, guiche, ultimoTempo);
	}

	/**
	 * Determina qual atendente está logado em um guichê.
	 * 
	 * @param guiche
	 *            Guichê a ser consultado.
	 * @return O login do atendente no guichê.
	 */
	private String getAtendente(String guiche) {
		return gerenciador.getAtendente(guiche);
	}

	public ResumoAtendimento gerarResultadoAtendimento(Date dataInicial,
			Date dataFinal) throws NotFoundInDBException {

		DadosAtendimentoDAO dadosDAO = new DadosAtendimentoDAO();
		List<DadosAtendimento> atendimentos = dadosDAO.listaDeDadosAtendimento(
				dataInicial, dataFinal);
		if (atendimentos.isEmpty()) {
			return null;
		}

		// GeradorRelatorioAtendimento gratendimento = new
		// GeradorRelatorioAtendimento();
		ResumoAtendimento resumoAtendimento = new ResumoAtendimento(DataUtil
				.formatarData(dataInicial), DataUtil.formatarData(dataFinal),
				atendimentos);
		// gratendimento.gerarDadosEstatisticos(resumoAtendimento, dataInicial,
		// dataFinal);
		return resumoAtendimento;
	}

	/**
	 * Metodo que gera Graficos contendo dados dos atendimentos realizados
	 * tendo como base o parametro dados
	 * @param dados os dados base para geração do gráfico
	 */
	public void GerarGraficosRelatorioAtendimentos(ResumoAtendimento dados) {
		GeradorGraficosAtendimentos geradorGraficos = new GeradorGraficosAtendimentos();
		geradorGraficos.gerarGraficos(dados);

	}

	public Document gerarRelatorioAtendimento(Date dataInicial, Date dataFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Salvar dados sobre entrega de título.
	 * @param entregaTitulo Objeto que representa a entrega de títulos.
	 */
	public void salvarDadosEntregaTitulo(EntregaTitulo entregaTitulo) {
		new EntregaTituloDAO().writeEntregaTitulo(entregaTitulo);
	}
	
	/**
	 * Salva os dados de tempo de avaliação.
	 * @param tempoAvaliacao o TempoAvaliacao a ser salvo.
	 */
	public void salvarDadosTempoAvaliacao(TempoAvaliacao tempoAvaliacao) {
		new TempoAvaliacaoDAO().writeTempoAvaliacao(tempoAvaliacao);
	}

	/**
	 * Altera o controle o qual o guichê está atendendo. 
	 * @param ip O ip do guichê a ser alterado.
	 * @param classe A nova classe a qual o atendente irá atender.
	 */
	public void alterarControle(String ip, String classe) {
		gerenciador.alterarClasse(ip, classe);
	}
	
	/**
	 * Retorna um mapa que associa cada controle com o total de guichês logados nesse controle.
	 * @return mapa de controle para total de guichês.
	 */
	public int getGuiches(String classe){

		return gerenciador.getGuiches(classe);
	}
	
	/**
	 * Determina os guichês em uma classe de atendimento.
	 * @param classe A classe dos guichês.
	 * @return Listagem de guiches da classe.
	 */
	public List<String> getGuichesClasse(String classe){
		return gerenciador.getGuichesClasse(classe);
	}

	/**
	 * Determina o tempo médio de atendimento para uma classe de atendimento.
	 * @param classe A classe a ser determinada.
	 * @return tempo médio de atendimento em minutos.
	 */
	public double getTempoMedioClasse(String classe) {
		List<String> lista = getGuichesClasse(classe);
		if(lista == null || lista.isEmpty())
			return 0.0;
		return tempoMedioAtendimento.getTempoMedioGuiches(lista);
	}

	/**
	 * Altera o tipo de login do sistema.
	 * @param tipoLogin Novo valor para o tipo de login.
	 */
	public void setTipoLogin(String tipoLogin) {
		Configuracao.setTipoLogin(tipoLogin);
		Configuracao.saveConfiguracao();
	}

	/**
	 * Determina o tipo de login do sistema.
	 * @return Tipo de login do sistema.
	 */
	public String getTipoLogin() {
		return Configuracao.getTipoLogin();
	}
}