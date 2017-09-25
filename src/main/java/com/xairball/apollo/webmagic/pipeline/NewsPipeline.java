package com.xairball.apollo.webmagic.pipeline;

import org.springframework.stereotype.Repository;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class NewsPipeline implements Pipeline {

	@Override
	public void process(ResultItems arg0, Task arg1) {
		// TODO Auto-generated method stub
		System.out.println(111);
	}

}
