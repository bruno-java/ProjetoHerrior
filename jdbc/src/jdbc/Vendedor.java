package jdbc;

public class Vendedor {
	
	private int codv;
	private String nomev;
	private int cpf;
	private String endereco;
	private String sexo;
	public int getCodv() {
		return codv;
	}
	public void setCodv(int codv) {
		this.codv = codv;
	}
	public String getNomev() {
		return nomev;
	}
	public void setNomev(String nomev) {
		this.nomev = nomev;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
