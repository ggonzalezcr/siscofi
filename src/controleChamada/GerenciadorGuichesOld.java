package controleChamada;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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
 * Gerenciador de guichês. Um objeto gerenciador de guichês é responsável por
 * gerenciar os guichês logados no sistema e removê-los do sistema. A remoção do
 * sistema é realizada quando o guichê fica inativo por um período maior que o
 * valor da duracaoSessao.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

public class GerenciadorGuichesOld extends TimerTask {

	private Map<String, Date> guiches;

	private int duracaoSessao;

	/**
	 * Cria um novo gerenciador de guichês.
	 * 
	 */
	public GerenciadorGuichesOld() {
		//Conversão para milissegundos
		this.duracaoSessao = duracaoSessao * 60 * 1000;
		guiches = new HashMap<String, Date>();
		Timer timer = new Timer();
		timer.schedule(this, duracaoSessao, duracaoSessao);
	}

	/**
	 * Verifica se a duração de uma sessão expirou e remove o guiche do
	 * gerenciador.
	 */
	public void run() {
		Date dataAtual = new Date();
		for (String guiche : guiches.keySet()) {
			Date data = guiches.get(guiche);
			if (diferencaDatas(dataAtual, data) > duracaoSessao) {
				guiches.remove(guiche);
			}
		}
	}

	/**
	 * Determina se a diferença entre a dataAtual e outra data.
	 * @param dataAtual A data final do período.
	 * @param dataGuiche A data inicial do período.
	 * @return a diferença das datas em milissegundos.
	 */
	private long diferencaDatas(Date dataAtual, Date dataGuiche) {
		return (dataAtual.getTime() - dataGuiche.getTime());
	}

	/**
	 * Determina se um guichê está ativo ou inativo no gerenciador. 
	 * @param guiche Guichê a ser verificado.
	 * @return True se o guichê estiver ativo ou false se o guichê estiver inativo.
	 */
	public boolean existGuiche(String guiche) {
		return guiches.containsKey(guiche);
	}

	/**
	 * Adiciona um guichê ao gerenciador. 
	 * @param guiche guichê a ser adicionado.
	 */
	public void addGuiche(String guiche) {
		guiches.put(guiche, new Date());
	}
	
	/**
	 * Atualiza o horário da última atividade do guichê.
	 * @param guiche O guichê a ser atualizado.
	 * @return True se o guichê for atualizado e False se o sistema não puder ser atualizado 
	 */
	public boolean atualizaGuiche(String guiche){
		boolean exist = guiches.containsKey(guiche);
		if(exist){
			guiches.put(guiche, new Date());
		}
		return exist;
	}

	/**
	 * Remove um guichê do gerenciador.
	 * @param guiche Guichê a ser removido.
	 */
	public void removeGuiche(String guiche) {
		guiches.remove(guiche);
	}

	/**
	 * Determina a última alteração de um guichê
	 * @param guiche Guichê a ser verificado.
	 * @return A data da última alteração do guichê.
	 */
	public Date getUltimaAlteracao(String guiche){
		return guiches.get(guiche);
	}
	
	/**
	 * Remove todos os guichês do gerenciador.
	 */
	public void removeTudo(){
		guiches.clear();
	}
	
}
