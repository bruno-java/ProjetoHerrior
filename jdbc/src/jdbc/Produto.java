package jdbc;

public class Produto {
	private int codp;
	private String nomep;
	private double precop;
	private int estoquep;
	public int getEstoquep() {
		return estoquep;
	}
	public void setEstoquep(int estoquep) {
		this.estoquep = estoquep;
	}
	public int getCodp() {
		return codp;
	}
	public void setCodp(int codp) {
		this.codp = codp;
	}
	public String getNomep() {
		return nomep;
	}
	public void setNomep(String nomep) {
		this.nomep = nomep;
	}
	public double getPrecop() {
		return precop;
	}
	public void setPrecop(double precop) {
		this.precop = precop;
	}
}
