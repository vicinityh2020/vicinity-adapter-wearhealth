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

package com.wearhealth.adapter.template.Service;

import com.wearhealth.adapter.template.Model.TechUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wearhealth.adapter.template.Repository.TechUnitRepository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Tech Unit Service
 *
 * @author WearHealth
 */

@Service
@Transactional
public class TechUnitService {

    @Autowired
    private TechUnitRepository techUnitRepository;

    /**
     * To add a new Tech Unit
     * @param techUnit
     */
    public void addTechUnit(TechUnit techUnit) {
        techUnitRepository.save(techUnit);
    }

    /**
     * Get All Tech Unit
     * @return
     */
    public List<TechUnit> getAll() {
        return techUnitRepository.findAll();
    }

    /**
     * Delete All Tech Unit
     */
    public void deleteAll() {
        techUnitRepository.deleteAll();
    }
}
