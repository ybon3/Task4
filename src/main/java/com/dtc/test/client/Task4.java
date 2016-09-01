package com.dtc.test.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.DateField;

public class Task4 implements EntryPoint {
	private static final RpcServiceAsync rpc = GWT.create(RpcService.class);

	private DateField dateField = new DateField();
	private TextButton button = new TextButton("送出");
	private boolean rpcFinish = false;
	private int counter = 0;
	private DateTimeFormat format = DateTimeFormat.getFormat("HH:mm:ss");

	@Override
	public void onModuleLoad() {
		button.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				start();
			}
		});
		
		VerticalLayoutContainer vc = new VerticalLayoutContainer();
		vc.add(dateField);
		vc.add(button);

		RootPanel.get().add(vc);
	}
	
	private void start() {
		GWT.log("開始啦開始啦～～～～");
		counter = 0;
		rpcFinish = false;
		
		//發 RPC
		rpc.before(dateField.getValue(), new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				GWT.log(result + "你的時間比較" + (result ? "早" : "晚"));
				rpcFinish = true;
			}
			
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("出問題啦！訊息：" + caught.getMessage());
				rpcFinish = true;
			}
		});
		
		//每隔 1 秒鐘寫一行 log 以顯示出 async 的行為
		Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
			@Override
			public boolean execute() {
				counter++;
				GWT.log("第 " + counter + " 次 @ " + format.format(new Date()));
				return !rpcFinish;
			}
		}, 1000);		
	}
}
