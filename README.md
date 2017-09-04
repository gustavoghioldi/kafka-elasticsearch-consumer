[![Build Status](https://travis-ci.org/BigDataDevs/kafka-elasticsearch-consumer.svg?branch=master)](https://travis-ci.org/BigDataDevs/kafka-elasticsearch-consumer)
[ ![Download](https://api.bintray.com/packages/bigdatadevs/bigdatadevs-repo/kafka-elasticsearch-consumer/images/download.svg) ](https://bintray.com/bigdatadevs/bigdatadevs-repo/kafka-elasticsearch-consumer/_latestVersion)

# kafka-elasticsearch-standalone-GHI-consumer!

## Arquitectura of the kafka-elasticsearch-standalone-GHI-consumer [indexer]

![](img/IndexerV2Design.jpg)


# Introduction

### **Kafka Standalone GHI Consumer [Indexer] lee mensajes de Kafka los procesa y los persiste en  ElasticSearch.**


# Como se usa ? 

### via Gradle 

1. `$INDEXER_HOME`/src/main/resources/config/kafka-es-indexer.properties <-- modificar.

2. `$INDEXER_HOME`/src/main/resources/config/logback.xml - especificar directorio en donde guardar los logs: `<property name="LOG_DIR" value="/tmp"/>`. 

3. `$INDEXER_HOME`/src/main/resources/config/kafka-es-indexer-start-options.config <-- aca configuro los offsets

4. `$INDEXER_HOME`/src/main/resources/spring/kafka-es-context-public.xml <-- aca propiedades el contexto

	Si necesitar usar un Handler a medida modificar aca:
	
	`<bean id="messageHandler"
          class="org.elasticsearch.kafka.indexer.service.impl.examples.SimpleMessageHandlerImpl"
          scope="prototype"/>`

5. bildeando la app:

    `cd $INDEXER_HOME`

    `./gradlew clean jar`

     **kafka-elasticsearch-consumer-0.0.2.0.jar** se crean en  `$INDEXER_HOME/build/libs/` dir.


6. run la app:

	`./gradlew run -Dindexer.properties=$INDEXER_HOME/src/main/resources/config/kafka-es-indexer.properties -Dlogback.configurationFile=$INDEXER_HOME/src/main/resources/config/logback.xml`
 
### generando un script:

* haver tdo lo anterior salvo correr la app (paso 6)
* run: `./gradlew clean installDist`

* `cd ./build/install/kafka-elasticsearch-consumer/bin`

* `./kafka-elasticsearch-consumer -Dindexer.properties=$INDEXER_HOME/src/main/resources/config/kafka-es-indexer.properties -Dlogback.configurationFile=$INDEXER_HOME/src/main/resources/config/logback.xml` 

# Versiiones soportadas

* Kafka Version: 0.10.2.1

* ElasticSearch: 5.5.x

* JDK 1.8

# Configuration

[kafka-es-indexer.properties](src/main/resources/config/kafka-es-indexer.properties).
You can specify you own properties file via `-Dindexer.properties=/abs-path/your-kafka-es-indexer.properties`

[logback.xml](src/main/resources/config/logback.xml).
`-Dlogback.configurationFile=/abs-path/your-logback.xml`

[kafka-es-context.xml](src/main/resources/spring/kafka-es-context-public.xml)

[kafka-es-indexer-start-options.config](src/main/resources/config/kafka-es-indexer-start-options.config).
`-Doffsets.config.path=/abs-path/your-kafka-es-indexer-start-options.config`