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

package com.wearhealth.adapter.Controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * TechUnit Controller
 *
 * @author WearHealth
 */

@RequestMapping("/adapter")
@RestController
public class TechUnitController {

    private static Logger log = LoggerFactory.getLogger(TechUnitController.class);

    /**
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/objects",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String generateResponseGetThingsDescription() throws Exception {
        log.info("Thing Description from  WearHealth VAS ... ");

        ClassLoader cl = getClass().getClassLoader();

        String thingsDescription = "";
        try {
            thingsDescription = IOUtils
                    .toString(cl.getResourceAsStream("things-wearhealth.json"));
        } catch (Exception ex) {
            log.error("Unable to load Things Description...");
            ex.printStackTrace();
        }
        return thingsDescription;
    }

}
