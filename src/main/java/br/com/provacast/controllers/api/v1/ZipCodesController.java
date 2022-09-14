package br.com.provacast.controllers.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provacast.domains.ZipCode;
import br.com.provacast.services.ZipCodesEndPointImp;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/zip-codes")
@AllArgsConstructor
public class ZipCodesController {

    private ZipCodesEndPointImp zipCodesImp;

    @GetMapping("/{code}")
    public ResponseEntity<ZipCode> findByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(zipCodesImp.getZipCode(code));
        // return ResponseEntity.ok(zipCodesImp.getZipCode());
    }
    
}
