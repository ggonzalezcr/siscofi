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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import database.bean.Formulario;

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
 * Classe que testa a classe Formulario
 * 
 * @author Carlos trajano
 * @author Hamon Barros Henriques
 * @author Rodrigo Lopes
 * 
 * @version 1.0
 */

public class TestaFormulario extends TestCase {

	private Formulario fm1;
	private Formulario fm2;
	
	
	public TestaFormulario(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		fm1 = new Formulario();
		fm2 = new Formulario();
	}

	/**
	 * Metodo que retorna uma suite de teste para a classe Formulario
	 * @return uma suite de teste.
	 */
	public static Test suite() {
		return new TestSuite(TestaAtendimento.class);
	}

	/**
	 * Test method for {@link database.bean.Formulario#getAlternativas1()}.
	 */
	public void testGetAlternativas1() {
		assertEquals("péssima" , fm1.getAlternativas1()[0]);
		assertEquals("ruim" , fm1.getAlternativas1()[1]);
		assertEquals("razoável" , fm1.getAlternativas1()[2]);
		assertEquals("boa" , fm1.getAlternativas1()[3]);
		assertEquals("execelente" , fm1.getAlternativas1()[4]);
	}

	/**
	 * Test method for {@link database.bean.Formulario#getAlternativas2()}.
	 */
	public void testGetAlternativas2() {
		assertEquals("nunca", fm1.getAlternativas2()[0]);
		assertEquals("raramente", fm1.getAlternativas2()[1]);
		assertEquals("às vezes", fm1.getAlternativas2()[2]);
		assertEquals("maior parte do tempo", fm1.getAlternativas2()[3]);
		assertEquals("o tempo todo", fm1.getAlternativas2()[4]);
	}

	/**
	 * Test method for {@link database.bean.Formulario#getAlternativas3()}.
	 */
	public void testGetAlternativas3() {
		assertEquals("nenhum  conhecimento", fm1.getAlternativas3()[0]);
		assertEquals("pouco", fm1.getAlternativas3()[1]);
		assertEquals("algum", fm1.getAlternativas3()[2]);
		assertEquals("muito", fm1.getAlternativas3()[3]);
		assertEquals("total", fm1.getAlternativas3()[4]);
	}

	/**
	 * Test method for {@link database.bean.Formulario#getAlternativas4()}.
	 */
	public void testGetAlternativas4() {
		assertEquals("não sabia que precisava trazer documentos", fm1.getAlternativas4()[0]);
		assertEquals("tinha ouvido falar de algum", fm1.getAlternativas4()[1]);
		assertEquals("mais ou menos", fm1.getAlternativas4()[2]);
		assertEquals("sabia, mas tinha alguma dúvida", fm1.getAlternativas4()[3]);
		assertEquals("sabia de todos com segurança", fm1.getAlternativas4()[4]);
	}

	/**
	 * Test method for {@link database.bean.Formulario#getAlternativas5()}.
	 */
	public void testGetAlternativas5() {
		assertEquals("péssima" , fm1.getAlternativas5()[0]);
		assertEquals("ruim" , fm1.getAlternativas5()[1]);
		assertEquals("razoável" , fm1.getAlternativas5()[2]);
		assertEquals("boa" , fm1.getAlternativas5()[3]);
		assertEquals("execelente" , fm1.getAlternativas5()[4]);
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao1()}.
	 */
	public void testGetQuestao1() {
		assertEquals("Quanto a cordialidade dos servidores no atendimento você consideraria:", fm1.getQuestao1());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao2()}.
	 */
	public void testGetQuestao2() {
		assertEquals("Durante o processo de atendimento você esteve orientado sobre o que fazer e quais seriam os próximos passos?", fm1.getQuestao2());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao3()}.
	 */
	public void testGetQuestao3() {
		assertEquals("Os servidores que lhe atenderam demonstraram conhecimento das funções que desempenhavam", fm1.getQuestao3());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao4()}.
	 */
	public void testGetQuestao4() {
		assertEquals("Quando saiu de casa, você já sabia quais os documentos que precisava trazer para receber o atendimento?", fm1.getQuestao4());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao5()}.
	 */
	public void testGetQuestao5() {
		assertEquals("A estrutura do local de atendimento (acesso, local espera, guichês, entrega de título, sistema de senhas, etc...)  lhe pareceu", fm1.getQuestao5());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao6()}.
	 */
	public void testGetQuestao6() {
		assertEquals("Qual a melhor e a pior parte do atendimento que você recebeu em todo processo que passou na Central?", fm1.getQuestao6());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getQuestao7()}.
	 */
	public void testGetQuestao7() {
		assertEquals("Há algum fato especial ocorrido durante o atendimento que gostaria de deixar registrado?", fm1.getQuestao7());
	}

	/**
	 * Test method for {@link database.bean.Formulario#getFormulario()}.
	 */
	public void testGetFormulario() {
		fm1 = Formulario.getFormulario();
		assertEquals("pessima", fm1.getAlternativas1()[0]);
	}

}
