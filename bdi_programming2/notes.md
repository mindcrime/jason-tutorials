# Notes on BDI Programming
## Chapter 8 "BDI Programming" from "Programming Multi-agent Systems in AgentSpeak with Jason"


### Definitions

Desires and Goals are very closely related!

Desires - states of affairs that the agent would like to bring about.
Goals - a consistent subset of an agent's Desires.

Note that using those two definitions, **both** Goals AND Desires are
"states of affairs that the agent would like to bring about". Goals are simply
a subset of the larger set of Desires.

Beliefs - literals denoting things directly believed by the agent

Intentions:
    a. The chosen course of action to achieve a Goal (intention-to); an instance of 
       a plan is an intention-to.
    b. The state that the chosen course of action aims to achieve (intention-that); in this
       case intentions are seen as a subset of an agent's Desires - the ones it is **committed*
       to bringing about.
       
Regarding "intention-that" and "intention-to" instances:
 
    an "intention that" is naturally seen as the goal in the triggering event of a plan instance
    within the set of intentions. For example, if an agent has a plan "+!g : b <- a." in its set
    of intentions, then "a' is an "intention-to" because g is an "intention-that"; the agent has
    the Desire to achieve a state of affairs where g is true, and is commited to bringing that
    about by being committed to executing a.
    
Intentions-that are a subset of desires. In particular, they are the specific desire for which
an agent has chosen a course of action (and committed to execute it). There are the goals for
which a plan is *already* in the set of intentions.    

When new Goals are created, they generate (internal) events that are included in the set of events.
At that point, the agent has a new Goal (eg, a new Desire) but has not yet committed to bringing
it about; in fact, it may turn out that the agent does not have the know-how, ability, or resources
to do so. 

While a relevant and applicable plan is not found for a particular goal currently in the
set of intentions, we can refer to it as a desire, but it is certainly not an intention.

NOTE: in AgentSpeak, the context part of a plan implicitly checks the belief state, it does
not allow for the agent's Desires and Intentions to be checked. The base language / model
does also not have a notion of the ability to **drop** a goals.

Jason includes "internal actions" to fill in these gaps, as follows:

.desire(D) - checks if D is one of the agent's desires

.intent(I) - checks if I is an Intention specifically (excluding the achievement goals that are
 internal events presently in the set of events)

.drop_desire(D) - removes events that are goal additions of D, then does everything that
 .drop_intention would do. Eg, all intentions and events which would cause .desire to succeed for
 this argument are dropped.
 
.drop_intention(I) - works like .drop_desire, but works on each intention in the set of intentions
 where any of the goal additions in the triggering events of plans unify with I. In other words,
 all Intentions that would make .intend(I) true are dropped.
 
.drop_event - Used where only achievement goals appearing in events (desires that are 
 not intentions) should be dropped.
 
.drop_all_desires - all events and all intentions are dropped. This also includes external events.

.drop_all_intentions - all intentions except the currently selected intention are dropped.

.drop_all_events - all events (including external events) currently in the set of events are dropped.


.succeed_goal(G) - TBD
.fail_goal(G) - TBD





    
    


