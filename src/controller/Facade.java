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

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import util.DataUtil;
import util.Impressao;
import coletaDados.EntregaTitulo;
import controleChamada.Aviso;
import database.bean.Atendimentos;
import database.bean.ConfiguradorPainel;
import database.bean.Controle;
import database.bean.DadosAvaliacao;
import exceptions.NotFoundInDBException;
import exceptions.SenhaInvalidaException;

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
 * Facade que acessa o sistema, utilizada para a realização de testes de
 * aceitação.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

public class Facade {

	private Siscofi siscofi;

	/**
	 * Construtor basico de uma Facade
	 * 
	 */
	public Facade() {
		siscofi = Siscofi.getInstance();
	}
	
	/**
	 * Determina os atendimentos do sistema.
	 * @return Os atendimentos.
	 * @throws ServletException 
	 */
	public Atendimentos getAtendimentos() throws ServletException {
		return siscofi.getAtendimentos();
	}
	
	/**
	 * Altera as configurações do banco de dados.
	 * @param login O login da BD.
	 * @param senha A senha da BD.
	 * @param ip O endereço IP do servidor de banco de dados.
	 * @param porta A porta do do servidor de banco de dados.
	 * @return True se alteração for realizada com sucesso e False em caso contrário.
	 */
	public boolean alterarConfigBD(String login, String senha, String ip, String porta) {
		return siscofi.alterarConfigBD(login, senha, ip, porta);
	}
	
	/**
	 * 
	 * Metodo que modifica as configurações do painel. 
	 *
	 * @param bgColor Cor de fundo.
	 * @param mensagem A mensagem a ser exibida.
	 * @param corMensagem cor da Mensagem.
	 * @param repeticao Número de repetição da chamada.
	 * @param intervalo Intervalor entre cada repetição de chamada.
	 * @param exibirRelogio 1 para exibir relógio e 0 para não exibir.
	 * @param posicaoRelogio Posição do relógio no eixo horizontal. Valores de 0a 320.
	 * @param velocidadeTexto Velocidade de passagem do texto da mensagem.
	 * @param destacarSenha Valor 1 para destacar a última senha chamada e 0 para não destacar.
	 * @param tempoExibicao Tempo de exibição de cada chamada.
	 * 
	 */
	public void configurarChamada(String bgColor, String mensagem, String corMensagem, int repeticao, int intervalo, int exibirRelogio, String posicaoRelogio,int velocidadeTexto, int destacarSenha, int tempoExibicao) {
		ConfiguradorPainel cp = new ConfiguradorPainel();
		cp.setBgColor(bgColor);
		cp.setMensagem(mensagem);
		cp.setCorMensagem(corMensagem);
		cp.setRepeat(repeticao);
		cp.setInterval(intervalo);
		cp.setShowClock(exibirRelogio);
		cp.setClockPosition(posicaoRelogio);
		cp.setSpeed(velocidadeTexto);
		cp.setDestacarUltimaSenha(destacarSenha);
		cp.setDuracaoExibicao(tempoExibicao);
		ConfiguradorPainel.setConfigurador(cp);
	}

	/**
	 * Metodo que adiciona um aviso ao Sistema
	 * 
	 * @param classe
	 *            o guiche do aviso a ser adicionado
	 * @param senha
	 *            a senha que devera aparecer no aviso
	 * @param cor a cor do aviso
	 * @throws ServletException 
	 */
	public void addAviso(String classe, String senha, String cor) throws ServletException {
		siscofi.addAviso(classe, senha, cor);
	}
	
	/**
	 * Salva a avaliacao no banco de dados
	 * @param resposta1 Valor da resposta1.  
	 * @param resposta2 Valor da resposta2.
	 * @param resposta3 Valor da resposta3.
	 * @param resposta4 Valor da resposta4.
	 * @param resposta5 Valor da resposta5.
	 * @param resposta6 Valor da resposta6.
	 * @param resposta7 Valor da resposta7.
	 * @throws ServletException 
	 */
	public void salvaAvaliacao(String resposta1,String resposta2,String resposta3,String resposta4,String resposta5,String resposta6,String resposta7) throws ServletException{
		siscofi.salvaAvaliacao(resposta1, resposta2, resposta3, resposta4, resposta5, resposta6, resposta7);
	}

