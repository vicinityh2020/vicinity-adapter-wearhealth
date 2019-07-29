/*
Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

Vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of MIT License.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT,
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/

package com.wearhealth.adapter.template.Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.wearhealth.adapter.template.Model.TechUnit;
import com.wearhealth.adapter.template.Service.TechUnitService;
import org.slf4j.Logger;
import java.util.List;
import org.apache.commons.io.IOUtils;

/**
 * DataTransferController we send data from our local database to cloud
 * Here we have a cronjob which initialize after application start
 * @author WearHealth
 */

@RestController
public class DataTransferController {

    private static Logger log = LoggerFactory.getLogger(DataTransferController.class);

    @Autowired
    private TechUnitService techUnitService;

    /**
     * Get cloud rest api url
     */
    @Value("${spring.wearhealth.restapi}")
    private String warehealthRestApi;

    /**
     * This is a cron job. It start after 100 seconds when application start
     * And then it continues every 5 seconds letter
     * @return
     */
    @Scheduled(fixedRate = 5000, initialDelay = 100000)
    @GetMapping("/sendDataToRemote")
    public ResponseEntity<?> sendDataToRemote() {
        boolean remoteCaptureSuccess = true;

        List<TechUnit> techUnitList = techUnitService.getAll();
        String responseMsg = "Tech Unit Json Size: " + techUnitList.size() + ". ";
        HttpStatus status = HttpStatus.OK;
        if(techUnitList.size() == 0) {
            responseMsg = responseMsg + "You have no data for sending to WH Cloud";
            log.info(responseMsg);
            return new ResponseEntity<>(responseMsg, status);
        }

        remoteCaptureSuccess= getPostRESTResponse(techUnitList);

        if (!remoteCaptureSuccess) {
            responseMsg = responseMsg + "Failed to sent TechUnit list to WH Cloud!";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        } else {
            techUnitService.deleteAll();
            responseMsg = responseMsg + "TechUnit Data Successfully Sent to WH Cloud";
        }
        log.info(responseMsg);
        return new ResponseEntity<>(responseMsg, status);
    }

    /**
     * Here we make a post request with our techUnitList data
     * @param techUnitList
     * @return
     */
    private boolean getPostRESTResponse(List<TechUnit> techUnitList) {
        boolean success = true;
        String techUnitCaptureURL = warehealthRestApi;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<String> entity = new HttpEntity<String>(createJsonArrayFromList(techUnitList).toString(), headers);
            restTemplate.exchange(techUnitCaptureURL, HttpMethod.POST, entity, String.class);
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    /**
     * Convert TechUnitList to TechUnitJsonArray
     * @param techUnitList
     * @return
     */
    private JSONArray createJsonArrayFromList(List<TechUnit> techUnitList) {
        JSONArray jsonArray = new JSONArray();
        for (TechUnit element : techUnitList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("heartRate", element.getHeartRate());
            jsonObject.put("deviceId", element.getDeviceId());
            jsonObject.put("createDateTime", element.getCreateDateTime().toString());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        return jsonArray;
    }

    /**
     * To get the ThingsDescription Json
     * @return
     */
    @GetMapping("/getThingsDescription")
    public ResponseEntity<?> getThingsDescription() {
        log.info("Inside getThingsDescription - TBD by each pilot depending on their VAS/Things...");

        ClassLoader cl = getClass().getClassLoader();

        String thingsDescription = "";
        try {
            thingsDescription = IOUtils
                    .toString(cl.getResourceAsStream("things-wearhealth.json"));
        } catch (Exception ex) {
            log.error("Unable to load Things Description...");
            ex.printStackTrace();
        }
        return new ResponseEntity<>(thingsDescription, HttpStatus.OK);
    }
}
