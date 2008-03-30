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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
 * Bean que armazena os dados de uma avaliação.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */
@Entity
public class Avaliacao {
	
	//Atributos
	@Id
	private Date data;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private String resposta4;
	private String resposta5;
	@Column(name = "resposta6", nullable = true, length = 8192)
	private String resposta6;
	@Column(name = "resposta7", nullable = true, length = 8192)
	private String resposta7;

	/**
	 * Método que determina resposta1
	 * @return o valor de resposta1
	 */
	public String getResposta1() {
		return resposta1;
	}

	/**
	 * Altera o valor da variável resposta1.
	 * @param resposta1 O novo valor de resposta1.
	 */
	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}

	/**
	 * Método que determina resposta2
	 * @return o valor de resposta2
	 */
	public String getResposta2() {
		return resposta2;
	}

	/**
	 * Altera o valor da variável resposta2.
	 * @param resposta2 O novo valor de resposta2.
	 */
	public void setResposta2(String resposta2) {
		this.resposta2 = resposta2;
	}

	/**
	 * Método que determina resposta3
	 * @return o valor de resposta3
	 */
	public String getResposta3() {
		return resposta3;
	}

	/**
	 * Altera o valor da variável resposta3.
	 * @param resposta3 O novo valor de resposta3.
	 */
	public void setResposta3(String resposta3) {
		this.resposta3 = resposta3;
	}

	/**
	 * Método que determina resposta4
	 * @return o valor de resposta4
	 */
	public String getResposta4() {
		return resposta4;
	}

	/**
	 * Altera o valor da variável resposta4.
	 * @param resposta4 O novo valor de resposta4.
	 */
	public void setResposta4(String resposta4) {
		this.resposta4 = resposta4;
	}

	/**
	 * Método que determina resposta5
	 * @return o valor de resposta5
	 */
	public String getResposta5() {
		return resposta5;
	}

	/**
	 * Altera o valor da variável resposta5.
	 * @param resposta5 O novo valor de resposta5.
	 */
	public void setResposta5(String resposta5) {
		this.resposta5 = resposta5;
	}

	/**
	 * Método que determina resposta6
	 * @return o valor de resposta6
	 */
	public String getResposta6() {
		return resposta6;
	}

	/**
	 * Altera o valor da variável resposta6.
	 * @param resposta6 O novo valor de resposta6.
	 */
	public void setResposta6(String resposta6) {
		this.resposta6 = resposta6;
	}

	/**
	 * Método que determina resposta7
	 * @return o valor de resposta7
	 */
	public String getResposta7() {
		return resposta7;
	}

	/**
	 * Altera o valor da variável resposta7.
	 * @param resposta7 O novo valor de resposta7.
	 */
	public void setResposta7(String resposta7) {
		this.resposta7 = resposta7;
	}

	/**
	 * Método que determina data
	 * @return o valor de data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Altera o valor da variável data.
	 * @param data O novo valor de data.
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * Retorna a resposta de acordo com o indice passado
	 * @param indice O indice da resposta
	 * @return A resposta com índice igual a "indice".
	 */
	public String getResposta(int indice){
		String resposta = "";
		switch (indice) {
		case 1:
			resposta = getResposta1();
			break;
		case 2:
			resposta = getResposta2();
			break;
		case 3:
			resposta = getResposta3();
			break;
		case 4:
			resposta = getResposta4();
			break;
		case 5:
			resposta = getResposta5();
			break;
		}
		return resposta;
	}

}
