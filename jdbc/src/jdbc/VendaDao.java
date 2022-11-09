package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDao {

	private Connection con;

	public VendaDao() throws SQLException, ClassNotFoundException {
		con = Conecta.start();
	}

	public void inserirVenda(Venda v) {

		String sql = "INSERT INTO venda VALUES(?,?,?,?,?,?)";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, v.getNf());
			preparador.setInt(2, v.getCodvendedor());
			preparador.setInt(3, v.getCodproduto());
			preparador.setDouble(4, v.getValorvenda());
			preparador.setInt(5, v.getQtdproduto());
			preparador.setString(6, v.getDtvenda());
			preparador.execute();
			preparador.close();

			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}

	public void deletarVenda(int nf) {

		String sql = "DELETE FROM venda WHERE nf = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, nf);
			preparador.execute();
			preparador.close();

			System.out.println("Venda deletada!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public void alterarVenda(int nf, Venda v) {

		String sql = "UPDATE venda SET nf = ?, codvendedor = ?, codproduto = ?, valorvenda = ?, qtdproduto = ?, dtvenda = ? WHERE nf = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, v.getNf());
			preparador.setInt(2, v.getCodvendedor());
			preparador.setInt(3, v.getCodproduto());
			preparador.setDouble(4, v.getValorvenda());
			preparador.setInt(5, v.getQtdproduto());
			preparador.setString(6, v.getDtvenda());
			preparador.setInt(7, nf);
			preparador.execute();
			preparador.close();

			System.out.println("Venda atualizada!");
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
	}
	public Venda getVenda(int nf) {

		Venda retorno = new Venda();
		
		String sql = "SELECT * FROM venda WHERE nf = ?";
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setInt(1, nf);

			ResultSet res = preparador.executeQuery();
			
			retorno.setNf(res.getInt("nf"));
			retorno.setCodvendedor(res.getInt("codvendedor"));
			retorno.setCodproduto(res.getInt("codproduto"));
			retorno.setQtdproduto(res.getInt("qtdproduto"));
			retorno.setValorvenda(res.getDouble("valorvenda"));
			retorno.setDtvenda(res.getString("dtvenda"));
			
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
		}
		return retorno;
	}
	public List<Venda> listaVendas() {

		String sql = "SELECT * FROM vendas";

		List<Venda> lista = new ArrayList<Venda>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet res = preparador.executeQuery();

		while (res.next()) {

			Venda v = new Venda();
			
			v.setNf(res.getInt("nf"));
			v.setCodvendedor(res.getInt("codvendedor"));
			v.setCodproduto(res.getInt("codproduto"));
			v.setQtdproduto(res.getInt("qtdproduto"));
			v.setValorvenda(res.getDouble("valorvenda"));
			v.setDtvenda(res.getString("dtvenda"));
			
			lista.add(v);
			}
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			}
		return lista;
	}
}

