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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import database.bean.Avaliacao;
import exceptions.NotFoundInDBException;

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
 * Classe que manipula um controle no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class AvaliacaoDAO {

	// Sessão utilizada nas manipulações do banco de dados
	private Session sess;

	// Transação da sessão
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * Lê do banco de dados um objeto Avaliacao.
	 * @param data A data/hora da avaliação a ser removida.
	 * @return O Avaliacao com a classe de atendimento especificada.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localiza um Avaliacao para a
	 *             classe especificada.
	 */
	public Avaliacao readAvaliacao(Date data) throws NotFoundInDBException {
		Avaliacao Avaliacao = new Avaliacao();
		try {
			abrirSecao();
			sess.load(Avaliacao, data);
		} catch (Exception e) {
			throw new NotFoundInDBException("Avaliacao de " + data
					+ " nao encontrado");
		} finally {
			fecharSecao();
		}
		return Avaliacao;
	}
	
	/**
	 * Lê do banco de dados uma objeto lista contendo todas as Avaliacoes.
	 * @param data A data/hora da avaliação a ser removida.
	 * @return O Avaliacao com a classe de atendimento especificada.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localiza um Avaliacao para a
	 *             classe especificada.
	 */
	public List<Avaliacao> 	listaDeAvaliacoes(Date data) throws NotFoundInDBException {

		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		try {
			abrirSecao();
			avaliacoes = sess.createCriteria(Avaliacao.class).list();
		} catch (Exception e) {
			throw new NotFoundInDBException("Avaliacao de " + data
					+ " nao encontrado");
		} finally {
			fecharSecao();
		}
		return avaliacoes;
	}
	
	/**
	 * Abre uma conexão, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Avaliacao.class);
		factory = cfg.buildSessionFactory();
		sess = factory.openSession();
		trans = sess.beginTransaction();
	}

	/**
	 * Fecha uma conexão aberta com o banco de dados.
	 * 
	 */
	private void fecharSecao() {
		try{
			trans.commit();
			sess.close();
			factory.close();
		} catch (Exception e){
			
		}
	}

	/**
	 * Grava um objeto Avaliacao no banco de dados. Caso já exista um Avaliacao da
	 * mesma classe de atendimento, este será sobreescrito.
	 * 
	 * @param avaliacao A Avaliação a ser gravada no banco de dados.
	 * @throws ServletException 
	 */
	public void writeAvaliacao(Avaliacao avaliacao) throws ServletException {
		try{
				abrirSecao();
				sess.saveOrUpdate(avaliacao);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			fecharSecao();
		}

	}

	/**
	 * Remove um objeto Avaliacao do banco de dados.
	 * 
	 * @param data
	 *            A Data/hora da avaliação a ser removida
	 * @throws NotFoundInDBException
	 */
	public void removeAvaliacao(Date data) throws NotFoundInDBException {
		try {
			abrirSecao();
			Avaliacao avaliacao = new Avaliacao();
			sess.load(avaliacao, data);
			sess.delete(avaliacao);
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Gera a tabela no banco de dados que conterá os objetos Avaliacao. <b><u>Cuidado!</u><b>
	 * Quando a tabela é gerada, caso já exista a tabela, esta será apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(database.bean.Avaliacao.class);
		new SchemaExport(cfg).create(true, true);
	}

	/**
	 * Remove uma lista de avaliações do banco de dados.
	 * @param listaAvaliacao Lista de avaliação a ser removida.
	 */
	public void removeAvaliacoes(List<Avaliacao> listaAvaliacao) {
		try {
			abrirSecao();
			for(Avaliacao av: listaAvaliacao){
				sess.delete(av);
			}
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
}
