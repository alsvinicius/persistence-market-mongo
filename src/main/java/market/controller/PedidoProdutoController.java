package market.controller;

import market.model.PedidoProduto;
import market.service.PedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes/{id_cliente}/pedidos/{id_pedido}/produtos")
public class PedidoProdutoController {

    @Autowired
    PedidoProdutoService service;

    //TODO verificar se produto possui estoque e reduzir quantidade
    //TODO adicionar valor ao pedido
    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoProduto inserir(
            @PathVariable("id_pedido") Long idPedido,
            @RequestBody PedidoProduto pedidoProduto
    ) {
        return service.inserir(idPedido, pedidoProduto);
    }

    //TODO voltar a quantidade ao produto
    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable("id_pedido") Long idPedido,
            @PathVariable Long id
    ) {
        service.excluir(idPedido, id);
    }

    @GetMapping
    @ResponseBody
    public List<PedidoProduto> listar(
            @PathVariable("id_pedido") Long idPedido
    ) {
        return service.listar(idPedido);
    }
    
}
