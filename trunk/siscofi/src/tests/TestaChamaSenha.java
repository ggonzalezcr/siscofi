package tests;

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
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
 * CCT -  CENTRO DE CIÊNCIA E TECNOLOGIA
 * DSC -  DEPARTAMENTO DE SISTEMAS E COMPUTACAO
 * DISCIPLINA - PROJETO 1
 * PROJETO: SISCOFI - SISTEMA DE CONTROLE DE FILAS
 * ALUNOS:  CARLOS TRAJANO DE OLIVEIRA
 * 			HAMON BARROS HENRIQUES
 * 			RODRIGO LOPES
 */

/**
 * Classe que testa a lógica de chamar um próximo eleitor
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
	 * Testa a lógica de chamar um próximo eleitor
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
			fail("Falha na conexão!");
		} catch (ServletException e) {
			e.printStackTrace();
			fail("Falha na conexão!");
		} finally {
			dao.removeControle(controle.getClasse());
		}
	}

}
