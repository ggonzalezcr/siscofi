package database.bean;

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
 * Bean que guarda os dados sobre uma chamada de senha. 
 * 
 * @author Carlos Trajano de Oliveira
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */


public class Solicitacao {
	
	//Classe de atendimento
	private String classe;
	
	//N�mero da senha a ser chamada
	private String senhaASerChamada;
	
	/**
	 * Determina o n�mero da senha a ser chamada.
	 * @return O n�mero da chamada da senha.
	 */
	public String getSenhaASerChamada() {
		return senhaASerChamada;
	}
	
	/**
	 * Altera o n�mero da senha a ser chamada.
	 * @param senhaASerChamada O novo valor da senha a ser chamada.
	 */
	public void setSenhaASerChamada(String senhaASerChamada) {
		this.senhaASerChamada = senhaASerChamada.toUpperCase();
	}
	
	/**
	 * Determina a classe de atendimento da chamada de senha.
	 * @return O nome da classe de atendimento da chamada de senha.
	 */
	public String getClasse() {
		return classe;
	}
	
	/**
	 * 
	 * Altera a classe de atendimento da chamada de senha. 
	 * @param classe o novo valor da classe de atendimento da chamada de senha.
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
}
