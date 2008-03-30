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
 * Bean que armazena os dados de um Guich�.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */
public class Guiche {

	// Atributos
	private String atendente = "";

	private String ip = "";

	private String classe = "";
	
	private String iDGuiche = "";
	
	/**
	 * Cria um novo guich�.
	 *
	 */
	public Guiche() {
	}

	/**
	 * Cria um novo guich�. 
	 * @param ip O IP do guich�.
	 * @param atendente logado no guich�.
	 * @param classe A classe de atendimento do guich�.
	 * @param NumGuiche O n�mero do guich�.
	 */
	public Guiche(String ip, String atendente, String classe, String NumGuiche) {
		this.ip = ip;
		this.atendente = atendente;
		this.classe = classe;
		this.iDGuiche = NumGuiche;
	}

	/**
	 * Determina o valor de atendente.
	 * @return o atendente.
	 */
	public String getAtendente() {
		return atendente;
	}

	/**
	 * Altera o valor de atendente.
	 * @param atendente o novo valor para atendente.
	 */
	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	/**
	 * Determina o valor de ip.
	 * @return o ip.
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Altera o valor de ip.
	 * @param ip o novo valor para ip.
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Determina o valor de classe.
	 * @return o classe.
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Altera o valor de classe.
	 * @param classe o novo valor para classe.
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * Determina o valor da identifica��o do guich�.
	 * @return a identifica��o do guich�.
	 */
	public String getIDGuiche() {
		return iDGuiche;
	}

	/**
	 * Altera o valor da identifica��o do guich�.
	 * @param iDGuiche o novo valor da identifica��o do guich�.
	 */
	public void setIDGuiche(String iDGuiche) {
		this.iDGuiche = iDGuiche;
	}

}
