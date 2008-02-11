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

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

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
 * Classe que estabele conex�o com o Banco de Dados. 
 * 
 * @author Carlos Trajano de Oliveira
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class EmissaoDAO {

	/**
	 * Construtor simples da classe EmissaoDAO
	 *
	 */
	public EmissaoDAO(){
		
	}
	
	/**
	 * Metodo que pega o proximo n�mero de fila a ser chamado no Bando de Dados
	 * @param path path do arquivo xml de configura��o do hibernate.
	 * @return um inteiro com o numero a ser chamado.
	 * @throws SQLException exce��o lan�ada caso haja algum erro com a conex�o
	 * com o Banco de Dados.
	 */
	public int getProximo(String path) throws SQLException {
		SessionFactory sf = new Configuration().configure(new File(path)).buildSessionFactory();
		Session session = sf.openSession();
    	Transaction tr = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("SELECT numero FROM senhas");
		List<Integer> list = query.list();
		tr.commit();
		session.flush();
		session.close();
		return list.get(0);
	}
	
}
