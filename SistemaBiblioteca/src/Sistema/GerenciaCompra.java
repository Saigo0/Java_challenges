package Sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciaCompra {
    static Scanner s = new Scanner(System.in);
    private static int cod = 1;
    private int id;
    private boolean status;
    private ArrayList<Livro> livros;
    private ArrayList<Equipamento> equipamentos;

    public GerenciaCompra() {
        this.setId();
        livros = new ArrayList<Livro>();
        equipamentos = new ArrayList<Equipamento>();
    }

    public boolean realizaPedidoCompra(GerenciaCompra compra, Produto produto, Fornecedor fornecedor) {
        if (produto instanceof Livro livro) {
            return realizaPedidoCompraLivro(compra, fornecedor);
        } else {
            return realizaPedidoCompraEquipamento(compra, fornecedor);
        }
    }

    private boolean realizaPedidoCompraLivro(GerenciaCompra compra, Fornecedor fonecedor) {
        if (compra.getLivros() == null) {
            return false;
        }

        if (calculaSubTotalLivros(compra) > 0) {
            System.out.println("O subtotal da compra foi de " + calculaSubTotalLivros(compra) + " reais! Deseja prosseguir?");
            String resposta = s.next();
            if (resposta.equalsIgnoreCase("Sim")) {
                if (verificaDisponibilidadeLivros(compra, fonecedor)) {
                    for (Livro livro : compra.getLivros()) {
                        GerenciaLivros.tornarDisponivel(livro, Biblioteca.getInstancia());
                        Biblioteca.getInstancia().addLivros(livro);
                    }
                    System.out.println("Compra de livro's realizada com sucesso!");
                    return true;
                    //Realizar a compra, alterar o status da compra, add à uma lista de compras, add aos livros da biblioteca e aos livros disponíveis
                }
                return false;
            }
        }
        return false;
    }

    private boolean realizaPedidoCompraEquipamento(GerenciaCompra compra, Fornecedor fornecedor) {
        if (compra.getEquipamentos() == null) {
            return false;
        }

        if (verificaDisponibilidadeEquipamentos(compra, fornecedor)) {
            for (Equipamento equipamento : compra.getEquipamentos()) {
                //.tornarDisponivel(livro, Biblioteca.getInstancia());
            }
            System.out.println("Compra de equipamento's realizada com sucesso!");
            return true;
            //Realizar a compra, alterar o status da compra, add à uma lista de compras
        }
        return false;
    }

    private boolean verificaDisponibilidadeLivros(GerenciaCompra compra, Fornecedor fornecedor) {
        ArrayList<Livro> listaCompraLivros = compra.getLivros();
        for (Livro livro : listaCompraLivros) {
            if (!fornecedor.getLivrosCatalogo().contains(livro)) {
                return false;
            }
        }
        return true;
    }

    private boolean verificaDisponibilidadeEquipamentos(GerenciaCompra compra, Fornecedor fornecedor) {
        ArrayList<Equipamento> listaCompraEquipamentos = compra.getEquipamentos();
        for (Equipamento equipamento : listaCompraEquipamentos) {
            if (!fornecedor.getEquipamentosCatalogo().contains(equipamento)) {
                return false;
            }
        }
        return true;
    }

    public double calculaSubTotalLivros(GerenciaCompra compra) {
        ArrayList<Livro> listaCompraLivros = compra.getLivros();
        double armazenaValoresLivros = 0;
        for (Livro liv : listaCompraLivros) {
            armazenaValoresLivros += liv.getPrecoCompra();
        }
        return armazenaValoresLivros;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private void setId() {
        this.id = GerenciaCompra.cod++;
    }

    private int getId() {
        return this.id;
    }

    public void addLivros(Livro liv) {
        this.livros.add(liv);
    }

    public void addEquipamentos(Equipamento equip) {
        this.equipamentos.add(equip);
    }

    public void removeLivros(Livro liv) {
        this.livros.remove(liv);
    }

    public void removeEquipamentos(Equipamento equip) {
        this.equipamentos.remove(equip);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return this.equipamentos;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "livros=" + livros +
                ", equipamentos=" + equipamentos +
                '}';
    }
}
