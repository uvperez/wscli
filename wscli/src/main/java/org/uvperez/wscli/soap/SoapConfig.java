package org.uvperez.wscli.soap;

import java.net.URI;
import java.security.Security;

public class SoapConfig {

	private int readTimeoutInMillis;
	private int connectTimeoutInMillis;
	private boolean endpointTlsEnabled;
	private URI proxyUri;
	private Security proxyProperties;
	private boolean proxyTlsEnabled;

	public SoapConfig() {
	}
	
	public int getReadTimeoutInMillis() {
		return readTimeoutInMillis;
	}

	public int getConnectTimeoutInMillis() {
		return connectTimeoutInMillis;
	}

	public boolean isEndpointTlsEnabled() {
		return endpointTlsEnabled;
	}

	public URI getProxyUri() {
		return proxyUri;
	}

	public Security getProxyProperties() {
		return proxyProperties;
	}

	public boolean isProxyTlsEnabled() {
		return proxyTlsEnabled;
	}

	public void setReadTimeoutInMillis(int readTimeoutInMillis) {
		this.readTimeoutInMillis = readTimeoutInMillis;
	}

	public void setConnectTimeoutInMillis(int connectTimeoutInMillis) {
		this.connectTimeoutInMillis = connectTimeoutInMillis;
	}

	public void setEndpointTlsEnabled(boolean endpointTlsEnabled) {
		this.endpointTlsEnabled = endpointTlsEnabled;
	}

	public void setProxyUri(URI proxyUri) {
		this.proxyUri = proxyUri;
	}

	public void setProxyProperties(Security proxyProperties) {
		this.proxyProperties = proxyProperties;
	}

	public void setProxyTlsEnabled(boolean proxyTlsEnabled) {
		this.proxyTlsEnabled = proxyTlsEnabled;
	}
	
	
}
