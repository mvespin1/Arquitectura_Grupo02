package ec.edu.espe.gateway.transaccion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ec.edu.espe.gateway.transaccion.dto.ActualizacionEstadoDTO;

@FeignClient(name = "pos-client", url = "http://18.118.255.136")
public interface PosClient {
    @PostMapping("/api/transacciones/actualizar-estado")
    void actualizarEstadoTransaccion(@RequestBody ActualizacionEstadoDTO actualizacion);
} 