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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

/**
 * Movie Node entity class
 * 
 * @author amresh.singh
 */

@Entity
@Table(name="MOVIE", schema="imdb@oraclenosql-pu")
@IndexCollection(columns = { @Index(name = "title", type = "KEYS"), @Index(name = "year", type = "KEYS") })
public class Movie
{
    @Id
    @Column(name = "MOVIE_ID")
    private String id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "YEAR")
    private int year;

    
    public Movie()
    {
    }

    public Movie(String id, String title, int year)
    {
        this.id = id;
        this.title = title;
        this.year = year;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

    

}
