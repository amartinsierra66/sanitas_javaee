package com.sanitas.converters;

import org.springframework.stereotype.Component;

import com.sanitas.dto.ProductoDto;
import com.sanitas.model.Producto;
@Component
public class ProductoConverterImpl implements ProductoConverter {

	@Override
	public ProductoDto productoToDto(Producto producto) {
		return new ProductoDto(producto.getNombre(),producto.getSeccion(),producto.getPrecio(),producto.getStock());
	}

	@Override
	public Producto dtoToProducto(ProductoDto dto) {
		return new Producto(0,dto.getProducto(),dto.getCategoria(),dto.getPrecio(),dto.getStock());
	}

}
