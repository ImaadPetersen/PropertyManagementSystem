package za.ac.mycput.factory;

import za.ac.mycput.domain.Maintenance;

import java.time.LocalDate;

/*
* MaintenanceFactory.java
* Factory class for Maintenance
* Olwethu Mtwazi (230036937)
* 21/3/2026
 */
public class MaintenanceFactory {
    public static Maintenance createMaintenance(String requestId, String description, String status, LocalDate reportedDate, double cost){
        return new Maintenance.Builder()
                .setRequestId(requestId)
                .setDescription(description)
                .setStatus(status)
                .setReportedDate(reportedDate)
                .setCost(cost)
                .build();
    }
}
