package com.account

import com.tools.EncryptUtil
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String fullname
	Date expiredDate
	Date createdTime
	Date updatedTime
	User createBy
	boolean newAccount = true
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false
	Date lastLoginTime
	String lastLoginIP

	User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {

		password = EncryptUtil.encode(username+password)
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
		lastLoginTime nullable: true
		lastLoginIP nullable: true
		expiredDate nullable: true
	}

	static mapping = {
		cache true
		table("t_user")
		fullname column: "s_fullname"
		password column: "s_password"
		username column: "s_username"
		expiredDate column: "d_expired_date"
		newAccount column: "is_new_account"
		enabled column: "is_enabled"
		accountExpired column: "is_account_expired"
		accountLocked column: "is_account_locked"
		passwordExpired column: "is_password_expired"
		createdTime column: "d_create_time"
		updatedTime column: "d_update_time"
		createBy column: "n_user_id"
		lastLoginTime column: "d_last_login_time"
		lastLoginIP column: "d_last_login_ip"
	}

	def enableOrDisable() {
		enabled = !enabled
	}
}
