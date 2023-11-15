package com.example.nawafotayf.movielist.service.implementations;

import com.example.nawafotayf.movielist.entity.Series;
import com.example.nawafotayf.movielist.repository.SeriesRepository;
import com.example.nawafotayf.movielist.service.interfaces.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {
    @Autowired
    SeriesRepository seriesRepository;

    @Override
    public void addSeries(List<Series> series) {
        seriesRepository.saveAll(series);
    }

    @Override
    public List<Series> listAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public void deleteSeries(String name) {
        Series series = seriesRepository.findByname(name);
        seriesRepository.delete(series);
    }

    @Override
    public void updateSeries(String name, Series series) {
        Series findSeries = seriesRepository.findByname(name);
        if(series.getName() != null){
            findSeries.setName(series.getName());
        }
        if(series.getStory() != null){
            findSeries.setStory(series.getStory());
        }
        if(series.getDuration() != 0){
            findSeries.setDuration(series.getDuration());
        }
        if(series.getStudios() != null){
            findSeries.setStudios(series.getStudios());
        }
        if(series.getStart() != null){
            findSeries.setStart(series.getStart());
        }
        if(series.getEnd() != null){
            findSeries.setEnd(series.getEnd());
        }
        if(series.getSeasons() != 0){
            findSeries.setSeasons(series.getSeasons());
        }
        if(series.getEpisodes() != 0){
            findSeries.setEpisodes(series.getEpisodes());
        }
        seriesRepository.save(findSeries);

    }

    @Override
    public Series findByName(String name) {
        return seriesRepository.findByname(name);
    }

}