	/**
	 * Metodo que inicializa o sistema adicionando a quantidade
	 * inicial de cada classe. Ao ser inicializado, o sistema permite chamar e emitir senhas.
	 * @return caso o sistema esteja iniciado retorna false e true caso contrário   
	 * @throws ServletException 
	 */
	public boolean inicializaSistema() throws ServletException {
		return siscofi.inicializaSistema();
	}
	
	/**
	 * Metodo que finaliza o sistema zerando a ultima senha, 
	 * a quantidade e o ultimo guichê. 
	 * @return caso o sistema esteja iniciado retorna true e false caso contrário 
	 * @throws ServletException 
	 */
	public boolean finalizaSistema() throws ServletException{
		return siscofi.finalizaSistema();
	}
	
	/**
	 * Determina se o sistema está logado.
	 * @return True se o sistema está logado e False em caso contrário.
	 */
	public boolean isStarted() {
		return siscofi.isStarted();
	}

	
//	/**
//	 * Realiza a chamada da proxima senha de uma classe de atendimento
//	 * 
//	 * @param guiche
//	 *            O guiche que chama a senha
//	 * @param classe
//	 *            A classe de guiche que chama a senha
//	 * @return um boolean indicando se conseguiu ou não chamar o proximo
//	 */
//	public boolean chamaProximo(String guiche, String classe) {
//		return siscofi.chamaProximo(guiche, classe);
//	}

	/**
	 * Metodo que chama uma determina senha
	 * 
	 * @param ip
	 *            O IP do guichê.            
	 * @param senha
	 *            A senha a ser chamada.
	 * @param classe A classe da senha.
	 * @throws SenhaInvalidaException lançada quando a senha não existe.
	 * @throws ServletException 
	 */
	public void chamarSenhaEspecifica(String ip, String senha, String classe)
			throws SenhaInvalidaException, ServletException {
		siscofi.chamarSenhaEspecifica(ip, senha, classe);
	}
	
	/**
	 * Chama a próxima senha de um guichê
	 * @param classe A classe de atendimento do guichê.
	 * @param ip O Ip do Guichê.
	 * @return A senha chamada.
	 * @throws ServletException 
	 * @throws NotFoundInDBException
	 */
	public String chamaProximo(String classe, String ip) throws ServletException, NotFoundInDBException{
		return siscofi.chamarProximaSenha(classe, ip);
	}
	
	/**
	 * Realiza a chamada da senha de uma classe de atendimento novamente
	 * 
	 * @param ip
	 *            O IP que chama a senha.
	 * @param classe
	 *            A classe de guiche que chama a senha
	 * @throws NotFoundInDBException
	 * @throws ServletException
	 */
	public synchronized void chamaNovamente(String ip, String classe,
			String senha) throws NotFoundInDBException, ServletException {
		siscofi.chamarNovamente(ip, classe, senha);
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
		siscofi.addGuiche(ip, guiche, controle, atendente);
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
		siscofi.addGuiche(ip, guiche, atendente);
	}

	/**
	 * Remove um guichê do gerenciador de guichês.
	 * 
	 * @param ip
	 *            o IP do guichê a ser removido.
	 */
	public void removeGuiche(String ip) {
			siscofi.removeGuiche(ip);
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
		siscofi.alterarClasse(nomeClasse, prefixo, cor, quantInicial);
	}
	
	/**
	 * Salvar dados sobre entrega de título.
	 * @param quantpessoas A quantidade de pessoas na entrega de título.
	 * @param tempoMedio O tempo médio para entrega de título.
	 */
	public void salvarDadosEntregaTitulo(int quantpessoas, double tempoMedio) {
		EntregaTitulo et = new EntregaTitulo();
		et.setQuantidadePessoas(quantpessoas);
		et.setTempoMedioEntrega(tempoMedio);
		siscofi.salvarDadosEntregaTitulo(et);
	}

	/**
	 * Retorna um resumo do atendimento num dado período.
	 * @param dataInicial data inicial do período.
	 * @param dataFinal data final do período.
	 * @return String contendo o resumo do atendimento
	 * @throws NotFoundInDBException
	 */
	public String getResultadoAtendimento(String dataInicial,
			String dataFinal) throws NotFoundInDBException {
		Date inicio = DataUtil.gerarData(dataInicial);
		Date fim = DataUtil.gerarData(dataFinal);
		return siscofi.gerarResultadoAtendimento(inicio, fim).toString();
	}

