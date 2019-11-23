package com.patryk_michal.electronicgradebook.controller;

import com.patryk_michal.electronicgradebook.model.News;
import com.patryk_michal.electronicgradebook.postgressConnection.news.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/allNews")
    public Iterable<News> allParents(){
        return newsRepository.findAll();
    }

}
