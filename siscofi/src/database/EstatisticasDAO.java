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

import util.DataUtil;

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
 * @author Rodrigo Lopes
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
	 * @param data A data da Estatistica de avaliacao a ser lida.
	 * @return A estatistica de um dia de atendimento.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localiza um Avaliacao para a
	 *             classe especificada.
	 */
	public Estatisticas readAvaliacao(Date data) throws NotFoundInDBException {
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
	 * Grava um objeto Estatistica de avaliação no banco de dados. Caso já exista A Estatistica de avaliacao, esta será sobreescrita.
	 * 
	 * @param Estatistica A Estatistica a ser gravada no banco de dados.
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
	 * Remove um objeto Avaliacao do banco de dados.
	 * 
	 * @param data
	 *            A Data/hora da avaliação a ser removida
	 * @throws NotFoundInDBException
	 */
	public void removeAvaliacao(Date data) throws NotFoundInDBException {
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
	 * Lê do banco de dados uma objeto lista contendo todas as Avaliacoes.
	 * @param data A data/hora da avaliação a ser removida.
	 * @return O Avaliacao com a classe de atendimento especificada.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localiza um Avaliacao para a
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
	 * Gera a tabela no banco de dados que conterá os objetos Avaliacao. <b><u>Cuidado!</u><b>
	 * Quando a tabela é gerada, caso já exista a tabela, esta será apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Estatisticas.class);
		cfg.addAnnotatedClass(EstatisticaResposta.class);
		new SchemaExport(cfg).create(true, true);
	}
	
	public static void main(String[] args) {
//		Siscofi.getInstance().resetBD();
//		new EstatisticasDAO().generateTable();
//		GerenciadorEstatisticas g = new GerenciadorEstatisticas();
//		g.GerarEstatisticasAvaliacao();
//		EstatisticasDAO e = new EstatisticasDAO();
////		e.generateTable();
//		Estatisticas e = new Estatisticas();
//		Set<String> er = new HashSet<String>();
//		e.setData(DataUtil.gerarData("01", "12", "2007"));
//		System.out.println(er);
//		er.add("Just a quick one, now i'm not suffering so badly from post traumatic release disorder, I thought I better just make a note saying to you guys the release builds were updated yesterday (if you didnt realise there was edit's) due to a bug making the TLB release extremely slow. This has now been fixed."+ 
//				"I have just updated the packs again to include Linuz ISO plugin version 0.7.0, seem's we accidently packed 0.6.0 with the earlier builds! sorry about that!" + 
//				"If you already have the slowness bug fixes (or you only use VM), you can download the Linuz ISO plugin update from our plugin downloads section, else feel free to redownload the packs, preferably from the mirror, as some of you may have noticed due to the volume of downloads we had, the site was grinding to a halt!");
//		e.setRespostas06(er);
//		System.out.println(er);
//		new EstatisticasDAO().writeEstatistica(e);
		try {
			for(Estatisticas e: new EstatisticasDAO().listaDeEstatisticas(DataUtil.gerarData("01", "12", "2007"), DataUtil.gerarData("01", "12", "2007")))
				System.out.println(e.getData());
		
		} catch (NotFoundInDBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		Estatisticas est = new Estatisticas();
//		est.setDia(new Date());
//		List<EstatisticaResposta> list = new ArrayList<EstatisticaResposta>();
//		EstatisticaResposta estr = new EstatisticaResposta();
//		estr.setEstatisticas(est);
//		estr.setNumPergunta(1);
//		estr.setPergunta("O que?");
//		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
//		map.put(10, 10);
//		estr.setRespostas(map);
//		list.add(estr);
//		EstatisticaResposta estr2 = new EstatisticaResposta();
//		estr2.setEstatisticas(est);
//		estr2.setNumPergunta(1);
//		estr2.setPergunta("O que?");
//		Map<Integer,Integer> map2 = new HashMap<Integer, Integer>();
//		map2.put(10, 10);
//		estr2.setRespostas(map2);
//		list.add(estr2);
//		est.setListaResposta(list);
//		e.writeEstatistica(est);

//		try {
//			Date data = new Date(2007,11,8);
//			
//			Date data2 = new Date(2007,11,8);
//			Date data3 = new Date();
//			data.setTime(data3.getTime());
//			data.setHours(13);
//			System.out.println("data1: " + data);
//			System.out.println("data2: " + data2);
//			System.out.println("data3: " + data3);
//			
//			Set l = e.listaDeEstatisticas(data,data3);
//			System.out.println(l);
//			System.out.println(l.size());
//		} catch (NotFoundInDBException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
	
}

