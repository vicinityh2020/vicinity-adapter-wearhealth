/*

Copyright © 2019 Wearhealth. All rights reserved.

This file is part of vicinity-adapter-wearhealth.

vicinity-adapter-wearhealth is free software: you can redistribute it and/or modify it under the terms of GNU General Public License v3.0.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

See README file for the full disclaimer information and LICENSE file for full license information in the project root.
*/
package com.wearhealth.adapter.template;

import com.wearhealth.adapter.template.pojos.Response;
import com.wearhealth.adapter.template.services.AdapterService;
import com.wearhealth.adapter.template.services.impl.AdapterServiceImpl;

import java.net.URI;
import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import org.springframework.http.*;
import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jubayed
 */

@SpringBootApplication
public class Application {


    private static final Logger LOG = Logger.getLogger(Application.class);

  public static void main(String[] args){

      //SpringApplication.run(Application.class, args);
      /*
      Read parameters from environment
       */
      ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
      String accessPoint = ctx.getEnvironment().getProperty("app.access-point");
      String password = ctx.getEnvironment().getProperty("app.password");

      Boolean initialize = Boolean.parseBoolean(ctx.getEnvironment().getProperty("app.initialize"));

      String agentProtocol = ctx.getEnvironment().getProperty("agent.protocol");
      String agentHost = ctx.getEnvironment().getProperty("agent.host");
      Integer agentPort = Integer.valueOf(ctx.getEnvironment().getProperty("agent.port"));
      String agentPath = ctx.getEnvironment().getProperty("agent.path");

      if (initialize) {
          LOG.info("Application will initialize things");

          RestTemplate restTemplate = new RestTemplate();

          /*
           * Agent_URL:Agent_Port is where your multi tenant agent is running, e.g. 160.43.33.111:8888
           *   , therefore, you have to adapt it for your case
           *
           * The POST during startup to the Agent below is needed when/if we do not have Auto-Discovery
           */
          //String agentUrl = "http://<Agent_URL>:<Agent_Port>/agent/objects";
          String agentUrl = getAgentUrl(agentProtocol, agentHost, agentPort, agentPath);

          AdapterService service = new AdapterServiceImpl();
          Response resp_ = service.getThingsDescription();

          HttpEntity<String> bodyEntity = new HttpEntity<>(resp_.getMessage(), createHeaders(accessPoint, password));

          URI uri = UriComponentsBuilder.fromHttpUrl(agentUrl)
                  .build()
                  .encode().toUri();

         // ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, String.class);

         // LOG.info("Things initialization response status : " + response.getStatusCodeValue());
      }

  }


    static HttpHeaders createHeaders(String username, String password){
        HttpHeaders headers = new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        return headers;
    }




  static String getAgentUrl(String protocol, String host, Integer port, String path) {
      return protocol + "://" + host + ":" + port + path;
  }
}
