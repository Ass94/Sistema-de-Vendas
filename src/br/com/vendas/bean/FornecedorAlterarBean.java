package br.com.vendas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.model.Fornecedor;

@ManagedBean (name = "FornecedorAlterarBean")
@ViewScoped
public class FornecedorAlterarBean {
	
	private String acao;
	private Long codigo;
	private Fornecedor fornecedor;

	
	public FornecedorAlterarBean() {
	}
	
	public void carregar() {
		if (codigo != null) {
			FornecedorDao fdao = new FornecedorDao();
			fornecedor = fdao.buscarPorId(codigo);
		} else {
			fornecedor = new Fornecedor();
		}
	}
	
	public void alterar() {
		FornecedorDao fdao = new FornecedorDao();
		fdao.alterar(fornecedor);
		fornecedor = new Fornecedor();
	}
	
	public void excluir() {
		
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Fornecedor getFornecedor() {
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
		}
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	


}
