package ec.edu.espe.gateway.comercio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ec.edu.espe.gateway.comercio.model.Comercio;
import ec.edu.espe.gateway.comercio.services.ComercioService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/comercios")
public class ComercioController {

    private final ComercioService comercioService;

    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Comercio> obtenerPorCodigo(@PathVariable Integer codigo) {
        try {
            Comercio comercio = comercioService.obtenerPorCodigo(codigo);
            return ResponseEntity.ok(comercio);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> registrarComercio(@RequestBody Comercio comercio) {
        try {
            comercioService.registrarComercio(comercio);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{codigo}/estado")
    public ResponseEntity<Void> actualizarEstado(@PathVariable Integer codigo, @RequestParam String nuevoEstado) {
        try {
            comercioService.actualizarEstado(codigo, nuevoEstado);
            return ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{codigo}/pagos-aceptados")
    public ResponseEntity<Void> actualizarPagosAceptados(@PathVariable Integer codigo, @RequestParam String pagosAceptados) {
        try {
            comercioService.actualizarPagosAceptados(codigo, pagosAceptados);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{codigoComercio}/comision/{codigoComision}")
    public ResponseEntity<Void> asignarComision(@PathVariable Integer codigoComercio, @PathVariable Integer codigoComision) {
        try {
            comercioService.asignarComision(codigoComercio, codigoComision);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Comercio>> listarComerciosPorEstado(@PathVariable String estado) {
        List<Comercio> comercios = comercioService.listarComerciosPorEstado(estado);
        return ResponseEntity.ok(comercios);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Comercio>> buscarPorRazonSocialONombreComercial(@RequestParam String criterio) {
        List<Comercio> comercios = comercioService.buscarPorRazonSocialONombreComercial(criterio);
        return ResponseEntity.ok(comercios);
    }
}
