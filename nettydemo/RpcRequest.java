package com.netty.bean;

import java.io.Serializable;
import java.util.Arrays;

public class RpcRequest implements Serializable{

	private String requestId;
	private String interfaceName;
	private String methoddName;
	private Object [] paramaterTypes;
	private Object [] parameters;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getMethoddName() {
		return methoddName;
	}
	public void setMethoddName(String methoddName) {
		this.methoddName = methoddName;
	}
	public Object[] getParamaterTypes() {
		return paramaterTypes;
	}
	public void setParamaterTypes(Object[] paramaterTypes) {
		this.paramaterTypes = paramaterTypes;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
	@Override
	public String toString() {
		return "RpcRequest [requestId=" + requestId + ", interfaceName=" + interfaceName + ", methoddName="
				+ methoddName + ", paramaterTypes=" + Arrays.toString(paramaterTypes) + ", parameters="
				+ Arrays.toString(parameters) + "]";
	}
	
	
}
