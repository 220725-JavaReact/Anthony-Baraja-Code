package com.revature.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoreComponentsTest {

	@Test
	void setNameShouldSet() {
		
		// Arrange
		CoreComponents cc = new CoreComponents();
		String testName = "AMD Legacy 1";
		
		// Act
		cc.setName(testName);
		
		// Assert
		assertEquals(testName, cc.getName());
	}

}
