package com.netty.bean;

import java.io.Serializable;

public class RpcResponse implements Serializable{
		private String requestId;
		private String result;
		public String getRequestId() {
			return requestId;
		}
		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		@Override
		public String toString() {
			return "RpcResponse [requestId=" + requestId + ", result=" + result + "]";
		}
		
}
