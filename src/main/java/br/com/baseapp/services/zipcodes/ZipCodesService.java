package br.com.baseapp.services.zipcodes;

import br.com.baseapp.domains.ZipCode;
import org.springframework.stereotype.Service;

@Service
public class ZipCodesService implements ZipCodesImp {

  public ZipCode findByCode(String code) {
    return ZipCode.builder().cep(code).build();
  }

  @Override
  public ZipCode getZipCode() {
    return null;
  }
}
