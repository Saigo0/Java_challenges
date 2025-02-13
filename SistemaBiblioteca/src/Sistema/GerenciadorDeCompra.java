package Sistema;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeCompra {
    private final Biblioteca biblioteca;
    private final List<Compra> historicoCompras;

    public GerenciadorDeCompra() {
        this.biblioteca = Biblioteca.getInstancia();
        historicoCompras = new ArrayList<Compra>();
    }

    public boolean realizaPedidoDeCompra(Compra compra, Fornecedor fornecedor, boolean confirmacaoCompra) {
        if (compra.getLivros() != null && compra.getEquipamentos() != null) {
            realizaPedidoCompraLivro(compra, fornecedor, true);
            realizaPedidoCompraEquipamento(compra, fornecedor, true);
            return true;
        }
        return false;
    }

    private boolean realizaPedidoCompraLivro(Compra compra, Fornecedor fonecedor, boolean confirmacaoCompra) {
        if (calculaSubTotalLivros(compra) > 0 && confirmacaoCompra) {
            if (verificaDisponibilidadeLivros(compra, fonecedor)) {
                for (Livro livro : compra.getLivros()) {
                    GerenciaLivros.tornarDisponivel(livro, Biblioteca.getInstancia());
                    Biblioteca.getInstancia().addLivros(livro);
                }
                compra.setStatus(true);
                this.historicoCompras.add(compra);
                //modificar a disponibilidade do livro chamando o método gerencia livro
                System.out.println("Compra de livro's realizada com sucesso!");
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean realizaPedidoCompraEquipamento(Compra compra, Fornecedor fornecedor, boolean confirmacaoCompra) {
        if (calculaSubTotalEquipamentos(compra) > 0 && confirmacaoCompra) {
            if (verificaDisponibilidadeEquipamentos(compra, fornecedor)) {
                for (Equipamento equipamento : compra.getEquipamentos()) {
                    GerenciaEquipamentos.tornarStatusDisponivel(equipamento, Biblioteca.getInstancia());
                    Biblioteca.getInstancia().addEquipamento(equipamento);
                }
                compra.setStatus(true);
                this.historicoCompras.add(compra);
                System.out.println("Compra de equipamento's realizada com sucesso!");
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean verificaDisponibilidadeLivros(Compra compra, Fornecedor fornecedor) {
        List<Livro> listaCompraLivros = compra.getLivros();
        for (Livro livro : listaCompraLivros) {
            if (!fornecedor.getLivrosCatalogo().contains(livro)) {
                //tratar, futuramente, com exeception
                System.out.println("O livro de nome: '" + livro.getTitulo() + "', não pertence ao catálogo do fornecedor");
                return false;
            }
        }
        return true;
    }

    private boolean verificaDisponibilidadeEquipamentos(Compra compra, Fornecedor fornecedor) {
        List<Equipamento> listaCompraEquipamentos = compra.getEquipamentos();

        for (Equipamento equipamento : listaCompraEquipamentos) {
            if (!fornecedor.getEquipamentosCatalogo().contains(equipamento)) {
                //tratar, futuramente, com exeception
                System.out.println("O equipamento de nome: '" + equipamento.getNome() + "', não pertence ao catálogo do fornecedor");
                return false;
            }
        }
        return true;
    }

    public double calculaSubTotalLivros(Compra compra) {
        List<Livro> listaCompraLivros = compra.getLivros();
        double armazenaValoresLivros = 0;
        for (Livro liv : listaCompraLivros) {
            armazenaValoresLivros += liv.getPrecoCompra();
        }
        return armazenaValoresLivros;
    }

    public double calculaSubTotalEquipamentos(Compra compra) {
        List<Equipamento> listaCompraEquipamentos = compra.getEquipamentos();
        double armazenaValoresEquipamentos = 0;
        for (Equipamento equi : listaCompraEquipamentos) {
            armazenaValoresEquipamentos += equi.getPrecoCompra();
        }
        return armazenaValoresEquipamentos;
    }

    public void addHistoricoCompras(Compra compra) {
        this.historicoCompras.add(compra);
    }

    public void removeHistoricoCompras(Compra compra) {
        this.historicoCompras.remove(compra);
    }

    public List<Compra> getHistoricoCompras() {
        return this.historicoCompras;
    }
}
