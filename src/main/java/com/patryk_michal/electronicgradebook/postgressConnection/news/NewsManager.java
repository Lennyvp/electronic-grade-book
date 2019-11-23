package com.patryk_michal.electronicgradebook.postgressConnection.news;

import com.patryk_michal.electronicgradebook.model.HeadAdmin;
import com.patryk_michal.electronicgradebook.model.News;
import com.patryk_michal.electronicgradebook.postgressConnection.headAdmin.HeadAdminRepository;
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
        saveNews(new News("Jutro apel szkolny o godzinie 12:00","Barbara Nowak"));
        saveNews(new News("Dyskoteka szkolna w czwartek zaczyna się o godzinie 17:00 i będzie trwała do godziny 20:00","Barbara Nowak"));
        saveNews(new News("W dniu 25.11.2019 zostanie przeprowadzona próbna ewakuacja szkoły pomiędzy godzinami 10:00 a 12:00.","Jan Kowalczyk"));
    }


}
