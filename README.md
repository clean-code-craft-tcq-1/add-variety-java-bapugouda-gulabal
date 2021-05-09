# Check and Alert based on types

This exercise is based on the [BMS monitoring] domain.

Expand the checks and alerts to take care of a variety of types.

## Open for Extensions

How can you minimize the amount of work done to add a new type?
Can you add without modifying existing code?

# Implementation:

Code contains two code packages:

1. TypewiseBreachAlert :-
   classes are- 
   a) TypewiseAlert:- To check the breach and alert
   b) Battery Character:- It contains the properties of the battery Enums are- 
                                                                   a) CoolingType b) BreachType

2. AlertTarget: 
   It contains different types of Alert notifier classes - Email, console, controller, fake 
   
    One test package: typewiseBreachAlert: It contains TypewiseAlertTest to test units of TypeWiseAlertClass

