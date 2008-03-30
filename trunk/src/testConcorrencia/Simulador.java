package testConcorrencia;

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

import java.util.Timer;
import java.util.TimerTask;

public class Simulador extends TimerTask{
	
	
	private Timer schedule;
	
	/**
	 * Cria um novo Simulador.
	 * @param tempo Tempo em milissegundos at� que a simula��o seja encerrada.
	 */
	public Simulador(int tempo) {
		schedule = new Timer();
		schedule.schedule(this, tempo);
	}

	/**
	 * Adiciona uma tarefa que deve ser repetida a cada n milissegundos.
	 * @param tarefa Tarefa a ser repetida.
	 * @param tempo tempo em milissegundos entre cada repeti��o
	 */
	public void addTarefaRepetitiva(TimerTask tarefa, int tempo){
		schedule.schedule(tarefa, 10, tempo);
	}
	
	/**
	 * Adiciona uma tarefa que ser� executada apenas uma vez, ap�s n milissegundos do momento da adi��o.
	 * @param tarefa Tarefa a ser repetida;
	 * @param tempo em milissegundos at� a tarefa seja executada.
	 */
	public void addTarefa(TimerTask tarefa, int tempo){
		schedule.schedule(tarefa, tempo);
	}

	@Override
	public void run() {
		schedule.cancel();
	}
	
	public static void main(String[] args) {
//		try {
//			Siscofi.getInstance().inicializaSistema();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Simulador simulador = new Simulador(10000);
		simulador.addTarefaRepetitiva(new ProximaSenhaTask("Geral", "01", "192.168.1.1", "joao"), 10);
		simulador.addTarefaRepetitiva(new ProximaSenhaTask("Geral", "02", "192.168.1.2", "mariana"), 10);
	}

}
