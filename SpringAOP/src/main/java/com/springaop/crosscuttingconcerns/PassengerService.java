package com.springaop.crosscuttingconcerns;

import com.springaop.example1.model.Passenger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PassengerService {
    private static final Logger LOGGER = LogManager.getLogger(PassengerService.class.getName());

    public static Passenger getPassenger(int id){
       /*if(!SecurityContext.hasRights("getPassenger")){
           throw new RuntimeException("Permission Denied");
        }
        LOGGER.debug("Call Method getPassenger with id " + id);
        Passenger passenger;

        try {
            if(cache.contains(id)) {
                passenger = cache.get(id);
            } else {
                passenger = Database.getPassenger(id);
            }
        } catch(Exception e){
            throw new RuntimeException(e);
        }

        LOGGER.debug("Passenger info: "+ passenger.toString());
        return passenger;*/
       return  null;
    }
}
