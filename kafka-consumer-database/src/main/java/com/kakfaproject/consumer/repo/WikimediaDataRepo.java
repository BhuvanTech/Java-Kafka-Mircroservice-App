package com.kakfaproject.consumer.repo;

import com.kakfaproject.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository<WikimediaData, Long> {


}
