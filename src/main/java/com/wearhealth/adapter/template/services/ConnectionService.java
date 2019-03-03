package com.wearhealth.adapter.template.services;


import org.sputnikdev.bluetooth.URL;
import org.sputnikdev.bluetooth.manager.CharacteristicGovernor;
import org.sputnikdev.bluetooth.manager.impl.BluetoothManagerBuilder;

/**
 *
 * @author Jubayed
 */

public final class ConnectionService {

    public static void main(String[] args) throws Exception {
        new BluetoothManagerBuilder()
                .withTinyBTransport(true)
                .withBlueGigaTransport("^*.$")
                .build()
                .getCharacteristicGovernor(new URL("localhost" 
                        + "040A1104-6C30-4F6F-8FF8-B4B0822905CB"), true)
                .whenReady(CharacteristicGovernor::read)
                .thenAccept(data -> {
                    LOG.info("HeartRate " + data[0]);   
                }).get();
    }
    
}