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

import com.wearhealth.adapter.Service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * VASController
 * @author WearHealth
 */

@RestController
public class VASController {

    private static Logger log = LoggerFactory.getLogger(VASController.class);

    final String BASE_URI = "http://vicinity.wearhealth.com:8099/api/";

    @RequestMapping(value = "/objects/{oid}/properties/{pid}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> generateResponseEvent(@PathVariable("pid") String pid, @PathVariable("oid") String oid,
                                                   @RequestBody String request) throws Exception {

        String result = "";
        String entity = request.toString();

        if (pid.equals("workload_level")) {

            String wsUrl = BASE_URI + "/workload_level";
            result = RestService.getPostRestService(wsUrl, entity);

        } else if (pid.equals("feedback")) {

            String wsUrl = BASE_URI + "/feedback";
            result = RestService.getPostRestService(wsUrl, entity);

        }

        // Return the response
        if (result.contains("\"error_message\"")) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
