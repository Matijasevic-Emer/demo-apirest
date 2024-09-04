package com.segunda.preentrega.controller;

import com.segunda.preentrega.model.Venta;
import com.segunda.preentrega.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
@Tag(name = "Venta", description = "Operaciones con las ventas ABML")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar una Venta", description = "Permite agregar una nueva venta al sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venta agregada con éxito"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida - error de validación de campos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public Venta agregarVenta(@RequestBody Venta venta) {
        return ventaService.agregarVenta(venta);
    }

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar una Venta por ID", description = "Recupera los detalles de una venta dado su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venta encontrada con éxito"),
            @ApiResponse(responseCode = "404", description = "Venta no encontrada con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public Optional<Venta> buscarVenta(@PathVariable Long id) {
        return ventaService.buscarVenta(id);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todas las Ventas", description = "Recupera una lista de todas las ventas registradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ventas obtenida con éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar una Venta", description = "Elimina una venta del sistema dado su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Venta eliminada con éxito"),
            @ApiResponse(responseCode = "404", description = "Venta no encontrada con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
    }
}
