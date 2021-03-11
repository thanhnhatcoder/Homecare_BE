package com.homecare.Homecare.convert;

import org.springframework.stereotype.Component;

import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.entity.ProductEntity;

@Component
public class ProductConvert {
	public ProductEntity dtoToEntity(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(productDTO.getId());
		productEntity.setName(productDTO.getName());
		return productEntity ;
	} 
	public ProductDTO entityToDto(ProductEntity productEntity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(productEntity.getId());
		productDTO.setName(productEntity.getName());
		return productDTO ;
	}
}