	/**
	 * Altera o valor minimo aceitável para que o tempo seja contabilizado
	 * 
	 * @param tempoMinimo
	 *            O novo tempo minimo
	 */
	public void setTempoMinimo(double tempoMinimo) {
		siscofi.setTempoMinimo(tempoMinimo);
	}

	/**
	 * Altera o valor maximo aceitável para que o tempo seja contabilizado
	 * 
	 * @param tempoMaximo
	 *            O novo valor maximo
	 */
	public void setTempoMaximo(double tempoMaximo) {
		siscofi.setTempoMaximo(tempoMaximo);
	}

	/**
	 * Retorna o fator da variacao
	 * @param variacao O valor máximo de variação de tempo de atendimento.
	 * 
	 */
	public void setVariacao(double variacao) {
		siscofi.setVariacao(variacao);
	}	

	/**
	 * Método que emite várias senhas de uma mesma classe. A emissão de uma
	 * senha consiste de incrementar o total de senhas emitidas.
	 * 
	 * @param classe
	 *            A classe de atendimento para a qual serão emitidas senhas.
	 * @param total
	 *            O total de senha a serem emitidas.
	 * @throws NotFoundInDBException
	 *             Lançada a classe de atendimento não existir.
	 * @throws ServletException 
	 */
	public void emiteSenha(String classe, int total)
			throws NotFoundInDBException, ServletException {
		Controle controle = siscofi.getControleClasse(classe);
		Impressao impressao = new Impressao();
		controle = impressao.setPrint(total, classe, controle);
		siscofi.emiteSenha(controle);
	}

	/**
	 * Método que determina o Controle de uma classe de atendimento.
	 * 
	 * @param classe
	 *            A classe solicitada.
	 * @return O controle de uma classe de atendimento.
	 * @throws NotFoundInDBException
	 *             Lançada a classe de atendimento não existir.
	 */
	public Controle getControleClasse(String classe)
			throws NotFoundInDBException {
		return siscofi.getControleClasse(classe);
	}

	/**
	 * Determina todas as classes existentes no sistema.
	 * 
	 * @return Lista contendo os nomes de todas as classes do sistema.
	 */
	public List<String> getListaClasses() {
		return siscofi.getListaClasses();
	}

	/**
	 * Determina a cor de exibição de uma classe de atendimento.
	 * 
	 * @param classe
	 *            Nome da classe de atendimento.
	 * @return o valor de hexaDecimal da cor da classe
	 * @throws NotFoundInDBException
	 *             Lançada se a classe não for encontrada no banco de dados.
	 */
	public String getCorClasse(String classe) throws NotFoundInDBException {
		return siscofi.getCorClasse(classe);
	}
	
	/**
	 * Determina a quantidade inicial de senhas em uma classe.
	 * @param classe Nome da classe de atendimento. 
	 * @return quantidade de senhas na classe.
	 * @throws NotFoundInDBException Lançada se a classe não for encontrada no banco de dados.
	 */
	public int getQuantidadeInicialSenhas(String classe) throws NotFoundInDBException {
		return siscofi.getQuantidadeInicialSenhas(classe);
	}

	/**
	 * Determina se a última senha chamada pelo sistema para uma dada classe de
	 * atendimento.
	 * 
	 * @param classe
	 *            A classe do guiche a ser verificada.
	 * @return o número da última senha a ser chamada na classe ou zero, caso
	 *         nenhuma senha tenha sido chamada para aquela classe.
	 * @throws NotFoundInDBException
	 *             Lançada a classe de atendimento não existir.
	 */
	public String getUltimaSenhaChamada(String classe)
			throws NotFoundInDBException {
		return siscofi.getUltimaSenhaChamada(classe);
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
		return siscofi.getTotalSenhas(guiche);
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
		siscofi.createClasse(nomeClasse, prefixo, cor, quantInicial);
	}
	
	
	
	
	
	/**
	 * Remove uma classe de atendimento do sistema.
	 * @param classe Nome da classe.
	 * @throws NotFoundInDBException Lançada se a classe não for encontrada no banco de dados. 
	 */
	public void removerClasse(String classe) throws NotFoundInDBException{
		siscofi.removerClasse(classe);
	}

	/**
	 * Apaga todos os dados do banco de dados
	 */
	public void resetBD() {
		siscofi.resetBD();
	}

