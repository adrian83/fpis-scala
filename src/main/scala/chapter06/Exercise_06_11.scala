package chapter06
/*
Hard: To gain experience with the use of State , implement a finite state 
automaton that models a simple candy dispenser. The machine has two types 
of input: you can insert a coin, or you can turn the knob to dispense candy. 
It can be in one of two states: locked or unlocked. It also tracks how many 
candies are left and how many coins it contains. 

sealed trait Input 
case object Coin extends Input 
case object Turn extends Input 

case class Machine(locked: Boolean, candies: Int, coins: Int)

The rules of the machine are as follows: 
- Inserting a coin into a locked machine will cause it to unlock if there’s any candy left. 
- Turning the knob on an unlocked machine will cause it to dispense candy and become locked. 
- Turning the knob on a locked machine or inserting a coin into an unlocked machine does nothing. 
- A machine that’s out of candy ignores all inputs. 

The method simulateMachine 
should operate the machine based on the list of inputs and return the 
number of coins and candies left in the machine at the end. For 
example, if the input Machine has 10 coins and 5 candies, and a total 
of 4 candies are successfully bought, the output should be (14, 1) . 

def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)]

 */

// case class State[S, +A](run: S => (A, S))

sealed trait Input
case object Coin extends Input
case object Turn extends Input

case class Machine(locked: Boolean, candies: Int, coins: Int)

object Exercise_06_11 extends App {

  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = 


      State(ma => {
        inputs match {
          case Nil => ((ma.coins, ma.candies), ma)
          case x :: xs => {
            val machine = x match {
              case Coin => {
                if(ma.candies < 1) {
                  ma
                } else if(ma.locked && ma.candies>0){
                  Machine(false, ma.candies, ma.coins+1)
                } else {
                  ma
                }
                
                
                
              }
              case Turn => {
                if(ma.candies < 1) {
                   ma
                } else if(! ma.locked){
                  Machine(true, ma.candies-1, ma.coins)
                } else {
                   ma
                }
              }
            }
            simulateMachine(xs).run(machine)
          }
        }
      })

    /*
        The rules of the machine are as follows: 
- Inserting a coin into a locked machine will cause it to unlock if there’s any candy left. 
- Turning the knob on an unlocked machine will cause it to dispense candy and become locked. 
- Turning the knob on a locked machine or inserting a coin into an unlocked machine does nothing. 
- A machine that’s out of candy ignores all inputs.  
        */
      

  
// case class Machine(locked: Boolean, candies: Int, coins: Int)

    val m1 = Machine(true, 5, 10)
    
    println(simulateMachine(List(Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn)).run(m1))
    


}