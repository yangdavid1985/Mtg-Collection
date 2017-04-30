package edu.matc.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CardsItem{

	@JsonProperty("colorIdentity")
	private List<String> colorIdentity;

	@JsonProperty("setName")
	private String setName;

	@JsonProperty("multiverseid")
	private int multiverseid;

	@JsonProperty("foreignNames")
	private List<ForeignNamesItem> foreignNames;

	@JsonProperty("originalType")
	private String originalType;

	@JsonProperty("artist")
	private String artist;

	@JsonProperty("rulings")
	private List<RulingsItem> rulings;

	@JsonProperty("type")
	private String type;

	@JsonProperty("colors")
	private List<String> colors;

	@JsonProperty("subtypes")
	private List<String> subtypes;

	@JsonProperty("number")
	private String number;

	@JsonProperty("printings")
	private List<String> printings;

	@JsonProperty("imageUrl")
	private String imageUrl;

	@JsonProperty("text")
	private String text;

	@JsonProperty("power")
	private String power;

	@JsonProperty("id")
	private String id;

	@JsonProperty("toughness")
	private String toughness;

	@JsonProperty("supertypes")
	private List<String> supertypes;

	@JsonProperty("types")
	private List<String> types;

	@JsonProperty("timeshifted")
	private boolean timeshifted;

	@JsonProperty("set")
	private String set;

	@JsonProperty("loyalty")
	private int loyalty;

	@JsonProperty("legalities")
	private List<LegalitiesItem> legalities;

	@JsonProperty("flavor")
	private String flavor;

	@JsonProperty("layout")
	private String layout;

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	@JsonProperty("border")
	private String border;

	@JsonProperty("reserve")
	private String reserve;

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	@JsonProperty("reserved")
	private String reserved;


	public String getWatermark() {
		return watermark;
	}

	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}

	@JsonProperty("watermark")
	private String watermark;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@JsonProperty("source")
	private String source;

	public List<String> getVariations() {
		return variations;
	}

	public void setVariations(List<String> variations) {
		this.variations = variations;
	}

	@JsonProperty("variations")
	private List<String> variations;

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}

	@JsonProperty("life")
	private String life;


	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	@JsonProperty("hand")
	private String hand;


	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@JsonProperty("releaseDate")
	private String releaseDate;

	@JsonProperty("originalText")
	private String originalText;

	@JsonProperty("names")
	private List<String> names;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cmc")
	private int cmc;

	@JsonProperty("manaCost")
	private String manaCost;

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

	public void setForeignNames(List<ForeignNamesItem> foreignNames){
		this.foreignNames = foreignNames;
	}

	public List<ForeignNamesItem> getForeignNames(){
		return foreignNames;
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

	public void setRulings(List<RulingsItem> rulings){
		this.rulings = rulings;
	}

	public List<RulingsItem> getRulings(){
		return rulings;
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

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
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

	public void setToughness(String toughness){
		this.toughness = toughness;
	}

	public String getToughness(){
		return toughness;
	}

	public void setSupertypes(List<String> supertypes){
		this.supertypes = supertypes;
	}

	public List<String> getSupertypes(){
		return supertypes;
	}

	public void setTypes(List<String> types){
		this.types = types;
	}

	public List<String> getTypes(){
		return types;
	}

	public void setTimeshifted(boolean timeshifted){
		this.timeshifted = timeshifted;
	}

	public boolean isTimeshifted(){
		return timeshifted;
	}

	public void setSet(String set){
		this.set = set;
	}

	public String getSet(){
		return set;
	}

	public void setLoyalty(int loyalty){
		this.loyalty = loyalty;
	}

	public int getLoyalty(){
		return loyalty;
	}

	public void setLegalities(List<LegalitiesItem> legalities){
		this.legalities = legalities;
	}

	public List<LegalitiesItem> getLegalities(){
		return legalities;
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

	public void setNames(List<String> names){
		this.names = names;
	}

	public List<String> getNames(){
		return names;
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

	public void setManaCost(String manaCost){
		this.manaCost = manaCost;
	}

	public String getManaCost(){
		return manaCost;
	}

	public void setRarity(String rarity){
		this.rarity = rarity;
	}

	public String getRarity(){
		return rarity;
	}
}