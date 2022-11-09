package jdbc;

public class Venda {
	private int nf;
	private int codvendedor;
	private int codproduto;
	private double valorvenda;
	private int qtdproduto;
	private String dtvenda;
	public int getNf() {
		return nf;
	}
	public void setNf(int nf) {
		this.nf = nf;
	}
	public int getCodvendedor() {
		return codvendedor;
	}
	public void setCodvendedor(int codvendedor) {
		this.codvendedor = codvendedor;
	}
	public int getCodproduto() {
		return codproduto;
	}
	public void setCodproduto(int codproduto) {
		this.codproduto = codproduto;
	}
	public double getValorvenda() {
		return valorvenda;
	}
	public void setValorvenda(double valorvenda) {
		this.valorvenda = valorvenda;
	}
	public int getQtdproduto() {
		return qtdproduto;
	}
	public void setQtdproduto(int qtdproduto) {
		this.qtdproduto = qtdproduto;
	}
	public String getDtvenda() {
		return dtvenda;
	}
	public void setDtvenda(String dtvenda) {
		this.dtvenda = dtvenda;
	}
}
