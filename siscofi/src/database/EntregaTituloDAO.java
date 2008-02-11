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

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import coletaDados.EntregaTitulo;
import exceptions.NotFoundInDBException;

/*
 * UFCG - UNIVERSIDADE FEDRAL DE CAMPINA GRANDE
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1I
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES DA SILVA
 */

/**
 * Classe que manipula objetos EntregaTitulo no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class EntregaTituloDAO {

	// Sessão utilizada nas manipulações do banco de dados
	private Session sess;

	// Transação da sessão
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * Lê do banco de dados um objeto EntregaTitulo.
	 * @param data A data da entrega de título a ser lida.
	 * @return objeto EntregaTitulo
	 * @throws NotFoundInDBException
	 *             lançada caso não seja possível localizar a entrega de título.
	 */
	public EntregaTitulo readEntregaTitulo(Date data) throws NotFoundInDBException {
		EntregaTitulo dados = new EntregaTitulo();
		try {
			abrirSecao();
			sess.load(dados, data);
		} catch (Exception e) {
			throw new NotFoundInDBException("Entrega de títulos da data " + data
					+ " nao encontrada");
		} finally {
			fecharSecao();
		}
		return dados;
	}
	
		
	/**
	 * Abre uma conexão, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(EntregaTitulo.class);
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
	 * Grava um objeto EntregaTitulo no banco de dados. Caso o objeto já exista, este será sobreescrito.
	 * 
	 * @param EntregaTitulo A entrega de título a ser gravada no banco de dados.
	 */
	public void writeEntregaTitulo(EntregaTitulo entregaTitulo) {
		try{
				abrirSecao();
				sess.saveOrUpdate(entregaTitulo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharSecao();
		}

	}

	/**
	 * Remove um objeto EntregaTitulo do banco de dados.
	 * 
	 * @param data
	 *            A Data da entrega a ser removida.
	 * @throws NotFoundInDBException lançada se a entrega não for encontrada.
	 */
	public void removeEntregaTitulo(Date data) throws NotFoundInDBException {
		try {
			abrirSecao();
			EntregaTitulo dados = null;
			sess.load(dados, data);
			sess.delete(dados);
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}

	
	/**
	 * Lê do banco de dados uma lista contendo todas as entregas de título num determinado período.
	 * @param dataInicial a data inicial do período de interesse.
	 * @param dataFinal a data final do período de interesse.
	 * @return Lista de EntregaTitulo do período.
	 * @throws NotFoundInDBException
	 *             lançada caso não seja encontrado nenhuma entrega de título no período.
	 */
	public List<EntregaTitulo> listaDeEntregaTitulo(Date dataInicial, Date dataFinal) throws NotFoundInDBException {
		List<EntregaTitulo> dados = new ArrayList<EntregaTitulo>();
		try {
			abrirSecao();
			dados = sess.createCriteria(EntregaTitulo.class).add(Restrictions.between("data", dataInicial, dataFinal)).list();
		} catch (Exception e) {
			throw new NotFoundInDBException("Não existem estatísticas para o período solicitado.");
		} finally {
			fecharSecao();
		}
		return dados;
	}
	
	/**
	 * Gera a tabela no banco de dados que conterá os objetos EntregaTitulo. <b><u>Cuidado!</u><b>
	 * Quando a tabela é gerada, caso já exista a tabela, esta será apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(EntregaTitulo.class);
		new SchemaExport(cfg).create(true, true);
	}
	
	public static void main(String[] args) {
		new EntregaTituloDAO().generateTable();
	}
	
}

