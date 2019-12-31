package market.controller;

import market.model.Pedido;
import market.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes/{id_cliente}/pedidos")
public class PedidoController {

    @Autowired
    PedidoService service;

    @PostMapping("/inserir")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido inserir(
            @PathVariable("id_cliente") Long idCliente,
            @RequestBody Pedido pedido
    ) {
        return service.inserir(idCliente, pedido);
    }

    @PatchMapping("/alterar/{id}")
    @ResponseBody
    public Optional<Pedido> alterar(
            @PathVariable("id_cliente") Long idCliente,
            @PathVariable Long id,
            @RequestBody Pedido pedido
    ) {
        return service.alterar(idCliente, id, pedido);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable("id_cliente") Long idCliente,
            @PathVariable Long id
    ) {
        service.excluir(idCliente, id);
    }

    @GetMapping
    @ResponseBody
    public List<Pedido> listar(
            @PathVariable("id_cliente") Long idCliente
    ) {
        return service.listar(idCliente);
    }

}
