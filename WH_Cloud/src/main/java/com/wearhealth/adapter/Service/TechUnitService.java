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

package com.wearhealth.adapter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wearhealth.adapter.Model.TechUnit;
import com.wearhealth.adapter.Repository.TechUnitRepository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * TechUnitService
 * @author WearHealth
 */

@Service
@Transactional
public class TechUnitService {

    @Autowired
    private TechUnitRepository techUnitRepository;

    /**
     * Add a new TechUnit
     * @param techUnit
     */
    public void addTechUnit(TechUnit techUnit) {
        techUnitRepository.save(techUnit);
    }

    /**
     * Save a list of TechUnit data
     * @param techUnitList
     */
    public void saveAll(List<TechUnit> techUnitList) {
        techUnitRepository.saveAll(techUnitList);
    }
}
