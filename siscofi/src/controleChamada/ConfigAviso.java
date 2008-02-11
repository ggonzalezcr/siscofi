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

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/** 
 * Objetos desta classe representam a configuração para um objeto PilhaAviso.  
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
	
	//Quanto tempo um aviso alertará
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
	 * Determina o tempo de duração de um aviso.  
	 * @return tempo Tempo atual em milissegundos.
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * Altera o tempo de duração um aviso.
	 * @param tempo Novo tempo de execução. 
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * Determina o tempo entre cada ação da PilhaAviso.  
	 * @return tempo tempo atual em milissegundos.
	 */
	public int getRefreshTime() {
		return refreshTime;
	}

	/**
	 * Altera o tempo entre cada ação da PilhaAviso.
	 * @param refreshTime Novo tempo de execução. 
	 */
	public void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}
	
}
