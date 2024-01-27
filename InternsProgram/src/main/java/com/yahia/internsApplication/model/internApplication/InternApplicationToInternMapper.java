package com.yahia.internsApplication.model.internApplication;


import com.yahia.internsApplication.model.intern.Intern;
import org.springframework.stereotype.Service;


import java.util.function.Function;

@Service
public class InternApplicationToInternMapper implements Function<InternApplication, Intern> {
    @Override
    public Intern apply(InternApplication internApplication) {
        return new Intern(
                internApplication.getName(),
                internApplication.getGpa(),
                internApplication.getCvUrl(),
                internApplication.getUniversityName(),
                internApplication.getTrack(),
                internApplication.getEmail(),
                "1234"
        );
    }
}
