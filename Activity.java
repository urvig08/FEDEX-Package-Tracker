package Assign4;

public class Activity {

	String tracking_number;
	String activity_id;
	String delivery_status;
	String Date;
	String day;
	String location;
	String message;
	
	
	public Activity(String tracking_number, String activity_id, String delivery_status, String date, String day,
			String location, String message) {
		this.tracking_number = tracking_number;
		this.activity_id = activity_id;
		this.delivery_status = delivery_status;
		this.Date = date;
		this.day = day;
		this.location = location;
		this.message = message;
	}
	
	
	
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return  "Delivery_status = "
				+ delivery_status + ", Date = " + Date + ", day = " + day + ", location = " + location + ", message = "
				+ message;
	}




	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public String getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
