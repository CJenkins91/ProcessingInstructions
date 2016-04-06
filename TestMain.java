import java.util.Random;

/**
 * This class instantiates an InstructionQueue and demonstrates its features
 * 
 * @author Chris Jenkins
 *
 */
public class TestMain {
	public static void main(String[] args) throws InvalidMessageException {
		
		//create a new queue
		InstructionQueue queue = new InstructionQueue();

		//if the queue is empty
		if(queue.queueEmpty() == true)
		
			System.out.println("the queue is empty");
		
		//if messages have been added before this point then it is not
		else
			
			System.out.println("the queue is not empty");
		
		//create a new random object
		Random r = new Random();

		//loop through generating messages and putting them in the queue
		for(int i=0; i < 1000;i++ ){
		
			//create a new message
			InstructionMessage message = new InstructionMessage();
			
			//set the properties for the message
			message.setInstructionType(r.nextInt(100)+1);

			message.setProductCode(100);

			message.setQuantity(100);

			message.setUom(255);

			message.setTimestamp(100);
			
			//add the message to the queue
			queue.queueInstructionMessage(message);
		}
		
		//print out the number of messages stored in the queue
		System.out.println("\nthere are now " + queue.getQueueSize() + " messages in the queue\n");
		
		//for every message in the queue, we print out the values stored and the message
		//to string allows us to identify the message being output
		
		for(InstructionMessage m : queue.getInstructionMessageList()){
			
			//print out the stored instructionType value for each message
			System.out.println("InstructionType: " + m.getInstructionType());

		}
		
		//we output the value at the front of the queue, we can then check it against the message output above
		//if the message has an instructiontype of 0 or similar then we know something has gone wrong
		
		System.out.println("\nthe message at the front of the queue is: " + queue.getInstructionMessageFront() + "\n");
		
		//remove all of the elements from the queue
		for(int i = queue.getQueueSize()-1; i >= 0; i--){
			queue.dequeueInstructionMessage(i);
		}
		
		//check that this has worked correctly, if it returns more than 0 then
		//something has gone wrong
		
		System.out.println("the queue should be empty now " + queue.getQueueSize() + "\n");
		
	}
}
