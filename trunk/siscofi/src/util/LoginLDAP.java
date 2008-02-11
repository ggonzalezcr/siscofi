package util;

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

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * 
 * Classe fornecida pelo TRE.
 * Classe responsável pela autenticação dos usuários atráves de
 * dados guardados no banco de dados interno do TRE
 * 
 * 
 * 
 * @author jpaulo
 */
public class LoginLDAP {

	// Obs: Colocar o endereço do LDAP em um arquivo de configuração (XML ou Properties);
	
	private final String URL_LDAP = "ldap://10.12.1.15:389";

	private String login;

	private String lotacao;

	private String email;

	private String nome;

	private String funcao;
	
	private String member;

	private static LoginLDAP loginLDAP;
	
	public LoginLDAP() {
	}

	public static synchronized LoginLDAP getInstance(){
		if(loginLDAP == null)
			loginLDAP =  new LoginLDAP();
		return loginLDAP;
	}

	/**
	 * Efetua o login do usuário Se login inválido, lança uma exceção do tipo
	 * AuthenticationException
	 */

	public boolean login(String username, String password)
			throws NamingException {
		// Tenta criar o contexto com os dados de login
		LdapContext ctx = null;
		this.login = username;
		boolean isAutenticado = false;
		try {
			ctx = new InitialLdapContext(ldap(username, password), null);
			isAutenticado = true;
			setAtributos(ctx);
		} catch (javax.naming.AuthenticationException e) {
			isAutenticado = false;
		} finally {
			if (ctx != null)
				ctx.close();
			ctx = null;
		}
		return isAutenticado;
	}

	public void setAtributos(LdapContext ctx) throws NamingException {

		Attributes atts = ctx.getAttributes("CN=" + this.login
				+ ",CN=Users,DC=tre-pb,DC=gov,DC=br");
		this.setNome(atts.get("displayName").get().toString());
		this.setEmail(atts.get("mail").get().toString());
		this.setLotacao(atts.get("physicalDeliveryOfficeName").get()
						.toString());
		this.setFuncao(atts.get("description").get().toString());
		this.setMember(atts.get("memberOf").get().toString());
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}
	
	public Hashtable ldap(String username, String password) {
		Hashtable env = new Hashtable(11);
		String dn = "CN=" + username + ",CN=Users,DC=tre-pb,DC=gov,DC=br";
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, URL_LDAP);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, dn);
		env.put(Context.SECURITY_CREDENTIALS, password);
		return env;
	}


}// fim - classe
