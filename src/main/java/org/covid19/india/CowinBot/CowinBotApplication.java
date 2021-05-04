package org.covid19.india.CowinBot;

import org.covid19.india.CowinBot.service.Bot;
import org.covid19.india.CowinBot.service.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

@SpringBootApplication
public class CowinBotApplication {

	public static void main(String[] args) {

		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}


	//	Consumer.getAppointmentAvailabilityByPincode("474001", "01-05-2021");

		SpringApplication.run(CowinBotApplication.class, args);
	}

}
