package market.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos_produtos")
public class PedidoProduto {

    @Id
    private String idPedidoProduto;

    private String idPedido;

    private String idProduto;

    public String getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(String idPedidoProduto) {
        this.idPedidoProduto = idPedidoProduto;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
}
