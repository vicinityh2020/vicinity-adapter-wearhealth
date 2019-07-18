/*

Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of GNU General Public License v3.0.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/
package com.wearhealth.adapter.template.services;

import com.wearhealth.adapter.template.pojos.Requests.ActionRequest;
import com.wearhealth.adapter.template.pojos.Requests.PropertyRequest;
import com.wearhealth.adapter.template.pojos.Response;

/**
 *
 * @author Jubayed
 */

public interface AdapterService {

    /**
     *
     * @param oid
     * @param aid
     * @param request
     * @return
     */
    Response postAction(String oid, String aid, ActionRequest request);

    /**
     *
     * @param oid
     * @param aid
     * @param tid
     * @return
     */
    Response getActionTask(String oid, String aid, String tid);

    /**
     *
     * @param oid
     * @param aid
     * @param tid
     * @return
     */
    Response deleteActionTask(String oid, String aid, String tid);

    /**
     *
     * @param oid
     * @param pid
     * @return
     */
    Response getProperty(String oid, String pid);

    /**
     *
     * @param oid
     * @param pid
     * @param request
     * @return
     */
    Response putProperty(String oid, String pid, PropertyRequest request);

    /**
     *
     * @param oid
     * @param eid
     * @param request
     * @return
     */
    Response putEvent(String oid, String eid, PropertyRequest request);

    /**
     *
     * @return
     */
    Response getThingsDescription();
}
