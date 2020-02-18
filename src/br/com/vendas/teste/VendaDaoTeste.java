package br.com.vendas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.vendas.dao.VendaDao;
import br.com.vendas.model.Funcionario;
import br.com.vendas.model.Venda;

public class VendaDaoTeste {
	
	public static void main(String[] args) {
		
		
		Funcionario funcionario = new Funcionario("Alice", "41816275828", "@123456", "Analista");
		funcionario.setId(1L);
		
		Venda venda = new Venda();
		
		Calendar data = Calendar.getInstance();
		data.getTimeZone();
		
		venda.setHorario(data);
		venda.setValorTotal(new BigDecimal(80.00));
		venda.setFuncionario(funcionario);
		new VendaDao().salvar(venda);
		System.out.println("Venda Salva com sucesso!");
	}

}
