package controller;

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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

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
 * Classe que implementa um objeto que representa a configuração 
 * do sistema.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class ConfiguracaoBD {
	
	//Constantes
	public static final String DIALECT = "hibernate.dialect"; 
	public static final String DRIVER = "hibernate.connection.driver_class"; 
	public static final String URL = "hibernate.connection.url"; 
	public static final String USER = "hibernate.connection.username"; 
	public static final String PASSWORD = "hibernate.connection.password"; 

	//Declaração de variáveis.
	public static final Properties properties;
	public static final Properties propertiesDefalt;
	private static String hibernateDialect;
	private static String hibernateConnectionDriver_class;
	private static String hibernateConnectionUrl;
	private static String hibernateConnectionUsername;
	private static String hibernateConnectionPassword;
	
	static{
		properties = new Properties();
		propertiesDefalt = new Properties();
		loadConfiguracao();
	}

	private static void loadConfiguracao() {
		String path = Configuracao.getPath() + "/WEB-INF/classes/hibernate.properties";
		try {
			properties.load(new BufferedInputStream(new FileInputStream(path)));
			hibernateDialect = properties.getProperty(DIALECT);
			hibernateConnectionDriver_class = properties.getProperty(DRIVER);
			hibernateConnectionUrl = properties.getProperty(URL);
			hibernateConnectionUsername = properties.getProperty(USER);
			hibernateConnectionPassword = properties.getProperty(PASSWORD);

		} catch (IOException e) {
			System.err.println(path);
		}
	}
	
	
	public static void saveConfiguracao(){
		try {
			String path = Configuracao.getPath() + "/WEB-INF/classes/hibernate.properties";
			File f = new File(path);
			OutputStream out = new FileOutputStream(f);
			properties.store(out, "Arquivo de configuração do Banco de Dados");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}


	/**
	 * @return the hibernateConnectionDriver_class
	 */
	public static String getHibernateConnectionDriver_class() {
		return hibernateConnectionDriver_class;
	}


	/**
	 * @param hibernateConnectionDriver_class the hibernateConnectionDriver_class to set
	 */
	public static void setHibernateConnectionDriver_class(
			String hibernateConnectionDriver_class) {
		ConfiguracaoBD.hibernateConnectionDriver_class = hibernateConnectionDriver_class;
		properties.setProperty(DRIVER, hibernateConnectionDriver_class);
	}


	/**
	 * @return the hibernateConnectionPassword
	 */
	public static String getHibernateConnectionPassword() {
		return hibernateConnectionPassword;
	}


	/**
	 * @param hibernateConnectionPassword the hibernateConnectionPassword to set
	 */
	public static void setHibernateConnectionPassword(
			String hibernateConnectionPassword) {
		ConfiguracaoBD.hibernateConnectionPassword = hibernateConnectionPassword;
		properties.setProperty(PASSWORD, hibernateConnectionPassword);
	}


	/**
	 * @return the hibernateConnectionUrl
	 */
	public static String getHibernateConnectionUrl() {
		return hibernateConnectionUrl;
	}
	
	public static void setIP(String IP, String porta){
		String url = "jdbc:postgresql://" + IP + ':' 
			+ porta + "/postgres";
		System.out.println(url);
		setHibernateConnectionUrl(url);
	}

	/**
	 * @param hibernateConnectionUrl the hibernateConnectionUrl to set
	 */
	public static void setHibernateConnectionUrl(String hibernateConnectionUrl) {
		ConfiguracaoBD.hibernateConnectionUrl = hibernateConnectionUrl;
		properties.setProperty(URL, hibernateConnectionUrl);
	}


	/**
	 * @return the hibernateConnectionUsername
	 */
	public static String getHibernateConnectionUsername() {
		return hibernateConnectionUsername;
	}


	/**
	 * @param hibernateConnectionUsername the hibernateConnectionUsername to set
	 */
	public static void setHibernateConnectionUsername(
			String hibernateConnectionUsername) {
		ConfiguracaoBD.hibernateConnectionUsername = hibernateConnectionUsername;
		properties.setProperty(USER, hibernateConnectionUsername);
	}


	/**
	 * @return the hibernateDialect
	 */
	public static String getHibernateDialect() {
		return hibernateDialect;
	}


	/**
	 * @param hibernateDialect the hibernateDialect to set
	 */
	public static void setHibernateDialect(String hibernateDialect) {
		ConfiguracaoBD.hibernateDialect = hibernateDialect;
		properties.setProperty(DIALECT, hibernateDialect);
	}
	
	/**
	 * Método que recupera o ip a partir de uma url
	 * @return O ip do banco de dados
	 */
	public static String getIp(){
		String url = getHibernateConnectionUrl();
		Scanner sc = new Scanner(url).useDelimiter("[:/]");
		for(int i=0; i<4; i++)
			sc.next();
		return sc.next();
	}
	
	/**
	 * Recupera a porta de um banco a partir de uma url
	 * @return A porta de um banco
	 */
	public static String getPorta(){
		String url = getHibernateConnectionUrl();
		Scanner sc = new Scanner(url).useDelimiter("[:/]");
		for(int i=0; i<5; i++)
			sc.next();
		return sc.next();
	}
		
}

