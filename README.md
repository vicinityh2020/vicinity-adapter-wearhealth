# VICINITY WearHealth Adapter

## About WearHealth

WearHealth is an intelligent decision support system that can use any 3rd party wearables
and IoT devices. 3rd party hardware is integrated into our proprietary cognitive technologies
to build an intelligent software platform that can identify markers of workers’ occupational
risks, health, workload, and work efficiency. With these insights, businesses are able to detect
and predict worker safety and health risks, thus preventing accidents and managing their workforce
 to improve productivity and operational efficiency.
IoT communication infrastructures and data stream integrations are not yet standardized in
the industry and need to comply with EU General Data Protection Regulation. The goal of this
project is to further develop our technology and market WearHealth version 2.0 that includes
a modularity approach to connecting to wearables and processing the data integrated into
VICINITY following its decentralized interoperability concept.

[Wearhealth official website]    https://www.wearhealth.com/

## Adopting WearHealth IoT resources to VICINITY things

 Sensors
	Smart shirt (ECG)

Smart shirt (ECG) have been modelled according to Vicinity adapters ontology and thus
registered within Vicinity platform.

Wearhealth devices that have been registered in Vicinity platform:

| Resource / PID        | Description / Thing Name     | Adapter Monitored Property  |
|:--------------------- |:---------------------------- |:--------------------------- |
| heart-rate                    | Heart Rate                   | Heart Rate in bpm           |

## Install

VICINITY Adapter for Wearhealth is being developed in Java 8 and uses Spring Boot Framework ```2.1.6.RELEASE```, thus it can be
installed via -

```
mvn clean install
```
## WearHealth VAS Application  
```
[WH_VAS_Service]
```
