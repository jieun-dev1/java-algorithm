package testdome;
import jdk.jshell.EvalException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//AlertService SHOULD HAVE A PUBLIC CONSTRUCTOR ACCEPTS ALERTDAO
class AlertService {
    private AlertDAO alertDAO;

    public AlertService(AlertDAO alertDAO){
        this.alertDAO = alertDAO;
    };

    //RAISE ALERT AND GET ALERT TIME METHOD SHOULD USE THE OBJECT PASSED THROUGH THE CONSTRUCTOR
    public UUID raiseAlert() {
        return alertDAO.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return alertDAO.getAlert(id);
    }
}

//MapAlertDAO SHOULD IMPLEMENT AlertDAO
class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

    public UUID addAlert(Date time) {
        UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }

    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }
}

//CREATE A NEW PACKAGE PRIVATE INTERFACE

interface AlertDAO {
    Map<UUID, Date> alerts = new HashMap<UUID, Date>();

    UUID addAlert(Date time);

    Date getAlert(UUID id);
}