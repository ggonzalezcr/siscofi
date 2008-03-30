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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import util.DataUtil;
import database.DadosAtendimentoDAO;
import estatisticas.atendimento.DadosAtendimento;
import exceptions.NotFoundInDBException;

public class TestaDadosAtendimentoDAO extends TestCase {

	private DadosAtendimentoDAO da;
	private DadosAtendimento dat1, dat2;
	private Date data1, data2;
	private List<DadosAtendimento> listagem;

	@Override
	protected void setUp() throws Exception {
		da = new DadosAtendimentoDAO();
		listagem = new ArrayList<DadosAtendimento>();
		data1 = DataUtil.gerarData("01", "02", "2001");
		data2 = DataUtil.gerarData("01", "02", "2002");
		dat1 = new DadosAtendimento();
		dat2 = new DadosAtendimento();
		dat1.setData(data1);
		dat2.setData(data2);
		listagem.add(dat1);
		listagem.add(dat2);
		dat1.setTotalAtendimentos(150);
		dat2.setTotalAtendimentos(10);
		dat1.setTempoMedio(0.0);
		dat2.setTempoMedio(0.0);
		dat1.atualizaContagem(01, "joaoe", "ABC");
		dat2.atualizaContagem(01, "marianaa", "ABC");
		da.writeDadosAtendimento(dat1);
		da.writeDadosAtendimento(dat2);
	}

	public void testReadDadosAtendimento() {
		try {
			assertEquals(dat1.toString(), da.readDadosAtendimento(data1).toString());
			assertEquals(dat2.toString(), da.readDadosAtendimento(data2).toString());
			dat2.setData(data1);
			da.writeDadosAtendimento(dat2);
			assertEquals(dat2.toString(), da.readDadosAtendimento(data1).toString());
		} catch (NotFoundInDBException e) {
			fail("erro inesperado");
		}

	}

	public void testWriteDadosAtendimento() {
		try {
			dat2.setData(data1);
			da.writeDadosAtendimento(dat2);
			assertEquals(dat2.getData(), da.readDadosAtendimento(data1).getData());
			Date data3= DataUtil.gerarData("25", "12", "2004");
			DadosAtendimento dat3 = new DadosAtendimento();
			dat3.atualizaContagem(00, "john joe", ":)");
			dat3.setData(data3);
			da.writeDadosAtendimento(dat3);
			assertEquals(dat3.getData(), da.readDadosAtendimento(data3).getData());

		} catch (NotFoundInDBException e) {
			fail("erro inesperado");
		}
	}

	public void testRemoveDadosAtendimento() {
		
	}

	public void testListaDeDadosAtendimento() {
		try {
			List<DadosAtendimento> atendimentos = da.listaDeDadosAtendimento(data1, data2);
			assertTrue(atendimentos.size() == 2);
		} catch (NotFoundInDBException e) {
			fail("erro inesperado");
		}
	}
	
}
