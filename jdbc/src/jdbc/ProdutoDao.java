package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

	private Connection con;

	public ProdutoDao() throws SQLException, ClassNotFoundException {
		con = Conecta.start();
	}

	public void inserirProduto(Produto prod) {

		String sql = "INSERT INTO produto VALUES(?,?,?,?)";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, prod.getCodp());
			preparador.setString(2, prod.getNomep());
			preparador.setDouble(3, prod.getPrecop());
			preparador.setInt(4, prod.getEstoquep());
			preparador.execute();
			preparador.close();

			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void deletarProduto(int codp) {

		String sql = "DELETE FROM produto WHERE codp = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, codp);
			preparador.execute();
			preparador.close();

			System.out.println("Produto deletado!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public void alterarProduto(int codp, Produto p) {

		String sql = "UPDATE produto p SET p.codp = ?, p.nomep = ?, p.precop = ?, p.estoquep = ? WHERE codp = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, p.getCodp());
			preparador.setString(2, p.getNomep());
			preparador.setDouble(3, p.getPrecop());
			preparador.setInt(4, p.getEstoquep());
			preparador.setInt(5, codp);
			preparador.execute();
			preparador.close();

			System.out.println("Produto atualizado!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public Produto getProduto(int codp) {

		Produto retorno = new Produto();
		
		String sql = "SELECT * FROM produto WHERE codp = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, codp);

			ResultSet res = preparador.executeQuery();
			
			retorno.setCodp(res.getInt("codp"));
			retorno.setNomep(res.getString("nomep"));
			retorno.setPrecop(res.getDouble("precop"));
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return retorno;
	}
	public List<Produto> listaProdutos() {

		String sql = "SELECT * FROM produtos";

		List<Produto> lista = new ArrayList<Produto>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet res = preparador.executeQuery();

		while (res.next()) {

			Produto prod = new Produto();
			
			prod.setCodp(res.getInt("codv"));
			prod.setNomep(res.getString("nomev"));
			prod.setPrecop(res.getDouble("precop"));
			prod.setEstoquep(res.getInt("estoquep"));
			
			lista.add(prod);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			}
		return lista;
	}
}

