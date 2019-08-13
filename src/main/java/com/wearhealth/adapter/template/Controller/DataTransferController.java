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

import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.apache.commons.io.IOUtils;

/**
 * DataTransferController we send data from our local database to cloud
 * Here we have a cronjob which initialize after application start
 * @author WearHealth
 */

@RestController
public class DataTransferController {

    private static Logger log = LoggerFactory.getLogger(DataTransferController.class);

    /**
     * To get the ThingsDescription Json
     * @return
     */
    @GetMapping("/getThingsDescription")
    public ResponseEntity<?> getThingsDescription() {
        log.info("Thing Description from  TechUnit ... ");

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
