package productservice.services.impls;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import productservice.dtos.ProductMapper;
import productservice.dtos.ProductRequestDTO;
import productservice.dtos.ProductResponseDTO;
import productservice.models.Product;
import productservice.repositories.ProductRepository;
import productservice.services.ProductCreateService;

@Service
@RequiredArgsConstructor
public class ProductCreateServiceImpl implements ProductCreateService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Override
	@Transactional
	public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {

		Product product = productMapper.toEntity(requestDTO);
		Product saved = productRepository.save(product);

		return productMapper.toResponseDTO(saved);
	}
}
