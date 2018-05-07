package io.github.asw.i3a.operatorsWebClient.entities;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import TestKit.UnitTest;
import io.github.asw.i3a.operatorsWebClient.entitites.Agent;
import pl.pojo.tester.api.assertion.Method;

@Category(UnitTest.class)
public class AgentTest {

	@Test
	public void allPropertiesTest() {
		assertPojoMethodsFor(Agent.class).testing(Method.GETTER, Method.SETTER).testing(Method.EQUALS)
				.testing(Method.HASH_CODE).testing(Method.CONSTRUCTOR).areWellImplemented();
	}

}