package com.example.demo_project.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.ifs.WidgetService;
import com.example.demo_project.repository.WidgetDao;

@Service
public class WidgetService_Impl implements WidgetService {

	@Autowired
	WidgetDao widgetdao;

	@Override
	public Widget save() {

		Widget widget = new Widget();
		widget.setName("AAA");
		return widgetdao.save(widget);
	}

}
