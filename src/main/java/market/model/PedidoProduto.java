package market.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos_produtos")
public class PedidoProduto {

    private long idPedidoProduto;

    private long idPedido;

    private long idProduto;

    public long getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(long idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
}
