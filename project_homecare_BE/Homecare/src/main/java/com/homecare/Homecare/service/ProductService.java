package com.homecare.Homecare.service;

import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homecare.Homecare.convert.ProductConvert;
import com.homecare.Homecare.dto.CustomerDTO;
import com.homecare.Homecare.dto.ProductDTO;
import com.homecare.Homecare.entity.CustomerEntity;
import com.homecare.Homecare.entity.ProductEntity;
import com.homecare.Homecare.exception.BadRequestException;
import com.homecare.Homecare.exception.NotFoundException;
import com.homecare.Homecare.reponse.success.SuccessResponse;
import com.homecare.Homecare.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductConvert productConvert;

	@Transactional
	public SuccessResponse edit(ProductDTO productDTO) {
		if (this.findById(productDTO.getId()) == null)
			throw new NotFoundException("");
		{
			Optional<ProductEntity> optionalProductEntity = productRepository.findById(productDTO.getId());
			ProductEntity productEntity = optionalProductEntity
					.orElseThrow(() -> new BadRequestException("id not correct"));
			productEntity.setName(productDTO.getName());
			productConvert.entityToDto(productRepository.save(productEntity));
		}
		return new SuccessResponse();
	}

	@Transactional
	public SuccessResponse save(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		if (productDTO.getName() == null)
			throw new BadRequestException("Invalid Input");
		else {
			UUID id = UUID.randomUUID();
			productDTO.setId(id.toString());
			productEntity.setId(productDTO.getId());
			productEntity.setName(productDTO.getName());
			productEntity = productConvert.dtoToEntity(productDTO);
			productRepository.save(productEntity);

		}
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setCode(201);
		return successResponse;
	}

	public SuccessResponse findById(String idProduct) {
		Optional<ProductEntity> optionalProduct = productRepository.findById(idProduct);
		if (optionalProduct.isPresent()) {
			return new SuccessResponse(this.productConvert.entityToDto(optionalProduct.get()));
		}
		return new SuccessResponse();
	}

	public SuccessResponse findAllProduct() {
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setData(productRepository.findAll());
		return successResponse;
	}
}