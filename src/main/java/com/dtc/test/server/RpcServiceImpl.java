package com.dtc.test.server;

import java.util.Date;

import com.dtc.test.client.RpcService;
import com.dtc.test.shared.exception.TestException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean before(Date clientDate) throws TestException {
		//故意暫停個一段時間，以顯示 async 的 fu
		try { Thread.sleep((long)(Math.random() * 5000) + 1000); } 
		catch (InterruptedException e) {}
		
		try {
			return new Date().compareTo(clientDate) > 0;
		} catch(NullPointerException npe) {
			throw new TestException("不要給我空值阿... 混蛋...");
		} catch(Exception e) {
			throw new TestException(e.getMessage());
		}
	}
}
