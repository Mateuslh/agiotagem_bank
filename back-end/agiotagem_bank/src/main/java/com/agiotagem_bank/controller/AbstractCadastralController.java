package com.agiotagem_bank.controller;

import com.agiotagem_bank.service.AbstractCadastralService;
import com.agiotagem_bank.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractCadastralController<E, S extends AbstractCadastralService<E, ?>> {
    protected final S service;
    protected final Class<E> entityClass;
    private final ObjectMapper objectMapper = new ObjectMapper();

    protected AbstractCadastralController(S service, Class<E> entityClass) {
        this.service = service;
        this.entityClass = entityClass;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody JsonNode requestBody) {
        try {
            if (requestBody.isArray()) {
                List<E> entities = new ArrayList<>();
                for (JsonNode node : requestBody) {
                    E entity = objectMapper.convertValue(node, entityClass);
                    entities.add(entity);
                }
                return ResponseEntity.ok().body(service.saveAll(entities));
            } else {
                E entity = objectMapper.convertValue(requestBody, entityClass);
                return ResponseEntity.ok().body(service.save(entity));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao executar operação:" + e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JsonNode requestBody) {
        try {
            E entity = objectMapper.convertValue(requestBody, entityClass);
            E existingEntity = service.getById(id);
            if (existingEntity != null) {
                E newEntity = EntityUtils.mergeEntities(existingEntity, entity);
                return ResponseEntity.ok().body(service.update(id, newEntity));
            }
            return ResponseEntity.badRequest().body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao executar operação:" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> FullUpdate(@PathVariable Long id, @RequestBody JsonNode requestBody) {
        try {
            E entity = objectMapper.convertValue(requestBody, entityClass);
            return ResponseEntity.ok().body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao executar operação:" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            E existingEntity = service.getById(id);
            if (existingEntity != null) {
                service.delete(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.status(404).body("Entity not found");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao executar operação:" + e.getMessage());
        }
    }
}
