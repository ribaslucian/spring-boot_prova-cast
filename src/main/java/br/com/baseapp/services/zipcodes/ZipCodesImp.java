package br.com.baseapp.services.zipcodes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.baseapp.domains.ZipCode;

@FeignClient(name = "ZipCode", url = "http://viacep.com.br/ws/01001000/json/")
public interface ZipCodesImp {
    
    // @RequestMapping(method = @RequestMethod.GET, value="")
    @RequestMapping(value = "", method = RequestMethod.GET)
    ZipCode getZipCode();
}
