package by.sokhaeduard.eighthhw.controller.command;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.sokhaeduard.eighthhw.controller.RequestParameters;
import by.sokhaeduard.eighthhw.controller.ResponseParameters;
import by.sokhaeduard.eighthhw.controller.command.Command;
import by.sokhaeduard.eighthhw.controller.command.impl.AddBookCommand;

public class AddBookCommandTest {

    @DataProvider(name = "executeData")
    public Object[][] createDataExecute() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(RequestParameters.PARAMETER_TITLE, "War and Peace");
        parameters.put(RequestParameters.PARAMETER_AUTHORS, "Lev");
        parameters.put(RequestParameters.PARAMETER_NUMBER_PAGES, "500");
        parameters.put(RequestParameters.PARAMETER_TYPOGRAPHY, "Moscow");
        Map<java.lang.String, java.lang.String> response = new HashMap<>();
        response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
        return new Object[][]{
                {parameters, response}
        };
    }

    @Test(dataProvider = "executeData")
    public void executeTest(Map<String, String> parameters,
                            Map<String, String> expected) {
        Command command = new AddBookCommand();
        Map<String, String> actual = command.execute(parameters);
        assertEquals(actual, expected);
    }
}