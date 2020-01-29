package com.example.demo.dao;

import com.example.demo.model.SkiResort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkiResortDao {
    int insertSkiResort(UUID id, SkiResort skiresort);
    default int insertSkiResort(SkiResort skiResort){
        UUID id = UUID.randomUUID();
        return insertSkiResort(id, skiResort);
    }

    List<SkiResort> selectAllSkiResort();

    Optional<SkiResort> selectSkiResortById(UUID id);
    int deleteSkiResortById(UUID id);

    int updateSkiResortById(UUID id, SkiResort skiResort);
}