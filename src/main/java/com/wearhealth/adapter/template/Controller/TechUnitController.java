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

import com.wearhealth.adapter.template.Model.TechUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wearhealth.adapter.template.Service.TechUnitService;
import java.util.List;

/**
 * TechUnit Controller
 *
 * @author WearHealth
 */

@RestController
public class TechUnitController {

    @Autowired
    private TechUnitService techUnitService;

    /**
     * To create a new Tech Unit
     * @param heartRate
     * @param deviceId
     */
    @PostMapping("/create")
    public void addTechUnit(@RequestParam String heartRate, @RequestParam String deviceId) {
        TechUnit techUnit = new TechUnit();
        techUnit.setHeartRate(heartRate);
        techUnit.setDeviceId(deviceId);
        techUnitService.addTechUnit(techUnit);
    }

    /**
     * To get all TechUnit
     * @return
     */
    @GetMapping("/all")
    public List<TechUnit> getAllTechUnit() {
        return techUnitService.getAll();
    }

    /**
     * Delete All TechUnit
     */
    @GetMapping("/deleteAll")
    public void deleteAll() {
        techUnitService.deleteAll();
    }
}
