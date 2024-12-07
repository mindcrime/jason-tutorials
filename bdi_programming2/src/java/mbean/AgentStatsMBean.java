package mbean;

public interface AgentStatsMBean
{
	public int getCurrentCycle();
	public void setCurrentCycle(int cycleNum);
	
	public String getIntentions();
	public void setIntentions(String intentions);
	
	public String getSelectedIntention();
	public void setSelectedIntention( String selectedIntention );
	
	public boolean isProceed();
	public void setProceed(boolean proceed);
	
	// operations
	
	public void doProceed();
	public void sayHello();	
	public int add(int x, int y);
	
}
