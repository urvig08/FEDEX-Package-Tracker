package Assign4;

public class Details {
	String packaging;
	String signature_services;
	String weight;
	String tracking_number;
	String dimensions;
	String services;
	String special_handling_section;
	String source_city, destination, estimated_date, shipping_date;
	public Details(String packaging, String signature_services, String weight, String tracking_number,
			String dimensions, String services, String special_handling_section, String source_city, String destination,
			String estimated_date, String shipping_date) {
		super();
		this.packaging = packaging;
		this.signature_services = signature_services;
		this.weight = weight;
		this.tracking_number = tracking_number;
		this.dimensions = dimensions;
		this.services = services;
		this.special_handling_section = special_handling_section;
		this.source_city = source_city;
		this.destination = destination;
		this.estimated_date = estimated_date;
		this.shipping_date = shipping_date;
	}
	
	public Details() {
		// TODO Auto-generated constructor stub
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getSignature_services() {
		return signature_services;
	}
	public void setSignature_services(String signature_services) {
		this.signature_services = signature_services;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getSpecial_handling_section() {
		return special_handling_section;
	}
	public void setSpecial_handling_section(String special_handling_section) {
		this.special_handling_section = special_handling_section;
	}
	public String getSource_city() {
		return source_city;
	}
	public void setSource_city(String source_city) {
		this.source_city = source_city;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getEstimated_date() {
		return estimated_date;
	}
	public void setEstimated_date(String estimated_date) {
		this.estimated_date = estimated_date;
	}
	public String getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}
	@Override
	public String toString() {
		return "Details [packaging=" + packaging + ", signature_services=" + signature_services + ", weight=" + weight
				+ ", tracking_number=" + tracking_number + ", dimensions=" + dimensions + ", services=" + services
				+ ", special_handling_section=" + special_handling_section + ", source_city=" + source_city
				+ ", destination=" + destination + ", estimated_date=" + estimated_date + ", shipping_date="
				+ shipping_date + "]";
	}
	
	
	

}
