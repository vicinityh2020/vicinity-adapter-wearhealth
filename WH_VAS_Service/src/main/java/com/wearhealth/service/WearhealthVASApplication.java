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

package com.wearhealth.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application must start from this main function
 * @author WearHealth
 */

@SpringBootApplication
public class WearhealthVASApplication {

    public static void main(String[] args) {
        SpringApplication.run(WearhealthVASApplication.class, args);
    }

}
