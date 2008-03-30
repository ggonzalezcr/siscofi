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
 * 			RODRIGO LOPES DA SILVA
 */

/*Classe que implementa um aviso.
(aviso a ser mostrado na tela juntamente com a senha)*/
/**
 * Os objetos dessa classe representam um objeto aviso.
 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */
public class Aviso {

	// Constante indicando se que aviso j� foi realizado
	public static final String NAO_AVISAR = "0";

	// Constante indicando se que aviso ainda foi realizado
	public static final String AVISAR = "1";
	
	// Guiche associado ao aviso
	private String guiche;

	// Senha do aviso
	private String senha;

	// Determina se o aviso j� foi realizado ou n�o
	private String avisar;

	private String cor;

	/**
	 * Metodo que retorna o tipo de guiche
	 * 
	 * @return uma String com o tipo de guiche
	 */
	public String getGuiche() {
		return guiche;
	}

	/**
	 * Metodo que modifica o tipo de guiche de um determinado aviso
	 * 
	 * @param guiche
	 *            o tipo do guiche
	 */
	public void setGuiche(String guiche) {
		this.guiche = guiche;
	}

	/**
	 * Metodo quer retorn o numero da senha do aviso
	 * 
	 * @return uma String com o numero da senha do aviso
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Metodo que modifica a senha de um determinado aviso
	 * 
	 * @param senha
	 *            string com nova senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	/**
	 * Metodo que retorna a informa��o se deve-se ou nao ser avisado
	 * @return 1 se deve avisar e 0 caso contrario
	 */
	public String getAvisar() {
		return avisar;
	}

	/**
	 * Metodo que modifica a opcao se deve se avisar ou n�o
	 * @param avisar 1 se deve avisar e 0 caso contrario
	 */
	public void setAvisar(String avisar) {
		this.avisar = avisar;
	}

	/**
	 * Metodo quer retorna a cor do aviso
	 * @return retorna a cor do aviso
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * Metodo que modifica a cor do aviso.
	 * @param cor a cor que o aviso deve conter
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	/**
	 * Metodo que retorna uma string com a representa��o de um aviso.
	 * @return uma string com a representa��o
	 */
	public String toString(){
		return "guiche=" + guiche + ", senha=" + senha;
	}

}

