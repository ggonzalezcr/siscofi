package tests;

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
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import javax.servlet.ServletException;

import junit.framework.TestCase;
import database.ControleDAO;
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
 * 			RODRIGO LOPES
 */

/**
 * Classe que testa a l�gica de chamar um pr�ximo eleitor
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */
public class TestaChamaSenha extends TestCase {

	ControleDAO dao = null;
	Controle controle;

	/**
	 * Construtor
	 * 
	 * @param name
	 */
	public TestaChamaSenha(String name) {
		super(name);
		dao = new ControleDAO();
	}

	protected void setUp() throws Exception {
		super.setUp();
		controle = new Controle();
		controle.setClasse("abc");
		controle.setPrefixo("aaa");
		controle.setQuantidade(10);
		controle.setUltimaSenha(2);
		dao.writeControle(controle);
	}

	/**
	 * Testa a l�gica de chamar um pr�ximo eleitor
	 * @throws NotFoundInDBException 
	 */
	public void testChamaProximo() throws NotFoundInDBException {
		try {
			Controle controle = dao.readControle("abc");
			int quantidadeAnterior = controle.getQuantidade();
			if (controle.avancar(controle.getClasse())) {
				int quantidadeFinal = controle.getQuantidade();
				String ultimoFinal = controle.getSenha();
				dao.writeControle(controle);
				assertEquals(quantidadeAnterior - 1, quantidadeFinal);
				assertEquals("AAA 03", ultimoFinal);
			}
		} catch (NotFoundInDBException e) {
			e.printStackTrace();
			fail("Falha na conex�o!");
		} catch (ServletException e) {
			e.printStackTrace();
			fail("Falha na conex�o!");
		} finally {
			dao.removeControle(controle.getClasse());
		}
	}

}
