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

import database.bean.Status;
import exceptions.ConnectionDBException;

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
 * Classe que manipula o status do sistema no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class StatusDAO {

	// Sessão utilizada nas manipulações do banco de dados
	private static Session sess;

	// Transação da sessão
	private static Transaction trans;

	// Factory de session
	private static SessionFactory factory;
	
	/**
	 * Determina o status do sistema.
	 * @return True se o sistema está inicializado e False em caso contrário.
	 */
	public static boolean isStarted() {
		Status status = new Status();
		try {
			abrirSecao();
			sess.load(status, Status.ID_STATUS);
		} catch (Exception e) {
			
		} finally {
			fecharSecao();
		}
		return status.isStarted();
	}
	
	/**
	 * Gera a tabela no banco de dados que conterá Status. <b><u>Cuidado!</u><b>
	 * Quando a tabela é gerada, caso já exista a tabela, esta será apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public static void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(database.bean.Status.class);
		new SchemaExport(cfg).create(true, true);
		setStatusIsStarted(false);
	}
		
	/**
	 * Abre uma conexão, criando um Session e uma Transaction.
	 */
	private static void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Status.class);
		factory = cfg.buildSessionFactory();
		sess = factory.openSession();
		trans = sess.beginTransaction();
	}

	/**
	 * Fecha uma conexão aberta com o banco de dados.
	 * 
	 */
	private static void fecharSecao() {
		try{
			trans.commit();
			sess.close();
			factory.close();
		} catch (Exception e){
			
		}
	}

	/**
	 * Altera o status de inicializado do sistema.
	 * @param isStarted Novo valor para a variável isStarted.
	 */
	public static void setStatusIsStarted(boolean isStarted) {
		try{
				abrirSecao();
				Status status = new Status();
				status.setStarted(isStarted);
				sess.saveOrUpdate(status);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharSecao();
		}
	}
	
	public static void TestaConexao() throws ConnectionDBException {
		try{
			abrirSecao();
			fecharSecao();
		} catch(Exception e){
			throw new ConnectionDBException("falha de conexão com a tabela status");
		}
	}
	
}