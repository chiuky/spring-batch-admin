package org.springframework.batch.admin.service;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.step.StepLocator;
import org.springframework.beans.factory.FactoryBean;

public class StepLocatorStepFactoryBean implements FactoryBean<Step> {

	public StepLocator stepLocator;
	public String stepName;

	/**
	 * @param stepLocator
	 */
	public void setStepLocator(StepLocator stepLocator) {
		this.stepLocator = stepLocator;
	}

	/**
	 * @param stepName
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;	
	}

	/**
	 * 
	 * @see FactoryBean#getObject()
	 */
	@Override
	public Step getObject() throws Exception {
		return stepLocator.getStep(stepName);
	}

	/**
	 * Tell clients that we are a factory for {@link Step} instances.
	 * 
	 * @see FactoryBean#getObjectType()
	 */
	@Override
	public Class<? extends Step> getObjectType() {
		return Step.class;
	}

	/**
	 * Always return true as optimization for bean factory.
	 * 
	 * @see FactoryBean#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}