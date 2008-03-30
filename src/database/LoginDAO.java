package database;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import database.bean.Login;

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
 * Classe que manipula o login no banco de dados.
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class LoginDAO {
	
	// Sess�o utilizada nas manipula��es do banco de dados
	private Session sess;

	// Transa��o da sess�o
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	
	/**
	 * Abre uma conex�o, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Login.class);
		factory = cfg.buildSessionFactory();
		sess = factory.openSession();
		trans = sess.beginTransaction();
	}

	/**
	 * Fecha uma conex�o aberta com o banco de dados.
	 * 
	 */
	private void fecharSecao() {
		trans.commit();
		sess.close();
		factory.close();
	}

	/**
	 * Gera a tabela no banco de dados que conter� os objetos Login. <b><u>Cuidado!</u><b>
	 * Quando a tabela � gerada, caso j� exista a tabela, esta ser� apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(database.bean.Login.class);
		new SchemaExport(cfg).create(true, true);
	}
	
	/**
	 * Verifica se o login � v�lido
	 * @param login Login digitado pelo usu�rio
	 * @return True se o login for v�lido ou false caso contr�rio
	 */
	public boolean validaLogin(Login login) {
		Login l = new Login();
		try {
			abrirSecao();
			String nome = login.getLogin();
			sess.load(l, nome);
		}catch (Exception e) {
			return false;
		} finally{
			fecharSecao();
		}
		if(login.getLogin().equals(l.getLogin()) &&
				login.getPassword().equals(l.getPassword())){
			return true;
		}
		return false;
	}
	
	/**
	 * Salva um novo login no banco de dados.
	 * @param login Login a ser salvo.
	 */
	public void writeLogin(Login login) {
		try{
				abrirSecao();
				sess.saveOrUpdate(login);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharSecao();
		}

	}

}
