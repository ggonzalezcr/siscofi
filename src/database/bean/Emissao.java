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
	 * Metodo que retorna o tipo de classe de guichê
	 * @return uma String com o tipo de Guichê
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Metodo que modifica o tipo de classe de Guichê
	 * @param classe o tipo do Guichê
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * Coloca o valor da quantidade de impressão para 1(um)
	 */
	public void reset(){
		total = 1;
	}
}
