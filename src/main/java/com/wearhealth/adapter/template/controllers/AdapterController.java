/*

Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of GNU General Public License v3.0.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/
package com.wearhealth.adapter.template.controllers;

import com.wearhealth.adapter.template.pojos.Requests.ActionRequest;
import com.wearhealth.adapter.template.pojos.Requests.PropertyRequest;
import com.wearhealth.adapter.template.pojos.Response;

import com.wearhealth.adapter.template.services.AdapterService;
import com.wearhealth.adapter.template.services.impl.AdapterServiceImpl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

import org.apache.log4j.Logger;

/**
 *
 * @author Jubayed
 */

@RestController
public class AdapterController {

    private static final Logger LOG = Logger.getLogger(AdapterController.class);

    private final AdapterService vasService_ = new AdapterServiceImpl();

    /**
     *
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param aid : the service infrastructure action name (not the VICINITY aid)
     * @param request : the request body (user defined/specific)
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/objects/{oid}/actions/{aid}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseAction(@PathVariable("oid") String oid, @PathVariable("aid") String aid,
            @RequestBody ActionRequest request) throws Exception {

        Response resp_ = vasService_.postAction(oid, aid, request);
        return resp_;
    }

    /**
     *
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param aid : the service infrastructure action name (not the VICINITY aid)
     * @param tid : the task id returned by previous POST operation
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/objects/{oid}/actions/{aid}/tasks/{tid}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseGetActionTask(@PathVariable("oid") String oid,
            @PathVariable("aid") String aid, @PathVariable("tid") String tid) throws Exception {

        Response resp_ = vasService_.getActionTask(oid, aid, tid);
        return resp_;
    }

    /**
     *
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param aid : the service infrastructure action name (not the VICINITY aid)
     * @param tid : the task id returned by previous POST operation
     * @return
     * @throws Exception
     */
    @DeleteMapping(value = "/objects/{oid}/actions/{aid}/tasks/{tid}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseDeleteActionTask(@PathVariable("oid") String oid,
            @PathVariable("aid") String aid, @PathVariable("tid") String tid) throws Exception {

        Response resp_ = vasService_.deleteActionTask(oid, aid, tid);
        return resp_;
    }

    /**
     *
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param pid : the service infrastructure property name (not the VICINITY pid)
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/objects/{oid}/properties/{pid}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseGetProperty(@PathVariable("oid") String oid,
            @PathVariable("pid") String pid) throws Exception {

        Response resp_ = vasService_.getProperty(oid, pid);
        return resp_;
    }

    /**
     *
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param pid : the service infrastructure property name (not the VICINITY pid)
     * @param request : the request body (user defined/specific)
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/objects/{oid}/properties/{pid}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponsePutProperty(@PathVariable("oid") String oid, @PathVariable("pid") String pid,
            @RequestBody PropertyRequest request) throws Exception {

        Response resp_ = vasService_.putProperty(oid, pid, request);
        return resp_;
    }

    /**
     *
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param eid : the service event name (not the VICINITY eid)
     * @param request : the request body (user defined/specific)
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/objects/{oid}/events/{eid}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponsePutEvent(@PathVariable("oid") String oid, @PathVariable("eid") String eid,
            @RequestBody PropertyRequest request) throws Exception {

        Response resp_ = vasService_.putEvent(oid, eid, request);
        return resp_;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/objects",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String generateResponseGetThingsDescription() throws Exception {

        Response resp_ = vasService_.getThingsDescription();
        return resp_.getMessage();
    }

}
