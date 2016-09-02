package com.dtc.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class Task4 implements EntryPoint {

	@Override
	public void onModuleLoad() {
		HorizontalLayoutContainer hlcTop = new HorizontalLayoutContainer();
		hlcTop.add(new TextButton("w:50%, h:50px"), new HorizontalLayoutData(0.5, 50));
		hlcTop.add(new TextButton("w:50%, h:50px"), new HorizontalLayoutData(0.5, 50));
		
		HorizontalLayoutContainer hlcBottomRightBottom = new HorizontalLayoutContainer();
		hlcBottomRightBottom.add(new TextButton("w:200px"), new HorizontalLayoutData(200, 1.0));
		hlcBottomRightBottom.add(new TextButton("?"), new HorizontalLayoutData(1.0, 1.0));
		hlcBottomRightBottom.add(new TextButton("w:80px h:80px"), new HorizontalLayoutData(80, 80));
		
		VerticalLayoutContainer vlcBottomRight = new VerticalLayoutContainer();
		vlcBottomRight.add(new TextButton("h:20%(不含上頭的 50px)"), new VerticalLayoutData(1.0, 0.2));
		vlcBottomRight.add(hlcBottomRightBottom, new VerticalLayoutData(1.0, 0.8));
		
		HorizontalLayoutContainer hlcBottom = new HorizontalLayoutContainer();
		hlcBottom.add(new TextButton("w:100px"), new HorizontalLayoutData(100, 1.0));
		hlcBottom.add(vlcBottomRight, new HorizontalLayoutData(1.0, 1.0));
		
		VerticalLayoutContainer vlcMain = new VerticalLayoutContainer();
		vlcMain.add(hlcTop, new VerticalLayoutData(1.0, 50));
		vlcMain.add(hlcBottom, new VerticalLayoutData(1.0, 1.0));
		
		Viewport vp = new Viewport();
		vp.add(vlcMain);

		RootPanel.get().add(vp);
		
	}
}
