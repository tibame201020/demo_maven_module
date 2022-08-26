package org.batch;

import org.batch.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    private BatchService batchService;

    public void execute() {
        batchService.updateSession();
    }
}
