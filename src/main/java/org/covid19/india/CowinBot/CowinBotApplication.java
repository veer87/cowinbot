package org.covid19.india.CowinBot;

import java.util.ArrayList;
import java.util.List;

import org.covid19.india.CowinBot.executors.CommandExecutor;
import org.covid19.india.CowinBot.executors.FetchCentresByLocationCommmandExecutor;
import org.covid19.india.CowinBot.service.Bot;
import org.covid19.india.CowinBot.service.CowinApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class CowinBotApplication {

	
	public static void main(String[] args) {

		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		List<CommandExecutor> commandList = new ArrayList<>();
		try {
			
			CommandExecutor fetchCentresByLocationCommmandExecutor = new FetchCentresByLocationCommmandExecutor();
			commandList.add(fetchCentresByLocationCommmandExecutor);
			telegramBotsApi.registerBot(new Bot(commandList));
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}


		/*ResponseEntity<String> responseEntity1 = CowinApi.getCalendarByPin("474001", "01-05-2021");
		ResponseEntity<String> responseEntity2 = CowinApi.getFindByPin("474001", "01-05-2021");
		System.out.println("----------ResponseE1---"+responseEntity1.getBody()+"\n"+
							"-------Respe2---- " + responseEntity2.getBody());*/
		SpringApplication.run(CowinBotApplication.class, args);
	}

}
