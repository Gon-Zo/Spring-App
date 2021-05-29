package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.basic.ProductType;
import io.gonzo.jpa.app.web.dto.NameOnly;
import io.gonzo.jpa.app.web.dto.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles("h2")
@ExtendWith(SpringExtension.class)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    private final String productTypeTitle = "샅품타입1";

    @BeforeEach
    public void beforeEach() {

        /**
         * product type 저장 로직
         */

        ProductType productType = new ProductType(productTypeTitle);

        productTypeRepository.save(productType);

    }

    @Test
    @DisplayName("기본적인 insert")
    void save_default_save() {

        Optional<ProductType> productType = productTypeRepository.findByName(productTypeTitle);

        productType.ifPresent(type -> {
            ProductDTO dto = ProductDTO.builder()
                    .type("ING")
                    .name("test....")
                    .price(new BigDecimal(0))
                    .productType(type)
                    .img("project.jpg")
                    .build();

            repository.save(dto.toEntity());
        });

    }

    @Test
    @DisplayName("select All 이 아닌 단일로 적용 하기")
    void findByImg_Success() {

        ProductDTO dto = ProductDTO.builder()
                .type("ING")
                .name("test....")
                .price(new BigDecimal(0))
                .productType(new ProductType("test..."))
                .img("project.jpg")
                .build();

        repository.save(dto.toEntity());

        String img = "project.jpg";

        String name = "test....";

        Collection<NameOnly> data = repository.findByImg(img, NameOnly.class);

        data.forEach(value -> Assertions.assertEquals(value.getName(), name));

    }

    @Test
    @DisplayName("dto 로 데이터 꺼내기 fail")
    void findByImg_Fail() {

        ProductDTO dto = ProductDTO.builder()
                .type("ING")
                .name("test....")
                .price(new BigDecimal(0))
                .productType(new ProductType("test..."))
                .img("project.jpg")
                .build();

        repository.save(dto.toEntity());

        String img = "project.jpg";

        String name = "test1";

        Collection<NameOnly> data = repository.findByImg(img, NameOnly.class);

        data.forEach(value -> Assertions.assertEquals(value.getName(), name));
    }

}
