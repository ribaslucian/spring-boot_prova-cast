package br.com.baseapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.baseapp.domains.Hero;
import br.com.baseapp.repositories.HeroesRepository;

@RestController
@Controller
@RequestMapping("/heroes")
public class HeroesController {

    @Autowired
    private HeroesRepository heroesRepository;

    @GetMapping("/api")
    public List<Hero> list() {
        return heroesRepository.findAll();
    }

    @PostMapping("/api")
    public Hero create(@RequestBody Hero h) {
        return heroesRepository.save(h);
    }

    @GetMapping("/api/{id}")
    public Hero search(@PathVariable("id") UUID id) {
        Optional<Hero> u = heroesRepository.findById(id);

        if (u.isPresent())
            return u.get();

        return null;
    }

    @PutMapping("/api/{id}")
    public Hero edit(@RequestBody Hero u, @PathVariable("id") UUID id) {
        return heroesRepository.save(u);
    }

}
