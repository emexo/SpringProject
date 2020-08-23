package com.springaop.example2.dao;

import com.springaop.example2.model.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengerMap = new HashMap<>();

    @Override
    public Passenger getPassenger(int id) {
        if (null != passengerMap.get(id)){
            return passengerMap.get(id);
        }

        Passenger passenger = new Passenger(id);
        passengerMap.put(id, passenger);
        System.out.println("PassengerDaoImpl:getPassenger");
        return passenger;
    }

    public void getPassenger1(){
        System.out.println("getPassenger1");
    }
}
