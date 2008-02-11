package util;

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
 * Classe que representa uma mensagem.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 * 
 */

public class Mensagem {

	//texto da mensagem
	private String _texto;
	//valor da cor em hexadecimal no sistema RGB. 
	private String _cor;
	
	/**
	 * Cria uma nova Mensagem.
	 * @param texto Texto da mensagem.
	 * @param cor valor da cor em hexadecimal no sistema RGB.
	 */
	public Mensagem(String texto, String cor){
		_texto = texto;
		_cor = cor;
		
	}
	
	/**
	 * Cria uma nova Mensagem.
	 */
	public Mensagem(){		
	}
	
	/**
	 * Determina o texto da mensagem.
	 * @return Texto da mensagem.
	 */
	public String getTexto() {
		return _texto;
	}
	
	/**
	 * Altera o texto da mensagem.
	 * @param texto Novo texto da mensagem. 
	 */
	public void setTexto(String texto) {
		this._texto = texto;
	}
	
	/**
	 * Determina a cor da mensagem.
	 * @return valor da cor em hexadecimal, no sistema RGB. 
	 */
	public String getCor() {
		return _cor;
	}
	
	/**
	 * Altera o valor da cor. 
	 * @param cor Novo valor da cor. O valor deve estar em RGB no sistema hexadecimal.
	 */
	public void setCor(String cor) {
		this._cor = cor;
	}
	
	/**
	 * Determina um string que representa a cor.
	 * @return o texto da mensagem
	 */
	public String toString(){
		return _texto + " " + _cor;
	}
	
	
}
