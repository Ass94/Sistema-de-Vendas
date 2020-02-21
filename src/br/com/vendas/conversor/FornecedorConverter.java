package br.com.vendas.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.model.Fornecedor;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {

		try {
			Long codigo = Long.parseLong(valor);
			FornecedorDao fdao = new FornecedorDao();
			Fornecedor fornecedor = fdao.buscarPorId(codigo);
			return fornecedor;
		} catch (RuntimeException e) {
			e.getMessage();
			return null;
		}
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {
		
		try {
			Fornecedor fornecedor = (Fornecedor) objeto;
			Long codigo = fornecedor.getId();
			return codigo.toString();
		} catch (RuntimeException e) {
			e.getMessage();
			return null;
		}
	}
	

}
