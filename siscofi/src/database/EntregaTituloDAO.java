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
 * CCT -  CENTRO DE CI�NCIA E TECNOLOGIA
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

	// Sess�o utilizada nas manipula��es do banco de dados
	private Session sess;

	// Transa��o da sess�o
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * L� do banco de dados um objeto EntregaTitulo.
	 * @param data A data da entrega de t�tulo a ser lida.
	 * @return objeto EntregaTitulo
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja poss�vel localizar a entrega de t�tulo.
	 */
	public EntregaTitulo readEntregaTitulo(Date data) throws NotFoundInDBException {
		EntregaTitulo dados = new EntregaTitulo();
		try {
			abrirSecao();
			sess.load(dados, data);
		} catch (Exception e) {
			throw new NotFoundInDBException("Entrega de t�tulos da data " + data
					+ " nao encontrada");
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
		cfg.addAnnotatedClass(EntregaTitulo.class);
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
	 * Grava um objeto EntregaTitulo no banco de dados. Caso o objeto j� exista, este ser� sobreescrito.
	 * 
	 * @param EntregaTitulo A entrega de t�tulo a ser gravada no banco de dados.
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
	 * @throws NotFoundInDBException lan�ada se a entrega n�o for encontrada.
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
	 * L� do banco de dados uma lista contendo todas as entregas de t�tulo num determinado per�odo.
	 * @param dataInicial a data inicial do per�odo de interesse.
	 * @param dataFinal a data final do per�odo de interesse.
	 * @return Lista de EntregaTitulo do per�odo.
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja encontrado nenhuma entrega de t�tulo no per�odo.
	 */
	public List<EntregaTitulo> listaDeEntregaTitulo(Date dataInicial, Date dataFinal) throws NotFoundInDBException {
		List<EntregaTitulo> dados = new ArrayList<EntregaTitulo>();
		try {
			abrirSecao();
			dados = sess.createCriteria(EntregaTitulo.class).add(Restrictions.between("data", dataInicial, dataFinal)).list();
		} catch (Exception e) {
			throw new NotFoundInDBException("N�o existem estat�sticas para o per�odo solicitado.");
		} finally {
			fecharSecao();
		}
		return dados;
	}
	
	/**
	 * Gera a tabela no banco de dados que conter� os objetos EntregaTitulo. <b><u>Cuidado!</u><b>
	 * Quando a tabela � gerada, caso j� exista a tabela, esta ser� apagada,
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

