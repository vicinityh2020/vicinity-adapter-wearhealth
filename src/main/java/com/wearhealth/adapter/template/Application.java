/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wearhealth.adapter.template;

import com.wearhealth.adapter.template.pojos.Response;
import com.wearhealth.adapter.template.services.AdapterService;
import com.wearhealth.adapter.template.services.impl.AdapterServiceImpl;

import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Jubayed
 */

@SpringBootApplication
public class Application {

  public static void main(String[] args){

      //SpringApplication.run(Application.class, args);
      /*
      Read parameters from environment
       */
      ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
      String accessPoint = ctx.getEnvironment().getProperty("app.access-point");

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

          ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, String.class);

          LOG.info("Things initialization response status : " + response.getStatusCodeValue());
      }

  }




  static String getAgentUrl(String protocol, String host, Integer port, String path) {
      return protocol + "://" + host + ":" + port + path;
  }
}