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
package com.impetus.kundera.graphbrowser.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

/**
 * Actor Node Entity class
 * 
 * @author amresh.singh
 */

@Entity
@Table(name="ACTOR", schema="imdb@cassandra-pu")
@IndexCollection(columns = { @Index(name = "name", type = "KEYS") })
public class Actor
{
    @Id
    @Column(name = "ACTOR_ID")
    private int id;

    @Column(name = "ACTOR_NAME")
    private String name;

    public Actor()
    {
    }

    public Actor(int actorId, String actorName)
    {
        this.id = actorId;
        this.name = actorName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACTOR_ID")
    private List<Movie> movies;

    
    
    
   
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

	public List<Movie> getMovies() {
		return movies;
	}

	public void addMovie(Movie movie) {
		if(movies == null)
		{
			movies = new ArrayList<Movie>();
		}
		movies.add(movie);
	}
    
    

   

}
