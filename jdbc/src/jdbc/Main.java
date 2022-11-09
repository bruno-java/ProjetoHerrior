package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private void menu() throws ClassNotFoundException, SQLException {
		
		System.out.println("Iniciando Menu :");
		System.out.println("Deseja Alterar Produto 1, venda 2, vendedor 3");
		Scanner meuScanner = new Scanner(System.in);
		int escolha = meuScanner.nextInt();
		if (escolha == 1) {
			System.out.println("Deseja Excluir Produto 1, Cadastar Produto 2, Listrar Produto 3 :");
			int escolhaProduto = meuScanner.nextInt();
			if (escolhaProduto == 1) {
				System.out.println("Digite o Numero do Produto :");
				int codProduto = meuScanner.nextInt();
               this.excluirProduto(codProduto);				
			} else if(escolhaProduto == 2) {
				this.cadastrarProduto();
			} else if(escolhaProduto == 3) {
				this.listarProduto();
			}
		
			
		} else if(escolha == 2) {
			
		 System.out.println();
		 
		} else if(escolha == 3) {
			
			System.out.println();
			
		}
}
	private void cadastrarProduto()  throws ClassNotFoundException, SQLException {
		
		Scanner meuScanner = new Scanner(System.in);
		String cadastrarProduto = meuScanner.nextLine();
		System.out.println("Digite as informações do produto :");
		System.out.println("Digite o código do produto :");
		
		int codp = meuScanner.nextInt();
		System.out.println("Digite o nome do produto :");
		String nomep = meuScanner.nextLine();
		System.out.println("Digite o Valor do produto :");
		double precop = meuScanner.nextDouble();
		System.out.println("Qual estoque do produto :");
		int estoquep = meuScanner.nextInt();
		Produto produto = new Produto();
		produto.setNomep(nomep);
		produto.setPrecop(precop);
		produto.setEstoquep(estoquep);
		ProdutoDao produtodao = new ProdutoDao();
	    produtodao.inserirProduto(produto);
	    System.out.println("Produto cadastrado :");
	}
	
        public void listarProduto() throws ClassNotFoundException, SQLException {
        	System.out.println("Listar Produtos :");
        	ProdutoDao produtodao = new ProdutoDao();
        	produtodao.listaProdutos().forEach(p -> System.out.println(p));
        	
        }  	
        
	
    private void excluirProduto(int codProduto) throws ClassNotFoundException, SQLException {
    	
    	System.out.println("Excluir Vendas");
    	VendaDao vendadao = new VendaDao();
    	vendadao.deletarVenda(codProduto);
    }
    
	private void cadastrarVenda() throws ClassNotFoundException, SQLException {
		
		Scanner meuScanner = new Scanner(System.in);
		String cadastrarProduto = meuScanner.nextLine();
		System.out.println("Digite as informações do produto :");
		System.out.println("Digite o código do produto :");
		
		int nf = meuScanner.nextInt();
		System.out.println("Digite o nome da Venda :");
		String nomep = meuScanner.nextLine();
		System.out.println("Digite o Valor da Venda :");
		double precop = meuScanner.nextDouble();
		System.out.println("Qual o Nome do Vendedor :");
		
		Scanner vendaScanner = new Scanner(System.in);
		int codVendedor = vendaScanner.nextInt();
		int codProduto = vendaScanner.nextInt();
		double valorVenda = vendaScanner.nextDouble();
		int qtdProduto = vendaScanner.nextInt();
		String dtVenda = vendaScanner.nextLine();
		Venda venda = new Venda();
		venda.setCodvendedor(codVendedor);
		venda.setCodproduto(codProduto);
		venda.setValorvenda(valorVenda);
		venda.setQtdproduto(qtdProduto);
		venda.setDtvenda(dtVenda);
		
		
		VendaDao vendatodao = new VendaDao();
	    vendatodao.inserirVenda(venda);
	    System.out.println("Venda Efetuada :");
	}
		
	
	
	private void cadastrarVendedor()  throws ClassNotFoundException, SQLException {
		
		Scanner meuScanner = new Scanner(System.in);
		String cadastrarVendor = meuScanner.nextLine();
		System.out.println("Digite Nome do Vendedor :");
		int codv = meuScanner.nextInt();
		System.out.println("Digite o codigo do vendedor :");
		String nomev = meuScanner.nextLine();
		System.out.println("Digite o nome do vendedor :");
		int cpf = meuScanner.nextInt();
		System.out.println("Cpf :");
		String endereco = meuScanner.nextLine();
		System.out.println("Qual endereço? ");
		String sexo = meuScanner.nextLine();
		System.out.println("Qual o Sexo?");
		Vendedor vendedor = new Vendedor();
		vendedor.setCodv(codv);
		vendedor.setNomev(nomev);
		vendedor.setCpf(cpf);
		vendedor.setEndereco(endereco);
		vendedor.setSexo(sexo);
		
		VendedorDao vendedordao = new VendedorDao();
		vendedordao.inserirVendedor(vendedor);
	    System.out.println("Vendedor Cadastrado :");
		}
		
	public static void main(String[] args) {
		try {
			Connection con = Conecta.start();
			Main main = new Main();
			main.menu();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}