package estatisticas.atendimento;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.bean.TempoAtendimento;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 2
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Bean que armazena um resumo dos tempos de atendimentos realizados por
 * cada guich�. 
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TempoMedioAtendimento {
	//Mapa que contem o guiche como chave dos tempos
	private Map<String,TempoAtendimento> tempoAtendimentos;
	
	/**
	 * Construtor
	 */
	public TempoMedioAtendimento() {
		tempoAtendimentos = new HashMap<String, TempoAtendimento>();
	}
	
	/**
	 * Adiciona os guiches ao mapa de tempo de atendimento ou
	 * atualiza o tempo medio e o ultimo tempo dos guiches 
	 * existentes
	 * @param contagem A quantidade de atendimentos
	 * @param variacao O fator que determinara o at� quanto
	 * o tempo m�dio deve variar
	 * @param tempoMinimo O menor tempo poss�vel
	 * @param tempoMaximo O maior tempo poss�vel 
	 * @param guiche O guiche a ser atualizado
	 * @param ultimoTempo O tempo a ser acrescentado
	 * j� ocorreram neste guiche
	 */
	public boolean addTempoAtendimento(int contagem, double variacao, double tempoMinimo, 
			double tempoMaximo, String guiche, 
				long ultimoTempo){
		if(tempoAtendimentos.containsKey(guiche)){
			TempoAtendimento ta = tempoAtendimentos.get(guiche);
			if(ta.contabilizaTempos(contagem, variacao, tempoMinimo, tempoMaximo, ultimoTempo)){
				tempoAtendimentos.put(guiche, ta);
				return true;
			}
			return false;
		}else{
			TempoAtendimento ta = new TempoAtendimento();
			ta.setUltimoTempo(ultimoTempo);
			tempoAtendimentos.put(guiche, ta);
			return true;
		}
	}
	
	/**
	 * Recupera o tempo medio de um guiche
	 * @param guiche O guiche a ser pesquisado
	 * @return O tempo medio de um guiche
	 */
	public double getTempoMedio(String guiche){
		TempoAtendimento ta = tempoAtendimentos.get(guiche);
		if(ta != null)
			return ta.getTempoMedio();
		return 0;
	}
	
	/**
	 * Recupera o valor do tempo do ultimo atendimento
	 * @param tempoFinal O tempo final do atendimento
	 * @param guiche O guiche que se esta pesquisando
	 * @return O valor do tempo do ultimo atendimento
	 */
	public double getTempoAtual(long tempoFinal, String guiche){
		TempoAtendimento ta = tempoAtendimentos.get(guiche);
		if(ta != null)
			return Math.abs((double)(ta.getUltimoTempo() - tempoFinal))/60000;
		return 0;		
	}
	
}
