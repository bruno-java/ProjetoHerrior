package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao {

	private Connection con;

	public VendedorDao() throws SQLException, ClassNotFoundException {
		con = Conecta.start();
	}

	public void inserirVendedor(Vendedor emp) {

		String sql = "INSERT INTO vendedor VALUES(?,?,?,?)";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, emp.getCodv());
			preparador.setString(2, emp.getNomev());
			preparador.setString(3, emp.getEndereco());
			preparador.setString(4, emp.getSexo());
			preparador.execute();
			preparador.close();

			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void deletarVendedor(int codv) {

		String sql = "DELETE FROM vendedor WHERE codv = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, codv);
			preparador.execute();
			preparador.close();

			System.out.println("Vendedor deletado!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public void alterarVendedor(int codv, Vendedor v) {

		String sql = "UPDATE vendedor v SET v.codv = ?, v.nomev = ?, v.cpf = ?, v.endereco = ?, v.sexo = ? WHERE codv = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, v.getCodv());
			preparador.setString(2, v.getNomev());
			preparador.setInt(3, v.getCpf());
			preparador.setString(4, v.getEndereco());
			preparador.setString(5, v.getSexo());
			preparador.setInt(6, codv);
			preparador.execute();
			preparador.close();

			System.out.println("Vendedor atualizado!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public Vendedor getVendedor(int codv) {

		Vendedor retorno = new Vendedor();
		
		String sql = "SELECT * FROM vendedor WHERE codv = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, codv);

			ResultSet res = preparador.executeQuery();
			
			retorno.setCodv(res.getInt("codv"));
			retorno.setNomev(res.getString("nomev"));
			retorno.setEndereco(res.getString("endereco"));
			retorno.setCpf(res.getInt("cpf"));
			retorno.setSexo(res.getString("sexo"));
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return retorno;
	}
	public List<Vendedor> listaVendedores() {

		String sql = "SELECT * FROM vendedor";

		List<Vendedor> lista = new ArrayList<Vendedor>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet res = preparador.executeQuery();

		while (res.next()) {

			Vendedor emp2 = new Vendedor();
			
			emp2.setCodv(res.getInt("codv"));
			emp2.setNomev(res.getString("nomev"));
			emp2.setEndereco(res.getString("endereco"));
			emp2.setCpf(res.getInt("cpf"));
			emp2.setSexo(res.getString("sexo"));
			
			lista.add(emp2);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			}
		return lista;
	}
}