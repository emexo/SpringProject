package com.bugtacking.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ReportServiceHealth implements HealthIndicator {
    @Override
    public Health health() {
        if(isReportServiceAvailable()) {
           return Health.up().withDetail("Report Service", "Report service is up").build();
       } else {
           return Health.down().withDetail("Report Service", "Report service is down").build();
       }
    }

    private boolean isReportServiceAvailable(){
        // write the logic to connect report microservice
        return true;
    }
}
