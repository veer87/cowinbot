package org.covid19.india.CowinBot.executors;

import java.util.List;
import java.util.stream.Collectors;
import org.covid19.india.CowinBot.pojo.VaccinationCentre;
import org.covid19.india.CowinBot.service.CowinApi;
import org.telegram.telegrambots.api.objects.Update;

public class FetchCentresByLocationCommmandExecutor extends CommandExecutor {
	
	private static String INPUT_COMMAND = "LOCATION";
	
	

	@Override
	public Boolean isApplicable(String query) {
		if(query.equalsIgnoreCase(INPUT_COMMAND))
			return true;
		return false;
	}

	@Override
	protected Boolean isValid(Update command) {
		return true;
	}

	@Override
	protected String executeValidCommand(Update command) {
		
		String message = command.getMessage().getText();
        System.out.println(message);
        String[] tokens = message.split(" ");

        List<VaccinationCentre> vaccinationCentreList =  CowinApi.getAvailableVaccinationCentresBylocation(tokens[1],tokens[2],tokens[3],tokens[4]);
        
        //return top 10 VaccinationCentre
        List<VaccinationCentre> firstNVaccinationCentreList = vaccinationCentreList.stream().limit(5).collect(Collectors.toList());
        
        return firstNVaccinationCentreList.toString();
	
	}

}
