package com.example.nawafotayf.movielist.controller;

import com.example.nawafotayf.movielist.entity.Series;
import com.example.nawafotayf.movielist.service.implementations.SeriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeriesController {
    @Autowired
    SeriesServiceImpl seriesServiceImpl ;

    @PostMapping(value = "movielist-admin/series/addseries")
    public ResponseEntity<String> addSeries(@RequestBody List<Series> series){
        try{
            seriesServiceImpl.addSeries(series);
            String message = "series add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            String message = "series not added\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @GetMapping(value = "movielist/series/allseries")
    public List<Series> listAllSeries(){
        return seriesServiceImpl.listAllSeries();
    }
    @DeleteMapping(value = "movielist-admin/series/delete")
    public ResponseEntity<String> deleteSeries(@RequestParam String name){
        try {
            seriesServiceImpl.deleteSeries(name);
            String message = "series deleted successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "series not deleted\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }
    @PutMapping(value = "movielist-admin/series/update")
    public ResponseEntity<String> updateSeries(@RequestParam String name, @RequestBody Series series){
        try{
            seriesServiceImpl.updateSeries(name, series);
            String message = "series updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch (Exception e){
            String message = "series not updated\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
        }
    @GetMapping(value = "/movielist/series/findbyname")
    public Series findbyname(@RequestParam String name) {
        return seriesServiceImpl.findByName(name);
    }
}

