package com.sanitas.converters;

import com.sanitas.dto.ProductoDto;
import com.sanitas.model.Producto;

public interface ProductoConverter {
	ProductoDto productoToDto(Producto producto);
	Producto dtoToProducto(ProductoDto dto);
}
