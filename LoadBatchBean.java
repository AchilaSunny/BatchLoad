package com.achila.ETLloadservice.batch;

import com.achila.ETLloadservice.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoadBatchBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransactionService transactionService;

    @Scheduled(cron = "0,30 * * * * *")

    //cron = "0 0 12 * * * *" - fires at 12PM EVERY DAY
    public void cronJob(){
        logger.info("> CronJob");

        transactionService.saveTransactionData();

        logger.info("< CronJob");
    }
}
