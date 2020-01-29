package com.example.demo.service;

import com.example.demo.dao.SkiResortDao;
import com.example.demo.model.SkiResort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkiResortService {

    private final SkiResortDao skiResortDao;

    @Autowired
    public SkiResortService(@Qualifier("fakeDao") SkiResortDao skiResortDao) {
        this.skiResortDao = skiResortDao;
    }

    public int addSkiResort(SkiResort skiresort){
        return skiResortDao.insertSkiResort(skiresort);
    }

    public List<SkiResort> getAllSkiResort(){
        return skiResortDao.selectAllSkiResort();
    }

    public Optional<SkiResort> getSkiResortById(UUID id){
        return skiResortDao.selectSkiResortById(id);

    }

    public int deleteSKiResort(UUID id){
        return skiResortDao.deleteSkiResortById(id);
    }

    public int updateSkiResort(UUID id, SkiResort newSkiResort){
        return skiResortDao.updateSkiResortById(id, newSkiResort);
    }
}
