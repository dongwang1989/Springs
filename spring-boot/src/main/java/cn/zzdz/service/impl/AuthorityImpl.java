package cn.zzdz.service.impl;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityImpl implements GrantedAuthority {

	/**
	 *
	 */
	public AuthorityImpl(Set<String> permissions) {
		this.permissions = permissions;
	}

	private static final long serialVersionUID = 1L;
	private Set<String> permissions;

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
