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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import estatisticas.atendimento.DadosAtendimento;
import exceptions.NotFoundInDBException;

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
 * Classe que manipula DadosAtendimento no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class DadosAtendimentoDAO {

	// Sess�o utilizada nas manipula��es do banco de dados
	private Session sess;

	// Transa��o da sess�o
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * L� do banco de dados um objeto DadosAtendimento.
	 * @param data A data dos dados de atendimento a ser lida.
	 * @return Os dados de atendimento
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja poss�vel localizar os dados de atendimento.
	 */
	public DadosAtendimento readDadosAtendimento(Date data) throws NotFoundInDBException {
		DadosAtendimento dados = new DadosAtendimento();
		try {
			abrirSecao();
			sess.load(dados, data);
		} catch (Exception e) {
			throw new NotFoundInDBException("Dados de atendimento de " + data
					+ " nao encontrados");
		} finally {
			fecharSecao();
		}
		return dados;
	}
	
		
	/**
	 * Abre uma conex�o, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(DadosAtendimento.class);
		factory = cfg.buildSessionFactory();
		sess = factory.openSession();
		trans = sess.beginTransaction();
	}

	/**
	 * Fecha uma conex�o aberta com o banco de dados.
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
	 * Grava um objeto DadosAtendimento no banco de dados. Caso o objeto j� exista, este ser� sobreescrito.
	 * 
	 * @param dadosAtendimento Os dados de atendimentos a serem gravados no banco de dados.
	 */
	public void writeDadosAtendimento(DadosAtendimento dadosAtendimento) {
		try{
				abrirSecao();
				sess.saveOrUpdate(dadosAtendimento);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharSecao();
		}

	}

	/**
	 * Remove um objeto DadosAtendimento do banco de dados.
	 * 
	 * @param data
	 *            A Data dos dados a ser removido.
	 * @throws NotFoundInDBException lan�ada se os dados n�o forem encontrados
	 */
	public void removeDadosAtendimento(Date data) throws NotFoundInDBException {
		try {
			abrirSecao();
			DadosAtendimento dados = null;
			sess.load(dados, data);
			sess.delete(dados);
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}

	
	/**
	 * L� do banco de dados uma lista contendo todos os dados de atendimento num determinado per�odo.
	 * @param dataInicial a data inicial do per�odo de interesse.
	 * @param dataFinal a data final do per�odo de interesse.
	 * @return Lista de DadosAtendimento do per�odo.
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja poss�vel encontrar nenhum dado de atendimento no per�odo.
	 */
	public List<DadosAtendimento> listaDeDadosAtendimento(Date dataInicial, Date dataFinal) throws NotFoundInDBException {
		Set<DadosAtendimento> dados = new HashSet<DadosAtendimento>();
		List<DadosAtendimento> listaDados = new ArrayList<DadosAtendimento>();
		try {
			abrirSecao();
			dados.addAll(sess.createCriteria(DadosAtendimento.class).add(Restrictions.between("data", dataInicial, dataFinal)).list());
			listaDados.addAll(dados);
		} catch (Exception e) {
			throw new NotFoundInDBException("N�o existem estat�sticas para o per�odo solicitado.");
		} finally {
			fecharSecao();
		}
		return listaDados;
	}
	
	/**
	 * Gera a tabela no banco de dados que conter� os objetos DadosAtendimento. <b><u>Cuidado!</u><b>
	 * Quando a tabela � gerada, caso j� exista a tabela, esta ser� apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(DadosAtendimento.class);
		new SchemaExport(cfg).create(true, true);
	}
	
	public static void main(String[] args) {
		new DadosAtendimentoDAO().generateTable();
	}
	
}

