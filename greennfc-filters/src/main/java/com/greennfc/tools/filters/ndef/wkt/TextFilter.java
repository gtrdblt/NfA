package com.greennfc.tools.filters.ndef.wkt;

public class TextFilter extends WellKnowFilter {

	protected TextFilter() {
	}

	@Override
	public String getDataType() {
		return "text/plain";
	}

}
