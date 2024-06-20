package com.agiotagem_bank.service;

import com.agiotagem_bank.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCadastralService<T, R extends JpaRepository<T, Long>> {

    private final String entityName = getModelName();
    @Autowired
    protected R repository;
    @Autowired
    protected ModelMapper modelMapper;

    public List<T> saveAll(List<T> entities) {
        return repository.saveAll(entities);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public T update(Long id, T entity) {
        Optional<T> existingEntityOptional = repository.findById(id);
        if (existingEntityOptional.isEmpty()) {
            throw new NotFoundException(entityName + " não encontrada!");
        }
        T existingEntity = existingEntityOptional.get();

        modelMapper.map(entity, existingEntity);

        return repository.save(existingEntity);
    }

    public void delete(Long id) {
        try {
            Optional<T> existingEntityOptional = repository.findById(id);
            repository.deleteById(id);
        } catch (NullPointerException e) {
            throw new NotFoundException(entityName + " não encontrada!");
        }
    }

    private String getModelName() {
        try {
            Class<?> clazz = getClass();
            while (clazz != null) {
                if (clazz.getSuperclass().equals(AbstractCadastralService.class)) {
                    break;
                }
                clazz = clazz.getSuperclass();
            }
            return ((Class<T>) ((java.lang.reflect.ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        } catch (Exception e) {
            throw new IllegalStateException("Erro ao obter o nome do modelo", e);
        }
    }
}