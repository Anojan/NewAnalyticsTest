package com.javacodegeeks.drools;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.DecisionTableConfiguration;
import org.kie.internal.builder.DecisionTableInputType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import com.javacodegeeks.drools.model.Analysis;

public class DroolsDecisionTableExample {
	private static StatelessKnowledgeSession session;

	public static void main(String[] args) throws Exception {
		KnowledgeBase knowledgeBase = createKnowledgeBaseFromSpreadsheet();
		session = knowledgeBase.newStatelessKnowledgeSession();

//		Customer customer = new Customer();
//		customer.setCoupon("x1");
		Map<String, String> tags = new HashMap<String, String>();
		tags.put("X1", "abc");
		tags.put("X2", "def");
		Analysis a = new Analysis();
		a.setTags(tags);
		session.execute(a);

//		System.out.println("First Customer\n" + customer);
//		System.out.println("*********************************");
//		System.out.println("Second Customer\n" + customer);
	}

	public static KnowledgeBase createKnowledgeBaseFromSpreadsheet()
			throws Exception {
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory
				.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);

		KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		knowledgeBuilder.add(ResourceFactory
				.newClassPathResource("URLs.xls"),
				ResourceType.DTABLE, dtconf);

		if (knowledgeBuilder.hasErrors()) {
			throw new RuntimeException(knowledgeBuilder.getErrors().toString());
		}		

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(knowledgeBuilder
				.getKnowledgePackages());
		return knowledgeBase;
	}
}
