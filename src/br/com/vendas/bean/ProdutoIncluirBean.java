package br.com.vendas.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.dao.FornecedorDao;
import br.com.vendas.dao.ProdutoDao;
import br.com.vendas.model.Fornecedor;
import br.com.vendas.model.Produto;

@ManagedBean (name = "ProdutoIncluirBean")
@ViewScoped
public class ProdutoIncluirBean {
	
	private Produto produto;

	private List<Fornecedor> fornecedores;
	
	public ProdutoIncluirBean() {
	}
	
	public void carregar() {
		FornecedorDao fdao = new FornecedorDao();
		fornecedores = fdao.listar();
	}
	
	public void salvar() {
		ProdutoDao pdao = new ProdutoDao();
		pdao.salvar(produto);
		produto = new Produto();
		
	}
	
	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
}
