package org.uvperez.wscli.soap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Simple SOAP client that uses apache http components classes.
 * This class works with the default configuration of the support classes.
 * This class can be inherited to add more functionality/configuration
 * @author uperez
 *
 */
public class SimpleSoapClient implements SoapClient {

	private CloseableHttpClient client;
	
	private final static String NULL_SOAP_ACTION = null;

	private URI endpointUri;
	
    
	
	public SimpleSoapClient(URI endpointUri) {
		this.endpointUri = endpointUri;
		initClient();
	}
	
	protected void initClient() {
		client = createClient();
		
	}

	@Override
	public String request(String action, String payload) throws IOException {
		payload = (payload == null)? "" : payload;
		String soapAction = action;
		try {
            HttpPost post = new HttpPost(endpointUri.toString());
            StringEntity contentEntity = new StringEntity(payload);
            post.setEntity(contentEntity);
            if (payload.contains(SOAP_1_1_NAMESPACE)) {
                soapAction = soapAction != null ? "\"" + soapAction + "\"" : "";
                post.addHeader(PROP_SOAP_ACTION_11, soapAction);
                post.addHeader(PROP_CONTENT_TYPE, MIMETYPE_TEXT_XML_CHARSET_UTF8);
            } else if (payload.contains(SOAP_1_2_NAMESPACE)) {
                String contentType = MIMETYPE_APPLICATION_XML;
                if (soapAction != null) {
                    contentType = contentType + PROP_DELIMITER + PROP_SOAP_ACTION_12 + "\"" + soapAction + "\"";
                }
                post.addHeader(PROP_CONTENT_TYPE, contentType);
            }
            
            HttpResponse response = client.execute(post);
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                EntityUtils.consume(entity);
                throw new SoapClientException(statusLine.getReasonPhrase(), statusLine.getStatusCode());
            }
			return entity == null ? null : EntityUtils.toString(entity);
            
        } catch (UnsupportedEncodingException ex) {
            throw new SoapClientException(ex);
        }
	}
	
	protected CloseableHttpClient createClient() {
		CloseableHttpClient client = HttpClients.custom().build();
		return client;
	}

	@Override
	public String request(String payload) throws IOException {
		return request(NULL_SOAP_ACTION, payload);
	}

}
