package com.company.restfulAPIs;
import com.company.hibernate.StudentManagement;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
public class RestConfiguration extends Application{

    private Set<Object> singletons = new HashSet<Object>();

    public RestConfiguration() {
        singletons.add(new StudentsResource());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}


