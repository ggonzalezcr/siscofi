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
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import database.bean.Controle;
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
 * Classe que manipula um controle no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class ControleDAO {

	// Sess�o utilizada nas manipula��es do banco de dados
	private Session sess;

	// Transa��o da sess�o
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * L� do banco de dados um objeto Controle
	 * 
	 * @param classe
	 *            A classe de atendimento do controle a ser lido.
	 * @return O controle com a classe de atendimento especificada.
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja poss�vel localiza um controle para a
	 *             classe especificada.
	 */
	public Controle readControle(String classe) throws NotFoundInDBException {
		Controle controle = new Controle();
		try {
			abrirSecao();
			sess.load(controle, classe);
		} catch (Exception e) {
			throw new NotFoundInDBException("controle de " + classe
					+ " nao encontrado");
		} finally {
			fecharSecao();
		}
		return controle;
	}
		
	/**
	 * Abre uma conex�o, criando um Session e uma Transaction.
	 */
	private void abrirSecao() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Controle.class);
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
	 * Grava um objeto Controle no banco de dados. Caso j� exista um controle da
	 * mesma classe de atendimento, este ser� sobreescrito.
	 * 
	 * @param controle
	 * @throws ServletException 
	 */
	public void writeControle(Controle controle) throws ServletException {
		try{
				abrirSecao();
				sess.saveOrUpdate(controle);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			fecharSecao();
		}

	}

	/**
	 * Remove um objeto controle do banco de dados.
	 * 
	 * @param classe
	 *            A classe de atendimento do controle a ser removida.
	 * @throws NotFoundInDBException
	 */
	public void removeControle(String classe) throws NotFoundInDBException {
		try {
			abrirSecao();
			Controle controle = new Controle();
			sess.load(controle, classe);
			sess.delete(controle);
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}

	/**
	 * Lista todas as classes de atendimento que existem no banco de dados.
	 * 
	 * @return Lista de classes.
	 */
	public List<String> listaClasses() {
		List<String> listaClasses = new ArrayList<String>();
		try {
			abrirSecao();
			List<Controle> listaControle = sess.createCriteria(Controle.class).list();
			for (Controle controle : listaControle) {
				listaClasses.add(controle.getClasse());
			}
		} finally {
			fecharSecao();
		}
		Collections.sort(listaClasses);
		return listaClasses;
	}

	/**
	 * Metodo que retona uma lista contendo os controles instanciados
	 * pelo sistema
	 * @return a lista dos controles instanciados pelo sistema
	 * @throws ServletException 
	 */
	public List<Controle> listaControles() throws ServletException {
		List<Controle> listaControle = new ArrayList<Controle>();
		try {
			abrirSecao();
			listaControle = sess.createCriteria(Controle.class).list();
			Collections.sort(listaControle);
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			fecharSecao();
		}
		return listaControle;
	}

	/**
	 * Gera a tabela no banco de dados que conter� os objetos controle. <b><u>Cuidado!</u><b>
	 * Quando a tabela � gerada, caso j� exista a tabela, esta ser� apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(database.bean.Controle.class);
		new SchemaExport(cfg).create(true, true);
	}
	
	/**
	 * Metodo que inicializa o sistema adicionando a quantidade
	 * inicial de cada classe.
	 * @return A lista de todos os controles do banco
	 * @throws ServletException 
	 */
	public List<Controle> inicializaSistema() throws ServletException {
		List<Controle> lista = this.listaControles();
		for(Controle l : lista){
			l.setQuantidade(l.getQuantidadeInicial());
			l.setUltimoGuiche(" ");
			this.writeControle(l);
		}
		return lista;
	}
	
	/**
	 * Metodo que finaliza o sistema zerando a ultima senha, 
	 * a quantidade e o ultimo guich�. 
	 * @throws ServletException 
	 */
	public void finalizaSistema() throws ServletException {
		List<Controle> lista = this.listaControles();
		for(Controle l : lista){
			l.setQuantidade(0);
			l.setUltimaSenha(0);
			l.setUltimoGuiche("");
			this.writeControle(l);
		}
	}

}
