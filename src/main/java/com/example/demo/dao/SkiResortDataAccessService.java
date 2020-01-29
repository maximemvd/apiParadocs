package com.example.demo.dao;

import com.example.demo.model.SkiResort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class SkiResortDataAccessService implements SkiResortDao {

    private static List<SkiResort> DB = new ArrayList<>();

    @Override
    public int insertSkiResort(UUID id, SkiResort skiresort) {
        DB.add(new SkiResort(id, skiresort.getName(), skiresort.getDescription()));
        return 1;
    }

    @Override
    public List<SkiResort> selectAllSkiResort() {
        return DB;
    }

    @Override
    public Optional<SkiResort> selectSkiResortById(UUID id) {
        return DB.stream()
                .filter(skiResort -> skiResort.getIdResort().equals(id))
                .findFirst();
    }

    @Override
    public int deleteSkiResortById(UUID id) {
        Optional<SkiResort> skiResortMaybe = selectSkiResortById(id);
        if(skiResortMaybe.isEmpty()){
            return 0;
        }
        DB.remove(skiResortMaybe.get());
        return 1;
    }

    @Override
    public int updateSkiResortById(UUID id, SkiResort update) {
        return selectSkiResortById(id)
                .map(skiresort -> {
                    int indexOfSkiResortToUpdate = DB.indexOf(skiresort);
                    if(indexOfSkiResortToUpdate >= 0){
                        DB.set(indexOfSkiResortToUpdate, new SkiResort(id, update.getName(), update.getDescription()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
