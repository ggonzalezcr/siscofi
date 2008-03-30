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

import controller.Siscofi;

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
 * Classe bean para as senhas
 */
public class Senha {

	// Atributos de classe
	private String _tipoGuiche, _data, _senha;

	/**
	 * Construtor da classe Senha
	 * 
	 * @param tipoGuiche
	 *            o tipo do guiche
	 * @param senha
	 *            o numero da _senha
	 */
	public Senha(String tipoGuiche, String senha) {
		_tipoGuiche = tipoGuiche;
		_senha = senha;
		_data = DataUtil.getDataHoraAtual();
	}

	/**
	 * Metodo que retorna a _data da _senha
	 * 
	 * @return a _data da _senha
	 */
	public String get_data() {
		return _data;
	}

	/**
	 * Metodo que modifica a _data da _senha
	 * 
	 * @param data
	 *            a _data da _senha
	 */
	public void set_data(String data) {
		this._data = data;
	}

	/**
	 * Metodo que retorna o numero da _senha
	 * 
	 * @return o numero da _senha
	 */
	public String get_senha() {
		return _senha;
	}

	/**
	 * Metodo que modifica o numero da _senha
	 * 
	 * @param senha
	 *            o numero da _senha
	 */
	public void set_senha(String senha) {
		_senha = senha;
	}

	/**
	 * Metodo que modifica o tipo de guiche
	 * 
	 * @return o tipo de guiche
	 */
	public String get_tipoGuiche() {
		return _tipoGuiche;
	}

	/**
	 * Metodo que modifica o tipo de guiche
	 * 
	 * @param tipoGuiche
	 *            o tipo de guiche
	 */
	public void set_tipoGuiche(String tipoGuiche) {
		_tipoGuiche = tipoGuiche;
	}

	/**
	 * Metod que compara duas senhas
	 * 
	 * @param outra
	 *            a _senha a ser comparada
	 * @return true caso as _senha sejam iguais e fase caso contrario
	 */
	public boolean equals(Senha outra) {
		if (outra == null) {
			return false;
		}
		return mesmaData(outra) && (mesmaSenha(outra))
				&& mesmoTipoGuiche(outra);
	}

	//Metodo que compara se duas senhas possuem o mesmo tipo de guiche
	private boolean mesmoTipoGuiche(Senha outra) {
		return (this.get_tipoGuiche()
				.equalsIgnoreCase(outra.get_tipoGuiche()));
	}

	//Metodo que compara se duas senha possuem a mesma data
	private boolean mesmaData(Senha outra) {
		return (this.get_data().equals(outra.get_data()));
	}

	//Metodo que compara se duas senhas possuem o mesmo n�mero
	private boolean mesmaSenha(Senha outra) {
		return this.get_senha().equals(outra.get_senha());
	}

	/**
	 * Metodo que retorna uma string com a representa��o de uma _senha
	 * @return uma sting com a senha
	 */
	public String toString() {
		String texto = "";
		texto+= "        Justi�a Eleitoral" + "\n";
		texto+= "Central de Atendimento ao Eleitor" + "\n";
		texto+= "      Campina Grande" + "\n";
		texto+="\n             " + this.get_tipoGuiche() + this.get_senha()
		+ "\r\n\n       " + this.get_data();
		return texto;
	}
	
	/**
	 * Metoque que retorna um array com as informa��es da _senha
	 * @return o array contendo as informa��es.
	 */
	public String[] getStrings() {
		String central = Siscofi.getInstance().getNomeCentral();
		String titulo = Siscofi.getInstance().getTitulo();
		String entidade = Siscofi.getInstance().getEntidade();
		String[] strings = {entidade, titulo, central, _senha, get_data()};
		System.out.println("##########################" + _senha);
		return strings;
	}
	
}
