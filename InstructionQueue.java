import java.util.ArrayList;

/**
 * this class defines an InstructionQueue object
 * 
 * @author Chris Jenkins
 *
 */
public class InstructionQueue{

	//create an array list of instruction messages to store our instruction messages
	private ArrayList<InstructionMessage> instructionMessageList = new ArrayList<InstructionMessage>();
	
	
	/**
	 * get the instruction message list
	 * @return
	 */
	public ArrayList<InstructionMessage> getInstructionMessageList() {
		return instructionMessageList;
	}

	/**
	 * get the number of instruction messages in the list
	 * @return
	 */
	public int getQueueSize(){
		return getInstructionMessageList().size();
		
		//what if it is empty?
	}
	
	/**
	 * remove instruction message from the list
	 * @param message
	 */
	public void dequeueInstructionMessage(int position){
		
		//if the message is empty then there is no need to remove
		//an element otherwise the specified element is removed
		if(!getInstructionMessageList().isEmpty()){
			getInstructionMessageList().remove(position);
		}
	}
	
	/**
	 * checks whether a message is valid or not 
	 * 
	 * @return true if the message is valid and false if it is not
	 */
	public boolean isMessageValid(InstructionMessage message){

		try{
				//if the value set for the instruction type is invalid then we inform the user and throw an InvalidMessageException
				if (message.getInstructionType() == -1){ 
					System.out.println("the instruction type for the supplied message is invalid: " + message.getInstructionType());
					throw new InvalidMessageException();
				}
				//if the value set for the product code is invalid then we inform the user and throw an InvalidMessageException
				else if (message.getProductCode() == -1){ 
					System.out.println("the product code for the supplied message is invalid: " + message.getProductCode());
					throw new InvalidMessageException();
				}
				//if the value set for the quantity is invalid then we inform the user and throw an InvalidMessageException
				else if (message.getQuantity() == -1){ 
					System.out.println("the quantity for the supplied message is invalid: " + message.getQuantity());
					throw new InvalidMessageException();
				}
				//if the value set for the uom is invalid then we inform the user and throw an InvalidMessageException
				else if (message.getUom() == -1){ 
					System.out.println("the uom for the supplied message is invalid: " + message.getUom());
					throw new InvalidMessageException();
				}
				//if the value set for the timestamp is invalid then we inform the user and throw an InvalidMessageException
				else if (message.getTimestamp() == -1){ 
					System.out.println("the timestamp for the supplied message is invalid: " + message.getTimestamp());
					throw new InvalidMessageException();
				}
				//otherwise the message has passed the check
				else{
					return true;
				}
		
		//catches the exception, informs the user and returns false
		}catch(InvalidMessageException e){
			System.out.println("the message(s) was/were invalid and has/have not been added to the queue");
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * adds the valid instruction message to the list
	 * 
	 * @param message
	 * @throws InvalidMessageException 
	 */
	public void queueInstructionMessage(InstructionMessage message) throws InvalidMessageException{

		//if the message is not valid then we inform the user
		if(isMessageValid(message) != true){
			
			throw new InvalidMessageException ("The supplied message was invalid");
				
		//otherwise the message is valid
		}else{
			
				//set the size of the list in a variable to prevent repeated calls 
				int listSize = getInstructionMessageList().size();
			
				// if the list size is 0 then we add the message
				if(listSize == 0){
					getInstructionMessageList().add(0, message);
				}
			
				//we loop through the queue in reverse checking that the
				//instruction type for the supplied message is more or equal to the
				//instruction type for the current message in the list. IF this is 
				//the case then we can add it to the list at the position of the iterator. 
				
				for(int i= listSize; i > 0 ; i--){

					if(message.getInstructionType() >= getInstructionMessageList().get(i-1).getInstructionType()){
						getInstructionMessageList().add(i, message);
						break;
					}
				}
		}
	}
	
	/**
	 * get the current element at the front of the list
	 * @return
	 */
	public InstructionMessage getInstructionMessageFront(){
		int size = getInstructionMessageList().size();
		return getInstructionMessageList().get(size-1);
	}
	
	/**
	 * checks the queue and returns true if it is
	 * empty otherwise it returns false
	 * 
	 * @return true or false
	 */
	public boolean queueEmpty(){
		//if the instructionMessageList is empty return true
		if(getInstructionMessageList().size() == 0)
			return true;
		//otherwise return false
		else
			return false;
		
	}
	


}
