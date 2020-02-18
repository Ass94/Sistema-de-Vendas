package br.com.vendas.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.model.Fornecedor;

@ManagedBean (name = "FornecedorIncluirBean")
@ViewScoped
public class FornecedorIncluirBean {
	
	private String acao;
	private Long codigo;
	private Fornecedor fornecedor;

	
	public FornecedorIncluirBean() {
	}
	
	public void salvar() {
		FornecedorDao fdao = new FornecedorDao();
		fdao.salvar(fornecedor);
		fornecedor = new Fornecedor();
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
