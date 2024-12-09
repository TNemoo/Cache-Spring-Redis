package com.example.cachespringredis.service;

import com.example.cachespringredis.dto.PersonDto;
import com.example.cachespringredis.entity.Person;
import com.example.cachespringredis.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    // Получаем person по id, если он получен первый раз, то из БД, далее уже только из Redis
    @Cacheable(cacheNames = "person", key = "#id")
    @Transactional(readOnly = true)
    public PersonDto findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The person has not been found"));
        log.info("The person {} was got from db", id);
        return modelMapper.map(person, PersonDto.class);
    }

    // Получаем person по id, только из БД, обновляя каждый раз кэш в Redis
    @CachePut(cacheNames = "person", key = "#id")
    @Transactional(readOnly = true)
    public PersonDto findByIdCacheUpdate(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The person has not been found"));
        log.info("The person {} was got from db", id);
        return modelMapper.map(person, PersonDto.class);
    }

    // Создаем нового person в БД
    @Transactional
    public PersonDto save(PersonDto personDto) {
        personRepository.findByPhoneNumber(personDto.getPhoneNumber())
                .ifPresent(p -> { throw new RuntimeException("The phone number is not correct"); });
        Person person = personRepository.save(modelMapper.map(personDto, Person.class));
        log.info("The person {} was saved", person.getId());
        return modelMapper.map(person, PersonDto.class);
    }
}
