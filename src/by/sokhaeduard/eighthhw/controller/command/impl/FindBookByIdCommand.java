package by.sokhaeduard.eighthhw.controller.command.impl;

import java.util.HashMap;
import java.util.Map;

import by.sokhaeduard.eighthhw.controller.RequestParameters;
import by.sokhaeduard.eighthhw.controller.ResponseParameters;
import by.sokhaeduard.eighthhw.controller.command.Command;
import by.sokhaeduard.eighthhw.entity.Book;
import by.sokhaeduard.eighthhw.service.BookService;
import by.sokhaeduard.eighthhw.service.ServiceException;
import by.sokhaeduard.eighthhw.service.impl.BookServiceImpl;

public class FindBookByIdCommand implements Command {

	@Override
	public Map<String, String> execute(Map<String, String> parameters) {
		BookService service = BookServiceImpl.getBookServiceInstance();
		String id = parameters.get(RequestParameters.PARAMETER_ID);
		Map<String, String> response = new HashMap<>();
		try {
			Book bookById = service.findBookById(id);
			response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
			response.put(ResponseParameters.RESULT, bookById.toString());
		} catch (ServiceException e) {
			response.put(ResponseParameters.STATUS, ResponseParameters.ERROR_STATUS);
			response.put(ResponseParameters.MESSAGE, e.getMessage());
		}
		return response;
	}

}
