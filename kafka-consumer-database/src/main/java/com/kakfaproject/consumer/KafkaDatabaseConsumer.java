package com.kakfaproject.consumer;

import com.kakfaproject.consumer.entity.WikimediaData;
import com.kakfaproject.consumer.repo.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepo dataRepo;

    public KafkaDatabaseConsumer(WikimediaDataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @KafkaListener(topics = "wikimedia_recent_change", groupId = "wikimediaGroup")
    public void consume(String eventMessage){

        LOGGER.info(String.format("Message received %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepo.save(wikimediaData);
    }
}