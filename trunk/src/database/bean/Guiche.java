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
 * Bean que armazena os dados de um Guichê.
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
	 * Cria um novo guichê.
	 *
	 */
	public Guiche() {
	}

	/**
	 * Cria um novo guichê. 
	 * @param ip O IP do guichê.
	 * @param atendente logado no guichê.
	 * @param classe A classe de atendimento do guichê.
	 * @param NumGuiche O número do guichê.
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
	 * Determina o valor da identificação do guichê.
	 * @return a identificação do guichê.
	 */
	public String getIDGuiche() {
		return iDGuiche;
	}

	/**
	 * Altera o valor da identificação do guichê.
	 * @param iDGuiche o novo valor da identificação do guichê.
	 */
	public void setIDGuiche(String iDGuiche) {
		this.iDGuiche = iDGuiche;
	}

}
