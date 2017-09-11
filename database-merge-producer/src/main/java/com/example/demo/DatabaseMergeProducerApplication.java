package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.couchbase.kafka.CouchbaseKafkaConnector;
import com.couchbase.kafka.DefaultCouchbaseKafkaEnvironment;

@SpringBootApplication
public class DatabaseMergeProducerApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(DatabaseMergeProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DefaultCouchbaseKafkaEnvironment.Builder builder = (DefaultCouchbaseKafkaEnvironment.Builder) DefaultCouchbaseKafkaEnvironment
				.builder()
				.kafkaFilterClass("com.example.demo.FilterImpl")
				.kafkaTopic("BVTP")
				.kafkaZookeeperAddress("192.168.74.23:20021")
				.couchbaseNodes("172.16.2.101")
				.couchbaseBucket("BSA_TRANSACTION")
				.kafkaValueSerializerClass("com.example.demo.Encoder")
				.dcpEnabled(true);
		CouchbaseKafkaConnector connector = CouchbaseKafkaConnector.create(builder.build());
		connector.run();
	}

}
