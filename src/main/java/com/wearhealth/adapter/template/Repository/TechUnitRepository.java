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

package com.wearhealth.adapter.template.Repository;

import com.wearhealth.adapter.template.Model.TechUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for get and send data to database
 *
 * @author WearHealth
 */
@Repository
public interface TechUnitRepository extends JpaRepository<TechUnit, Integer> {

}
