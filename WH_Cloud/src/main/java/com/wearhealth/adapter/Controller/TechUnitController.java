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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wearhealth.adapter.Model.TechUnit;
import com.wearhealth.adapter.Service.TechUnitService;
import java.util.List;

/**
 * TechUnitController
 * @author WearHealth
 */

@RestController
public class TechUnitController {

    private static Logger log = LoggerFactory.getLogger(TechUnitController.class);

    @Autowired
    private TechUnitService techUnitService;

    /**
     * To save a list of TechUnit Data
     * @param techUnitList
     * @return
     */
    @PostMapping("/saveTechUnitList")
    public ResponseEntity<?> saveTechUnitList(@RequestBody List<TechUnit> techUnitList) {
        techUnitService.saveAll(techUnitList);
        log.info("Tech Unit List Captured!");
        return new ResponseEntity<>("Tech Unit List Captured!", HttpStatus.OK);
    }
}
