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
 *
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
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

import coletaDados.TempoAvaliacao;
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
 * Classe que manipula objetos TempoAvaliacao no banco de dados.
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes da Silva
 * 
 * @version 1.0
 */

public class TempoAvaliacaoDAO {

	// Sess�o utilizada nas manipula��es do banco de dados
	private Session sess;

	// Transa��o da sess�o
	private Transaction trans;

	// Factory de session
	private SessionFactory factory;

	/**
	 * L� do banco de dados um objeto TempoAvalia��o.
	 * @param data A data e a hora em que foi coletado o dado.
	 * @return objeto TempoAvaliacao
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja poss�vel localizar a Avaliacao.
	 */
	public TempoAvaliacao readTempoAvaliacao(Date data) throws NotFoundInDBException {
		TempoAvaliacao dados = new TempoAvaliacao();
		try {
			abrirSecao();
			sess.load(dados, data);
		} catch (Exception e) {
			throw new NotFoundInDBException("Avaliacao " + data
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
		cfg.addAnnotatedClass(TempoAvaliacao.class);
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
	 * Grava um objeto TempoAvaliacao no banco de dados. Caso o objeto j� exista, este ser� sobreescrito.
	 * 
	 * @param tempoAvaliacao O tempo de Avaliacao a ser gravada no banco de dados.
	 */
	public void writeTempoAvaliacao(TempoAvaliacao tempoAvaliacao) {
		try{
				abrirSecao();
				sess.saveOrUpdate(tempoAvaliacao);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharSecao();
		}

	}

	/**
	 * Remove um objeto TempoAvalicao do banco de dados.
	 * 
	 * @param data
	 *            A Data/Hora do tempoAvaliacao a ser removido.
	 * @throws NotFoundInDBException lan�ada se a tempoAvaliacao n�o for encontrado.
	 */
	public void removeTempoAvaliacao(Date data) throws NotFoundInDBException {
		try {
			abrirSecao();
			TempoAvaliacao dados = new TempoAvaliacao();
			sess.load(dados, data);
			sess.delete(dados);
			fecharSecao();
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
		}
	}

	
	/**
	 * L� do banco de dados uma lista contendo todas as temposDeAvaliacao num determinado per�odo.
	 * @param dataInicial a data inicial do per�odo de interesse.
	 * @param dataFinal a data final do per�odo de interesse.
	 * @return Lista de tempoAvaliacao do per�odo.
	 * @throws NotFoundInDBException
	 *             lan�ada caso n�o seja encontrado nenhuma tempoAvaliacao no per�odo.
	 */
	public List<TempoAvaliacao> listaDeTempoAvaliacao(Date dataInicial, Date dataFinal) throws NotFoundInDBException {
		List<TempoAvaliacao> dados = new ArrayList<TempoAvaliacao>();
		try {
			abrirSecao();
			dados = sess.createCriteria(TempoAvaliacao.class).add(Restrictions.between("dataAtual", dataInicial, dataFinal)).list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new NotFoundInDBException("N�o existem estat�sticas para o per�odo solicitado.");
		} finally {
			fecharSecao();
		}
		return dados;
	}
	
	/**
	 * Gera a tabela no banco de dados que conter� os objetos TempoAvaliacao. <b><u>Cuidado!</u><b>
	 * Quando a tabela � gerada, caso j� exista a tabela, esta ser� apagada,
	 * <u>perdendo</u> todos os dados.
	 */
	public void generateTable() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(coletaDados.TempoAvaliacao.class);
		new SchemaExport(cfg).create(true, true);
	}
}
