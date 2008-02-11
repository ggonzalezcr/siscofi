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

import database.bean.Status;
import exceptions.ConnectionDBException;

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
 * Classe que manipula o status do sistema no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class StatusDAO {

	// Sess�o utilizada nas manipula��es do banco de dados
	private static Session sess;

	// Transa��o da sess�o
	private static Transaction trans;

	// Factory de session
	private static SessionFactory factory;
	
	/**
	 * Determina o status do sistema.
	 * @return True se o sistema est� inicializado e False em caso contr�rio.
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
	 * Gera a tabela no banco de dados que conter� Status. <b><u>Cuidado!</u><b>
	 * Quando a tabela � gerada, caso j� exista a tabela, esta ser� apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public static void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(database.bean.Status.class);
		new SchemaExport(cfg).create(true, true);
		setStatusIsStarted(false);
	}
		
	/**
	 * Abre uma conex�o, criando um Session e uma Transaction.
	 */
	private static void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Status.class);
		factory = cfg.buildSessionFactory();
		sess = factory.openSession();
		trans = sess.beginTransaction();
	}

	/**
	 * Fecha uma conex�o aberta com o banco de dados.
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
	 * @param isStarted Novo valor para a vari�vel isStarted.
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
			throw new ConnectionDBException("falha de conex�o com a tabela status");
		}
	}
	
}