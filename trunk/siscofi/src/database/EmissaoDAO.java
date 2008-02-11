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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que estabele conexão com o Banco de Dados. 
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
	 * Metodo que pega o proximo número de fila a ser chamado no Bando de Dados
	 * @param path path do arquivo xml de configuração do hibernate.
	 * @return um inteiro com o numero a ser chamado.
	 * @throws SQLException exceção lançada caso haja algum erro com a conexão
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
