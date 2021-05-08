package org.covid19.india.CowinBot.executors;

import org.telegram.telegrambots.api.objects.Update;

public abstract class CommandExecutor {
	
	public String execute(final Update command) {
        if (!isValid(command)) {
            return "Invalid Command";
        }
        return executeValidCommand(command);
    }

    public abstract Boolean isApplicable(final String query);

    protected abstract Boolean isValid(final Update command);

    protected abstract String executeValidCommand(final Update command);

}
