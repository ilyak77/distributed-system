import rmi.*;

/**
 * @author: Yilun Zhang, Qiao Zhang
 * @date: 2016/04/26
 */

/** Remote object implementation
*/

public class PingPongImpl implements PingPong{
	public PingPongImpl() throws RMIException{
       super();
	}

	public String ping(int idNumber) throws RMIException{
		String s = "Pong" + idNumber;
		return s;
	} 
}