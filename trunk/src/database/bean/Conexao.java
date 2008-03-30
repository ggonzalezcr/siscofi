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

import controller.ConfiguracaoBD;

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
 * Bean que armazena os dados de uma Conexão.
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
	 * Método que salva as alterações no hibernate.properties
	 * 
	 * @param conexao
	 *            Nova conexao
	 * @exception NullPointerException Lançada se algum parâmetro for null
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
	 * Método que retorna os atributos de ip e porta da conexão
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
