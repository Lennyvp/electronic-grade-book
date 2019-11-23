package com.patryk_michal.electronicgradebook.postgressConnection.news;

import com.patryk_michal.electronicgradebook.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News,Long> {
}
