package estatisticas.atendimento;

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
import java.util.HashMap;
import java.util.Map;

import database.bean.TempoAtendimento;

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
 * Bean que armazena um resumo dos tempos de atendimentos realizados por
 * cada guichê. 
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
	 * @param variacao O fator que determinara o até quanto
	 * o tempo médio deve variar
	 * @param tempoMinimo O menor tempo possível
	 * @param tempoMaximo O maior tempo possível 
	 * @param guiche O guiche a ser atualizado
	 * @param ultimoTempo O tempo a ser acrescentado
	 * já ocorreram neste guiche
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
