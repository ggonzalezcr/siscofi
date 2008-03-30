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
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Objetos dessa classe representam um objeto do tipo Emissao
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */

public class Emissao {
	
	//Atributos de classe
	private String classe;
	private int total = 1;//total de senha a emitir
	
	/**
	 * Constutor simples da classe Emissao
	 *
	 */
	public Emissao(){
		
	}

	/**
	 * Metodo que retorna o total de senha a serem emitidas
	 * @return o total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Metodo que modifica o total de senhas a serem emitidas
	 * @param total o total de senhas.
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Metodo que retorna o tipo de classe de guich�
	 * @return uma String com o tipo de Guich�
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Metodo que modifica o tipo de classe de Guich�
	 * @param classe o tipo do Guich�
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * Coloca o valor da quantidade de impress�o para 1(um)
	 */
	public void reset(){
		total = 1;
	}
}
