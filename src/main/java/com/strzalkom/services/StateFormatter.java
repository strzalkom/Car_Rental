package com.strzalkom.services;

import com.strzalkom.domain.State;
import com.strzalkom.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.Locale;

@Service
public class StateFormatter implements Formatter<State> {

    @Autowired
    StateRepository repository;

    @Override
    public State parse(String idAsStr, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idAsStr);
        return repository.getState(id);
    }

    @Override
    public String print(State object, Locale locale) {
        return object.toString();
    }
}
