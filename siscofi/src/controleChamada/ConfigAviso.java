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
 * Objetos desta classe representam a configura��o para um objeto PilhaAviso.  
 *
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 * 
 */

@Deprecated
public class ConfigAviso {
	
	//Quanto tempo um aviso alertar�
	private int tempo;
	
	//Intervalo de tempo entre cada atualiza da pilha de avisos.
	private int refreshTime;

	private String pathAudio;
	
	/**
	 * Metodo que retorna o path onde se encontra o audio.
	 * @return o path do audio.
	 */
	public String getPathAudio() {
		return pathAudio;
	}

	/**
	 * Metodo que modifica o path do audio
	 * @param pathAudio o novo path do audio.
	 */
	public void setPathAudio(String pathAudio) {
		this.pathAudio = pathAudio;
	}

	/**
	 * Determina o tempo de dura��o de um aviso.  
	 * @return tempo Tempo atual em milissegundos.
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * Altera o tempo de dura��o um aviso.
	 * @param tempo Novo tempo de execu��o. 
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * Determina o tempo entre cada a��o da PilhaAviso.  
	 * @return tempo tempo atual em milissegundos.
	 */
	public int getRefreshTime() {
		return refreshTime;
	}

	/**
	 * Altera o tempo entre cada a��o da PilhaAviso.
	 * @param refreshTime Novo tempo de execu��o. 
	 */
	public void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}
	
}
