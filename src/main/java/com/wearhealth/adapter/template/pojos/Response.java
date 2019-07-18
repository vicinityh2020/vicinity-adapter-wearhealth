/*

Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of GNU General Public License v3.0.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/
package com.wearhealth.adapter.template.pojos;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Jubayed
 */

public class Response {

    private String message = "";

    public Response(){}
    public Response(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement
    public String getMessage(){
        return message;
    }
}
