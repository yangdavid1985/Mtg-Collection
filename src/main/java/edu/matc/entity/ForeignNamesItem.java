package edu.matc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ForeignNamesItem{

	@JsonProperty("multiverseid")
	private int multiverseid;

	@JsonProperty("name")
	private String name;

	@JsonProperty("language")
	private String language;

	@JsonProperty("imageUrl")
	private String imageUrl;

	public void setMultiverseid(int multiverseid){
		this.multiverseid = multiverseid;
	}

	public int getMultiverseid(){
		return multiverseid;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}
}