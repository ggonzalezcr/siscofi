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

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

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
 * 
 * Classe fornecida pelo TRE.
 * Classe respons�vel pela autentica��o dos usu�rios atr�ves de
 * dados guardados no banco de dados interno do TRE
 * 
 * 
 * 
 * @author jpaulo
 */
public class LoginLDAP {

	// Obs: Colocar o endere�o do LDAP em um arquivo de configura��o (XML ou Properties);
	
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
	 * Efetua o login do usu�rio Se login inv�lido, lan�a uma exce��o do tipo
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
