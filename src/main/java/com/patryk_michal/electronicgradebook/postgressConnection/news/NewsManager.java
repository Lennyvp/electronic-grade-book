package com.patryk_michal.electronicgradebook.postgressConnection.news;

import com.patryk_michal.electronicgradebook.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class NewsManager {

    @Autowired
    private NewsRepository newsRepository;


    public void saveNews(News news){
        newsRepository.save(news);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveNews(new News("Dnia 27.11.2019 apel szkolny o godzinie 12:00","Barbara Nowak","High"));
        saveNews(new News("Dyskoteka szkolna w 26.11.2019 zaczyna się o godzinie 17:00 i będzie trwała do godziny 20:00","Barbara Nowak","Normal"));
        saveNews(new News("W dniu 25.11.2019 zostanie przeprowadzona próbna ewakuacja szkoły pomiędzy godzinami 10:00 a 12:00.","Jan Kowalczyk","High"));
        saveNews(new News("W dniach 01.12.2019-14.12.2019 sklepik szkolny będzie nieczynny z powodu remontów","Barbara Nowak","High"));
    }
}
