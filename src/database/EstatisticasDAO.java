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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import controller.Siscofi;

import estatisticas.avaliacao.EstatisticaResposta;
import estatisticas.avaliacao.Estatisticas;
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
 * Classe que manipula uma Estatistica no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class EstatisticasDAO {

	// Sessão utilizada nas manipulações do banco de dados
	private Session sess;

	// Transação da sessão
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * Lê do banco de dados um objeto Estatistica.
	 * @param data A data da Estatistica de Estatistica a ser lida.
	 * @return A estatistica de um dia de atendimento.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localiza um Estatistica para a
	 *             classe especificada.
	 */
	public Estatisticas readEstatisticas(Date data) throws NotFoundInDBException {
		Estatisticas estatisticas = new Estatisticas();
		try {
			abrirSecao();
			sess.load(estatisticas, data);
			estatisticas.getRespostas06();
			estatisticas.getRespostas06();
		} catch (Exception e) {
			throw new NotFoundInDBException("Estatistica de " + data
					+ " nao encontrado");
		} finally {
			fecharSecao();
		}
		return estatisticas;
	}
	
		
	/**
	 * Abre uma conexão, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Estatisticas.class);
		cfg.addAnnotatedClass(EstatisticaResposta.class);
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
	 * Grava um objeto Estatistica de avaliação no banco de dados. Caso já exista A Estatistica de Estatistica, esta será sobreescrita.
	 * 
	 * @param estatisticas A Estatistica a ser gravada no banco de dados.
	 */
	public void writeEstatistica(Estatisticas estatisticas) {
		try{
				abrirSecao();
				Map<Integer, EstatisticaResposta> est = estatisticas.getMapaEstatisticaResposta();
				for(Integer e: est.keySet()){
					sess.saveOrUpdate(est.get(e));
				}
				sess.saveOrUpdate(estatisticas);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharSecao();
		}

	}

	/**
	 * Remove um objeto Estatistica do banco de dados.
	 * 
	 * @param data
	 *            A Data/hora da avaliação a ser removida
	 * @throws NotFoundInDBException
	 */
	public void removeEstatistica(Date data) throws NotFoundInDBException {
		try {
			abrirSecao();
			Estatisticas estatisticas = new Estatisticas();
			sess.load(estatisticas, data);
			sess.delete(estatisticas);
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}

	
	/**
	 * Lê do banco de dados uma objeto lista contendo todas as Avaliações.
	 * @param dataInicial A data/hora inicial do intervalo e estatísticas a serem coletadas.
	 * @param dataFinal A data/hora final do intervalo e estatísticas a serem coletadas.
	 * @return O Estatistica com a classe de atendimento especificada.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localiza um Estatistica para a
	 *             classe especificada.
	 */
	public List<Estatisticas> listaDeEstatisticas(Date dataInicial, Date dataFinal) throws NotFoundInDBException {
		Set<Estatisticas> estatisticas = new HashSet<Estatisticas>();
		List<Estatisticas> listaEstatisticas = new ArrayList<Estatisticas>();
		try {
			abrirSecao();
			estatisticas.addAll(sess.createCriteria(Estatisticas.class).add(Restrictions.between("data", dataInicial, dataFinal)).list());
			listaEstatisticas.addAll(estatisticas);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundInDBException("Não existem estatísticas para o período solicitado.");
		} finally {
			fecharSecao();
		}
		return listaEstatisticas;
	}
	
	/**
	 * Gera a tabela no banco de dados que conterá os objetos Estatistica. <b><u>Cuidado!</u><b>
	 * Quando a tabela é gerada, caso já exista a tabela, esta será apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Estatisticas.class);
		cfg.addAnnotatedClass(EstatisticaResposta.class);
		new SchemaExport(cfg).create(true, true);
	}	
}

