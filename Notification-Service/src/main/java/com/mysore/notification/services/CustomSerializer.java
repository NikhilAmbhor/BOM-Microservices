package com.mysore.notification.services;

import java.util.Map;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysore.notification.model.Notification;

public class CustomSerializer implements Serializer<Notification> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, Notification data) {
		try {
			if (data == null) {
				System.out.println("Null received at serializing");
				return null;
			}
			System.out.println("Serializing...");

			return objectMapper.writeValueAsBytes(data);

		} catch (Exception e) {
			throw new SerializationException("Error when serializing MessageDto to byte[]");
		}
	}

	@Override
	public void close() {

	}

}
