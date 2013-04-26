/**
 * Copyright 2012 Impetus Infotech.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.impetus.kundera.graphbrowser.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.impetus.kundera.graphbrowser.IMDBUtils;
import com.impetus.kundera.graphbrowser.entities.Actor;
import com.impetus.kundera.graphbrowser.entities.Movie;
import com.impetus.kundera.graphbrowser.service.IMDBService;

/**
 * Managed Bean for IMDB 
 * @author amresh.singh
 */
@ManagedBean(name="imdbBean")
@RequestScoped
public class IMDBBean
{
    public String execute()
    {       
        
        IMDBService imdbService = IMDBUtils.getIMDBService();        
        
        // Actors
        Actor actor1 = new Actor(1, "Tom Cruise");        

        // Movies
        Movie movie1 = new Movie("m1", "War of the Worlds", 2005);
        Movie movie2 = new Movie("m2", "Mission Impossible", 1996);
        Movie movie3 = new Movie("m3", "Hell", 2009);      

        // Relationships
        actor1.addMovie(movie1);
        actor1.addMovie(movie2);
        actor1.addMovie(movie3);

        
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(actor1);        
        imdbService.insert(actor1);    
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Test case run successfully"));
        
        imdbService.find();
        
        imdbService.findActorByName();
        
        imdbService.merge();
        
        imdbService.delete();
        
        imdbService.find();
        
        String outcome = "insertionSuccessful";
        
        return outcome;
    }
}