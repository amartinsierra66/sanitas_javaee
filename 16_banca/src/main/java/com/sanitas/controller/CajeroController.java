package com.sanitas.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sanitas.dtos.ClienteDto;
import com.sanitas.dtos.CuentaDto;
import com.sanitas.dtos.MovimientoDto;
import com.sanitas.service.CajeroService;
@CrossOrigin("*")
@Controller
public class CajeroController {
    CajeroService cajeroService;
    public CajeroController (@Autowired CajeroService cajeroService) {
        this.cajeroService = cajeroService;
    }
    @GetMapping (value = "clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ClienteDto> clientes () {
        return cajeroService.clientes();
    }
    @GetMapping (value = "cuentas", produces = MediaType.APPLICATION_JSON_VALUE) 
    public @ResponseBody List<CuentaDto> cuentas (@RequestParam ("dni") int dni) {
        return cajeroService.cuentasCliente (dni);
    }
    @GetMapping (value = "movimientos", produces = MediaType.APPLICATION_JSON_VALUE) 
    public @ResponseBody List<MovimientoDto> movimientos (@RequestParam ("numeroCuenta") int numeroCuenta) {
        return cajeroService.movimientosCuenta (numeroCuenta);
    }
}