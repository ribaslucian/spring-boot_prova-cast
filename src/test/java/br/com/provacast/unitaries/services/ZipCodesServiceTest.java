package br.com.provacast.unitaries.services;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.provacast.domains.ZipCode;
import br.com.provacast.services.ZipCodesEndPointImp;

@SpringBootTest
class ZipCodesServiceTest {

    @Autowired
    private ZipCodesEndPointImp zipCodeEndPoint;

	@Test
    void testFindZipCodeAndCompareCorrectlyFields() {
        ZipCode zipCodeCorrectly = createZipCode();
        ZipCode zipCodeFinded = zipCodeEndPoint.getZipCode("85070370");

        Assertions.assertThat(zipCodeFinded).isNotNull();
        Assertions.assertThat(zipCodeFinded.getCep()).isEqualTo(zipCodeCorrectly.getCep());
    }

    private ZipCode createZipCode() {
       return ZipCode.builder()
        .cep("85070-370")
        .logradouro("Rua Floriano Guine")
        .complemento("")
        .bairro("Morro Alto")
        .localidade("Guarapuava")
        .uf("PR")
        .ibge("4109401")
        .gia("")
        .ddd("42")
        .siafi("7583")
        .build();
    }

}
