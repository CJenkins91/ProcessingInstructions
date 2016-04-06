/**
 * This class defines an InstructionMessage object
 * 
 * @author Chris Jenkins
 *
 */
public class InstructionMessage{

	/**
	 * retrieves the instruction type
	 * @return
	 */
	public Integer getInstructionType() {
		return instructionType;
	}

	/**
	 * sets the instruction type
	 * @param instructionType
	 */
	public void setInstructionType(int instructionType) {
		
		//if the value passed in is outside of the range then we set
		//it to -1 which represents an invalid value
		if(instructionType < 0 || instructionType > 100)
			this.instructionType = -1;
		
		//otherwise the value is valid and it is set
		else
			this.instructionType = instructionType;
	}

	/**
	 * retrieves the product code
	 * @return
	 */
	public int getProductCode() {
		return productCode;
	}

	/**
	 * sets the product code
	 * @param productCode
	 */
	public void setProductCode(int productCode) {
		
		//if the value passed in is outside of the range then we set
		//it to -1 which represents an invalid value
		if(productCode < 0)
			this.productCode = -1;
		
		//otherwise the value is valid and it is set
		else	
			this.productCode = productCode;
	}

	/**
	 * get the quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * set the quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		
		//if the value passed in is outside of the range then we set
		//it to -1 which represents an invalid value
		if(quantity < 0)
			this.quantity = -1;
		
		//otherwise the value is valid and it is set
		else
			this.quantity = quantity;
	}

	/**
	 * get the uom
	 * @return
	 */
	public int getUom() {
		return uom;
	}

	/**
	 * set the uom
	 * @param uom
	 */
	public void setUom(int uom) {
		
		//if the value passed in is outside of the range then we set
		//it to -1 which represents an invalid value
		if(uom < 0 || uom > 256)
			this.uom = -1;
		
		//otherwise the value is valid and it is set
		else
			this.uom = uom;
	}
	
	/**
	 * get the timestamp
	 * @return
	 */
	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		
		//if the value passed in is outside of the range then we set
		//it to -1 which represents an invalid value
		if(timestamp < 0)
			this.timestamp = -1;
		
		//otherwise the value is valid and it is set
		else
			this.timestamp = timestamp;
	}

	
	//the instructionType value
	private int instructionType;
	
	//the productCode value
	private int productCode;
	
	//the quantity value
	private int quantity;
	
	//the uom value
	private int uom;
	
	//the timestamp value
	private int timestamp;
	
	
}
