package com.trilogyed.ZachMerelU1M5Summative.dao;

import com.trilogyed.ZachMerelU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {
    void updatePublisher(Publisher publisher);
    void deletePublisher(int publisherId);
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisher(int publisherId);
    List<Publisher> getAllPublishers();
}
