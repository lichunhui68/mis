package com.sm.framework.model.entity;

public class Org {
	private String orgId = null;
	private String orgNo = null;
	private String orgName = null;
	private String orgMemo = null;
	private String orgTypeId = null;
	
	public Org() {
		// TODO Auto-generated constructor stub
	}

	public Org(String orgId, String orgNo, String orgName, String orgMemo,
			String orgTypeId) {
		super();
		this.orgId = orgId;
		this.orgNo = orgNo;
		this.orgName = orgName;
		this.orgMemo = orgMemo;
		this.orgTypeId = orgTypeId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgMemo() {
		return orgMemo;
	}

	public void setOrgMemo(String orgMemo) {
		this.orgMemo = orgMemo;
	}

	public String getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	@Override
	public String toString() {
		return "Org [orgId=" + orgId + ", orgNo=" + orgNo + ", orgName="
				+ orgName + ", orgMemo=" + orgMemo + ", orgTypeId=" + orgTypeId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgMemo == null) ? 0 : orgMemo.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgNo == null) ? 0 : orgNo.hashCode());
		result = prime * result
				+ ((orgTypeId == null) ? 0 : orgTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Org other = (Org) obj;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (orgMemo == null) {
			if (other.orgMemo != null)
				return false;
		} else if (!orgMemo.equals(other.orgMemo))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgNo == null) {
			if (other.orgNo != null)
				return false;
		} else if (!orgNo.equals(other.orgNo))
			return false;
		if (orgTypeId == null) {
			if (other.orgTypeId != null)
				return false;
		} else if (!orgTypeId.equals(other.orgTypeId))
			return false;
		return true;
	}
	
	
}
