package database;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import database.bean.Login;

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
 * Classe que manipula o login no banco de dados.
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class LoginDAO {
	
	// Sessão utilizada nas manipulações do banco de dados
	private Session sess;

	// Transação da sessão
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	
	/**
	 * Abre uma conexão, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Login.class);
		factory = cfg.buildSessionFactory();
		sess = factory.openSession();
		trans = sess.beginTransaction();
	}

	/**
	 * Fecha uma conexão aberta com o banco de dados.
	 * 
	 */
	private void fecharSecao() {
		trans.commit();
		sess.close();
		factory.close();
	}

	/**
	 * Gera a tabela no banco de dados que conterá os objetos Login. <b><u>Cuidado!</u><b>
	 * Quando a tabela é gerada, caso já exista a tabela, esta será apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(database.bean.Login.class);
		new SchemaExport(cfg).create(true, true);
	}
	
	/**
	 * Verifica se o login é válido
	 * @param login Login digitado pelo usuário
	 * @return True se o login for válido ou false caso contrário
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
