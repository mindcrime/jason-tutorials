package org.fogbeam.demo.spring;

import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import jason.architecture.AgArch;
import jason.asSemantics.Agent;
import jason.infra.local.LocalAgArch;
import jason.mas2j.ClassParameters;
import jason.runtime.Settings;
import jason.util.Config;

public class SpringLocalAgArch extends LocalAgArch
{
    /**
     * Creates the user agent architecture, default architecture is
     * jason.architecture.AgArch. The arch will create the agent that then creates
     * the TS.
     */
    public Agent createArchs2(List<String> agArchClasses, String agClass, ClassParameters bbPars, String asSrc, Settings stts) throws Exception {
        try {
        	Agent ag = Agent.create(this, agClass, bbPars, asSrc, stts);
            insertAgArch(this);

            createCustomArchs(agArchClasses);

            // mind inspector arch
            if (stts.getUserParameter(Settings.MIND_INSPECTOR) != null) {
                insertAgArch( (AgArch)Class.forName( Config.get().getMindInspectorArchClassName()).getConstructor().newInstance() );
                getFirstAgArch().init();
            }

            setLogger();
            
            return ag;
            
        } catch (Exception e) 
        {
        	FieldUtils.writeField(this, "running", false, true);
        	
        	// running = false;        
        	
        	throw e; //new JasonException("as2j: error creating the agent class! - "+e.getMessage(), e);
        }
    }

}
