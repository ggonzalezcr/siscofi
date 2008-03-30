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

import controller.ConfiguracaoBD;

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
 * Bean que armazena os dados de uma Conex�o.
 * 
 * @author Carlos Trajano
 * @author Hamon Barros
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 * 
 */
public class Conexao {

	// Atributos
	private String login;

	private String senha;

	private String ip = "localhost";

	private String porta = "5432";

	/**
	 * @return the porta
	 */
	public String getPorta() {
		return porta;
	}

	/**
	 * @param porta
	 *            the porta to set
	 */
	public void setPorta(String porta) {
		this.porta = porta;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * M�todo que salva as altera��es no hibernate.properties
	 * 
	 * @param conexao
	 *            Nova conexao
	 * @exception NullPointerException Lan�ada se algum par�metro for null
	 */
	public static void save(Conexao conexao) throws NullPointerException{
		if (conexao.getIp() == null || conexao.getLogin() == null
				|| conexao.getSenha() == null | conexao.getPorta() == null) {
			throw new NullPointerException("Parametro null invalido");
		} else {
			ConfiguracaoBD.setIP(conexao.getIp(), conexao.getPorta());
			ConfiguracaoBD.setHibernateConnectionPassword(conexao.getSenha());
			ConfiguracaoBD.setHibernateConnectionUsername(conexao.getLogin());
			ConfiguracaoBD.saveConfiguracao();
		}
	}

	/**
	 * M�todo que retorna os atributos de ip e porta da conex�o
	 * 
	 * @return Os atributos ip e porta da conexao
	 */
	public static Conexao getConexao() {
		String ip = ConfiguracaoBD.getIp();
		String porta = ConfiguracaoBD.getPorta();
		Conexao con = new Conexao();
		con.setIp(ip);
		con.setPorta(porta);
		return con;
	}
}
