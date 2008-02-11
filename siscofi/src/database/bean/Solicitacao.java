package database.bean;

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
	
	//Número da senha a ser chamada
	private String senhaASerChamada;
	
	/**
	 * Determina o número da senha a ser chamada.
	 * @return O número da chamada da senha.
	 */
	public String getSenhaASerChamada() {
		return senhaASerChamada;
	}
	
	/**
	 * Altera o número da senha a ser chamada.
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
