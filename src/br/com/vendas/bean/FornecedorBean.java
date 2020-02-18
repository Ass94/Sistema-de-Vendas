package br.com.vendas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.model.Fornecedor;

@ManagedBean(name = "FornecedorBean")
@ViewScoped
public class FornecedorBean {

	private String acao;
	private Long codigo;
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;

	public FornecedorBean() {

	}

	public void carregar() {
		FornecedorDao fdao = new FornecedorDao();
		fornecedores = fdao.listar();
	}

	public void novo() {
		this.fornecedor = new Fornecedor();
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

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
