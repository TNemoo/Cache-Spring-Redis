package com.example.cachespringredis.controller;

import com.example.cachespringredis.dto.PersonDto;
import com.example.cachespringredis.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    // Получаем person по id, если он получен первый раз, то из БД, далее уже только из Redis
    @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id){
        PersonDto personDto = personService.findById(id);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    // Получаем person по id, только из БД, обновляя каждый раз кэш в Redis
    @GetMapping("/update/{id}")
    public ResponseEntity<?> findByIdCacheUpdate(@PathVariable Long id){
        PersonDto personDto = personService.findByIdCacheUpdate(id);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    // Создаем нового person в БД
    @PostMapping("/new")
    public ResponseEntity<?> savePerson(@RequestBody PersonDto personDto){
        PersonDto savedPersonDto = personService.save(personDto);
        return new ResponseEntity<>(savedPersonDto, HttpStatus.CREATED);
    }
}
