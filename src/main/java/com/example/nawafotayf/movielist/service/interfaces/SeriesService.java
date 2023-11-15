package com.example.nawafotayf.movielist.service.interfaces;

import com.example.nawafotayf.movielist.entity.Series;

import java.util.List;

public interface SeriesService {

    public void addSeries(List<Series> series);
    public List<Series> listAllSeries();
    public void deleteSeries(String name);
    public void updateSeries(String name, Series series);
    public Series findByName(String name);
}
