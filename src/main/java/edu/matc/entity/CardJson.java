package edu.matc.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CardJson {

    @JsonProperty("colorIdentity")
    private List<String> colorIdentity;

    @JsonProperty("setName")
    private String setName;

    @JsonProperty("multiverseid")
    private int multiverseid;

    @JsonProperty("types")
    private List<String> types;

    @JsonProperty("set")
    private String set;

    @JsonProperty("originalType")
    private String originalType;

    @JsonProperty("artist")
    private String artist;

    @JsonProperty("legalities")
    private List<LegalitiesItem> legalities;

    @JsonProperty("type")
    private String type;

    @JsonProperty("colors")
    private List<String> colors;

    @JsonProperty("subtypes")
    private List<String> subtypes;

    @JsonProperty("number")
    private int number;

    @JsonProperty("flavor")
    private String flavor;

    @JsonProperty("layout")
    private String layout;

    @JsonProperty("originalText")
    private String originalText;

    @JsonProperty("printings")
    private List<String> printings;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cmc")
    private int cmc;

    @JsonProperty("supertypes")
    private List<String> supertypes;

    @JsonProperty("text")
    private String text;

    @JsonProperty("power")
    private String power;

    @JsonProperty("id")
    private String id;

    @JsonProperty("manaCost")
    private String manaCost;

    @JsonProperty("toughness")
    private String toughness;

    @JsonProperty("rarity")
    private String rarity;

    public void setColorIdentity(List<String> colorIdentity){
        this.colorIdentity = colorIdentity;
    }

    public List<String> getColorIdentity(){
        return colorIdentity;
    }

    public void setSetName(String setName){
        this.setName = setName;
    }

    public String getSetName(){
        return setName;
    }

    public void setMultiverseid(int multiverseid){
        this.multiverseid = multiverseid;
    }

    public int getMultiverseid(){
        return multiverseid;
    }

    public void setTypes(List<String> types){
        this.types = types;
    }

    public List<String> getTypes(){
        return types;
    }

    public void setSet(String set){
        this.set = set;
    }

    public String getSet(){
        return set;
    }

    public void setOriginalType(String originalType){
        this.originalType = originalType;
    }

    public String getOriginalType(){
        return originalType;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getArtist(){
        return artist;
    }

    public void setLegalities(List<LegalitiesItem> legalities){
        this.legalities = legalities;
    }

    public List<LegalitiesItem> getLegalities(){
        return legalities;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setColors(List<String> colors){
        this.colors = colors;
    }

    public List<String> getColors(){
        return colors;
    }

    public void setSubtypes(List<String> subtypes){
        this.subtypes = subtypes;
    }

    public List<String> getSubtypes(){
        return subtypes;
    }

    public void setFlavor(String flavor){
        this.flavor = flavor;
    }

    public String getFlavor(){
        return flavor;
    }

    public void setLayout(String layout){
        this.layout = layout;
    }

    public String getLayout(){
        return layout;
    }

    public void setOriginalText(String originalText){
        this.originalText = originalText;
    }

    public String getOriginalText(){
        return originalText;
    }

    public void setPrintings(List<String> printings){
        this.printings = printings;
    }

    public List<String> getPrintings(){
        return printings;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCmc(int cmc){
        this.cmc = cmc;
    }

    public int getCmc(){
        return cmc;
    }

    public void setSupertypes(List<String> supertypes) { this.supertypes = supertypes; }

    public List<String> getSupertypes() { return supertypes; }

    public void setNumber(int number) { this.number = number; }

    public int getNumber() { return number; }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setPower(String power){
        this.power = power;
    }

    public String getPower(){
        return power;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setManaCost(String manaCost){
        this.manaCost = manaCost;
    }

    public String getManaCost(){
        return manaCost;
    }

    public void setToughness(String toughness){
        this.toughness = toughness;
    }

    public String getToughness(){
        return toughness;
    }

    public void setRarity(String rarity){
        this.rarity = rarity;
    }

    public String getRarity(){
        return rarity;
    }
}