	/**
	 * Metodo que gera um arquivo XML que será utilizado pelo arquivo flash
	 * 
	 * @param aviso
	 *            o aviso que constará no XML
	 * @throws ServletException 
	 */
	public void gerarXMLFlash(Aviso aviso) throws ServletException {
		siscofi.gerarXMLFlash(aviso);
	}

	/**
	 * Metodo que retorna a mensagem cadastrada no sistema 
	 * 
	 * @return uma string com a mensagem cadastrada no sistema.
	 */
	public String getMensagem() {
		return siscofi.getMensagem();
	}

	/**
	 * Metodo que altera a mensagem do sistema
	 * @param mensagem a mensagem
	 */
	public void setMensagem(String mensagem){
		siscofi.setMensagem(mensagem);
	}
	
	/**
	 * Metodo que altera a cor da mensagem
	 * @param cor a cor da mensagem
	 */
	public void setCorMensagem(String cor){
		siscofi.setCorMensagem(cor);
	}
	
	/**
	 * Metodo que retorna a cor da mensagem
	 * @return a cor da mensagem
	 */
	public String getCorMensagem(){
		return siscofi.getCorMensagem();
	}
	
	/**
	 * Metodo que modifica a velocidade da mensagem
	 * @param speed a velocidade da mensagem.
	 */
	public void setSpeedMensagem(int speed){
		siscofi.setSpeedMensagem(speed);
	}
	
	/**
	 * Metodo que retorna a velocidade da mensagem
	 * @return a velocidade da mensagem
	 */
	public int getSpeedMensagem(){
		return siscofi.getSpeedMensagem();
	}
	
	/**
	 * Metodo que modifica o intervalo de tempo da mensagem 
	 * @param interval o intevalo de tempo da mensagem
	 */
	public void setIntervalMensagem(int interval){
		siscofi.setIntervalMensagem(interval);
	}
	
	/**
	 * Metodo que retorna o intervalo de tempo da mensagem
	 * @return o intervalo de tempo da mensagem
	 */
	public int getIntervalMensagem(){
		return siscofi.getIntervalMensagem();
	}
	
	/**
	 * Metodo que altera a exibição do relógio no painel
	 * @param showClock 1 para mostrar o relógio e 0 para não mostar.
	 */
	public void setShowClock(int showClock){
		siscofi.setShowClock(showClock);
	}
	
	/**
	 * Metodo que retorna 1 se o relógio estiver sendo mostrado no painel
	 * e 0 caso contrário
	 * @return 1 ou 0
	 */
	public int getShowClock(){
		return siscofi.getShowClock();
	}
	
	/**
	 * Metodo que altera a posição do relógio
	 * @param clockPosition a posição do relógio (direita, esquerda ou centro).
	 */
	public void setClockPosition(String clockPosition){
		siscofi.setClockPosition(clockPosition);
	}
	
	/**
	 * Metodo que retona a posição do relógio no painel
	 * @return a posição do relógio no painel.
	 */
	public String getClockPosition(){
		return siscofi.getClockPosition();
	}
	
	/**
	 * Metodo que altera o número de repetições da chamada da senha
	 * @param repeat o número de repetições.
	 */
	public void setRepeat(int repeat){
		siscofi.setRepeat(repeat);
	}
	
	/**
	 * Metodo que retorna o número de repetições da chamada da senha
	 * @return o número de repetições.S
	 */
	public int getRepeat(){
		return siscofi.getRepeat();
	}
	
	/**
	 * Metodo que modifica a cor de fundo do painel
	 * @param bgColor a cor 
	 */
	public void setBgColor(String bgColor){
		siscofi.setBgColor(bgColor);
	}
	
	/**
	 * Metodo que retorna a cor de fundo do painel
	 * @return a cor de fundo do painel
	 */
	public String getBgColor(){
		return siscofi.getBgColor();
	}
	
	public void getResultadosAvalicao(String dataInicial, String dataFinal, String path) throws NotFoundInDBException, IOException{
		Date inicio = DataUtil.gerarData(dataInicial);
		Date fim = DataUtil.gerarData(dataFinal);
		DadosAvaliacao da = siscofi.gerarResultadoAvaliacao(inicio, fim);
		writeFile(da, path);
	}
	
	private void writeFile(Object obj, String path) throws IOException{
		FileWriter fw = new FileWriter(path);
		String str = "";
		if (obj != null){
			str = obj.toString();
		}
		fw.write(str);
		fw.close();
	}
}
