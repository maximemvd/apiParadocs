package com.example.demo.api;

import com.example.demo.model.SkiResort;
import com.example.demo.service.SkiResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import java.util.List;
@RequestMapping("api/v2/skiresort")
@RestController
public class SkiResortController {

    private final SkiResortService skiResortService;

    @Autowired
    public SkiResortController(SkiResortService skiResortService) {
        this.skiResortService = skiResortService;
    }

    @PostMapping
    public void addSkiResort(@Valid @NonNull @RequestBody SkiResort skiResort){
        skiResortService.addSkiResort(skiResort);
    }

    @GetMapping
    public List<SkiResort> getAllSkiResort() {
        return skiResortService.getAllSkiResort();
    }

    @GetMapping(path = "{idResort}")
    public SkiResort getSkiResortById(@PathVariable("idResort") UUID id){
        return skiResortService.getSkiResortById(id)
                .orElse(null);

    }
    @DeleteMapping(path = "{idResort}")
    public void deleteSkiResortById(@PathVariable("idResort") UUID id){
        skiResortService.deleteSKiResort(id);
    }

    @PutMapping(path = "{idResort}")
    public void updateSkiResort(@PathVariable("idResort") UUID id, @Valid @NonNull @RequestBody SkiResort skiResortToUpdate){
        skiResortService.updateSkiResort(id, skiResortToUpdate);
    }
}
