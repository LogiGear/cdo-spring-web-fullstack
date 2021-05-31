/**
 * 
 */
package com.logigear.training.entities;
/**
 * @author bang.ngo
 *
 */
public class Employee {

	private String username;
	
	private String password;
	
	private String fullname;
	
	private String role;

	public Employee() {
	}

	public Employee(String username, String password, String fullname, String role) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}

	public  String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public String getRole() {
		return this.role;
	}

	public void setUsername( String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof Employee)) return false;
		final Employee other = (Employee) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$username = this.getUsername();
		final Object other$username = other.getUsername();
		if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
		final Object this$password = this.getPassword();
		final Object other$password = other.getPassword();
		if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
		final Object this$fullname = this.getFullname();
		final Object other$fullname = other.getFullname();
		if (this$fullname == null ? other$fullname != null : !this$fullname.equals(other$fullname)) return false;
		final Object this$role = this.getRole();
		final Object other$role = other.getRole();
		if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof Employee;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $username = this.getUsername();
		result = result * PRIME + ($username == null ? 43 : $username.hashCode());
		final Object $password = this.getPassword();
		result = result * PRIME + ($password == null ? 43 : $password.hashCode());
		final Object $fullname = this.getFullname();
		result = result * PRIME + ($fullname == null ? 43 : $fullname.hashCode());
		final Object $role = this.getRole();
		result = result * PRIME + ($role == null ? 43 : $role.hashCode());
		return result;
	}

	public String toString() {
		return "Employee(username=" + this.getUsername() + ", password=" + this.getPassword() + ", fullname=" + this.getFullname() + ", role=" + this.getRole() + ")";
	}
}
