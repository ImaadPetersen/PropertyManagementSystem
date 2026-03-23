package za.ac.mycput.repository.impl;

/*
*MaintenanceRepositoryImpl.Java
* Implementation of Maintenance Repository class
* Olwethu Mtwazi (230036937)
* 21/3/2026
 */


import za.ac.mycput.domain.Maintenance;
import za.ac.mycput.repository.IMaintenanceRepository;

import java.util.HashSet;
import java.util.Set;

public class MaintenanceRepositoryImpl implements IMaintenanceRepository {
    private Set<Maintenance> maintenanceDB = new HashSet<>();

    @Override
    public Maintenance create(Maintenance maintenance){
        maintenanceDB.add(maintenance);
        return maintenance;
    }
    @Override
    public Maintenance read(String requestId){
        return maintenanceDB.stream()
                .filter(m -> m.getRequestId().equals(requestId))
                .findAny()
                .orElse(null);
    }
    @Override
    public Maintenance update(Maintenance maintenance){
        Maintenance old = read(maintenance.getRequestId());
        if(old !=null){
            maintenanceDB.remove(old);
            maintenanceDB.add(maintenance);
            return maintenance;
        }
        return null;
    }
    @Override
    public boolean delete(String requestId){
        Maintenance m = read(requestId);
        if (m !=null){
            maintenanceDB.remove(m);
            return true;
        }
        return false;
    }
    @Override
    public Set<Maintenance> getAll(){
        return maintenanceDB;
    }
}
