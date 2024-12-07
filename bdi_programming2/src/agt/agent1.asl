!dummy.

!started.

!started2.

!foobar.

+!started <- .print( "Started"); .wait(8000); +foobaz.

// include this, and the foobar Intention never fires, as the Desire is dropped
// before it is ever selected as an Intention
+!started2 <- .wait(800); .desire(foobar); .print( "Desire exists!"); .drop_desire(foobar).

+!foobar <- .print( "Foobar'ing"); .stopMAS.

+!dummy <- true.
