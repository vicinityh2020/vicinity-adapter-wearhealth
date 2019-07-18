/*

Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of GNU General Public License v3.0.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/
package com.wearhealth.adapter.template.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

/**
 *
 * @author Jubayed
 */

public class Requests {

    public static class Input {

        private String parameterName;
        private String parameterValue;

        public Input(){}
        public Input(String parameterName, String parameterValue) {
            this.parameterName = parameterName;
            this.parameterValue = parameterValue;
        }

        @XmlElement(name = "parameterName")
        public String getParameterName() {
            return parameterName;
        }

        public void setParameterName(String parameterName) {
            this.parameterName = parameterName;
        }

        @XmlElement(name = "parameterValue")
        public String getParameterValue() {
            return parameterValue;
        }

        public void setParameterValue(String parameterValue) {
            this.parameterValue = parameterValue;
        }
    }

    /**
     *  The class is just an example. The Request for any related VAS endpoint is user-specific
     */
    @XmlRootElement
    public static class ActionRequest {

        private ArrayList<Input> input = new ArrayList<>();

        public ActionRequest(){}
        public ActionRequest(ArrayList<Input> input) {
            this.input = input;
        }

        @XmlElement(name = "input")
        public ArrayList<Input> getInput() {
            return input;
        }

        public void setInput(ArrayList<Input> input) {
            this.input = input;
        }
    }

    @XmlRootElement
    public static class PropertyRequest {

        private String value;

        public PropertyRequest(){}
        public PropertyRequest(String value) {
            this.value = value;
        }

        @XmlElement(name = "value")
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
