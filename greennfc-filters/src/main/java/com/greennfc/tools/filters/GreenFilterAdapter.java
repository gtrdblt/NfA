package com.greennfc.tools.filters;

import com.greennfc.tools.api.IGreenIntentFilter;

public abstract class GreenFilterAdapter implements IGreenIntentFilter {

	public String getDataType() {
		return null;
	}

	public String getAction() {
		return null;
	}

	public String getDataScheme() {
		return null;
	}

	public String getDataAuthorityPort() {
		return null;
	}

	public String getDataAuthorityHost() {
		return null;
	}

	public String getDataPath() {
		return null;
	}

}
