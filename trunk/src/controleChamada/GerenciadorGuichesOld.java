package controleChamada;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Gerenciador de guich�s. Um objeto gerenciador de guich�s � respons�vel por
 * gerenciar os guich�s logados no sistema e remov�-los do sistema. A remo��o do
 * sistema � realizada quando o guich� fica inativo por um per�odo maior que o
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
	 * Cria um novo gerenciador de guich�s.
	 * 
	 */
	public GerenciadorGuichesOld() {
		//Convers�o para milissegundos
		this.duracaoSessao = duracaoSessao * 60 * 1000;
		guiches = new HashMap<String, Date>();
		Timer timer = new Timer();
		timer.schedule(this, duracaoSessao, duracaoSessao);
	}

	/**
	 * Verifica se a dura��o de uma sess�o expirou e remove o guiche do
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
	 * Determina se a diferen�a entre a dataAtual e outra data.
	 * @param dataAtual A data final do per�odo.
	 * @param dataGuiche A data inicial do per�odo.
	 * @return a diferen�a das datas em milissegundos.
	 */
	private long diferencaDatas(Date dataAtual, Date dataGuiche) {
		return (dataAtual.getTime() - dataGuiche.getTime());
	}

	/**
	 * Determina se um guich� est� ativo ou inativo no gerenciador. 
	 * @param guiche Guich� a ser verificado.
	 * @return True se o guich� estiver ativo ou false se o guich� estiver inativo.
	 */
	public boolean existGuiche(String guiche) {
		return guiches.containsKey(guiche);
	}

	/**
	 * Adiciona um guich� ao gerenciador. 
	 * @param guiche guich� a ser adicionado.
	 */
	public void addGuiche(String guiche) {
		guiches.put(guiche, new Date());
	}
	
	/**
	 * Atualiza o hor�rio da �ltima atividade do guich�.
	 * @param guiche O guich� a ser atualizado.
	 * @return True se o guich� for atualizado e False se o sistema n�o puder ser atualizado 
	 */
	public boolean atualizaGuiche(String guiche){
		boolean exist = guiches.containsKey(guiche);
		if(exist){
			guiches.put(guiche, new Date());
		}
		return exist;
	}

	/**
	 * Remove um guich� do gerenciador.
	 * @param guiche Guich� a ser removido.
	 */
	public void removeGuiche(String guiche) {
		guiches.remove(guiche);
	}

	/**
	 * Determina a �ltima altera��o de um guich�
	 * @param guiche Guich� a ser verificado.
	 * @return A data da �ltima altera��o do guich�.
	 */
	public Date getUltimaAlteracao(String guiche){
		return guiches.get(guiche);
	}
	
	/**
	 * Remove todos os guich�s do gerenciador.
	 */
	public void removeTudo(){
		guiches.clear();
	}
	
}
