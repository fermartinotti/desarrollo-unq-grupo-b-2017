package morfiya.domain.auth;

public class AuthProfile {
	
	public String sub;
	public String given_name;
	public String family_name;
	public String nickname;
	public String name;
	public String picture;
	public String gender;
	public String locale;
	public String updated_at;
	public String email;
	public String email_verified;
	
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_verified() {
		return email_verified;
	}
	public void setEmail_verified(String email_verified) {
		this.email_verified = email_verified;
	}
	
	
	
}
