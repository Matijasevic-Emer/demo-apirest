package com.segunda.preentrega.controller;

import com.segunda.preentrega.model.Producto;
import com.segunda.preentrega.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@Tag(name = "Producto", description = "Operaciones con los productos ABML")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/agregar")
    @Operation(summary = "Agregar un Producto", description = "Permite agregar un nuevo producto al sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto agregado con éxito"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida - error de validación de campos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar un Producto por ID", description = "Recupera los detalles de un producto dado su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado con éxito"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public Optional<Producto> buscarProducto(@PathVariable Long id) {
        return productoService.buscarProducto(id);
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar todos los Productos", description = "Recupera una lista de todos los productos disponibles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida con éxito"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un Producto", description = "Elimina un producto del sistema dado su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado con éxito"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
}
